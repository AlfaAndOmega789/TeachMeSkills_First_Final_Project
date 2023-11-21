package org.example.user.selection;

import org.example.check.file.CheckFileInDirectoryInput;
import org.example.list.txt.GenerateListTXT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserSelection {
    public static final String PATH_INPUT = "src\\main\\java\\org\\example\\folders\\input";

    /**
     * Метод просит ввести пользователя значение в консоль
     * @throws IOException
     */
    public static void userSelection() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Выберете вариант из двух доступных:\n" +
                "1. Вызов операции парсинга файлов перевода из input\n" +
                "2. Вызов операции вывода списка всех переводов из файла-отчета.\n" +
                "Для выбора операции нажмите 1 или 2 соответственно: "
        );

        boolean somevalue = true;

        while(somevalue){
            int variableEnteredByTheUser = Integer.parseInt(reader.readLine());
            System.out.println();

            if(variableEnteredByTheUser == 1){
                CheckFileInDirectoryInput check = new CheckFileInDirectoryInput();
                GenerateListTXT listTXT = new GenerateListTXT();

                if(check.checkFileTxtInDirectory(listTXT.generateListTxt(PATH_INPUT))){
                    System.out.println("В папке input отсутствуют файлы формата .txt \n" +
                    "Завершение работы программы!");
                    break;
                }else {
                    //вызов операции парсинга файлов .txt
                    //переложить спаршенный файл в директорию за сегодняшнюю дату
                }




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
