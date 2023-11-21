package org.example.create.file;

import org.example.count.file.CountFileInDirectory;
import org.example.name.file.GenerateOutputFileName;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateFileReport {


//    public static void main(String[] args) throws IOException {
//        File file = new File(createFileName());
//
//        if(file.mkdir()){
//            System.out.println("File created");
//        }
//    }



    /**
     * bcgjkm будет использован в файле-отчете
     * @return - возвращает строку в виде даты в нужном формате
     */
    public String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy-HH:mm");
        return dateFormat.format(new Date());
    }
}
