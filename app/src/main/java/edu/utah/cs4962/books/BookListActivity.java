package edu.utah.cs4962.books;

import android.app.Activity;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class BookListActivity extends Activity implements ListAdapter
{
    int _viewCount = 0;
    ArrayList<String> _bookList = new ArrayList<String>();
    ArrayList<Integer> _bookImageList = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

//        _bookList.add("Song of Ice and Fire");
//        _bookList.add("Words of Radience");
//        _bookList.add("Mistborn");
//        _bookList.add("Ende's Game");
//        _bookList.add("Green Eggs and Ham");
//        _bookList.add("Catcher in the Rye");
//        _bookList.add("Harry Potter and Sorcerer's Stone");


        _bookList.add("Mistborn");
        _bookList.add("Words of Radience");
        _bookList.add("Green Eggs and Ham");
        _bookList.add("Ender's Game");

        _bookImageList.add(R.drawable.book0);
        _bookImageList.add(R.drawable.book1);
        _bookImageList.add(R.drawable.book2);
        _bookImageList.add(R.drawable.book3);


        ListView bookListView = new ListView(this);
        bookListView.setAdapter( this);
        bookListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Toast.makeText(BookListActivity.this, parent.getAdapter().getItem(position).toString(), Toast.LENGTH_LONG).show();
            }
        });
        setContentView(bookListView);
    }


    @Override
    public boolean isEmpty()
    {
        return false;
    }

    @Override
    public int getCount()
    {
        return _bookList.size();
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
        return _bookList.get((int)getItemId(position));
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
        String itemText = _bookList.get(position);
        int itemResource = _bookImageList.get(position);

        LinearLayout bookLayout = new LinearLayout(this);
        bookLayout.setOrientation(LinearLayout.HORIZONTAL);

        ImageView bookImageView = new ImageView(this);
        bookImageView.setImageResource(itemResource);
        bookLayout.addView(bookImageView);

        TextView bookView = null;
//        if(convertView != null && convertView.getClass() == TextView.class)
//            bookView = (TextView)convertView;
//        else
//        {
            bookView = new TextView(this);
            _viewCount++;
//            Log.i("viewCount", "viewCount = " + _viewCount);
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
