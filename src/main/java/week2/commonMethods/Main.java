package week2.commonMethods;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Contact> contactList=new ArrayList<>();
        for( int i=0; i<10;i++) {
            Name name = new Name(Generator.Random_prefix(), Generator.random_name(), Generator.random_name());
            PhoneNumber phoneNumber=new PhoneNumber(Generator.random_number(3), Generator.random_number(7));
            Contact contact = new Contact(name,phoneNumber );
            contactList.add(contact);
        }

        PhoneBook phoneBook= new PhoneBook(contactList, "PhoneBook");

        phoneBook.PrintPhoneBook();


    }
}
