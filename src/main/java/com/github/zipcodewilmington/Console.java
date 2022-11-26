package com.github.zipcodewilmington;

import java.util.Scanner;

public class Console {
    Scanner scanner = new Scanner(System.in);

    public Character getTheUserGuess(){
        System.out.println("Guess a single letter");
        String input = scanner.nextLine().toLowerCase();
        Character guess = input.charAt(0);
        while(input.length() != 1 || !Character.isLetter(guess)){
            System.out.println("Guess a single letter");
            input = scanner.nextLine().toLowerCase();
            guess = input.charAt(0);
        }
        return guess;
    }

}
