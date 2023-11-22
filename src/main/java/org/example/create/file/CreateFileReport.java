package org.example.create.file;

import org.example.name.file.GenerateOutputFileName;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateFileReport {
    static GenerateOutputFileName generate = new GenerateOutputFileName();
    private static final String PATH_ARCHIVE = "src\\main\\java\\org\\example\\folders\\archive\\";

    public static void main(String[] args) throws IOException {
        createFileReport();
    }
    public static void createFileReport() throws IOException {
        File file = new File(PATH_ARCHIVE + generate.createFileNameReport(PATH_ARCHIVE));
        file.createNewFile();
    }
}
