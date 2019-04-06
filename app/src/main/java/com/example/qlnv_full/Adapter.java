package com.example.qlnv_full;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter <Adapter.ViewHolder> {

    public MainGiaoDien_Activity context;
    public List<NhanVien> NhanVienList;
    public Adapter(MainGiaoDien_Activity context,List<NhanVien>List){
        this.context = context;
        this.NhanVienList=List;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int typeView) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_recycle,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
         final NhanVien nhanvien = NhanVienList.get(position);
            viewHolder.tvMaNV.setText(nhanvien.getMaNV());
             viewHolder.tvTenNV.setText(nhanvien.getTenNV());
             viewHolder.btnXoa.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     context.DialogXoa(nhanvien.getTenNV(), (int) nhanvien.getId());
                 }
             });

             viewHolder.btnSua.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     context.DiaLogSuaNhanVien( nhanvien.getId(),nhanvien.getMaNV(), nhanvien.getTenNV(),nhanvien.getGioiTinh(),nhanvien.getChucVu(),nhanvien.getMaPB(),nhanvien.getTenPB(),nhanvien.getNgaySinh(),nhanvien.getNoiSinh(),nhanvien.getQueQuan(),nhanvien.getDienThoai(),nhanvien.getCMT(),nhanvien.getDanToc(),nhanvien.getTonGiao(),nhanvien.getHocVan());

                 }
             });
             viewHolder.btnXemChiTiet.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     context.DiaLogXemChiTiet( nhanvien.getId(),nhanvien.getMaNV(), nhanvien.getTenNV(),nhanvien.getGioiTinh(),nhanvien.getChucVu(),nhanvien.getMaPB(),nhanvien.getTenPB(),nhanvien.getNgaySinh(),nhanvien.getNoiSinh(),nhanvien.getQueQuan(),nhanvien.getDienThoai(),nhanvien.getCMT(),nhanvien.getDanToc(),nhanvien.getTonGiao(),nhanvien.getHocVan());
                 }
             });


    }

    @Override
    public int getItemCount() {
        return NhanVienList.size();
    }


    public void filterlist(ArrayList<NhanVien> filteredList){
        NhanVienList = filteredList;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvMaNV;
        TextView tvTenNV;
        Button btnSua;
        Button btnXoa;
        Button btnXemChiTiet;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMaNV = itemView.findViewById(R.id.tvMaNV);
            tvTenNV = itemView.findViewById(R.id.tvTenNV);
            btnSua = itemView.findViewById(R.id.btnSua);
            btnXoa = itemView.findViewById(R.id.btnXoa);
            btnXemChiTiet = itemView.findViewById(R.id.btnXemChiTiet);
        }

    }


}

