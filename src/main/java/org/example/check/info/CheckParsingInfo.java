package org.example.check.info;

import java.util.ArrayList;

public class CheckParsingInfo {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();

        System.out.println(checkLengthBilling("Hello"));
    }

    public static boolean checkLengthBilling(String str){
        return str.length() == 10;
    }

    public static boolean checkSum(String str){
        return Integer.parseInt(str) > 0 ;

    }
    public static boolean lengthSum(String str){

    }

}
