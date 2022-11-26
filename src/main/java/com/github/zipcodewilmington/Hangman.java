package com.github.zipcodewilmington;


import java.util.Random;

/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02 AM
 */
public class Hangman {
    private String word;
    Integer guessCounter = 0;
    String[] wordBank = new String[]{"rocks", "ridiculous", "cool","something","very","simple","generics","tests"};
    Random random = new Random();

    public Integer getGuessCounter() {
        return guessCounter;
    }

    public void setGuessCounter(Integer guessCounter) {
        this.guessCounter = guessCounter;
    }

    public Hangman(){
        this.word = wordBank[(int) (Math.random() * wordBank.length)] ;
    }
    public String getWord() {
        return this.word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void run() {
        Console console = new Console();
        String currentState = emptyWordStringCreator(getWord());
        Character lastGuess = ' ';
        System.out.println("Welcome to Hangman. You have 5 guesses to get the word.");
        while(guessCounter <= 5){
            System.out.println("Your word: " + currentState + " Guesses used: " + getGuessCounter() + " Last Guess: " +lastGuess);
            lastGuess = console.getTheUserGuess();
            incrementGuessesForWrongGuess(lastGuess,getWord());
            currentState = populateCharacterSpaceWithCorrectGuess(currentState,getWord(),lastGuess);
            if(currentState.equals(getWord())){
                System.out.println("You got it! Word was: "+currentState);
                break;
            };
        }
        if(guessCounter > 5) System.out.println("Word was: " + getWord() +"\nBetter luck next time.");
    }

    public String emptyWordStringCreator(String word) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < word.length(); i++){
            sb.append("_");
        }
        return sb.toString();
    }

    public String populateCharacterSpaceWithCorrectGuess(String currentState, String word, Character guess) {
        StringBuilder sb = new StringBuilder(currentState);
        for(int i = 0; i< word.length(); i++){
            if(word.charAt(i)==guess) sb.replace(i,i+1, guess.toString());
        }
        return sb.toString();
    }

    public void incrementGuessesForWrongGuess(Character guess, String word) {
        if(!word.contains(guess.toString())){
            this.guessCounter++;
            System.out.println("Wrong! Letter not in this word.");
        }
    }
}
