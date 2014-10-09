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
    static Library _instance = null;
    static Library getInstance(File libraryFile)
    {
        if(_instance == null)
            _instance = new Library(libraryFile);

        return _instance;
    }

    ArrayList<Book> _books = new ArrayList<Book>();
    File _libraryFile;
    Type _bookArrayType = new TypeToken<ArrayList<Book>>(){}.getType();

    private Library(File libraryFile)
    {
        _libraryFile = libraryFile;
        loadLibrary();
    }

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
        if(book.title == null || book.title.length() == 0)
            return;

        _books.add(new Book(book));
        saveLibrary();

        // TODO: Notify listener of book addition
    }

    public void removeBook(int bookIndex)
    {
        _books.remove(bookIndex);
        saveLibrary();

        // TODO: Notify listener of book removal
    }

    private void loadLibrary()
    {
        _books.clear();
        try
        {
            FileReader textReader = new FileReader(_libraryFile);
            BufferedReader bufferedTextReader = new BufferedReader(textReader);
            String jsonBookList = null;
            jsonBookList = bufferedTextReader.readLine();

            Gson gson = new Gson();
            _books  = gson.fromJson(jsonBookList, _bookArrayType);

            bufferedTextReader.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void saveLibrary()
    {
        Gson gson = new Gson();
        String jsonBookList = gson.toJson(_books, _bookArrayType);

        try
        {
            FileWriter textWriter = new FileWriter(_libraryFile, false);
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
