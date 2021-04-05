package run;
/** Class used to store details of a single payment in a hostel 
 * @author Marek Stefanowski
 * @version 13/03/21
 */


public class Payment {

    private String month;
    private double paymentAmount;
    
    /** Constructor initialises paymnent month and amount paid
     * @param month : payment month
     * @param paymentAmount : amount paid
     */
    public Payment(String month, double paymentAmount) {
        this.month = month;
        this.paymentAmount = paymentAmount;
    }

    /** Reads the month that this payment is for
     * @return Returns a string contianing the month of the payment
     */
    public String getMonth() {
        return month;
    }

    /** Reads the amount that was paid
     * @return Returns a double with the amount paid
     */
    public double getAmount() {
        return paymentAmount;
    }

    @Override
    public String toString() {
        return "(" + month + ": " + paymentAmount + ")";
    }
}