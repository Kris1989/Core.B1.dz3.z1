package ru.kristinak.HW;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static StringBuilder logBuilder = new StringBuilder();

    public static void main(String[] args) {

        List<File> allGamesDir = new ArrayList<>();
        List<File> allFilesDir = new ArrayList<>();

        File gamesDir = new File("C:\\Users\\kostyuninak\\Desktop\\Учеба Java\\Games");
        File srcDir = new File(gamesDir, "src");
        File resDir = new File(gamesDir, "res");
        File savegamesDir = new File(gamesDir, "savegames");
        File tempDir = new File(gamesDir, "temp");

        allGamesDir.add(srcDir);
        allGamesDir.add(resDir);
        allGamesDir.add(savegamesDir);
        allGamesDir.add(tempDir);

        File GamesSrcDir = new File("C:\\Users\\kostyuninak\\Desktop\\Учеба Java\\Games\\src");
        File mainDir = new File(GamesSrcDir, "main");
        File testDir = new File(GamesSrcDir, "test");

        allGamesDir.add(mainDir);
        allGamesDir.add(testDir);

        File mainFile = new File("C:\\Users\\kostyuninak\\Desktop\\Учеба Java\\Games\\src\\main");
        File addFileMainJava = new File(mainFile, "Main.java");
        File addFileUtilsJava = new File(mainFile, "Utils.java");

        allFilesDir.add(addFileMainJava);
        allFilesDir.add(addFileUtilsJava);

        File gamesResDir = new File("C:\\Users\\kostyuninak\\Desktop\\Учеба Java\\Games\\res");
        File drawablesDir = new File(gamesResDir, "drawables");
        File vectorsDir = new File(gamesResDir, "vectors");
        File iconsDir = new File(gamesResDir, "icons");

        allGamesDir.add(drawablesDir);
        allGamesDir.add(vectorsDir);
        allGamesDir.add(iconsDir);

        File gamesTempFile = new File("C:\\Users\\kostyuninak\\Desktop\\Учеба Java\\Games\\temp");
        File addFileTempTxt = new File(gamesTempFile, "temp.txt");

        allFilesDir.add(addFileTempTxt);

        for (File allGames : allGamesDir) {
            if (allGames.mkdir()) {
                logBuilder.append("Директории " + allGames + " созданы");
                logBuilder.append('\n');
            } else {
                logBuilder.append("Директории " + allGames + " не созданы");
                logBuilder.append('\n');
            }
        }

        for (File allFiles : allFilesDir) {
            try {
                if (allFiles.createNewFile())
                    logBuilder.append("Файлы " + allFiles + " были созданы");
                logBuilder.append('\n');
            } catch (IOException ex) {
                logBuilder.append(ex.getMessage());
            }
        }

        try (FileWriter writer = new FileWriter("C:\\Users\\kostyuninak\\Desktop\\Учеба Java\\Games\\temp\\temp.txt", false)) {
            String builderString = logBuilder.toString();
            writer.write(builderString);
            writer.write('\n');
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}