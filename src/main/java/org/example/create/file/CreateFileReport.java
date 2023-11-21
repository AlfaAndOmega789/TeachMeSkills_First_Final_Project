package org.example.create.file;

import org.example.name.file.GenerateOutputFileName;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateFileReport {
    GenerateOutputFileName generate = new GenerateOutputFileName();
    private static final String PATH_ARCHIVE = "src\\main\\java\\org\\example\\folders\\archive\\";

    public static void main(String[] args) {

    }

    public void createFileReport(){
        File file = new File(generate.createFileNameReport(PATH_ARCHIVE));
    }

}
