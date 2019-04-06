package com.example.qlnv_full;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main_baocao extends AppCompatActivity {

    private Button btnDanhsach,btnTuyenDung,btnChinhsach,btnThoatct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_baocao);


        btnDanhsach = (Button) findViewById(R.id.btnDanhsach);
        btnDanhsach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main_baocao.this,MainGiaoDien_Activity.class);
                startActivity(intent);
            }
        });

        btnThoatct=(Button) findViewById(R.id.btnThoatct);
        btnThoatct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Main_baocao.this,android.R.style.Theme_DeviceDefault_Light_Dialog);
                builder.setTitle("Bạn chắc chắn muốn thoát chứ !");
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setPositiveButton("có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onBackPressed();
                    }
                });
                builder.setNegativeButton("không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });


    }
}
