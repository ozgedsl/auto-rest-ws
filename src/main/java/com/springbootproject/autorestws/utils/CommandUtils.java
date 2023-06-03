package com.springbootproject.autorestws.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandUtils {

    public static  String runCommand(String command, String workingDirectory) {
        StringBuilder output = new StringBuilder();

        try {
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", command);
            processBuilder.directory(new File(workingDirectory));
            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            int exitCode = process.waitFor();
            if (exitCode != 0) {
                output.append("Komut çalıştırma hatası. Hata kodu: ").append(exitCode);
            }
        } catch (IOException | InterruptedException e) {
            output.append("Komut çalıştırma hatası: ").append(e.getMessage());
        }

        return output.toString();
    }

}
