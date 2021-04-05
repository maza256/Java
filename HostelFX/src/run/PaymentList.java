package run;
import java.util.ArrayList;
/** Collection class to hold a list of payment objects
 * @author Marek Stefanowski
 * @version 13/03/21
 */
public class PaymentList {
    //Attributes
    private ArrayList<Payment> pList;
    public final int MAX;

    /** Constrictor initialises the payment list and sets max limit size
     * @param maxIn : Maximum number of payments in the list
     */
    public PaymentList(int maxIn){
        this.MAX = maxIn;
        pList = new ArrayList<Payment>();
    }

    /** Checks if payment list is full
     * @return Return true if list length is equal to the max
     */
    public boolean isFull()
    {
        return (pList.size() == MAX);
    }

    /** Gets the total number of payments 
     * @return Integer value of payments in the list
    */
    public int getTotal()
    {
        return pList.size();
    }

    /** Adds a new payment to the end of the list
     * @param pIn : Payments to add
     * @return Returns true if payment was added succesfully
     */
    public boolean addPayment(Payment pIn)
    {
        if(!isFull())
        {
            pList.add(pIn);
            return true;
        }
        return false;
    }

    /** Reads the payment at given position in the list
     * @param positionIn : The logical position of the payment in the list
     * @return Return payment at given position in the list or null if no payment exists
     */
    public Payment getPayment(int positionIn)
    {
        if(positionIn < 1 || positionIn > getTotal())
            return null;
        else
            return pList.get(positionIn - 1);
    }

    /** Calculate all the payments tenant has made 
     * @return Total of all payments made as double
    */
    public double calculateTotalPayments()
    {
        double totalPayments = 0;
        for (Payment p : pList)
        {
            totalPayments += p.getAmount();
        }

        return totalPayments;
    }

    @Override
    public String toString()
    {
        return pList.toString();
    }


}