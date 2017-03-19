package com.example;

import java.util.Random;

public class JokeStory {
    private String[] JOKES;
    private Random RANDOM;

    public JokeStory() {
        JOKES = new String[10];
        JOKES[0] = "Why do we sing 'Take Me Out to the Ballgame' when we're already there?";
        JOKES[1] = "Does it disturb anyone else that \"The Los Angeles Angels\" baseball team translates directly to 'The The Angels Angels'?";
        JOKES[2] = "The one thing I've learned from the World Cup is that Europe still hasn't mastered the haircut.";
        JOKES[3] = "It's weird that NFL players don't constantly look at their phones to check their stats.";
        JOKES[4] = "Anyone who thinks women talk too much has never sat through a six-hour Super Bowl pregame show.";
        JOKES[5] = "My dad didn't text me after the Patriots game, which is basically a Life Alert signal if you're from New England.";
        JOKES[6] = "The reason women don't play football is that 11 of them would never wear the same outfit in public.";
        JOKES[7] = "If you understand English, press 1. If you do not understand English, press 2.";
        JOKES[8] = "The closest I've been to a diet this year is erasing food searches from my browser history.";
        JOKES[9] = "I can still remember a time when I knew more than my phone.";
        RANDOM = new Random();
    }

    public String getJokeStory() {
        return JOKES[RANDOM.nextInt(JOKES.length)];
    }
}
