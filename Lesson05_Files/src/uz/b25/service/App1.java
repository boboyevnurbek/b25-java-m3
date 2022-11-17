package uz.b25.service;

import java.io.File;
import java.io.IOException;

public class App1 {
    public static void main(String[] args) {
//        File, Directory (Folder)
        // File file = new File("D:\\PDP\\MainJava\\Group B-25\\Projects\\Modul03\\Lesson05_Files\\src\\uz\\b25\\service\\App1.java");
        File file = new File("files/com.txt");

        System.out.println("file.exists() = " + file.exists());

        if(file.exists()){
            file.delete();
            return;
        }

        if(!file.exists()){
            File parentFile = file.getParentFile();
            boolean mkdir = parentFile.mkdirs();
            System.out.println("mkdir = " + mkdir);

            try {
                boolean newFile = file.createNewFile();
                System.out.println("newFile = " + newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("file.isFile() = " + file.isFile());
        System.out.println("file.isDirectory() = " + file.isDirectory());

        System.out.println();

        System.out.println("file.getName() = " + file.getName());
        System.out.println("file.length() = " + file.length());
        System.out.println("file.getPath() = " + file.getPath());
        System.out.println("file.getAbsolutePath() = " + file.getAbsolutePath());
        System.out.println("file.getParent() = " + file.getParent());


    }
}
