public class TenantTest {
    public static void main(String[] args)
    {
        Tenant tenant1 = new Tenant("Mark Stanley", 1);
        Tenant tenant2 = new Tenant("Stanley Mark", 2);

        tenant1.makePayment(new Payment("Jan", 250));
        System.out.println(tenant1.getPayments());
        System.out.println(tenant2.getPayments());

        System.out.println(tenant1.getName() + tenant1.getRoom());
    }
}