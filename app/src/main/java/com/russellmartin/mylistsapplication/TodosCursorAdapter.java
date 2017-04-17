package com.russellmartin.mylistsapplication;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CursorAdapter;
import android.widget.TextView;
import android.widget.Toast;


import com.russellmartin.mylistsapplication.data.DatabaseHelper;
import com.russellmartin.mylistsapplication.data.MyListsContract;

public class TodosCursorAdapter extends CursorAdapter {
    public TodosCursorAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.todo_list_item, null, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView todoTextView = (TextView) view.findViewById(R.id.tvNote);
        final CheckBox checkBox = (CheckBox) view.findViewById(R.id.checkBox);
        int todoStatus = cursor.getColumnIndex(MyListsContract.TodosEntry.COLUMN_DONE);
        int textColumn = cursor.getColumnIndex(MyListsContract.TodosEntry.COLUMN_TEXT);
        String text = cursor.getString(textColumn);
        todoTextView.setText(text);

        // save the row's _id value in the checkbox's tag for retrieval later

    }
}
