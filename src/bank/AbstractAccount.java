package bank;

import java.text.DecimalFormat;

/**
 * The type Abstract account.
 */
public abstract class AbstractAccount implements IAccount {
  private double balance;

  /**
   * Instantiates a new Abstract account.
   *
   * @param starter the starter
   * @throws IllegalArgumentException the illegal argument exception
   */
  public AbstractAccount(double starter) throws IllegalArgumentException {
    if (starter < 0.01) {
      throw new IllegalArgumentException("Starting balance must be at least $0.01.");
    }
    this.balance = starter;
  }

  public void deposit(double deposit) throws IllegalArgumentException {
    if (deposit < 0) {
      throw new IllegalArgumentException("Deposit cannot be negative.");
    }
    this.balance = deposit;
  }

  public double getBalance() {
    return this.balance;
  }

  /**
   * Sets balance.
   *
   * @param balance the balance
   */
  protected void setBalance(double balance) {
    this.balance = balance;
  }

  @Override
  public String toString() {
    DecimalFormat money = new DecimalFormat("$0.00");
    return money.format(this.balance);
  }
}
