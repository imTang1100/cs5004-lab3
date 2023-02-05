package bank;

import static org.junit.Assert.*;

/**
 * The type Savings account test.
 */
public class SavingsAccountTest {

  /**
   * The Saving 1.
   */
  SavingsAccount saving1;
  /**
   * The Saving 2.
   */
  SavingsAccount saving2;

  /**
   * Sets up.
   *
   * @throws Exception the exception
   */
  @org.junit.Before
  public void setUp() throws Exception {
    this.saving1 = new SavingsAccount(200);
    this.saving2 = new SavingsAccount(100);
  }

  /**
   * Bad deposit.
   */
  @org.junit.Test(expected = IllegalArgumentException.class)
  public void badDeposit() {
    saving1.deposit(-10);
  }

  /**
   * Deposit.
   */
  @org.junit.Test
  public void deposit() {
    saving2.deposit(50);
    assertEquals(150,saving2.getBalance(),0.01);
  }

  /**
   * Gets balance.
   */
  @org.junit.Test
  public void getBalance() {
    assertEquals(200,saving1.getBalance(),0.01);
  }

  /**
   * Sets balance.
   */
  @org.junit.Test
  public void setBalance() {
    saving1.setBalance(500);
    assertEquals(500,saving1.getBalance(),0.01);

    // try negative double.
    saving2.setBalance(-50);
    assertEquals(-50,saving2.getBalance(),0.01);
  }

  /**
   * Test to string.
   */
  @org.junit.Test
  public void testToString() {
    assertEquals("$200.00",saving1.toString());
    saving2.setBalance(-100);
    assertEquals("-$100.00",saving2.toString());
  }

  /**
   * Withdraw.
   */
  @org.junit.Test
  public void withdraw() {
    // Bad withdraw.
    assertEquals(false,saving1.withdraw(-50));
    assertEquals(false,saving1.withdraw(1000));

    saving1.withdraw(20);
    assertEquals(180,saving1.getBalance(),0.01);
    assertEquals(1,saving1.getTransactios());
    saving1.withdraw(10);
    assertEquals(2,saving1.getTransactios());
  }

  /**
   * Perform monthly maintenance.
   */
  @org.junit.Test
  public void performMonthlyMaintenance() {
    // testing 15 transactions($75), should have penalty for twice($28).
    for (int i = 0; i < 15; i++) {
      saving1.withdraw(5);
      saving1.performMonthlyMaintenance();
    }
    assertEquals(97,saving1.getBalance(),0.01);
  }
}