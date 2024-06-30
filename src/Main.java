package com.example;

import java.util.Scanner;

import com.example.database.DictionaryModification;
import com.example.database.DictionaryQueries;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DictionaryQueries dictionaryQueries = new DictionaryQueries();
        DictionaryModification dictionaryModification = new DictionaryModification();
        System.out.println("Введите слово: ");
        String word = scanner.nextLine();
        System.out.println("Введите язык (польский/белорусский): ");
        String language = scanner.nextLine();
        String translation = dictionaryQueries.getTranslation(language, word);
        System.out.println("Перевод: " + translation);
        System.out.println("Введите перевод: ");
        String wordTranslation = scanner.nextLine();
        dictionaryModification.addTranslation(language, word, wordTranslation);
        scanner.close();
    }
}