package org.example.create.info;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GenerateInfoInFileReport {

    /**
     * Метод будет использован в файле-отчете(дата совершения операции)
     * @return - возвращает строку в виде даты в нужном формате
     */
    public String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy-HH:mm");
        return dateFormat.format(new Date());
    }
}
