package Application;

import java.util.List;
import java.util.Scanner;

import model.Student;
import service.StudentService;

public class main {

	static StudentService service = new StudentService();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int chon;
		do {
			menu();
			System.out.print("Nhập vào chức năng bạn muốn thực hiện : ");
			chon = Integer.parseInt(scanner.nextLine());
			switch (chon) {
			case 1:
				getListStudent(service.getStudent());
				break;
			case 2:
				addStudent();
				break;
			case 3:
				updateStudent();
				break;
			case 4:
				
				break;
			case 5:
				System.out.println("\t\t\t\t===================TẠM BIỆT BẠN==================");
				break;
			default:
				break;
			}
		} while (chon != 5);
	}

	public static void getListStudent(List<Student> students) {
		System.err.println("=============Danh sách sinh viên=========");
		int i =1;
		for (Student item : students) {
			item.inTT();		
		}
	}

	public static void addStudent() {
		Student studentAdd = new Student();
		studentAdd.nhapTT();
		service.insertStudent(studentAdd);
		System.err.println("\t\t--->Thêm thông tin thành công !");
	}

	public static void updateStudent() {
		Scanner scanner = new Scanner(System.in);
		Student studentAdd = new Student();
		System.out.print("Nhap vao email :");
		String email = scanner.nextLine();
		studentAdd = service.findByEmail(email);
		studentAdd.inTT();
		studentAdd.nhapTT();
		service.updateStudent(studentAdd, email);
		System.err.println("\t\t--->Sửa thông tin thành công !");
	}

	public static void menu() {
		System.out.println("\t\t\t\t ============SHOW MENU============");
		System.out.println("\t\t\t\t|[1].Hiển thị danh sách sinh viên  |");
		System.out.println("\t\t\t\t|[2].Thêm mới sinh viên            |");
		System.out.println("\t\t\t\t|[3].Cập nhật sinh viên theo email |");
		System.out.println("\t\t\t\t|[4].Tìm kiếm sinh viên theo email |");
		System.out.println("\t\t\t\t|[5].Thoát                         |");
		System.out.println("\t\t\t\t ================================== ");
	}
}
