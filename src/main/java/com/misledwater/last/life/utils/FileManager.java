package com.misledwater.last.life.utils;

import com.google.common.io.Files;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;

public class FileManager {

    public static void writeFile(File fileName, String toWrite) {
        try {
            fileName.createNewFile();
            FileWriter fileWriter = new FileWriter(fileName);
            for(int i = 0; i < toWrite.length(); i++) {
                fileWriter.write(toWrite.charAt(i));
            }
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void copyFolders(File sourceFolder, File destinationFolder) throws IOException {
        if(sourceFolder.isDirectory()) {
            if(!destinationFolder.exists()) {
                destinationFolder.mkdir();
            }
            for(String files : Objects.requireNonNull(sourceFolder.list())) {
                File srcFile = new File(sourceFolder, files);
                File destFile = new File(destinationFolder, files);

                copyFolders(srcFile, destFile);
            }
        } else {
            Files.copy(sourceFolder, destinationFolder);
        }
    }

    public static LinkedList<File> getFilesUnderFolder(File file) {
        if(file.listFiles() == null) return new LinkedList<>();
        return new LinkedList<>(Arrays.asList(file.listFiles()));
    }

    public static String readFile(String fileName) {
        try {
            FileReader fileReader = new FileReader(fileName);
            StringBuilder builder = new StringBuilder();
            for(int ch; (ch = fileReader.read()) != -1;) {
                builder.appendCodePoint(ch);
            }
            String message = builder.toString();
            fileReader.close();
            return message;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String readFile(File file) {
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            FileReader fileReader = new FileReader(file);
            StringBuilder builder = new StringBuilder();
            for(int ch; (ch = fileReader.read()) != -1;) {
                builder.appendCodePoint(ch);
            }
            String message = builder.toString();
            fileReader.close();
            return message;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}