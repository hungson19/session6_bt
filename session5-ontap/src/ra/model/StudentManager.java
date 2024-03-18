package ra.model;


import java.util.Scanner;

public class StudentManager {
    private static Student[] students = new Student[100];

    static {
        students[0] = new Student(1, "P001", 18, true, "Hà Nội", 97898324);
        students[1] = new Student(2, "P002", 20, true, "Thái Bình", 97898324);
        students[2] = new Student(3, "P003", 19, true, "Hà Nam", 97898324);
    }
    private static int length = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager.showAllStudent();
        do {
            System.out.println("1.\tHiển thị danh sách sinh viên\n" +
                    "2.\tThêm mới n sinh viên\n" +
                    "3.\tUpdate thông tin sinh viên theo id\n" +
                    "4.\tXoá sinh viên theo id\n" +
                    "5.\tSắp xếp sinh viên theo id\n" +
                    "6.\tTìm sinh viên theo tuổi\n");
            System.out.println("Moi lua chon ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    showAllStudent();
                    break;
                case 2:
                    createStudent();
                    break;
                case 3:
                    updateStudent();

                    break;
                case 4:
                    delete(scanner);
                    break;

                case 5:
                    sort();
                    break;
                case 6:
                    seachStudent(scanner);
                    break;
                default:
                    System.out.println("Lua chon khong dung, moi chon lai");

            }
        } while (true);
    }

    public static void seachStudent(Scanner scanner){

        System.out.println("Nhap so tuoi: ");
        int age = Integer.parseInt(scanner.nextLine());
        boolean check = true;
        for (int i = 0; i < length; i++) {
            if(students[i].getAge() == age) {
                System.out.println("Thong tin sinh vien");
                students[i].displayData();
                check = false;
            }
        }
        if (check){
            System.out.println("Khong tim thay");
        }

    }

    public static void showAllStudent() {

        for (int j = 0; j < length; j++) {
            students[j].displayData();
            System.out.println("--------------------------");
        }

    }

    public static void createStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bạn muốn nhập mấy người: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            Student student = new Student();
            student.inputData(scanner,students,length);
            students[length] = student;
            length++;
        }
    }

    public static void updateStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập id sinh viên muốn sửa :");
        int id = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < length; i++) {
            if (students[i].getId() == id) {
                System.out.println("chọn 1 để sửa tên sinh viên: ");
                System.out.println("chọn 2 để sửa tuổi sinh viên: ");
                System.out.println("chọn 3 để sửa địa chỉ sinh viên: ");
                System.out.println("chọn 0 để quay lại: ");
                System.out.println(" nhập lựa chọn của bạn");
                int chon = Integer.parseInt(scanner.nextLine());
                switch (chon) {
                    case 1:
                        System.out.println("mời nhập tên muốn sửa");
                        String newName = scanner.nextLine();
                        students[i].setName(newName);
                        break;
                    case 2:
                        System.out.println("mời nhập tuổi để sửa");
                        int newAge = Integer.parseInt(scanner.nextLine());
                        students[i].setAge(newAge);
                        break;
                    case 3:
                        System.out.println(" mời nhập địa chỉ mới:");
                        String newAddress = scanner.nextLine();
                        students[i].setAddress(newAddress);
                        break;
                    default:
                        System.out.println("thôi quay lại khỏi sửa");
                        break;
                }
            }
        }
    }

    public static void delete(Scanner scanner)
    {
        System.out.println("Nhap ID muon xoa");
        int x = Integer.parseInt(scanner.nextLine());
        boolean isExist = false;
        for (int i = 0; i < length; i++) {
            if(students[i].getId()==x)
            {
                students[i] = students[i+1];
                isExist = true;

            }
        }
        if (!isExist)
        {
            System.out.println("Khong ton tai ID can xoa");
        }
        else {

            length--;
        }

    }
    public static void sort(){
        for (int i = 0; i < length-1; i++) {
            for (int j = i+1; j < length; j++) {
                if(students[i].getAge() > students[j].getAge()){
                    Student st = students[i];
                    students[i] = students[j];
                    students[j]  = st;
                }
            }

        }
    }

}

