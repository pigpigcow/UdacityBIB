package com.example.jokeprovider;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JokeProvider {
    private static final String DEFAULT_JOKE = "Sorry, no more jokes.";
    private List<String> jokeList = new ArrayList<>();

    public JokeProvider() {
        jokeList.add("Joke a1,Answer A1");
        jokeList.add("Joke a2,Answer A2");
        jokeList.add("Joke a3,Answer A3");
        jokeList.add("Joke a4,Answer A4");
        jokeList.add("Joke a5,Answer A5");
        jokeList.add("Joke a6,Answer A6");
        jokeList.add("Joke a7,Answer A7");
        jokeList.add("Joke a8,Answer A8");
        jokeList.add("Joke a9,Answer A9");
        jokeList.add("Joke a10,Answer A10");
        jokeList.add("Joke a11,Answer A11");
        jokeList.add("Joke a12,Answer A12");
        jokeList.add("Joke 13a,Answer A13");
    }

    public String getJoke() {
        String joke = DEFAULT_JOKE;
        if(jokeList.size() > 0) {
            int rn = getRandomNumberInRange(jokeList.size());
            joke = jokeList.get(rn);
        }
        return joke;
    }

    private int getRandomNumberInRange(int max) {
        return getRandomNumberInRange(0, max);
    }

    private int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

}
