package com.example.qlnv_full;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdapterMember extends RecyclerView.Adapter<AdapterMember.ViewHolder> {
    Main_Member_Activity context;
    public List<NhanVien> NhanVienlist;

    public AdapterMember(Main_Member_Activity context,List<NhanVien>List){
        this.context=context;
        this.NhanVienlist=List;
    }

    @NonNull
    @Override
    public AdapterMember.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int TypeView) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_member,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMember.ViewHolder viewHolder, int position) {
        final NhanVien nhanvien = NhanVienlist.get(position);
        viewHolder.tvMaNVm.setText(nhanvien.getMaNV());
        viewHolder.tvTenNVm.setText(nhanvien.getTenNV());
        viewHolder.btnXemChiTiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.DiaLogXemChiTietm(nhanvien.getId(),nhanvien.getMaNV(),nhanvien.getTenNV(),nhanvien.getGioiTinh(),nhanvien.getChucVu(),nhanvien.getMaPB(),nhanvien.getTenPB(),nhanvien.getNgaySinh(),nhanvien.getNoiSinh(),nhanvien.getQueQuan(),nhanvien.getDienThoai(),nhanvien.getCMT(),nhanvien.getDanToc(),nhanvien.getTonGiao(),nhanvien.getHocVan());
            }
        });

    }

    @Override
    public int getItemCount() {
        return NhanVienlist.size();
}
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvMaNVm;
        TextView tvTenNVm;
        Button btnXemChiTiet;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMaNVm = itemView.findViewById(R.id.tvMaNVm);
            tvTenNVm= itemView.findViewById(R.id.tvTenNVm);
            btnXemChiTiet = itemView.findViewById(R.id.btnXemChiTiet);
        }

    }
    public void filterlist(ArrayList<NhanVien> filteredList){
        NhanVienlist = filteredList;
        notifyDataSetChanged();
    }
}
