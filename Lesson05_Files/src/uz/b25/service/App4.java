package uz.b25.service;

import java.io.File;
import java.util.Arrays;

public class App4 {
    public static void main(String[] args) {
        File folder = new File("./");

        showInFolder(folder, "");
    }

    static  void showInFolder(File folder, String prefix){
        for (File file : folder.listFiles()) {
            System.out.println(prefix+file.getName());
            if(file.isDirectory()){
                showInFolder(file, prefix+"  ");
            }
        }
    }

}
