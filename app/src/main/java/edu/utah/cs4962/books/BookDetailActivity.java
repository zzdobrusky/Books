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
    public static int CHOOSE_COLOR_REQUEST_CODE = 10;
    public static final String CHOOSE_COLOR_REQUEST_COLOR_EXTRA = "chosen_color";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);


        TextView bookTitleTextView = new TextView(this);
        bookTitleTextView.setBackgroundColor(Color.GREEN);
        bookTitleTextView.setText("Book Title");
        setContentView(bookTitleTextView);

       if (getIntent().hasExtra(BOOK_TITLE_EXTRA))
       {
           String bookTitle = getIntent().getExtras().getString(BOOK_TITLE_EXTRA);
           bookTitleTextView.setText(bookTitle);
       }

       //setResult(Integer.parseInt(CHOOSE_COLOR_REQUEST_COLOR_EXTRA));
    }

}
