package bank;

/**
 * The type Savings account.
 */
public class SavingsAccount extends AbstractAccount {
  private static final int MAX_TRANSACTIONS = 6;

  private static final int PENALTY = 14;
  private int transactions = 0;

  /**
   * Instantiates a new Savings account.
   *
   * @param balance the balance
   */
  public SavingsAccount(double balance) {
    super(balance);
  }

  /**
   * Gets transactios.
   *
   * @return the transactios
   */
  public int getTransactios() {
    return this.transactions;
  }

  @Override
  public boolean withdraw(double withdraw) {
    if (withdraw > this.getBalance() || withdraw < 0) {
      return false;
    }
    this.setBalance(this.getBalance() - withdraw);
    transactions += 1;
    return true;
  }

  @Override
  public void performMonthlyMaintenance() {
    if (transactions > MAX_TRANSACTIONS) {
      this.setBalance(this.getBalance() - PENALTY);
      this.transactions = 0;
    }
  }
}
