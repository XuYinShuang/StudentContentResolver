package com.zhiyuan3g.studentcontentresolver.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zhiyuan3g.studentcontentresolver.R;
import com.zhiyuan3g.studentcontentresolver.entity.Student;

import java.util.List;

/**
 * Created by Administrator on 2016/4/28 0028.
 */
public class SelectAdapter extends BaseAdapter {

    private Context context;
    private List<Student> students;
    private LayoutInflater inflater;

    public SelectAdapter(Context context, List<Student> students) {
        this.context = context;
        this.students = students;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            holder = new Holder();
            convertView = inflater.inflate(R.layout.list_view_item, null);
            holder.txtId = (TextView) convertView.findViewById(R.id.txtId);
            holder.txtName = (TextView) convertView.findViewById(R.id.txtName);
            holder.txtAge = (TextView) convertView.findViewById(R.id.txtAge);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        Student student = students.get(position);
        holder.txtId.setText(String.valueOf(student.getId()));
        holder.txtName.setText(student.getName());
        holder.txtAge.setText(String.valueOf(student.getAge()));
        return convertView;
    }

    private class Holder {
        private TextView txtId, txtName, txtAge;
    }
}
