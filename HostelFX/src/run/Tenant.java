package run;
/** Class used to record details of a tenant
 * @author Marek Stefanowski
 * @version 14/03/21
 */
public class Tenant {
    private String name;
    private int room;
    private PaymentList payments;
    public static final int MAX = 12;

    /** Constructor initialises the name and room number of teneant
     * and sets payments made to the empty list
     * @param nameIn : name of tenant
     * @param roomIn : room number of tenant
     */
    public Tenant(String nameIn, int roomIn)
    {
        name = nameIn;
        room = roomIn;
        payments = new PaymentList(MAX);
    }

    /** Records a payment for the tenant
     * @param paymentIn : payment made by tenant
     */
    public void makePayment(Payment paymentIn)
    {  
        payments.addPayment(paymentIn);
    }

    /** Returns the name of the tenant
     * @return Returns name of tenant
     */
    public String getName()
    {
        return name;
    }

    /** Returns the room number of the tenant
     * @return Returns room number of tenant
     */
    public int getRoom()
    {
        return room;
    }

    /** Returns the payment list for the tenant
     * @return PaymentList for the tenant
     */
    public PaymentList getPayments()
    {
        return payments;
    }

    @Override
    public String toString()
    {
        return "(" + name + ": " + room + ")";
    }
}