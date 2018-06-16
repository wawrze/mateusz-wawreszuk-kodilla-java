package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class LibraryTestSuite {

    @Test
    public void testGetBooks() {
        //Given
        Library library = new Library("Library 1");
        Book book = new Book("Title 1", "Author 1", LocalDate.of(2001,1,1));
        library.addBook(book);
        library.addBook(new Book("Title 2", "Author 2", LocalDate.of(2002,2,5)));
        library.addBook(new Book("Title 3", "Author 3", LocalDate.of(2003,3,10)));
        library.addBook(new Book("Title 4", "Author 4", LocalDate.of(2004,4,15)));
        library.addBook(new Book("Title 5", "Author 5", LocalDate.of(2005,5,20)));
        Library shallowClonedLibrary = null;
        Library deepClonedLibrary = null;
        try {
            shallowClonedLibrary = library.shallowCopy();
            shallowClonedLibrary.setName("Library 2");
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Library 3");
        }
        catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        //When
        library.removeBook(book);
        //Then
        System.out.println(library);
        System.out.println(shallowClonedLibrary);
        System.out.println(deepClonedLibrary);
        Assert.assertEquals(4, library.getBooks().size());
        Assert.assertEquals(4, shallowClonedLibrary.getBooks().size());
        Assert.assertEquals(5, deepClonedLibrary.getBooks().size());
        Assert.assertEquals(library.getBooks(), shallowClonedLibrary.getBooks());
        Assert.assertNotEquals(library.getBooks(), deepClonedLibrary.getBooks());
    }

}
