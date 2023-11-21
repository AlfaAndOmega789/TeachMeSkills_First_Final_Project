package org.example.check.file;

import java.io.File;
import java.util.List;

public class CheckFileInDirectoryInput {
    /**
     * @param list - лист с названием файлов .txt
     * @return - булевское значение, size() > 0 - true, иначе false
     */
    public boolean checkFileTxtInDirectory(List<String> list){
        return list.size() == 0;
    }

}
