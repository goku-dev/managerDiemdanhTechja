package com.techja.myapplication.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.techja.myapplication.App;
import com.techja.myapplication.R;
import com.techja.myapplication.model.ClassEntity;

import java.util.List;

public class ClassAdapter extends RecyclerView.Adapter<ClassAdapter.ClassHolder> {
    private List<ClassEntity> listData;
    private Context context;

    public ClassAdapter(List<ClassEntity> listData, Context context) {
        this.listData = listData;
        this.context = context;
    }

    @NonNull
    @Override
    public ClassHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(context).inflate(R.layout.item_class, parent, false);
        return new ClassHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ClassHolder holder, int position) {
        ClassEntity entity = listData.get(position);
        holder.tvClassName.setText(entity.getClassName());
        holder.tvClassCode.setText(entity.getClassCode());
        holder.tvClassCode.setTag(entity);

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class ClassHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvClassName, tvClassCode;
        Button btTimetable;

        public ClassHolder(@NonNull View itemView) {
            super(itemView);
            tvClassCode = itemView.findViewById(R.id.tv_class_code_m004);
            tvClassCode.setTypeface(App.getInstance().getRegularFont());
            tvClassName = itemView.findViewById(R.id.tv_name_class_m004);
            tvClassName.setTypeface(App.getInstance().getRegularFont());
            btTimetable = itemView.findViewById(R.id.bt_timetable_dialog);
            btTimetable.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {
            ClassEntity entity = (ClassEntity) tvClassCode.getTag();
            if (v.getId() == R.id.bt_timetable_dialog) {
                callBack.clickButtonTimetable(entity);
            }
        }
    }

    private adapterListener callBack;

    public void setCallBackItem(adapterListener event) {
        callBack = event;
    }

    public interface adapterListener {


        void clickButtonTimetable(ClassEntity data);

    }
}
