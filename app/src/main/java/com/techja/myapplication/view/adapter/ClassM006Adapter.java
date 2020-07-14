package com.techja.myapplication.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.techja.myapplication.R;
import com.techja.myapplication.model.ClassEntity;

import java.util.List;

public class ClassM006Adapter extends RecyclerView.Adapter<ClassM006Adapter.ClassM006Holder> {
    private List<ClassEntity> listData;
    private Context context;

    public ClassM006Adapter(List<ClassEntity> listData, Context context) {
        this.listData = listData;
        this.context = context;
    }

    @NonNull
    @Override
    public ClassM006Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(context).inflate(R.layout.item_m006_list_class, parent, false);
        return new ClassM006Holder(item);
    }


    @Override
    public void onBindViewHolder(@NonNull ClassM006Holder holder, int position) {
        ClassEntity entity = listData.get(position);
        holder.tvClassCode.setText(entity.getClassCode());
        holder.tvClassName.setText(entity.getClassName());
        holder.tvClassName.setTag(entity);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class ClassM006Holder extends RecyclerView.ViewHolder {
        TextView tvClassName, tvClassCode;
        Button btListHS;

        public ClassM006Holder(@NonNull View itemView) {
            super(itemView);
            tvClassName = itemView.findViewById(R.id.tv_name_class_m006);
            tvClassCode = itemView.findViewById(R.id.tv_class_code_m006);
            btListHS = itemView.findViewById(R.id.bt_list_006);
            btListHS.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ClassEntity data = (ClassEntity) tvClassName.getTag();
                    callBack.clickButtonListHS(data);
                }
            });

        }
    }

    private M006AdapterListener callBack;

    public void setClicklistener(M006AdapterListener event) {
        callBack = event;
    }

    public interface M006AdapterListener {
        void clickButtonListHS(ClassEntity data);
    }
}