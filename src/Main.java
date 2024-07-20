import java.io.*;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static SinhVien[] dsSinhVien = new SinhVien[100];
    private static int cntSinhVien = 0;
    private static MonHoc[] dsMonHoc = new MonHoc[100];
    private static int cntMonHoc = 0;
    private static BangDiem[] dsBangDiem = new BangDiem[100];
    private static int cntBangDiem = 0;

    public static void main(String[] args) {
        loadData();
        while (true) {
            System.out.println("Menu");
            System.out.println("1. Nhập sinh viên.");
            System.out.println("2. Nhập môn học.");
            System.out.println("3. Nhập điểm cho sinh viên.");
            System.out.println("4. Sắp xếp bảng điểm theo tên sinh viên.");
            System.out.println("5. Sắp xếp bảng điểm theo tên môn học.");
            System.out.println("6. Tính GPA.");
            System.out.println("0. Thoát.");

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    nhapSinhVien();
                    inDsSinhVien();
                    break;
                case 2:
                    nhapMonHoc();
                    inDsMonHoc();
                    break;
                case 3:
                    nhapDiem();
                    inBangDiem();
                    break;
                case 4:
                    sapXepBangDiemTheoTenSV();
                    break;
                case 5:
                    sapXepBangDiemTheoTenMH();
                    break;
                case 6:
                    tinhGPA();
                    break;
                case 0:
                    saveData();
                    System.out.println("Kết thúc!");
                    return;
            }
        }
    }

    private static void nhapSinhVien() {
        int current = SinhVien.getCnt();
        SinhVien.setCnt(current + cntSinhVien);
        System.out.print("Nhập số lượng sinh viên: ");
        int slSinhVien = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < slSinhVien; i++) {
            System.out.println("Nhập thông tin sinh viên thứ " + (i + 1));
            System.out.print("Họ và tên sinh viên: ");
            String hoTen = sc.nextLine();
            System.out.print("Địa chỉ: ");
            String dchi = sc.nextLine();
            System.out.print("Số điện thoại: ");
            String sdt = sc.nextLine();
            System.out.print("Lớp: ");
            String lop = sc.nextLine();
            dsSinhVien[cntSinhVien++] = new SinhVien(hoTen, dchi, sdt, lop);
        }
    }

    private static void inDsSinhVien() {
        System.out.println("Danh sách sinh viên: ");
        for (int i = 0; i < cntSinhVien; i++) {
            System.out.println(dsSinhVien[i]);
        }
    }

    private static void nhapMonHoc() {
        int current = MonHoc.getCnt();
        MonHoc.setCnt(current + cntMonHoc);
        System.out.print("Nhập số lượng môn học: ");
        int slMH = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < slMH; i++) {
            System.out.println("Nhập thông tin môn học thứ " + (i + 1));
            System.out.print("Nhập tên môn học: ");
            String tenMon = sc.nextLine();
            System.out.print("Nhập số đơn vị học trình: ");
            int soDV = Integer.parseInt(sc.nextLine());
            System.out.println("Nhập loại môn: ");
            System.out.println("1. Đại cương.");
            System.out.println("2. Cơ sở ngành.");
            System.out.println("3. Chuyên ngành.");
            String loai = "";
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    loai = "Đại cương";
                    break;
                case 2:
                    loai = "Cơ sở ngành";
                    break;
                case 3:
                    loai = "Chuyên ngành";
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    return;
            }
            dsMonHoc[cntMonHoc++] = new MonHoc(tenMon, soDV, loai);
        }
    }

    private static void inDsMonHoc() {
        System.out.println("Danh sách môn học: ");
        for (int i = 0; i < cntMonHoc; i++) {
            System.out.println(dsMonHoc[i]);
        }
    }

    private static void nhapDiem() {
        System.out.print("Nhập mã sinh viên: ");
        int maSV = Integer.parseInt(sc.nextLine());
        SinhVien sinhVien = null;
        for (int i = 0; i < cntSinhVien; i++) {
            if (dsSinhVien[i].getMaSV() == maSV) {
                sinhVien = dsSinhVien[i];
                break;
            }
        }
        if (sinhVien == null) {
            System.out.println("Không tìm thấy sinh viên!");
            return;
        }
        BangDiem bangDiem = null;
        for (int i = 0; i < cntBangDiem; i++) {
            if (dsBangDiem[i].getSinhVien().getMaSV() == sinhVien.getMaSV()) {
                bangDiem = dsBangDiem[i];
                break;
            }
        }
        if (bangDiem == null) {
            bangDiem = new BangDiem(sinhVien);
            dsBangDiem[cntBangDiem++] = bangDiem;
        }
        System.out.print("Nhập số môn học: ");
        int slMon = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < slMon; i++) {
            System.out.print("Nhập mã môn học thứ " + (i + 1) + ": ");
            int maMon = Integer.parseInt(sc.nextLine());
            MonHoc monHoc = null;
            for (int j = 0; j < cntMonHoc; j++) {
                if (dsMonHoc[j].getMaMon() == maMon) {
                    monHoc = dsMonHoc[j];
                    break;
                }
            }
            if (monHoc == null) {
                System.out.println("Không tìm thấy môn học!");
                continue;
            }
            System.out.print("Nhập điểm: ");
            double diem = Double.parseDouble(sc.nextLine());
            bangDiem.addDiem(monHoc, diem);
        }

    }

    private static void inBangDiem() {
        for (int i = 0; i < cntBangDiem; i++) {
            System.out.println(dsBangDiem[i]);
        }
    }

    private static void sapXepBangDiemTheoTenSV() {
        System.out.println("Danh sách bảng điểm sắp xếp theo họ tên sinh viên: ");
        if (cntBangDiem > 1) {
            for (int i = 0; i < cntBangDiem - 1; i++) {
                for (int j = i + 1; j < cntBangDiem; j++) {
                    if (dsBangDiem[i].getSinhVien().getHoTen().compareToIgnoreCase(dsBangDiem[j].getSinhVien().getHoTen()) > 0) {
                        BangDiem temp = dsBangDiem[i];
                        dsBangDiem[i] = dsBangDiem[j];
                        dsBangDiem[j] = temp;
                    }
                }
            }
        }
        inBangDiem();
    }

    private static void sapXepBangDiemTheoTenMH() {
        System.out.println("Danh sách bảng điểm sắp xếp theo tên môn học: ");
        for (int i = 0; i < cntBangDiem; i++) {
            MonHoc[] monHocs = dsBangDiem[i].getDsMonHoc();
            int cnt = BangDiem.getCntMonHoc();
            if (cnt > 1) {
                for (int j = 0; j < cnt - 1; j++) {
                    for (int k = j + 1; k < cnt; k++) {
                        if (monHocs[j].getTenMon().compareToIgnoreCase(monHocs[k].getTenMon()) > 0) {
                            MonHoc temp = monHocs[j];
                            monHocs[j] = monHocs[k];
                            monHocs[k] = temp;
                        }
                    }
                }
            } else continue;
        }
        inBangDiem();
    }

    private static void tinhGPA() {
        for (int i = 0; i < cntBangDiem; i++) {
            System.out.println(dsBangDiem[i].getSinhVien().getHoTen() + " " + String.format("%.2f", dsBangDiem[i].tinhDiem()));
        }
    }

    private static void loadData() {
        File file = new File("data.txt");
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.txt"))) {
                dsSinhVien = (SinhVien[]) ois.readObject();
                dsMonHoc = (MonHoc[]) ois.readObject();
                dsBangDiem = (BangDiem[]) ois.readObject();
                cntSinhVien = ois.readInt();
                cntMonHoc = ois.readInt();
                cntBangDiem = ois.readInt();
                System.out.println("Đọc dữ liệu thành công!");
            } catch (IOException | ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.txt"))) {
            oos.writeObject(dsSinhVien);
            oos.writeObject(dsMonHoc);
            oos.writeObject(dsBangDiem);
            oos.writeInt(cntSinhVien);
            oos.writeInt(cntMonHoc);
            oos.writeInt(cntBangDiem);
            System.out.println("Ghi dữ liệu thành công!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}