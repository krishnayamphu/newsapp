package com.newsapp.utils;

import java.io.File;
import java.util.ArrayList;

public class MediaFile {
    public static ArrayList<String> getFiles(String path) {
        ArrayList<String> files = new ArrayList<>();
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        File[] allFiles = file.listFiles();
        for (File f : allFiles) {
            files.add(f.getName());
        }
        return files;
    }

    public static void remove(String path, String fileItem) {
        File file = new File(path + "/" + fileItem);
        if (file.delete()) {
            System.out.println(fileItem + " deleted successfully.");
        } else {
            System.out.println("file can't delete");
        }

    }
}
