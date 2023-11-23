package org.example.user.selection;

import org.example.check.file.CheckFileInDirectoryInput;
import org.example.check.info.CheckParsingInfo;
import org.example.create.file.CreateFileReports;
import org.example.create.info.GenerateDateInFileReport;
import org.example.create.path.CreatePathInArchive;
import org.example.list.txt.GenerateListTXT;
import org.example.name.file.GenerateArchiveFileName;

import org.example.parsing.file.DOMProjectParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class UserSelection {
    private static final String PATH_INPUT = "src\\main\\java\\org\\example\\folders\\input";
    private static final String PATH_ARCHIVE = "src\\main\\java\\org\\example\\folders\\archive\\";
    static CheckFileInDirectoryInput check = new CheckFileInDirectoryInput();
    static GenerateListTXT listTXT = new GenerateListTXT();
    static DOMProjectParser parser = new DOMProjectParser();
    static GenerateDateInFileReport gen = new GenerateDateInFileReport();
    static boolean someValue = true;

    static GenerateArchiveFileName nameFile = new GenerateArchiveFileName();
    /**
     * Метод просит ввести пользователя значение в консоль
     * @throws IOException
     */
    public void userSelection() throws IOException, ParserConfigurationException, SAXException {
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
//                    for(int i = 0 ; i < newListTXt.size();i++){
                        String result = null;
                        String resultOperation = null;
                        CheckParsingInfo check = new CheckParsingInfo();
                        CreateFileReports createFileReports = new CreateFileReports();

                        listWithDataFromFileTXT = parser.parsingFile(PATH_INPUT + "\\" + newListTXt.get(0));

                        if(!check.checkLengthBilling(listWithDataFromFileTXT.get(0)) &&
                                !check.checkLengthBilling(listWithDataFromFileTXT.get(3))){
                            resultOperation = "Неуспешно. Некорректный номер счета отправителя или получателя.";
                        }else if(!check.checkTransferAmount(listWithDataFromFileTXT.get(3))){
                            resultOperation = "Неуспешно. Указана некорректная сумма перевода.";
                        }else if(!check.checkAmountLength(listWithDataFromFileTXT.get(3))){
                            resultOperation = "Неуспешно. Не заполнено поле суммы.";
                        }else if(!check.checkTheRecipientBilling(
                                listWithDataFromFileTXT.get(1), listWithDataFromFileTXT.get(3))){
                            resultOperation = "Неуспешно. Сумма перевода превышает кол-во денежных средств на счете отправителя";
                        }else{
                            resultOperation = "Успешно.";
                        }

                        result = gen.getCurrentDate() + " | " + newListTXt.get(0) + " | перевод с " +
                                listWithDataFromFileTXT.get(0) + " на " + listWithDataFromFileTXT.get(2) + " " +
                                    listWithDataFromFileTXT.get(3) + " | " + resultOperation;

                        createFileReports.createFileReportGeneral(PATH_ARCHIVE);


                        BufferedWriter writer = new BufferedWriter(new FileWriter(nameFile.createNameFileReportGeneral(PATH_ARCHIVE), StandardCharsets.UTF_8));
                        writer.write(result);

//                        listWithDataFromFileTXT.get(0); // 1. Номер счёта отправителя
//                        listWithDataFromFileTXT.get(1); // 2. Сумма денежных средств на счёте отправителя
//                        listWithDataFromFileTXT.get(2); // 3. Номер счёта получателя
//                        listWithDataFromFileTXT.get(3); // 4. Сумма перевода

//                    }
                    //вызов операции парсинга файлов .txt
                    //проведение проверок
                    //формирование строки для записи в файл
                    // создание файла отчета с сгенерированным именем файла
                    //запись строки в файл
                    //формирование файла отчета
                    //переложить спаршенный файл в директорию за сегодняшнюю дату
                }
            }
            else if(variableEnteredByTheUser == 2){
                // вызов операции вывода списка всех переводов из файла-отчета.
                someValue = false;
            }else if(variableEnteredByTheUser == 3){
                //при вводе тройки, юзер выбирает дату и номер чека на выбор(этот выбор предлагает в консоли)
            }else{
                System.out.print("Вы ввели значение отличное от 1 или 2, повторите ввод снова:");
            }
        }
    }
}
