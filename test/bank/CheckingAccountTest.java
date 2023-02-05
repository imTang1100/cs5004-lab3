package bank;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * The type Checking account test.
 */
public class CheckingAccountTest {

  private CheckingAccount checking1;
  private CheckingAccount checking2;

  /**
   * Sets up.
   *
   * @throws Exception the exception
   */
  @Before
  public void setUp() throws Exception {
    checking1 = new CheckingAccount(200);
    checking2 = new CheckingAccount(50);
  }

  /**
   * Bad deposit.
   */
  @Test(expected = IllegalArgumentException.class)
  public void badDeposit() {
    checking1.deposit(-100);
  }

  /**
   * Deposit.
   */
  @Test
  public void deposit() {
    // test below100
    assertEquals(false,checking1.getBelow());
    assertEquals(true,checking2.getBelow());

    checking1.deposit(20);
    assertEquals(20,checking1.getBalance(),0.01);
  }

  /**
   * Gets balance.
   */
  @Test
  public void getBalance() {
    assertEquals(200,checking1.getBalance(),0.01);
    assertEquals(50,checking2.getBalance(),0.01);
  }

  /**
   * Sets balance.
   */
  @Test
  public void setBalance() {
    checking1.setBalance(10);
    assertEquals(10,checking1.getBalance(),0.01);

    //negative number.
    checking2.setBalance(-100);
    assertEquals(-100,checking2.getBalance(),0.01);
  }

  /**
   * Test to string.
   */
  @Test
  public void testToString() {
    assertEquals("$200.00",checking1.toString());
  }

  /**
   * Withdraw.
   */
  @Test
  public void withdraw() {
    // test bad withdraw
    checking1.withdraw(1000);
    assertEquals(200,checking1.getBalance(),0.01);

    checking2.withdraw(20);
    assertEquals(30,checking2.getBalance(),0.01);
  }

  /**
   * Perform monthly maintenance.
   */
  @Test
  public void performMonthlyMaintenance() {
    // test maintenance for 5 times.($25 monthly fee)
    for (int i = 0; i < 5; i++) {
      checking2.performMonthlyMaintenance();
    }
    assertEquals(25, checking2.getBalance(), 0.01);
  }
}