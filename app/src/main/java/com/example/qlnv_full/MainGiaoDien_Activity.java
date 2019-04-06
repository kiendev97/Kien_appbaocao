package com.example.qlnv_full;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainGiaoDien_Activity extends AppCompatActivity {
    DataBase dataBase;
    private Adapter adapter;
    private ArrayList<NhanVien> nhanVienList= new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_giao_dien_);
        bindView();
        EditText edTk= findViewById(R.id.tkTen);
        EditText edTKPB = findViewById(R.id.tkPhongBan);
        edTk.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());

            }
        });
        edTKPB.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());

            }
        });

        dataBase = new DataBase(this,"QLNS3",null,1);
        dataBase.QueryData("CREATE TABLE IF NOT EXISTS PhongBan (MaPB VARCHAR(10) PRIMARY KEY,TenPB VARCHAR(10) )");
        dataBase.QueryData("CREATE TABLE IF NOT EXISTS LyLichNhanVien(Id INTEGER PRIMARY KEY AUTOINCREMENT,MaNV VARCHAR(10),TenNV VARCHAR(30),GioiTinh VARCHAR(5),MaCV VARCHAR(10),ChucVu VARCHAR(20),MaPB VARCHAR(10),TenPB VARCHAR(20),NgaySinh VARCHAR(20),NoiSinh VARCHAR(100),QueQuan VARCHAR(100),DienThoai VARCHAR(11),CMT VARCHAR(20),DanToc VARCHAR(10),TonGiao VARCHAR(10),MaHV VARCHAR(10),HocVan VARCHAR(20))");
        dataBase.QueryData("CREATE TABLE IF NOT EXISTS ChucVu(MaCV VARCHAR(10) PRIMARY KEY,ChuVu VARCHAR(20))");
        dataBase.QueryData("CREATE TABLE IF NOT EXISTS HocVan(MaHV VARCHAR(10) PRIMARY KEY,HocVan VARCHAR(50))");
        dataBase.QueryData("CREATE TABLE IF NOT EXISTS Luong(MaLuong VARCHAR(10) PRIMARY KEY,MaNV VARCHAR(10),MaPB VARCHAR(10),HeSoLuong INTEGER,LuongCB VARCHAR(20),PhuCap VARCHAR(20))");
                GetDataNhanVien();
                FloatingActionButton fab = findViewById(R.id.fab);
                fab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                final Dialog dialog = new Dialog(MainGiaoDien_Activity.this);
                dialog.setTitle("Hộp thoại Thêm Nhân Viên");
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.addnhanvien);
                        final     EditText edMaNV = (EditText)dialog.findViewById(R.id.edMaNV);
                        final     EditText edTenNV  = (EditText)dialog.findViewById(R.id.edTenNV);
                        final     EditText edGioiTinh = (EditText)dialog.findViewById(R.id.edGioiTinh);
                        final     EditText edChucVu = (EditText)dialog.findViewById(R.id.edChucVu);
                        final     EditText edMaPB = (EditText)dialog.findViewById(R.id.edMaPB);
                        final     EditText edTenPB = (EditText)dialog.findViewById(R.id.edTenPB);
                        final     EditText edNgaySinh = (EditText)dialog.findViewById(R.id.edNgaySinh);
                        final     EditText edNoiSinh = (EditText)dialog.findViewById(R.id.edNoiSinh);
                        final     EditText edQueQuan = (EditText)dialog.findViewById(R.id.edQueQuan);
                        final     EditText edDienThoai = (EditText)dialog.findViewById(R.id.edDienThoai);
                        final     EditText edCMT = (EditText)dialog.findViewById(R.id.edCMT);
                        final     EditText edDanToc = (EditText)dialog.findViewById(R.id.edDantoc);
                        final     EditText edTonGiao = (EditText)dialog.findViewById(R.id.edTonGiao);
                        final     EditText edHocVan = (EditText)dialog.findViewById(R.id.edHocVan);
                Button btnadd = (Button)dialog.findViewById(R.id.btnadd);
                    btnadd.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String MaNV  =edMaNV.getText().toString();
                            String TenNV =edTenNV.getText().toString();
                            String GioiTinh  =edGioiTinh.getText().toString();
                            String ChucVu  =edChucVu.getText().toString();
                            String MaPB  =edMaPB.getText().toString();
                            String TenPB  =edTenPB.getText().toString();
                            String NgaySinh  =edNgaySinh.getText().toString();
                            String NoiSinh  =edNoiSinh.getText().toString();
                            String QueQuan  =edQueQuan.getText().toString();
                            String DienThoai  =edDienThoai.getText().toString();
                            String CMT        = edCMT.getText().toString();
                            String Dantoc  =edDanToc.getText().toString();
                            String TonGiao  =edTonGiao.getText().toString();
                            String HocVan  =edHocVan.getText().toString();
                            if (TenNV.equals(""))
                            {
                                Toast.makeText(MainGiaoDien_Activity.this,"Vui Lòng nhập đầy đủ thông tin",Toast.LENGTH_SHORT).show();

                            }else
                            {
                                dataBase.QueryData("INSERT INTO LyLichNhanVien VALUES (null,'"+MaNV+"','"+TenNV+"','"+GioiTinh+"',null,'"+ChucVu+"','"+MaPB+"','"+TenPB+"','"+NgaySinh+"','"+NoiSinh+"','"+QueQuan+"','"+DienThoai+"','"+CMT+"','"+Dantoc+"','"+TonGiao+"',null,'"+HocVan+"')");
                                Toast.makeText(MainGiaoDien_Activity.this,"ĐÃ THÊM !",Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                                GetDataNhanVien();
                                adapter.notifyDataSetChanged();

                            }



                        }
                    });

                Button btnHuy =(Button)dialog.findViewById(R.id.btnHuy);
                btnHuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        findViewById(R.id.btnThoat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(MainGiaoDien_Activity.this,android.R.style.Theme_DeviceDefault_Light_Dialog);
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
    private  void bindView(){
            RecyclerView rvNhanVien = findViewById(R.id.rvNhanVien);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
            adapter = new Adapter(this,nhanVienList);
            rvNhanVien.setLayoutManager(layoutManager);
            rvNhanVien.setAdapter(adapter);
            adapter.notifyDataSetChanged();
}
       private void filter(String text){

        ArrayList<NhanVien> filterlist = new ArrayList<>();
        for (NhanVien item : nhanVienList){

            if (item.getTenNV().toLowerCase().contains(text.toLowerCase())||item.getTenPB().toLowerCase().contains(text.toLowerCase())){
                filterlist.add(item);
            }

        }
        adapter.filterlist(filterlist);
        adapter.notifyDataSetChanged();
    }


    public void GetDataNhanVien(){
        Cursor dataNhanVien =dataBase.GetData("SELECT * FROM LyLichNhanVien");
        nhanVienList.clear();
        while (dataNhanVien.moveToNext()){
            int id = dataNhanVien.getInt(0);
            String MaNV = dataNhanVien.getString(1);
            String TenNV = dataNhanVien.getString(2);
           String  GioiTinh = dataNhanVien.getString(3);
           String MaCV = dataNhanVien.getString(4);
           String ChucVu = dataNhanVien.getString(5);
            String MaPB = dataNhanVien.getString(6);
            String TenPB = dataNhanVien.getString(7);
            String NgaySinh = dataNhanVien.getString(8);
             String NoiSinh = dataNhanVien.getString(9);
            String QueQuan = dataNhanVien.getString(10);
           String DienThoai = dataNhanVien.getString(11);
            String CMT = dataNhanVien.getString(12);
              String DanToc = dataNhanVien.getString(13);
            String TonGiao = dataNhanVien.getString(14);
            String MaHV = dataNhanVien.getString(15);
           String HocVan = dataNhanVien.getString(16);

          nhanVienList.add(new NhanVien(id,MaNV,TenNV,GioiTinh,MaCV,ChucVu,MaPB,TenPB,NgaySinh,NoiSinh,QueQuan,DienThoai,CMT,DanToc,TonGiao,MaHV,HocVan));

        }

    }

    public void DiaLogSuaNhanVien(final long id, String MaNV, String TenNV, String GoiTinh, final String ChucVu, final String MaPB, String TenPB, String NgaySinh, String NoiSinh, String QueQuan, String DienThoai, String CMT, String DanToc, String TonGiao, String HocVan) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.editnhanvien);
        final EditText edMaNV = (EditText) dialog.findViewById(R.id.edMaNV);
        final EditText edTenNV = (EditText) dialog.findViewById(R.id.edTenNV);
        final EditText edGioiTinh = (EditText) dialog.findViewById(R.id.edGioiTinh);
        final EditText edChucVu = (EditText) dialog.findViewById(R.id.edChucVu);
        final EditText edMaPB = (EditText) dialog.findViewById(R.id.edMaPB);
        final EditText edTenPB = (EditText) dialog.findViewById(R.id.edTenPB);
        final EditText edNgaySinh = (EditText) dialog.findViewById(R.id.edNgaySinh);
        final EditText edNoiSinh = (EditText) dialog.findViewById(R.id.edNoiSinh);
        final EditText edQueQuan = (EditText) dialog.findViewById(R.id.edQueQuan);
        final EditText edDienThoai = (EditText) dialog.findViewById(R.id.edDienThoai);
        final EditText edCMT = (EditText) dialog.findViewById(R.id.edCMT);
        final EditText edDanToc = (EditText) dialog.findViewById(R.id.edDantoc);
        final EditText edTonGiao = (EditText) dialog.findViewById(R.id.edTonGiao);
        final EditText edHocVan = (EditText) dialog.findViewById(R.id.edHocVan);
        Button btnedit = (Button) dialog.findViewById(R.id.btnedit);
        Button btnHuyedit = (Button) dialog.findViewById(R.id.btnHuyedit);
        edMaNV.setText(MaNV);
        edTenNV.setText(TenNV);
        edGioiTinh.setText(GoiTinh);
        edChucVu.setText(ChucVu);
        edMaPB.setText(MaPB);
        edTenPB.setText(TenPB);
        edNgaySinh.setText(NgaySinh);
        edNoiSinh.setText(NoiSinh);
        edQueQuan.setText(QueQuan);
        edDienThoai.setText(DienThoai);
        edCMT.setText(CMT);
        edDanToc.setText(DanToc);
        edTonGiao.setText(TonGiao);
        edHocVan.setText(HocVan);
        adapter.notifyDataSetChanged();
        btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String MaNVmoi = edMaNV.getText().toString().trim();
                String TenNVmoi = edTenNV.getText().toString().trim();
                String GioiTinhMoi = edGioiTinh.getText().toString().trim();
                String ChucVuMoi = edChucVu.getText().toString().trim();
                String MaPbmoi = edMaPB.getText().toString().trim();
                String TenPBmoi = edTenPB.getText().toString().trim();
                String NgaySinhmoi = edNgaySinh.getText().toString().trim();
                String NoiSinhmoi = edNoiSinh.getText().toString().trim();
                String QueQuanmoi = edQueQuan.getText().toString().trim();
                String DienThoaimoi = edDienThoai.getText().toString().trim();
                String CMTmoi = edCMT.getText().toString().trim();
                String DanTocmoi = edDanToc.getText().toString().trim();
                String TonGiaomoi = edTonGiao.getText().toString().trim();
                String HocVanmoi = edHocVan.getText().toString().trim();
                dataBase.QueryData("UPDATE LyLichNhanVien SET MaNV = '"+MaNVmoi+"',TenNV = '"+TenNVmoi+"',GioiTinh = '"+GioiTinhMoi+"',ChucVu = '"+ChucVuMoi+"',MaPB='"+MaPbmoi+"',TenPB='"+TenPBmoi+"',NgaySinh='"+NgaySinhmoi+"',NoiSinh='"+NoiSinhmoi+"',QueQuan='"+QueQuanmoi+"',DienThoai='"+DienThoaimoi+"',CMT='"+CMTmoi+"',DanToc='"+DanTocmoi+"',TonGiao ='"+TonGiaomoi+"',HocVan = '"+HocVanmoi+"' WHERE Id='"+id+"'");
                Toast.makeText(MainGiaoDien_Activity.this,"Đã Sửa Thành Công !",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                adapter.notifyDataSetChanged();
                GetDataNhanVien();

            }
        });

        btnHuyedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();

    }
    public void DiaLogXemChiTiet(final long id, String MaNV, String TenNV, String GoiTinh, final String ChucVu, final String MaPB, String TenPB, String NgaySinh, String NoiSinh, String QueQuan, String DienThoai, String CMT, String DanToc, String TonGiao, String HocVan) {
        final Dialog dialog = new Dialog(this);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.xemchitietnv);
        final TextView tvMaNv = (TextView) dialog.findViewById(R.id.tvMaNV);
        final TextView tvTenNV = (TextView) dialog.findViewById(R.id.tvTenNV);
        final TextView tvGioiTinh = (TextView) dialog.findViewById(R.id.tvGioiTinh);
        final TextView tvChucVu = (TextView) dialog.findViewById(R.id.tvChucVu);
        final TextView tvMaPB = (TextView) dialog.findViewById(R.id.tvMaPB);
        final TextView tvTenPB = (TextView) dialog.findViewById(R.id.tvTenPB);
        final TextView tvNgaySinh = (TextView) dialog.findViewById(R.id.tvNgaySinh);
        final TextView tvNoiSinh = (TextView) dialog.findViewById(R.id.tvNoiSinh);
        final TextView tvQueQuan = (TextView) dialog.findViewById(R.id.tvQueQuan);
        final TextView tvDienThoai = (TextView) dialog.findViewById(R.id.tvDienThoai);
        final TextView tvCMT = (TextView) dialog.findViewById(R.id.tvCMT);
        final TextView tvDanToc = (TextView) dialog.findViewById(R.id.tvDanToc);
        final TextView tvTonGiao = (TextView) dialog.findViewById(R.id.tvTonGiao);

        final TextView tvHocVan = (TextView) dialog.findViewById(R.id.tvHocVan);

        Button btnHuyXem = (Button) dialog.findViewById(R.id.btnHuyXem);

        tvMaNv.setText(MaNV);
        tvTenNV.setText(TenNV);
        tvGioiTinh.setText(GoiTinh);
        tvChucVu.setText(ChucVu);
        tvMaPB.setText(MaPB);
        tvTenPB.setText(TenPB);
        tvNgaySinh.setText(NgaySinh);
        tvNoiSinh.setText(NoiSinh);
        tvQueQuan.setText(QueQuan);
        tvDienThoai.setText(DienThoai);
        tvCMT.setText(CMT);
        tvDanToc.setText(DanToc);
        tvTonGiao.setText(TonGiao);

        tvHocVan.setText(HocVan);

        btnHuyXem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();


    }

    public void DialogXoa(final String TenNV, final int id){
        AlertDialog.Builder dialogxoa = new AlertDialog.Builder(this);
        dialogxoa.setMessage("Bạn Có Muốn Xóa Thông Tin Của "+TenNV+" Không !");
        dialogxoa.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dataBase.QueryData("DELETE FROM LyLichNhanVien  WHERE Id ='"+id+"'");
                Toast.makeText(MainGiaoDien_Activity.this,"Đã Xóa Thông tin"+TenNV,Toast.LENGTH_SHORT).show();
                GetDataNhanVien();
                adapter.notifyDataSetChanged();

            }
        });
        dialogxoa.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        adapter.notifyDataSetChanged();
        dialogxoa.show();


    }

    private void ShowFragment(Fragment fm){
        getSupportFragmentManager().beginTransaction().replace(R.id.Layoutchinh,fm).commit();
}
}
