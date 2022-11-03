package Week2.Lambdas.methods;

import java.time.LocalDate;

import static Week2.Lambdas.methods.Util.random_name;

public class Item {
    private final String name;
    private final Types productType;
    private final LocalDate expirationDate;
    private final int weight;


    private Item(Types productType, LocalDate expirationDate, int weight) {
        this.name = random_name();
        this.productType = productType;
        this.expirationDate = expirationDate;
        this.weight = weight;
    }

    public static Item newItem(Types productType, LocalDate expirationDate, int weight) {
        return new Item(productType, expirationDate, weight);
    }

    public static Item sort(Item item1, Item item2) {
        return (item1.expirationDate.isBefore(item2.expirationDate) ? item1 : item2);
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public static boolean IsType(Types type, Item item) {
        return item.productType == type;
    }

    public Types getProductType() {
        return productType;
    }

}
