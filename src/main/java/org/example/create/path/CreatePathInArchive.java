package org.example.create.path;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreatePathInArchive {

    /**
     * @return - строка, так будет выглядеть название папки
     */
    public String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(new Date());
    }
    /**
     * метод создает каталог по переданному пути
     * @param path - путь в виде строке
     */
    public void createPathInDirectory(String path){
        File directory  = new File(path + getCurrentDate());

        if(directory.mkdir()){
            System.out.println("Каталог создан!");
        }
    }
}
