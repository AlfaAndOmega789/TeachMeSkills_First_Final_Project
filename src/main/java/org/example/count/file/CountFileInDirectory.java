package org.example.count.file;

import java.io.File;

public class CountFileInDirectory {

    /**
     * countFileReportInDirectory(String directoryPath)
     * Метод проверяет кол-во файлов REPORT в переданной директории
     * @param directoryPath - переданный каталог
     * @return - счетчик кол-ва файлов
     */
    public int countFileReportInDirectory(String directoryPath){
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();
        int countMerch = 1;

        for(File file : files) {
            if(file.getName().contains("REPORT")){
                countMerch++;
            }
        }
        return countMerch;
    }
}
