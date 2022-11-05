package week2.commonMethods;

import java.util.Objects;

enum Prefix{
    Mr,
    Ms,
    Mrs,
    Miss
}
public class Name implements Comparable<Name>{
    Prefix prefix;
    private final String firstName;
    private final String lastName;

    public Name(Prefix prefix, String firstName, String lastName) {
        this.prefix = prefix;
        this.firstName = new String(firstName);
        this.lastName = new String(lastName);
    }

    public int compareTo(Name name) {
        int result =firstName.compareTo(name.firstName);
        if(result==0) {
            return lastName.compareTo(name.lastName);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null ||!(o instanceof Name)) return false;
        Name name = (Name) o;
        return prefix == name.prefix && firstName.equals(name.firstName) && lastName.equals(name.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prefix, firstName, lastName);
    }

    @Override
    public String toString() {
        return "Name{" +
                "prefix=" + prefix +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public static Name copyOf(Name name){
        return new Name(name.prefix,name.firstName,name.lastName);
    }
}
