package org.example.check.info;

import java.util.ArrayList;

public class CheckParsingInfo {
    public static void main(String[] args) {
        CheckParsingInfo checkParsingInfo = new CheckParsingInfo();
//        List<String> list = new ArrayList<>();


        if(!checkParsingInfo.checkTheRecipientBilling("100", "101")){
            System.out.println("некорректно");
        }
//        System.out.println(checkParsingInfo.checkLengthBilling("Hello"));


    }

    /**
     * Проверка длины строки, использ. для номера счета
     * @param str
     * @return
     */
    public boolean checkLengthBilling(String str){
        return str.length() == 11;
    }

    /**
     * Проверка суммы перевода на отрицательное значение
     * @param str
     * @return
     */
    public boolean checkTransferAmount(String str){
        return Integer.parseInt(str) > 0 ;
    }

    /**
     * Проверка на отсутствие заполненого поля(суммы перевода)
     * @param str
     * @return
     */
    public boolean checkAmountLength(String str){
        return str.length() == 0;
    }

    /**
     * Проверка, сравнение суммы перевода с количеством денежных средств на счёте отправителя
     * @param str1
     * @param str3
     * @return
     */
    public boolean checkTheRecipientBilling(String str1, String str3){
        return Double.parseDouble(str1) > Double.parseDouble(str3);
    }
}
