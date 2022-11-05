package week2.methods;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final String name;
    private final List<Coupon> couponList;

    public User(String name) {
        this.name = name;
        this.couponList = new ArrayList<>();
    }

    public List<Coupon> getCouponList() {
        return couponList;

    }

    public void printCouponList() {
        System.out.println("coupons list of: " + name);
        for (Coupon coupon : couponList) {
            System.out.println(coupon.toString());
        }
    }

}
