package org.example.name.file;

import org.example.counter.CountFileInDirectory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GenerateArchiveFileName {

    /**
     *
     * @param PATH_ARCHIVE - путь к каталогу
     * @return - имя файла в виде строки
     */
    public String createNameFileReportGeneral(String PATH_ARCHIVE){
        return "FILE_REPORT_GENERAL_" + getCurrentDate() + ".txt";
    }

    /**
     * Метод создает название файла
     * @return - название в виде строки
     */
    public static String createFileNameReports(String PATH_ARCHIVE){
        CountFileInDirectory count = new CountFileInDirectory();
        String formattedCounter = String.format("%03d",
                count.countFileReportInDirectory(PATH_ARCHIVE));

        return "FILE_REPORT_" + getCurrentDate() + "_" + formattedCounter +  ".txt";
    }

    /**
     * @return - дату в виде строки, нужного формата
     */
    private static String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        return dateFormat.format(new Date());
    }
}
