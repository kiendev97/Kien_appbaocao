package com.example.qlnv_full;

import android.app.Dialog;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Main_Member_Activity extends AppCompatActivity {
    DataBase dataBase;

    private AdapterMember adapter;
    private ArrayList<NhanVien> nhanVienList= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__member_);
        bindView();
        EditText edTkMb= findViewById(R.id.edTkMb);
        EditText edTkPb=findViewById(R.id.edTkPb);
        edTkPb.addTextChangedListener(new TextWatcher() {
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
        edTkMb.addTextChangedListener(new TextWatcher() {
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
    }

    private  void bindView(){
        RecyclerView rlMemBer = findViewById(R.id.rlMemBer);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        adapter = new AdapterMember(this,nhanVienList);
        rlMemBer.setLayoutManager(layoutManager);
        rlMemBer.setAdapter(adapter);
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
        Cursor DataNhanVien =dataBase.GetData("SELECT * FROM LyLichNhanVien");
        nhanVienList.clear();
        while (DataNhanVien.moveToNext()){
            int id = DataNhanVien.getInt(0);
            String MaNV = DataNhanVien.getString(1);
            String TenNV = DataNhanVien.getString(2);
            String  GioiTinh = DataNhanVien.getString(3);
            String MaCV = DataNhanVien.getString(4);
            String ChucVu = DataNhanVien.getString(5);
            String MaPB = DataNhanVien.getString(6);
            String TenPB = DataNhanVien.getString(7);
            String NgaySinh =DataNhanVien.getString(8);
            String NoiSinh = DataNhanVien.getString(9);
            String QueQuan = DataNhanVien.getString(10);
            String DienThoai = DataNhanVien.getString(11);
            String CMT = DataNhanVien.getString(12);
            String DanToc = DataNhanVien.getString(13);
            String TonGiao = DataNhanVien.getString(14);
            String MaHV = DataNhanVien.getString(15);
            String HocVan = DataNhanVien.getString(16);
            nhanVienList.add(new NhanVien(id,MaNV,TenNV,GioiTinh,MaCV,ChucVu,MaPB,TenPB,NgaySinh,NoiSinh,QueQuan,DienThoai,CMT,DanToc,TonGiao,MaHV,HocVan));
        }

    }

    public void DiaLogXemChiTietm(final long id, String MaNV, String TenNV, String GoiTinh, final String ChucVu, final String MaPB, String TenPB, String NgaySinh, String NoiSinh, String QueQuan, String DienThoai, String CMT, String DanToc, String TonGiao, String HocVan) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.xemchitietnv);
        final TextView tvMaNV = (TextView) dialog.findViewById(R.id.tvMaNV);
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

        tvMaNV.setText(MaNV);
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
}
