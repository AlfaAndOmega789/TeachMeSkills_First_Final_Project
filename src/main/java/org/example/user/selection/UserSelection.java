package org.example.user.selection;

import org.example.check.file.CheckFileInDirectoryInput;
import org.example.list.txt.GenerateListTXT;
import org.example.parsing.file.DOMProjectParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class UserSelection {
    public static final String PATH_INPUT = "src\\main\\java\\org\\example\\folders\\input";
    static CheckFileInDirectoryInput check = new CheckFileInDirectoryInput();
    static GenerateListTXT listTXT = new GenerateListTXT();
    static boolean someValue = true;

    /**
     * Метод просит ввести пользователя значение в консоль
     * @throws IOException
     */
    public static void userSelection() throws IOException, ParserConfigurationException, SAXException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Выберете вариант из двух доступных:\n" +
                "1. Вызов операции парсинга файлов перевода из input\n" +
                "2. Вызов операции вывода списка всех переводов из файла-отчета.\n" +
                "Для выбора операции нажмите 1 или 2 соответственно: "
        );

        while(someValue){
            int variableEnteredByTheUser = Integer.parseInt(reader.readLine());

            if(variableEnteredByTheUser == 1){

                List<String> newListTXt = listTXT.generateListTxt(PATH_INPUT);
                //list c именами фалов .txt
                List<String> listWithDataFromFileTXT = null;

                if(check.checkFileTxtInDirectory(newListTXt)){
                    System.out.println("В папке input отсутствуют файлы формата .txt \n" +
                    "Завершение работы программы!");
                    break;
                }else {
                    for(int i = 0 ; i < newListTXt.size();i++){
                        DOMProjectParser parser = new DOMProjectParser();
                        listWithDataFromFileTXT = parser.parsingFile(PATH_INPUT + "\\" + newListTXt.get(i));
                    }
                    //вызов операции парсинга файлов .txt
                    //проведение проверок
                    //формирование файла отчета
                    //переложить спаршенный файл в директорию за сегодняшнюю дату
                }
            }
            else if(variableEnteredByTheUser == 2){
                // вызов операции вывода списка всех переводов из файла-отчета.
                someValue = false;
            }else{
                System.out.print("Вы ввели значение отличное от 1 или 2, повторите ввод снова:");
            }
        }
    }
}
