import java.io.Serializable;

public class BangDiem implements Serializable {
    private SinhVien sinhVien;
    private MonHoc[] dsMonHoc;
    private double[] dsDiem;
    private static int cntMonHoc;

    public BangDiem() {
    }

    public BangDiem(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
        this.dsMonHoc = new MonHoc[100];
        this.dsDiem = new double[100];
        this.cntMonHoc = 0;
    }

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }

    public MonHoc[] getDsMonHoc() {
        return dsMonHoc;
    }

    public void setDsMonHoc(MonHoc[] dsMonHoc) {
        this.dsMonHoc = dsMonHoc;
    }

    public double[] getDsDiem() {
        return dsDiem;
    }

    public void setDsDiem(double[] dsDiem) {
        this.dsDiem = dsDiem;
    }

    public static int getCntMonHoc() {
        return cntMonHoc;
    }

    public static void setCntMonHoc(int cntMonHoc) {
        BangDiem.cntMonHoc = cntMonHoc;
    }

    public void addDiem(MonHoc monHoc, double diem) {
        for (int i=0; i<cntMonHoc; i++) {
            if (monHoc.getMaMon() == dsMonHoc[i].getMaMon()) {
                dsDiem[i] = diem;
                return;
            }
        }
        dsMonHoc[cntMonHoc] = monHoc;
        dsDiem[cntMonHoc] = diem;
        cntMonHoc++;
    }

    public double tinhDiem() {
        double tongDiem = 0;
        double tongTC = 0;
        for (int i=0; i<cntMonHoc; i++) {
            tongDiem += dsMonHoc[i].getSoDV() * dsDiem[i];
            tongTC += dsMonHoc[i].getSoDV();
        }
        return tongDiem/tongTC;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Bảng điểm của sinh viên " + this.sinhVien.getHoTen() + ":\n");
        for (int i=0; i<cntMonHoc; i++) {
            sb.append(dsMonHoc[i].getMaMon()).append("\t").append(dsMonHoc[i].getTenMon()).append("\t").append(String.format("%.2f", dsDiem[i])).append("\n");
        }
        return sb.toString();
    }
}
