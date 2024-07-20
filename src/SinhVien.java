import java.io.Serializable;

public class SinhVien implements Serializable {
    private static int cnt = 10000;
    private int maSV;
    private String hoTen, dchi, sdt, lop;

    public SinhVien() {
    }

    public SinhVien(String hoTen, String dchi, String sdt, String lop) {
        this.maSV = cnt++;
        this.hoTen = hoTen;
        this.dchi = dchi;
        this.sdt = sdt;
        this.lop = lop;
    }

    public static int getCnt() {
        return cnt;
    }

    public static void setCnt(int cnt) {
        SinhVien.cnt = cnt;
    }

    public int getMaSV() {
        return maSV;
    }

    public void setMaSV(int maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDchi() {
        return dchi;
    }

    public void setDchi(String dchi) {
        this.dchi = dchi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    @Override
    public String toString() {
        return maSV + "\t" + hoTen + "\t" + dchi + "\t" + sdt + "\t" + lop;
    }
}
