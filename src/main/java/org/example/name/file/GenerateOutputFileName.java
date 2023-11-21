package org.example.name.file;

import org.example.counter.CountFileInDirectory;
import org.example.create.path.CreatePathInArchive;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GenerateOutputFileName {
    private static final String PATH_ARCHIVE = "src\\main\\java\\org\\example\\folders\\archive\\";

    public static void main(String[] args) {
//        System.out.println(createFileNameReport());
    }

    /**
     * Метод создает название файла
     * @return - название в виде строки
     */
    public static String createFileNameReport(String PATH_ARCHIVE){
        CountFileInDirectory count = new CountFileInDirectory();
        String formattedCounter = String.format("%03d",
                count.countFileReportInDirectory(PATH_ARCHIVE));

        return "FILE_REPORT_" + getCurrentDate() + "_" + formattedCounter + ".txt";
    }

    /**
     * @return - дату в виде строки
     */
    private static String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        return dateFormat.format(new Date());
    }
}
