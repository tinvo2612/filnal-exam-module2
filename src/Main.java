import java.util.Date;
import model.Contact;
import service.FileService;
import service.ContactService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ContactService contactService = new ContactService();
        FileService fileService = new FileService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n---- CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ ----");
            System.out.println("Chọn chức năng theo số ( để tiếp tục ):");
            System.out.println("1. Xem danh bạ");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Tìm kiếm liên hệ");
            System.out.println("6. Đọc từ file");
            System.out.println("7. Ghi vào file");
            System.out.println("8. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> contactService.displayContacts();
                case 2 -> {
                    System.out.println("Nhập thông tin của liên hệ:");
                    System.out.print("Họ tên : ");
                    String name = scanner.nextLine();
                    System.out.print("Số điện thoại: ");
                    String phone = scanner.nextLine();
                    System.out.print("Nhóm: ");
                    String group = scanner.nextLine();
                    System.out.print("Giới tính: ");
                    String gender = scanner.nextLine();
                    System.out.print("Địa chỉ: ");
                    String address = scanner.nextLine();
                    System.out.print("Ngày sinh (dd/MM/yyyy): ");
                    Date birthDate = new Date(scanner.nextLine());
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    contactService.addContact(new Contact(name, phone, group, gender, address, birthDate, email));
                }
                case 3 -> {
                    System.out.print("Nhập tên liên hệ cần cập nhật: ");
                    String name = scanner.nextLine();
                    System.out.println("Nhập thông tin mới:");
                    System.out.print("Họ tên: ");
                    String newName = scanner.nextLine();
                    System.out.print("Số điện thoại: ");
                    String newPhone = scanner.nextLine();
                    System.out.print("Nhóm: ");
                    String newGroup = scanner.nextLine();
                    System.out.print("Giới tính: ");
                    String newGender = scanner.nextLine();
                    System.out.print("Địa chỉ: ");
                    String newAddress = scanner.nextLine();
                    System.out.print("Ngày sinh (dd/MM/yyyy): ");
                    Date newBirthDate = new Date(scanner.nextLine());
                    System.out.print("Email: ");
                    String newEmail = scanner.nextLine();
                    contactService.updateContact(name, new Contact(newName, newPhone, newGroup, newGender, newAddress, newBirthDate, newEmail));
                }
                case 4 -> {
                    System.out.print("Nhập tên liên hệ cần xóa: ");
                    String name = scanner.nextLine();
                    contactService.deleteContact(name);
                }
                case 5 -> contactService.searchContact();
//                case 6 -> contactService.setContactList(fileService.readContactsFromFile());
//                case 7 -> fileService.writeContactsToFile(contactService.getContactList());
                case 8 -> {
                    System.out.println("Thoát chương trình.");
                    System.exit(0);
                }
                default -> System.out.println("Lựa chọn không hợp lệ.");
            }
            Thread.sleep(1000);
        }
    }
}
