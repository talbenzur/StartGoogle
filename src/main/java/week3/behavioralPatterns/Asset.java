package week3.behavioralPatterns;

public class Asset implements Business {
    int serialNumber;
    String owner;
    double rating;

    public Asset(int serialNumber, String owner, double rating) {
        this.serialNumber = serialNumber;
        this.owner = owner;
        this.rating = rating;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Asset{" +
                "serialNumber=" + serialNumber +
                ", owner='" + owner + '\'' +
                ", rating=" + rating +
                '}';
    }
}
