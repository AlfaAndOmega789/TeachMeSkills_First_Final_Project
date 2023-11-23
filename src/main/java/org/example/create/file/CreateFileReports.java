package org.example.create.file;

import org.example.name.file.GenerateArchiveFileName;


import java.io.File;
import java.io.IOException;

public class CreateFileReports {
    static GenerateArchiveFileName generate = new GenerateArchiveFileName();
    private static final String PATH_ARCHIVE = "src\\main\\java\\org\\example\\folders\\archive\\";

    public static void main(String[] args) throws IOException {
//        createFileReportNumber();
//        createFileReportGeneral();
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
    public void createFileReportGeneral(String PATH_ARCHIVE) throws IOException {
        String str = PATH_ARCHIVE + generate.createNameFileReportGeneral(PATH_ARCHIVE);
        File file = new File(str);
        file.createNewFile();
    }
}
