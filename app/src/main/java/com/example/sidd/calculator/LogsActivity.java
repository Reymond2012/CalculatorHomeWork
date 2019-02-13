package com.example.sidd.calculator;

import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LogsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        TextView tvLogs = findViewById(R.id.tvDispaly);


        ArrayList<String> logs = getIntent().getStringArrayListExtra("LogsResult");

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < logs.size(); i++) {
            stringBuilder.append(logs.get(i));
            stringBuilder.append("\n");

        }
        Bus bus = (Bus) getIntent().getSerializableExtra("Bus");


        Room room = (Room) getIntent().getParcelableExtra("Room");

        //tvLogs.setText(readDataFromFile());


        RecyclerView recyclerView = findViewById(R.id.rvData);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        ActivityAdaptor logsAdapter = new ActivityAdaptor(logs);
        recyclerView.setAdapter(logsAdapter);

    }
            private String readDataFromFile(){
                //File file = new File(getFilesDir(), "Logs.txt");
                File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "Calculator/Logs.txt");

                int size = (int) file.length();
                byte[] contents = new byte[size];
                try (FileInputStream fileInputStream = new FileInputStream(file)) {
                    fileInputStream.read(contents);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return new String(contents);
            }


        }




