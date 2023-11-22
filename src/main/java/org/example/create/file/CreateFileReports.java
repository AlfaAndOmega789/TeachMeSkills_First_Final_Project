package org.example.create.file;

import org.example.name.file.GenerateOutputFileName;

import java.io.File;
import java.io.IOException;

public class CreateFileReports {
    static GenerateOutputFileName generate = new GenerateOutputFileName();
    private static final String PATH_ARCHIVE = "src\\main\\java\\org\\example\\folders\\archive\\";

    public static void main(String[] args) throws IOException {
//        createFileReportNumber();
        createFileReportGeneral();
    }

    /**
     * Создание файла отчета с использованием счётчика
     * @throws IOException
     */
    public static void createFileReportNumber() throws IOException {
        String str = PATH_ARCHIVE + generate.createFileNameReports(PATH_ARCHIVE);
        File file = new File(str);
        file.createNewFile();

        //дописать запись в созданный файл
    }

    /**
     * Создание GENERAL файла отчета
     * @throws IOException
     */
    public static void createFileReportGeneral() throws IOException {
        String str = PATH_ARCHIVE + generate.createFileNameReportGeneral(PATH_ARCHIVE);
        File file = new File(str);
        file.createNewFile();
    }
}
