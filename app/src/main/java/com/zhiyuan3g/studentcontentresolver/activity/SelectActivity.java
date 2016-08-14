package com.zhiyuan3g.studentcontentresolver.activity;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ListView;

import com.zhiyuan3g.studentcontentresolver.R;
import com.zhiyuan3g.studentcontentresolver.adapter.SelectAdapter;
import com.zhiyuan3g.studentcontentresolver.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class SelectActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        ListView lvStudent = (ListView) findViewById(R.id.lvStudent);

        ContentResolver resolver = getContentResolver();
        Uri uri = Uri.parse("content://com.zhiyuan3g.contentprovider/student");

        Cursor cursor;

        List<Student> students = null;

        try {

            students = new ArrayList<>();

            cursor = resolver.query(uri, null, null, null, null);

            if (cursor != null) {
                while (cursor.moveToNext()) {
                    int id = cursor.getInt(cursor.getColumnIndex("_id"));
                    String name = cursor.getString(cursor.getColumnIndex("name"));
                    int age = cursor.getInt(cursor.getColumnIndex("age"));

                    Student student = new Student();
                    student.setId(id);
                    student.setName(name);
                    student.setAge(age);
                    students.add(student);
                }
            }
            cursor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        SelectAdapter adapter = new SelectAdapter(this, students);
        lvStudent.setAdapter(adapter);
    }
}
