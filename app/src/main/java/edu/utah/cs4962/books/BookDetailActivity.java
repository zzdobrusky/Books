package edu.utah.cs4962.books;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;

/**
 * Created by zbynek on 10/1/2014.
 */
public class BookDetailActivity extends Activity
{
    public static final String BOOK_TITLE_EXTRA = "book_title";
    public static final String BOOK_INDEX_EXTRA = "book_index";
    public static int CHOOSE_COLOR_REQUEST_CODE = 10;
    public static final String CHOOSE_COLOR_REQUEST_COLOR_EXTRA = "chosen_color";
    private File _libraryFile;
    int _bookIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        _libraryFile = new File(getFilesDir(), "library.txt");

        LinearLayout bookLayout = new LinearLayout(this);
        bookLayout.setOrientation(LinearLayout.HORIZONTAL);


        TextView bookTitleTextView = new TextView(this);
        bookTitleTextView.setBackgroundColor(Color.GREEN);
        LinearLayout.LayoutParams textViewLP = new LinearLayout.LayoutParams(
                0,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                1);
        textViewLP.gravity = Gravity.CENTER_HORIZONTAL;
        bookLayout.addView(bookTitleTextView, textViewLP);

        Button deleteButton = new Button(this);
        deleteButton.setText(R.string.button_label);// ??? getString(R.string.button_label));
        LinearLayout.LayoutParams buttonLP = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        deleteButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(_bookIndex >= 0 && _bookIndex < Library.getInstance(_libraryFile).getBookCount())
                    Library.getInstance(_libraryFile).removeBook(_bookIndex);
            }
        });

        bookLayout.addView(deleteButton, buttonLP);

        setContentView(bookLayout);

       if (getIntent().hasExtra(BOOK_INDEX_EXTRA))
       {
           //String bookTitle = getIntent().getExtras().getString(BOOK_TITLE_EXTRA);
           _bookIndex = getIntent().getExtras().getInt(BOOK_INDEX_EXTRA);
           String bookTitle = Library.getInstance(_libraryFile).getBook(_bookIndex).title;
           bookTitleTextView.setText(bookTitle);
       }

       //setResult(Integer.parseInt(CHOOSE_COLOR_REQUEST_COLOR_EXTRA));
    }

}
