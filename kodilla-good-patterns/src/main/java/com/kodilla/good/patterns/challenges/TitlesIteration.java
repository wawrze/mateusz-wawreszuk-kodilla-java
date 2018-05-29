package com.kodilla.good.patterns.challenges;

public class TitlesIteration {

    public static void main (String args[]){
        MovieStore movieStore = new MovieStore();
        movieStore.getMovies().entrySet().stream()
                .flatMap(entry -> entry.getValue().stream())
                .forEach(title -> System.out.print(title + "!"));
    }

}
