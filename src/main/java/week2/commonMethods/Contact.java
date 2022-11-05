package week2.commonMethods;

import java.util.Objects;

public class Contact implements Comparable<Contact>{
    Name name;
    PhoneNumber phoneNumber;

    public Contact(Name name, PhoneNumber phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null ||!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return name.equals(contact.name) && phoneNumber.equals(contact.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name=" + name +
                ", phoneNumber=" + phoneNumber +
                '}';
    }

    @Override
    public int compareTo(Contact o) {
        return name.compareTo(o.name);
    }

    public static Contact copyOf(Contact contact){
        return new Contact(contact.name,contact.phoneNumber);
    }

}
