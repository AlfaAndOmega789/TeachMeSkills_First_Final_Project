package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean somevalue = true;

        System.out.print("Выберете вариант из двух доступных:\n" +
                "1. Вызов операции парсинга файлов перевода из input\n" +
                "2. Вызов операции вывода списка всех переводов из файла-отчета.\n" +
                "Для выбора операции нажмите 1 или 2 соответственно: "
        );

        while(somevalue){

            int variableEnteredByTheUser = Integer.parseInt(reader.readLine());
            System.out.println();

            if(variableEnteredByTheUser == 1){
                //вызов операции парсинга файлов перевода из input,
                somevalue = false;
            }
            else if(variableEnteredByTheUser == 2){
                // вызов операции вывода списка всех переводов из файла-отчета.
                somevalue = false;
            }else{
                System.out.print("Вы ввели значение отличное от 1 или 2, повторите ввод снова:");

            }
        }
    }
}