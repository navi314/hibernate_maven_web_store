package hibernate_maven;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
   TestClient.class,
   TestCreditCard.class,
   TestDeliveryAddress.class,
   TestArticle.class,
   TestBilling.class,
   TestDeliveryPackages.class,
   TestPurchaseOrder.class
})

public class TestSuite {   
}