public class TenantListTester {

    public static void main(String[] args)
    {
        TenantList tenList = new TenantList(3);
        Tenant t = new Tenant("Mandy", 1);
        Tenant u = new Tenant("Sandy",2);
        Tenant v = new Tenant("Handy",3);
        Tenant w = new Tenant("Blandy",1);
        System.out.println(tenList.isEmpty());
        System.out.println(tenList.addTenant(t));
        System.out.println(tenList.addTenant(u));        
        System.out.println(tenList.addTenant(v));        
        System.out.println(tenList.addTenant(w));
        System.out.println(tenList.toString());
        System.out.println(tenList.isFull());
        System.out.println(tenList.isEmpty());
        System.out.println("Test");
        System.out.println(tenList.removeTenant(1));
        System.out.println(tenList.addTenant(w));
        System.out.println(tenList.toString());
        System.out.println(tenList.search(1).toString());
    }
}