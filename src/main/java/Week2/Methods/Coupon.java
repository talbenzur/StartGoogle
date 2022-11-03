package Week2.Methods;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class Coupon {
    private static int counterForID = 1;
    private int id;
    private Date expireDate;//final
    private int value;

    private Coupon(int numOfDays, int value) {
        this.id = counterForID;
        counterForID++;
        GenerateFutureDate(numOfDays);
        this.value = value;//check if value is positive
    }

    public static Coupon createNewCoupon(int numOfDays, int value) {
        Coupon coupon = new Coupon(numOfDays, value);
        return coupon;
    }

    public int getId() {
        return id;
    }

    public int getValue() {
        return value;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public boolean isCouponValid() {
        if (Generator.getCurrentDate().before(expireDate))
            return true;
        return false;
    }

    private void GenerateFutureDate(int numOfDays) {
        this.expireDate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(expireDate);
        cal.add(Calendar.DATE, numOfDays);
        expireDate = cal.getTime();
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "id=" + id +
                ", expireDate=" + expireDate +
                ", value=" + value +
                '}';
    }


}
