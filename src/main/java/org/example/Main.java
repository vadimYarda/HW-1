package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        StringBuilder stringBuilder = new StringBuilder();

        List<String> pathList = Arrays.asList(
                "Game",
        "Game/src",
        "Game/res",
        "Game/temp",
        "Game/savegames",
        "Game/src/main",
        "Game/src/test",
        "Game/res/drawablesDir",
        "Game/res/vectors",
        "Game/res/icons"
        );
        for (String path : pathList) {
            String message = createDirectory(path);
            stringBuilder.append(message + "\n");
        }

        File mainFile = new File("Game/src/main/Main.java");
        try {
            if (mainFile.createNewFile()) {
                stringBuilder.append("Файл был создан\n");
            }
        } catch (IOException ex) {
            stringBuilder.append(ex.getMessage() + "\n"); }

        File utilsFile = new File("Game/src/main/Utils.java");
        try {
            if (utilsFile.createNewFile()) {
                stringBuilder.append("Файл был создан\n");
            }
        } catch (IOException e) {
            stringBuilder.append(e.getMessage() + "\n");
        }


        File tempFile = new File("Game/temp/temp.txt");
        try {
            if (tempFile.createNewFile()) {
                stringBuilder.append("Файл был создан\n");
            }
        } catch (IOException eq) {
            stringBuilder.append(eq.getMessage() + "\n");
        }

        FileWriter fileWriter = new FileWriter(tempFile);
        fileWriter.write(stringBuilder.toString());
        fileWriter.close();
    }

    public static String createDirectory (String failPath) {
        File file = new File(failPath);
        String message;
        if (file.mkdir()) {
            message = "Каталог " + failPath + " успешно создан";
        } else {
            message = "Каталог " + failPath + " не был создан";
        }
        return message;
    }
}

