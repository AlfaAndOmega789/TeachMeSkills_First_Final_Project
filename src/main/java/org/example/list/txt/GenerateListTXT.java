package org.example.list.txt;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GenerateListTXT {
    public static final String PATH_INPUT = "src\\main\\java\\org\\example\\folders\\input";

    /**
     * Метод проверяет наличие файлов формата .txt в педанном каталоге,
     * в случае их наличия, добавляет файлы в List<String> и возвращает его
     * @param path - путь к каталогу
     * @return - List<String>
     */
    public List<String> generateListTxt(String path){
        List<String> txtFileNames = new ArrayList<>();

        File directory = new File(path);

        if(directory.exists() && directory.isDirectory()){
            File[] files = directory.listFiles();
            if(files != null){
                for(File file: files){
                    if(file.isFile() && file.getName().toLowerCase().endsWith(".txt")){
                        txtFileNames.add(file.getName());
                    }
                }
            }
        }
        return txtFileNames;
    }
}
