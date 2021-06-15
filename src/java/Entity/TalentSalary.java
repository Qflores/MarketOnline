
package Entity;

import java.sql.Date;

public class TalentSalary {
    
    private int id;
    private double amount;
    private String paymentdate;
    private double bonus1;
    private double bonus2;
    private double discountamount1;
    private double discountamount2;
    private int humantalent_id;

    public TalentSalary() {
    }

    public TalentSalary(int id, double amount, String paymentdate, double bonus1, double bonus2, double discountamount1, double discountamount2, int humantalent_id) {
        this.id = id;
        this.amount = amount;
        this.paymentdate = paymentdate;
        this.bonus1 = bonus1;
        this.bonus2 = bonus2;
        this.discountamount1 = discountamount1;
        this.discountamount2 = discountamount2;
        this.humantalent_id = humantalent_id;
    }

    public int getHumantalent_id() {
        return humantalent_id;
    }

    public void setHumantalent_id(int humantalent_id) {
        this.humantalent_id = humantalent_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentdate() {
        return paymentdate;
    }

    public void setPaymentdate(String paymentdate) {
        this.paymentdate = paymentdate;
    }

    public double getBonus1() {
        return bonus1;
    }

    public void setBonus1(double bonus1) {
        this.bonus1 = bonus1;
    }

    public double getBonus2() {
        return bonus2;
    }

    public void setBonus2(double bonus2) {
        this.bonus2 = bonus2;
    }

    public double getDiscountamount1() {
        return discountamount1;
    }

    public void setDiscountamount1(double discountamount1) {
        this.discountamount1 = discountamount1;
    }

    public double getDiscountamount2() {
        return discountamount2;
    }

    public void setDiscountamount2(double discountamount2) {
        this.discountamount2 = discountamount2;
    }
    
    
    
    
    
}
