public class PaymentListTester {
    public static void main(String[] args)
    {
        PaymentList pList = new PaymentList(4);
        Payment payJan = new Payment("Jan", 310);
        Payment payFeb = new Payment("Feb", 280);
        pList.addPayment(payJan);
        pList.addPayment(payFeb);
        System.out.println(pList.toString());
        System.out.println("Full: " + pList.isFull());
        Payment payMar = new Payment("Mar", 300);
        Payment payApr = new Payment("Apr", 250);
        pList.addPayment(payMar);
        pList.addPayment(payApr);
        System.out.println(pList.toString());
        System.out.println("Full: " + pList.isFull());
        System.out.println(pList.getPayment(4));
        System.out.println(pList.getPayment(5));
        System.out.println(pList.getTotal());
        System.out.println(pList.calculateTotalPayments());
        Payment payMay = new Payment("May", 280);
        System.out.println(pList.addPayment(payMay));
                
        
        
    }
}