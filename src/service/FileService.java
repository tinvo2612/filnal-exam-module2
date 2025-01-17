package service;
import model.Contact;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileService {
    private static final String FILE_PATH = "contacts.csv";
    private static final String HEADER = "Họ Tên,Số Điện Thoại,Nhóm,Giới Tính,Địa Chỉ,Ngày Sinh,Email";

    public void writeContactsToCSV(List<Contact> contacts) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(FILE_PATH))) {
            writer.write(HEADER);
            writer.newLine();
            for (Contact contact : contacts) {
                writer.write(contact.toCSVString());
                writer.newLine();
            }
            System.out.println("Danh bạ đã được lưu vào file CSV.");
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi file CSV: " + e.getMessage());
        }
    }

    public List<Contact> readContactsFromCSV() {
        List<Contact> contacts = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(FILE_PATH))) {
            String line;
            boolean isFirstLine = true;
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] data = line.split(",");
                if (data.length == 7) {
                    Contact contact = new Contact(data[0], data[1], data[2], data[3], data[4], data[5], data[6]);
                    contacts.add(contact);
                }
            }
            System.out.println("Danh bạ đã được đọc từ file CSV.");
        } catch (IOException e) {
            System.err.println("Lỗi khi đọc file CSV: " + e.getMessage());
        }
        return contacts;
    }
}
