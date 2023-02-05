package bank;

/**
 * The type Checking account.
 */
public class CheckingAccount extends AbstractAccount {
  private static final int MINIMUM = 100;
  private static final int MON_FEE = 5;
  private boolean below100 = false;

  /**
   * Instantiates a new Checking account.
   *
   * @param starter the starter
   */
  public CheckingAccount(double starter) {
    super(starter);
    if (this.getBalance() < MINIMUM) {
      this.below100 = true;
    }
  }

  /**
   * Get below boolean.
   *
   * @return the boolean
   */
  public boolean getBelow(){
    return this.below100;
  }

  @Override
  public boolean withdraw(double withdraw) {
    if (withdraw > this.getBalance() || withdraw < 0) {
      return false;
    }
    this.setBalance(this.getBalance() - withdraw);
    if (this.getBalance() < MINIMUM) {
      this.below100 = true;
    }
    return true;
  }

  @Override
  public void performMonthlyMaintenance() {
    if (this.below100) {
      this.setBalance(this.getBalance() - MON_FEE);
      this.below100 = false;
    }
    if (this.getBalance() < MINIMUM) {
      this.below100 = true;
    }
    return;
  }

}
