package ra.model;

import java.util.Scanner;

//khai báo các trường cho lớp Sinhvien
public class Student {
    private int id;
    private String name;
    private int age;
    private Boolean gender;
    private String address;
    private int phonenumber;
    // khai báo constructor Sinhvien không tham số
    public Student () {

    }
    //khai báo constructor có tham số
    public Student (int id, String name, int age, Boolean gender, String address, int phonenumber) {
        this. id =id;
        this. name = name;
        this. age = age;
        this.gender = gender;
        this. address = address;
        this. phonenumber = phonenumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }
    public void inputData(Scanner scanner, Student[] students, int length) {
        System.out.println("nhập vào id sinh viên: " );
        id = Integer.parseInt(scanner.nextLine());

        do {
            System.out.println("Moi nhap ten");
            this.name = scanner.nextLine();
            if (this.name.length() == 4 && this.name.startsWith("P")){
                // thoa man 4 ky tu va bat dau = P
                boolean isExist = true;
                for (int i = 0; i < length; i++) {
                    if (this.name.equals(students[i].getName())){
                        // trung ten thi vao day
                        System.out.println("Ten da ton tai , moi nhap lai");
                        isExist = false;
                    }
                }
                if (isExist){
                    // thoa man khong ton tai trung lap thoa man 4 ky tu va bat dau = P
                    break;
                }
            }else {
                System.out.println("Chuoi phair bat dau bang P hoac phai co 4 ky tu, moi nhap lai");
            }
        }while (true);

//        System.out.println("nhập vào tên sinh viên: " );
//        name = scanner.nextLine();
        System.out.println("nhập vào tuổi của sinh viên: ");
        age = Integer.parseInt(scanner.nextLine());
        System.out.println("nhập vào giới tính sinh viên: " );
        gender = Boolean.parseBoolean(scanner.nextLine());
        System.out.println("nhập vào địa chỉ sinh viên: " );
        address = scanner.nextLine();
        System.out.println("nhập vào số điện thoại sinh viên: " );
        phonenumber = Integer.parseInt(scanner.nextLine());
    }
    public void displayData() {
        System.out.println("Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phonenumber + '\'' +
                '}');

    }
}
