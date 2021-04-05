public class PaymentTester {
    public static void main(String[] args)
    {
        Payment p1 = new Payment("January", 175);
        Payment p2 = new Payment("February", 250);

        System.out.println(p1.toString());
        System.out.println(p2.toString());
    }
}