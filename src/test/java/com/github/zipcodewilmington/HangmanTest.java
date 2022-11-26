package com.github.zipcodewilmington;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02 AM
 */
public class HangmanTest {
    @Test
    public void testEmptyWordStringCreator(){
        //given
        Hangman hangman = new Hangman();
        String word = "hello";
        String expected = "_____";
        //when
        String actual = hangman.emptyWordStringCreator(word);
        //then
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testPopulateCharacterSpaceWithCorrectGuess(){
        //given
        Hangman hangman = new Hangman();
        String currentState = "_____";
        String word = "hello";
        String expected = "____o";
        Character guess = 'o';
        //when
        String actual = hangman.populateCharacterSpaceWithCorrectGuess(currentState,word,guess);
        //then
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testIncrementGuessesForWrongGuess(){
        //given
        Hangman hangman = new Hangman();
        Character guess = 'z';
        String word = "hello";
        Integer expected = 1;
        //when
        hangman.incrementGuessesForWrongGuess(guess,word);
        //then
        Assert.assertEquals(expected,hangman.getGuessCounter());

    }
}
