package com.zhiyuan3g.studentcontentresolver.activity;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.zhiyuan3g.studentcontentresolver.R;

public class UpdateActivity extends Activity {

    EditText edtName, edtAge, edtId;
    Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        initView();
    }

    private void initView() {
        edtId = (EditText) findViewById(R.id.edtId);
        edtName = (EditText) findViewById(R.id.edtName);
        edtAge = (EditText) findViewById(R.id.edtAge);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = edtId.getText().toString();
                String name = edtName.getText().toString();
                String age = edtAge.getText().toString();

                ContentResolver resolver = getContentResolver();
                Uri uri = Uri.parse("content://com.zhiyuan3g." +
                        "contentprovider/student");

                ContentValues values = new ContentValues();
                values.put("name", name);
                values.put("age", age);

                Uri updateUri = ContentUris
                        .withAppendedId(uri, Integer.valueOf(id));

                resolver.update(updateUri, values, null, null);
            }
        });
    }
}
