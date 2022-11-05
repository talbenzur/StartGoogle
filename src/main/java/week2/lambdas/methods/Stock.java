package week2.lambdas.methods;

import java.time.LocalDate;
import java.util.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stock {
    private final List<Item> itemList = new ArrayList<>();


    private Stock() {
        for (int i = 0; i < 10; i++) {
            Item newItem = Util.GenerateNewItem();
            this.itemList.add(newItem);
        }
    }

    public static Stock CreateNewStock() {
        Stock stock = new Stock();
        return stock;
    }


    public Item GenerateItemFromList() {
        int randomNumber = (int) Math.floor(Math.random() * (itemList.size()));
        return itemList.get(randomNumber);
    }

    public void addItemToList(Item item) {
        this.itemList.add(item);
    }

    public List<Item> getExpiredItemList() {
        Stream<Item> stream = itemList.stream().filter(item -> item.getExpirationDate().isBefore(LocalDate.now()));
        return stream.toList();
    }

    public List<Item> getSortedItemList() {
        itemList.sort(Comparator.comparing(Item::getName)); //(i1,i2)->(i1.getName().compareTo(i2.getName()))
        return itemList;
    }

    public Item getItemByName(String name) {
        Stream<Item> stream = itemList.stream().filter((item -> Objects.equals(item.getName(), name)));
        return (Item) stream;
    }

    public List<String> getListOfItemsNameAboveWeight(int weight) {
        Stream<Item> stream = itemList.stream().filter(item -> item.getWeight() > weight);
        return stream.map(Item::getName).collect(Collectors.toList());
    }


    //Get a hash map of <type, Integer> to sum all the items according to their type.
    public Map<Types, Integer> sumAllItemsByType() {

        return itemList.stream().collect(Collectors.toMap(Item::getProductType, e -> 1, Math::addExact));

        //Map<Types,Integer> result = itemList.stream().collect(Collectors.groupingBy(Item::getProductType,e->1));
    }

    @Override
    public String toString() {
        return "Stock{" +
                "itemList=" + itemList +
                '}';
    }
}
