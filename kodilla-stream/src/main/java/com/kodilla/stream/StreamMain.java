package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.forumuser.Forum;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class StreamMain {

    public static void main(String[] args) {
        // 7.3
        (new Forum()).getUserList().stream()
                .filter(user -> user.getSex() == 'M')
                .filter(user -> (LocalDate.now().getYear() - user.getDateOfBirth().getYear()) >= 20)
                . filter(user -> user.getPosts() > 0)
                .collect(Collectors.toMap(user -> user.getUserID(), user -> user))
                .entrySet()
                .stream()
                .map(user -> "ID " + user.getKey() + ": " + user.getValue())
                .forEach(System.out::println);

        // 7.1
        System.out.println("\n\n\n");
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        String text;
        text = "Some Text To Beautify.";
        System.out.println("Result 1: " + poemBeautifier.beutify(text, (s) -> s.toLowerCase()));
        System.out.println("Result 2: " + poemBeautifier.beutify(text, s -> s.toUpperCase()));
        System.out.println("Result 3: " + poemBeautifier.beutify(text, s -> s + " And this is the beautiful part."));
        System.out.println("Result 4: " + poemBeautifier.beutify(text, (s) -> {
            String result = "";
            for(int i = 0;i<s.length();i++)
                result += (" " + s.charAt(i));
            return result;
        }));
        System.out.println("Result 5: " + poemBeautifier.beutify(text, (s) -> {
            String result = "";
            for(int i = (s.length() - 1);i>=0;i--)
                result += s.charAt(i);
            return result;
        }));
        System.out.println("Result 6: " + poemBeautifier.beutify(text, (s) -> {
            Random r = new Random();
            List<Character> list = new ArrayList<>();
            String result = "";
            int i;
            for(i = 0;i < s.length();i++)
                list.add(s.charAt(i));
            while(!list.isEmpty()){
                i = r.nextInt(list.size());
                result += list.get(i);
                list.remove(i);
            }
            return result;
        }));
    }

}