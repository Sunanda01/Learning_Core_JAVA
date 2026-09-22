package Java_By_TelUsko.InterfaceDemo;
interface Payment {
    void pay();
}
class CreditCardPayment implements Payment {
    public void pay() {
        System.out.println("Paid using Credit Card");
    }
}

class UPIPayment implements Payment {
    public void pay() {
        System.out.println("Paid using UPI");
    }
}

class PayPalPayment implements Payment {
    public void pay() {
        System.out.println("Paid using PayPal");
    }
}
public class Solution1 {
    public static void main(String[] args) {
        Payment creditCardPayment = new CreditCardPayment();
        creditCardPayment.pay();

        Payment upiPayment = new UPIPayment();
        upiPayment.pay();

        Payment payPalPayment = new PayPalPayment();
        payPalPayment.pay();
    }
}
/*
The biggest benefit: polymorphism.
Here in Solution1, we can use the common type Payment to refer to any payment method. 
This allows us to write more flexible and maintainable code. 
If we want to add a new payment method in the future, we just need to implement the Payment interface, and the existing code will still work without any changes.
*/
