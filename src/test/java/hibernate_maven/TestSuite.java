package hibernate_maven;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
   ClientTest.class,
   CreditCardTest.class
})

public class TestSuite {   
}