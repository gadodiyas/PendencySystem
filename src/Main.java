import model.Entity;
import model.PendencySystem;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        PendencySystem pendencySystem = new PendencySystem();
        Entity entity = pendencySystem.startTracking(new Entity(1,"glass courier"), Arrays.asList("UPI", "Karnataka", "Bangalore"));
        Entity entity1 = pendencySystem.startTracking(new Entity(2,"glass courier"), Arrays.asList("UPI", "Karnataka", "Mysore"));

        Entity entity2 = pendencySystem.startTracking(new Entity(3,"glass courier"), Arrays.asList("UPI", "Rajasthan", "Jaipur"));

        Entity entity3 = pendencySystem.startTracking(new Entity(4, "glass courier"), Arrays.asList("Wallet", "Karnataka", "Bangalore"));

        int cnt  = pendencySystem.getCounts(Arrays.asList("UPI"));
        int cnt1  = pendencySystem.getCounts(Arrays.asList("UPI", "Karnataka"));
        int cnt2 = pendencySystem.getCounts(Arrays.asList("UPI", "Karnataka", "Bangalore"));
        int cnt3 = pendencySystem.getCounts(Arrays.asList("Bangalore"));

        pendencySystem.stopTracking(entity.getId());
        pendencySystem.stopTracking(entity1.getId());

        pendencySystem.getCounts(Arrays.asList("UPI"));



    }
}