package edu.utah.cs4962.books;

import android.app.Activity;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;



public class BookListActivity extends Activity implements ListAdapter
{
    private File _libraryFile;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        _libraryFile = new File(getFilesDir(), "library.txt");

//        _library.addBook(new Book("Song of Ice and Fire"));
//        _library.addBook(new Book("Words of Radience"));
//        _library.addBook(new Book("Mistborn"));
//        _library.addBook(new Book("Ende's Game"));
//        _library.addBook(new Book("Green Eggs and Ham"));
//        _library.addBook(new Book("Catcher in the Rye"));
//        _library.addBook(new Book("Harry Potter and Sorcerer's Stone"));


//        _bookList.add("Mistborn");
//        _bookList.add("Words of Radience");
//        _bookList.add("Green Eggs and Ham");
//        _bookList.add("Ender's Game");

//        _bookImageList.add(R.drawable.book0);
//        _bookImageList.add(R.drawable.book1);
//        _bookImageList.add(R.drawable.book2);
//        _bookImageList.add(R.drawable.book3);


        ListView bookListView = new ListView(this);
        bookListView.setAdapter( this);
        bookListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                //Toast.makeText(BookListActivity.this, parent.getAdapter().getItem(position).toString(), Toast.LENGTH_LONG).show();
                int bookIndex = position;

                Intent bookDetailIntent = new Intent();
                bookDetailIntent.setClass(BookListActivity.this, BookDetailActivity.class);
                bookDetailIntent.putExtra(BookDetailActivity.BOOK_INDEX_EXTRA, bookIndex);

                //startActivityForResult(bookDetailIntent, BookDetailActivity.CHOOSE_COLOR_REQUEST_CODE);
                startActivity(bookDetailIntent);
            }
        });
        setContentView(bookListView);
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data)
//    {
//        super.onActivityResult(requestCode, resultCode, data);
//    }
//
//    @Override
//    protected void onResume()
//    {
//        super.onResume();
//
//        Library.getInstance(_libraryFile).loadLibrary();
//    }

//    @Override
//    protected void onPause()
//    {
//        super.onPause();
//
//        Library.getInstance(_libraryFile).saveLibrary();
//    }

    @Override
    public boolean isEmpty()
    {
        return false;
    }

    @Override
    public int getCount()
    {
        return Library.getInstance(_libraryFile).getBookCount();
    }

    @Override
    public boolean hasStableIds()
    {
        return true;
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public Object getItem(int position)
    {
        return Library.getInstance(_libraryFile).getBook(position);
    }

    @Override
    public int getViewTypeCount()
    {
        return 1;
    }

    @Override
    public int getItemViewType(int position)
    {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        //long itemId = getItemId(position); returns Id from some data model, we don't have that
        //String itemText = (String)getItem(position);
        int bookIndex = position;
        String itemText = Library.getInstance(_libraryFile).getBook(bookIndex).title;
        //int itemResource = _bookImageList.get(position);

        LinearLayout bookLayout = new LinearLayout(this);
        bookLayout.setOrientation(LinearLayout.HORIZONTAL);

        //ImageView bookImageView = new ImageView(this);
        //bookImageView.setImageResource(itemResource);
       // bookLayout.addView(bookImageView);

        TextView bookView = null;
//        if(convertView != null && convertView.getClass() == TextView.class)
//            bookView = (TextView)convertView;
//        else
//        {
            bookView = new TextView(this);
//        }
        bookView.setText(itemText);
        bookLayout.addView(bookView);

        return bookLayout;
    }



    @Override
    public boolean areAllItemsEnabled()
    {
        return true;
    }

    @Override
    public boolean isEnabled(int i)
    {
        return true;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver)
    {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver)
    {

    }
}
