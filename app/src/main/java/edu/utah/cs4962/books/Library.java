package edu.utah.cs4962.books;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
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

        public Book()
        {

        }

        public Book(Book book)
        {
            title = book.title;
            publicationDate = book.publicationDate;
        }
    }

    ArrayList<Book> _books = new ArrayList<Book>();

    public int getBookCount()
    {
        return _books.size();
    }

    public Book getBook(int bookIndex)
    {
        return new Book(_books.get(bookIndex));
    }

    public void addBook(Book book)
    {
        // TODO: Validate befor eadding to list
        if(book.title == null || book.title.length() == 0)
            return;

        _books.add(book);

        //saveLibrary();

        // TODO: Notify listener of book addition
    }

    public void removeBook(int bookIndex)
    {
        _books.remove(bookIndex);

        //saveLibrary();

        // TODO: Notify listener of book removal
    }

    public void loadLibrary(File libraryFile)
    {
        _books.clear();
        try
        {
            FileReader textReader = new FileReader(libraryFile);
            BufferedReader bufferedTextReader = new BufferedReader(textReader);
            String jsonBookList = null;
            jsonBookList = bufferedTextReader.readLine();

            Gson gson = new Gson();
            Book[] bookList  = gson.fromJson(jsonBookList, Book[].class);
            for (Book book : bookList)
                _books.add(book);

            bufferedTextReader.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void saveLibrary(File libraryFile)
    {
        Gson gson = new Gson();
        String jsonBookList = gson.toJson(_books.toArray(new Book[_books.size()]));

        try
        {
            FileWriter textWriter = new FileWriter(libraryFile, false);
            BufferedWriter bufferedWriter = new BufferedWriter(textWriter);
            bufferedWriter.write(jsonBookList);
            bufferedWriter.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
