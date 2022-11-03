package Week2.Methods;

import java.util.Date;
import java.util.List;

public class Store {
    private String name;

    public Store(String name) {
        this.name = name;
    }

    void assignCouponToUser(User user) {
        int numOfDays = Generator.randomNumber(10);//the coupon will be valid for 10 days max.
        int couponValue = Generator.randomNumber(50);//the coupon will be value max 50.
        Coupon newCoupon = Coupon.createNewCoupon(numOfDays, couponValue);
        user.getCouponList().add(newCoupon);
    }

    public void UseCouponById(User user, int id) {
        Coupon curr;

        for (int i = 0; i < user.getCouponList().size(); i++) {
            curr = user.getCouponList().get(i);
            if (curr.getId() == id && curr.isCouponValid()) {
                user.getCouponList().remove(i);
                break;
            }
        }
    }

    public void UseCouponByHighestValue(User user) {
        int indexOfMaxValue = 0;
        int maxValue = 0;
        Coupon curr;

        for (int i = 0; i < user.getCouponList().size(); i++) {
            curr = user.getCouponList().get(i);
            if (curr.getValue() > maxValue) {
                indexOfMaxValue = i;
            }
        }
        user.getCouponList().remove(indexOfMaxValue);
    }

    public void UseCouponByClosestExpireDate(User user) {
        int indexOfClosest = 0;
        Date closestDate = user.getCouponList().get(0).getExpireDate();
        Coupon curr;
        for (int i = 0; i < user.getCouponList().size(); i++) {
            curr = user.getCouponList().get(i);
            if (curr.getExpireDate().before(closestDate)) {
                indexOfClosest = i;
            }
        }
        user.getCouponList().remove(indexOfClosest);
    }

    public void UseCouponByRandom(User user) {
        int randomNumber = Generator.randomNumber(user.getCouponList().size() - 1);
        user.getCouponList().remove(randomNumber);
    }
}
