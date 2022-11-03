package Week2.CommonMethods;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    private List<Contact> contactList;
    private final String name;

    public PhoneBook(List<Contact> contactList, String name) {
        this.contactList=new ArrayList<>();
        this.contactList = contactList;
        this.name = name;
    }

    public void PrintPhoneBook(){
        System.out.println("PhoneBook name: "+name);
        for(Contact contact:contactList){
            System.out.println(contact.toString());
        }
    }

}
