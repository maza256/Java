package run;
import java.util.ArrayList;
/** Collection class for holding all Tenants
 * @author Marek Stefanowski
 * @version 14/03/21
 */

public class TenantList {
    private ArrayList<Tenant> tList;
    public final int MAX;
    /** Constructor initialises the Tenant List and the maximum tenants for this hostel 
     * @param maxIn : Maximum number of rooms
    */
    public TenantList(int maxIn)
    {
        MAX = maxIn;
        tList = new ArrayList<Tenant>();
    }

    /** Adds a Tenant to the list if there are rooms available
     * @param newTenant : The new tenant being added
     * @return True/False marker if the tenant was added
     */
    public boolean addTenant(Tenant newTenant)
    {
        if(isFull())
            return false;
        else {
            tList.add(newTenant);
            return true;
        }
    }

    public Tenant search(int room)
    {
        for (Tenant t : tList)
        {
            if(t.getRoom() == room)
            {
                return t;
            }
        }
        return null;
    }

    /** Removes a tenant from the list
     * @param roomNum : The room for which the tenant is being removed
     * @return Boolean to indicate if the room was removed
     */
    public boolean removeTenant(int room)
    {
        Tenant toBeRemoved = search(room);
        if(toBeRemoved == null)
            return false;
        tList.remove(toBeRemoved);
        return true;
    }

    /** Finds a tenant based on the room number
     * @param room : The room number of the tenant to find
     */
    public Tenant getTenant(int room)
    {
        if(room < 1 || MAX < room)
            return null;
        return tList.get(room - 1);
    }

    /** Returns true if the hostel has no current tenants 
     * @return Boolean true is hostel is empty
    */
    public boolean isEmpty() {
        return tList.isEmpty();
    }
    /** Returns true if the hostel has no space for new tenants 
     * @return Boolean true is hostel is full
    */
    public boolean isFull() {
        return (tList.size() == MAX);
    }

    /** Return number of tenants in hostel
     * @return integer number of tenants in the hostel
     */
    public int getTotal() {
        return tList.size();
    }

    @Override
    public String toString() {
        return tList.toString();
    }

}