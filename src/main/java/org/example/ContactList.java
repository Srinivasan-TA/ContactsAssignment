package org.example;
import java.util.Scanner;
import java.util.HashMap;
public class ContactList {
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
            System.out.println("1.add Contact \n2.delete a contact \n3.Search Contact \n4.Exit");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter phone: ");
                    String phone = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    addContact(name, phone, email);
                    break;
                case 2:
                    System.out.print("Enter name: ");
                    name = sc.nextLine();
                    deleteContact(name);
                    break;
                case 3:
                    System.out.print("Enter name: ");
                    name = sc.nextLine();
                    searchContact(name);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }
    static void addContact(String name, String phone, String email) {
        contacts.put(name, new Contact(name, phone, email));
        System.out.println("Contact added successfully.");
    }
    static void deleteContact(String name) {
        if (contacts.remove(name) != null) {
            System.out.println("Contact deleted successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }
    static void searchContact(String name) {
        Contact contact = contacts.get(name);
        if (contact != null) {
            System.out.println("Name: " + contact.name);
            System.out.println("Phone: " + contact.phone);
            System.out.println("Email: " + contact.email);
        } else {
            System.out.println("Contact not found.");
        }
    }
}
