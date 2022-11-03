package Week2.Methods;

public class Client {

    public static void main(String[] args) {
        User shir = new User("Shir");
        User dina = new User("Dina");

        Store maxStock = new Store("MaxStock");

        for (int i = 0; i < 5; i++) {
            maxStock.assignCouponToUser(shir);
        }
        for (int i = 0; i < 5; i++) {
            maxStock.assignCouponToUser(dina);
        }

        shir.printCouponList();
        dina.printCouponList();
        System.out.println(shir.getCouponList().get(0).getId());
        maxStock.UseCouponById(shir, shir.getCouponList().get(0).getId());
        maxStock.UseCouponByClosestExpireDate(dina);
        maxStock.UseCouponByHighestValue(shir);
        maxStock.UseCouponByRandom(dina);


        shir.printCouponList();
        dina.printCouponList();
    }
}
