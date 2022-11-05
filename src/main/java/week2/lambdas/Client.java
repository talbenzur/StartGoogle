package week2.lambdas;

import week2.lambdas.methods.Item;
import week2.lambdas.methods.Stock;
import week2.lambdas.methods.Types;

import java.util.List;
import java.util.Map;

import static week2.lambdas.methods.Stock.CreateNewStock;

public class Client {
    public static void main(String[] args) {

        Stock stock = CreateNewStock();
        System.out.println(stock);

        List<Item> itemSortedList = stock.getSortedItemList();
        System.out.println(itemSortedList);

        List<Item> expiredList = stock.getExpiredItemList();
        System.out.println(expiredList);

        Map<Types, Integer> itemMap = stock.sumAllItemsByType();
        for (Types key : itemMap.keySet()) {
            String value = itemMap.get(key).toString();
            System.out.println(key + " " + value);
        }

        List<String> itemList = stock.getListOfItemsNameAboveWeight(20);


    }

}
