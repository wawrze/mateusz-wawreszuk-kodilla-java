package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.Classifier;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookSignature;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MedianAdapter extends MedianAdaptee implements Classifier {

    @Override
    public int publicationYearMedian(Set<com.kodilla.patterns2.adapter.bookclasifier.librarya.Book> bookSet) {
        Map<BookSignature, com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book> bookMap = new HashMap<>();
        bookSet.forEach(b -> bookMap.put(
                new BookSignature(b.getSignature()),
                new com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book(
                        b.getAuthor(),
                        b.getTitle(),
                        b.getPublicationYear()
                )));
        return medianPublicationYear(bookMap);
    }

}