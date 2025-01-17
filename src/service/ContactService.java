package service;
import model.Contact;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactService {
    private List<Contact> contactList = new ArrayList<>();

    public void addContact(Contact contact) {
        contactList.add(contact);
    }


    public void updateContact(String name, Contact newContact) {
        for (Contact contact : contactList) {
            if (contact.getName() != null && contact.getName().equals(name)) {
                contact.setName(newContact.getName());
                contact.setPhoneNumber(newContact.getPhoneNumber());
                contact.setGroup(newContact.getGroup());
                contact.setGender(newContact.getGender());
                contact.setAddress(newContact.getAddress());
                contact.setBirthDate(newContact.getBirthDate());
                contact.setEmail(newContact.getEmail());
                System.out.println("Cập nhật liên hệ thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy liên hệ với tên: " + name);
    }


    public void deleteContact(String name) {
        contactList.removeIf(contact -> contact.getName().equals(name));
    }

    public void displayContacts() {
        if (contactList.isEmpty()) {
            System.out.println("Danh bạ trống.");
        } else {
            for (Contact contact : contactList) {
                System.out.println(contact);
            }
        }
    }

    public void searchContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên hoặc số điện thoại cần tìm: ");
        String searchQuery = scanner.nextLine();
        boolean found = false;

        for (Contact contact : contactList) {
            if (contact.getName().contains(searchQuery) || contact.getPhone().contains(searchQuery)) {
                System.out.println(contact);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy liên hệ nào.");
        }
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }
}
