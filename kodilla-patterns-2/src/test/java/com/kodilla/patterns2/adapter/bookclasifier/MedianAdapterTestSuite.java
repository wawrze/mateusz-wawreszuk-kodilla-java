package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MedianAdapterTestSuite {

    @Test
    public void publicationYearMedianTest() {
        //Given
        Set<Book> bookSet1 = new HashSet<>();
        Set<Book> bookSet2 = new HashSet<>();
        Book book1 = new Book("Author 1", "Title 1", 2000, "sig1");
        Book book2 = new Book("Author 2", "Title 2", 2010, "sig2");
        Book book3 = new Book("Author 3", "Title 3", 2005, "sig3");
        Book book4 = new Book("Author 4", "Title 4", 1995, "sig4");
        Book book5 = new Book("Author 5", "Title 5", 1990, "sig5");
        Book book6 = new Book("Author 6", "Title 6", 2015, "sig6");
        int result1, result2;
        MedianAdapter medianAdapter = new MedianAdapter();
        //When
        bookSet1.add(book1);
        bookSet1.add(book2);
        bookSet1.add(book3);
        bookSet1.add(book4);
        bookSet1.add(book5);
        bookSet2.add(book1);
        bookSet2.add(book2);
        bookSet2.add(book3);
        bookSet2.add(book4);
        bookSet2.add(book5);
        bookSet2.add(book6);
        result1 = medianAdapter.publicationYearMedian(bookSet1);
        result2 = medianAdapter.publicationYearMedian(bookSet2);
        //Then
        Assert.assertEquals(2000, result1);
        Assert.assertEquals(2005, result2);
    }

}