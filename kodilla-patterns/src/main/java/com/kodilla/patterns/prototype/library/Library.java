package com.kodilla.patterns.prototype.library;

import com.kodilla.patterns.prototype.Prototype;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public final class Library extends Prototype {

    String name;
    Set<Book> books = new HashSet<>();

    public Library(final String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    @Override
    public String toString() {
        String s = name;
        s += "\n";
        s += books.stream()
                .map(b -> b.toString())
                .collect(Collectors.joining("\n"));
        return s;
    }

    public Library shallowCopy() throws CloneNotSupportedException {
        return (Library) super.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException {
        Library clonedLibrary = (Library) super.clone();
        clonedLibrary.books = new HashSet<>();
        for(Book b : books) {
            clonedLibrary.getBooks().add(new Book(b.getTitle(), b.getAuthor(), b.getPublicationDate()));
        }
        return clonedLibrary;
    }

}