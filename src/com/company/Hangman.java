package com.company;

import java.util.*;

public class Hangman {
    List<String> words= new ArrayList<>(
            Arrays.asList("buenos", "vasiokas", "vilnius", "kaunas"));

    public String getRandomWord() {

        Random smth = new Random();
        int random = smth.nextInt(words.size());
        return words.get(random);
    }


    public boolean wordToStars(String belekas, List<Character> guessed) {
        boolean guessedAll = true;
        for (int i = 0; i < belekas.length(); i++) {
            if (guessed.contains(belekas.charAt(i))) {
                System.out.print(belekas.charAt(i));
            } else {
                System.out.print("*");
                guessedAll = false;
            }
        }
        System.out.println("");
        return guessedAll;
    }

    public void play () {
        String randomWord = getRandomWord();
        boolean guessed = false;
        List<Character> guessedLetters = new ArrayList<>();
        int count = 0;
        wordToStars(randomWord, guessedLetters);
        while (!guessed) {

            System.out.println("Input new letter");
            Scanner sc = new Scanner(System.in);
            char letter = sc.next().charAt(0);

            System.out.println("You guessed "+letter);
            guessedLetters.add(letter);
            guessed =  wordToStars(randomWord, guessedLetters);
            count++;
        }
        System.out.println("You guessed times: "+ count);
    }
}