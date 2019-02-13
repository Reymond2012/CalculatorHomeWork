package com.example.sidd.calculator;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ActivityAdaptor extends RecyclerView.Adapter<ActivityAdaptor.LogsViewHolder> {

    private final List<String> data = new ArrayList<>();

    public ActivityAdaptor(List<String>data){
        this.data.addAll(data);
    }
    @NonNull
    @Override
    public LogsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View rootView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adaptor_logs, viewGroup, false);

        return new LogsViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull LogsViewHolder logsViewHolder, int position) {
        logsViewHolder.tvDispaly.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class  LogsViewHolder extends RecyclerView.ViewHolder {

        TextView tvDispaly;
        public LogsViewHolder(@NonNull View itemView) {
            super(itemView);

            tvDispaly = itemView.findViewById(R.id.tvDispaly);
        }
    }
}
