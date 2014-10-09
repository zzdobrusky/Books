package edu.utah.cs4962.books;

import java.util.Date;

/**
 * Created by zbynek on 10/9/2014.
 */
public class Book
{
    public String title;
    public Date publicationDate;

    public Book()
    {

    }

    public Book(Book book)
    {
        title = book.title;
        publicationDate = book.publicationDate;
    }

    public Book(String t)
    {
        title = t;
        publicationDate = new Date();
    }
}
