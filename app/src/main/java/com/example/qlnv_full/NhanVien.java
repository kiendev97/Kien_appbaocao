package com.example.qlnv_full;

public class NhanVien {
    private long Id;
    private String MaNV;
    private String TenNV;
    private String GioiTinh;
    private String MaCV;
    private String ChucVu;
    private String MaPB;
    private String TenPB;
    private String NgaySinh;
    private String NoiSinh;
    private String QueQuan;
    private String DienThoai;
    private String CMT;
    private String DanToc;
    private String TonGiao;
    private String MaHV;
    private String HocVan;

    public NhanVien(int id, String maNV, String tenNV, String gioiTinh, String chucVu, String maPB, String tenPB, String ngaySinh, String noiSinh, String queQuan, String dienThoai, String CMT, String danToc, String s, String nv) {
    }

    public NhanVien(long id, String maNV, String tenNV, String gioiTinh, String maCV, String chucVu, String maPB, String tenPB, String ngaySinh, String noiSinh, String queQuan, String dienThoai, String CMT, String danToc, String tonGiao, String maHV, String hocVan) {
        Id = id;
        MaNV = maNV;
        TenNV = tenNV;
        GioiTinh = gioiTinh;
        MaCV = maCV;
        ChucVu = chucVu;
        MaPB = maPB;
        TenPB = tenPB;
        NgaySinh = ngaySinh;
        NoiSinh = noiSinh;
        QueQuan = queQuan;
        DienThoai = dienThoai;
        this.CMT = CMT;
        DanToc = danToc;
        TonGiao = tonGiao;
        MaHV = maHV;
        HocVan = hocVan;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String maNV) {
        MaNV = maNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String tenNV) {
        TenNV = tenNV;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public String getMaCV() {
        return MaCV;
    }

    public void setMaCV(String maCV) {
        MaCV = maCV;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String chucVu) {
        ChucVu = chucVu;
    }

    public String getMaPB() {
        return MaPB;
    }

    public void setMaPB(String maPB) {
        MaPB = maPB;
    }

    public String getTenPB() {
        return TenPB;
    }

    public void setTenPB(String tenPB) {
        TenPB = tenPB;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getNoiSinh() {
        return NoiSinh;
    }

    public void setNoiSinh(String noiSinh) {
        NoiSinh = noiSinh;
    }

    public String getQueQuan() {
        return QueQuan;
    }

    public void setQueQuan(String queQuan) {
        QueQuan = queQuan;
    }

    public String getDienThoai() {
        return DienThoai;
    }

    public void setDienThoai(String dienThoai) {
        DienThoai = dienThoai;
    }

    public String getCMT() {
        return CMT;
    }

    public void setCMT(String CMT) {
        this.CMT = CMT;
    }

    public String getDanToc() {
        return DanToc;
    }

    public void setDanToc(String danToc) {
        DanToc = danToc;
    }

    public String getTonGiao() {
        return TonGiao;
    }

    public void setTonGiao(String tonGiao) {
        TonGiao = tonGiao;
    }

    public String getMaHV() {
        return MaHV;
    }

    public void setMaHV(String maHV) {
        MaHV = maHV;
    }

    public String getHocVan() {
        return HocVan;
    }

    public void setHocVan(String hocVan) {
        HocVan = hocVan;
    }
}
