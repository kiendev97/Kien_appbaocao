package com.example.qlnv_full;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edUser,edPassworl;
    private Button btnLongin,btnSingup,btnExit;
    String TenAD = "admin";
    String MkAD = "admin";
    String TenMb;
    String MkMb;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Anhxa();
        controlButton ();

        btnLongin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edUser.getText().length() != 0 && edPassworl.getText().length() !=0){
                    if (edUser.getText().toString().equals(TenAD) && edPassworl.getText().toString().equals(MkAD)){
                        Toast.makeText(MainActivity.this,"Ban dang nhap thanh cong",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this,Main_baocao.class);
                        startActivities(new Intent[]{intent});
                    }else if (edUser.getText().toString().equals(TenAD) && edPassworl.getText().toString().equals(MkAD)){
                        Toast.makeText(MainActivity.this,"Ban dang nhap thanh cong",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this,Main_baocao.class);
                        startActivities(new Intent[]{intent});
                    }else if (edUser.getText().toString().equals(TenMb) && edPassworl.getText().toString().equals(MkMb))
                    {
                        Toast.makeText(MainActivity.this,"Ban dang nhap thanh cong",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this,MainMember2_Activity.class);
                        startActivities(new Intent[]{intent});
                    }
                    else {

                        Toast.makeText(MainActivity.this,"Ban da dang nhap that bai",Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(MainActivity.this,"Dien day du thong tin",Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

    private void controlButton() {
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this,android.R.style.Theme_DeviceDefault_Light_Dialog);
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
        btnSingup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setTitle("Hộp thoại đăng ký");
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.customdialog);
                final EditText edUserdk = (EditText)dialog.findViewById(R.id.edUserdk);
                final EditText edPassworldk = (EditText)dialog.findViewById(R.id.edPassworldk);
                Button btnDk = (Button)dialog.findViewById(R.id.btnDk);
                Button btnHuydk = (Button)dialog.findViewById(R.id.btnHuydk);
                btnDk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TenMb = edUserdk.getText().toString().trim();
                        MkMb = edPassworldk.getText().toString().trim();
                        edUserdk.setText(TenMb);
                        edPassworldk.setText(MkMb);
                        Toast.makeText(MainActivity.this,"Đăng Ký Thành Công",Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });
                btnHuydk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                dialog.cancel();
                dialog.show();
            }
        });
    }
    private void Anhxa(){
        edUser = (EditText)findViewById(R.id.edUser);
        edPassworl = (EditText)findViewById(R.id.edPassworl);
        btnLongin = (Button)findViewById(R.id.btnLongin);
        btnSingup = (Button)findViewById(R.id.btnSingup);
        btnExit = (Button)findViewById(R.id.btnExit);

    }
}
