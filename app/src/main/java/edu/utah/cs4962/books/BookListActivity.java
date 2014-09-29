package edu.utah.cs4962.books;

import android.app.Activity;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class BookListActivity extends Activity implements ListAdapter
{
    int _viewCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ListView bookListView = new ListView(this);
        bookListView.setAdapter( this);
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
        return 1000000;
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
        return "The Way of Kings #" + position;
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
        String itemText = (String)getItem(position);
        TextView bookView = null;
        if(convertView != null && convertView.getClass() == TextView.class)
            bookView = (TextView)convertView;
        else
        {
            bookView = new TextView(this);
            _viewCount++;
            Log.i("viewCount", "viewCount = " + _viewCount);
        }

        bookView.setText(itemText);

        return bookView;
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
