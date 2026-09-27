package Java_By_TelUsko.InterfaceDemo;

class CreditCardPayment {
    void pay() {
        System.out.println("Paid using Credit Card");
    }
}

class UPIPayment {
    void pay() {
        System.out.println("Paid using UPI");
    }
}

class PayPalPayment {
    void pay() {
        System.out.println("Paid using PayPal");
    }
}

public class Problem1 {
    public static void main(String[] args) {
        CreditCardPayment creditCardPayment = new CreditCardPayment();
        creditCardPayment.pay();

        UPIPayment upiPayment = new UPIPayment();
        upiPayment.pay();

        PayPalPayment payPalPayment = new PayPalPayment();
        payPalPayment.pay();
    }
}

/*  
They all have pay(), but Java doesn't have a common type/contract saying:
"Any payment method MUST provide pay()." That's the problem.
*/
