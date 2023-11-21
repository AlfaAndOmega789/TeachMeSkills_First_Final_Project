package org.example.name.file;

import org.example.count.file.CountFileInDirectory;
import org.example.create.path.CreatePathInArchive;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GenerateOutputFileName {
    private static final String PATH_ARCHIVE = "src\\main\\java\\org\\example\\folders\\archive\\";
    static CountFileInDirectory count = new CountFileInDirectory();
    public static void main(String[] args) {
        System.out.println(createFileNameReport());
    }

    public static String createFileNameReport(){
        CreatePathInArchive cr = new CreatePathInArchive();

        String formattedCounter = String.format("%03d",
                count.countFileReportInDirectory(PATH_ARCHIVE + cr.getCurrentDate()));
        return "FILE_REPORT_" + getCurrentDate() + "_" + formattedCounter + ".txt";
    }

    private static String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        return dateFormat.format(new Date());
    }
}
