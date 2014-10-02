package edu.utah.cs4962.books;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by zbynek on 10/1/2014.
 */
public class BookDetailActivity extends Activity
{
    public static final String BOOK_TITLE_EXTRA = "book_title";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);


        TextView bookTitleTextView = new TextView(this);
        bookTitleTextView.setBackgroundColor(Color.GREEN);
        setContentView(bookTitleTextView);

        if (getIntent().hasExtra())
    }
}
