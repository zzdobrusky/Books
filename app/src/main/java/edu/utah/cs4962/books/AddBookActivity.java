package edu.utah.cs4962.books;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.Date;

/**
 * Created by zbynek on 10/17/2014.
 */
public class AddBookActivity extends Activity
{
    EditText _bookTitleEditText = null;
    private File _libraryFile;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        _libraryFile = new File(getFilesDir(), "library.txt");

        LinearLayout rootLayout = new LinearLayout(this);
        rootLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(rootLayout);

        LinearLayout titleLayout = new LinearLayout(this);
        titleLayout.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams titleLayoutLP = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        rootLayout.addView(titleLayout);

        TextView bookTitleLabel = new TextView(this);
        bookTitleLabel.setText(R.string.book_title);
        LinearLayout.LayoutParams bookTitleLabelLP = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        titleLayout.addView(bookTitleLabel, bookTitleLabelLP);

        _bookTitleEditText = new EditText(this);
        LinearLayout.LayoutParams bookTitleEditTextLP = new LinearLayout.LayoutParams(
                0,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                1
        );
        titleLayout.addView(_bookTitleEditText, bookTitleEditTextLP);

        Button saveBookButton = new Button(this);
        saveBookButton.setText(R.string.save_book_button_label);
        LinearLayout.LayoutParams saveBookButtonLP = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        titleLayout.addView(saveBookButton, saveBookButtonLP);
        saveBookButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String bookTitle = _bookTitleEditText.getText().toString();

                if (bookTitle.length() <= 0)
                {
                    Toast toast = Toast.makeText(view.getContext(), "Book must have a title.", Toast.LENGTH_LONG);
                    toast.show();
                }
                else
                {

                    Book book = new Book();
                    book.title = bookTitle;
                    book.publicationDate = new Date();
                    Library.getInstance(_libraryFile).addBook(book);
                    finish();
                }
            }
        });
    }
}
