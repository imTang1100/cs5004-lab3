package bank;

/**
 * The interface Account.
 */
public interface IAccount {

  /**
   * Deposit.
   *
   * @param amount the amount
   * @throws IllegalArgumentException the illegal argument exception
   */
  void deposit(double amount) throws IllegalArgumentException;

  /**
   * Withdraw boolean.
   *
   * @param amount the amount
   * @return the boolean
   */
  boolean withdraw(double amount);

  /**
   * Gets balance.
   *
   * @return the balance
   */
  double getBalance();

  /**
   * Perform monthly maintenance.
   */
  void performMonthlyMaintenance();
}
