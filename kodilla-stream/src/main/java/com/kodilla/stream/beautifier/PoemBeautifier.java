package com.kodilla.stream.beautifier;

public class PoemBeautifier {

    public String beutify(String s, PoemDecorator poemDecorator){
        return poemDecorator.decorate(s);
    }

}
