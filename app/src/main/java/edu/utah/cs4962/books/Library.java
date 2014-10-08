package edu.utah.cs4962.books;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by zbynek on 10/7/2014.
 */
public class Library
{
    public class Book
    {
        public String title;
        public Date publicationDate;
    }

    ArrayList<Book> _books = new ArrayList<Book>();

    public int getBookCount()
    {
        return _books.size();
    }

    public Book getBook(int bookIndex)
    {
        return _books.get(bookIndex);
    }

    public void addBook(Book book)
    {
        // TODO: Validate befor eadding to list
        if(book.title == null || book.title.length() == 0)
            return;

        _books.add(book);

        // TODO: Notify listener of book addition
    }

    public void removeBook(int bookIndex)
    {
        _books.remove(bookIndex);

        // TODO: Notify listener of book removal
    }
}
