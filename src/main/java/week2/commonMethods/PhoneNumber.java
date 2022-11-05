package week2.commonMethods;

public class PhoneNumber implements  Comparable<PhoneNumber>{
    private String areaCode;
    private String number;

    public PhoneNumber(String areaCode, String number) {
        this.areaCode = new String(areaCode);
        this.number = new String(number);
    }

    @Override
    public int compareTo(PhoneNumber o) {
        return number.compareTo(o.number);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof PhoneNumber)) return false;
        PhoneNumber that = (PhoneNumber) o;
        return areaCode.equals(that.areaCode) && number.equals(that.number);
    }

    @Override
    public String toString() {
        return areaCode+"-"+number;
    }

    public static PhoneNumber copyOf(PhoneNumber phoneNumber){
        return new PhoneNumber(phoneNumber.areaCode,phoneNumber.number);
    }
}
