package org.example;

import org.example.folders.user.selection.UserSelection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        UserSelection userSelection = new UserSelection();
        userSelection.userSelection();


    }
}