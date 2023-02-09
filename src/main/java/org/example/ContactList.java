package org.example;
import java.util.Scanner;
import java.util.HashMap;
import java.util.logging.Logger;
import java.util.logging.Level;

public class ContactList {
    static Logger l = Logger.getLogger("com.api.jar");
    static HashMap<String, Contact> contacts = new HashMap<>();
    static class Contact {
        String name;
        String phone;
        String email;
        Contact(String name, String phone, String email) {
            this.name = name;
            this.phone = phone;
            this.email = email;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        while (choice != 4) {
            l.info("1.add Contact \n2.delete a contact \n3.Search Contact \n4.Exit");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    l.info("Enter name: ");
                    String name = sc.nextLine();
                    l.info("Enter phone: ");
                    String phone = sc.nextLine();
                    l.info("Enter email: ");
                    String email = sc.nextLine();
                    addContact(name, phone, email);
                    break;
                case 2:
                    l.info("Enter name to be display: ");
                    name = sc.nextLine();
                    deleteContact(name);
                    break;
                case 3:
                    l.info("Enter name to be deleted : ");
                    name = sc.nextLine();
                    searchContact(name);
                    break;
                case 4:
                    l.info("Exiting...");
                    break;
                default:
                    l.info("Invalid choice, try again.");
            }
        }
    }
    static void addContact(String name, String phone, String email) {
        contacts.put(name, new Contact(name, phone, email));
        l.info("Contact added successfully.");
    }
    static void deleteContact(String name) {
        if (contacts.remove(name) != null) {
            l.info("Contact deleted successfully.");
        } else {
            l.info("Contact not found.");
        }
    }
    static void searchContact(String name) {
        Contact contact = contacts.get(name);
        if (contact != null) {
            l.log(Level.INFO,()->"Name: " + contact.name);
            l.log(Level.INFO,()->"Phone: " + contact.phone);
            l.log(Level.INFO,()->"Email: " + contact.email);
        } else {
            l.info("Contact not found.");
        }
    }
}
