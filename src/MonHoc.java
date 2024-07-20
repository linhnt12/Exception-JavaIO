import java.io.Serializable;

public class MonHoc implements Serializable {
    private static int cnt = 100;
    private int maMon, soDV;
    private String tenMon, loai;

    public MonHoc() {
    }

    public static int getCnt() {
        return cnt;
    }

    public static void setCnt(int cnt) {
        MonHoc.cnt = cnt;
    }

    public MonHoc(String tenMon, int soDV, String loai) {
        this.maMon = cnt++;
        this.tenMon = tenMon;
        this.soDV = soDV;
        this.loai = loai;
    }

    public int getMaMon() {
        return maMon;
    }

    public void setMaMon(int maMon) {
        this.maMon = maMon;
    }

    public int getSoDV() {
        return soDV;
    }

    public void setSoDV(int soDV) {
        this.soDV = soDV;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    @Override
    public String toString() {
        return maMon + "\t" + tenMon + "\t" + soDV + "\t" + loai;
    }
}
