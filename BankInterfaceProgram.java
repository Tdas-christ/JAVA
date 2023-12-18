/*Create an interface named 'BankInterface' containing abstract methods 'getBalance' and
'getInterestRate'. Deposit amounts of 10000, 150000, and 200000 into banks A, B, and C,
respectively. 'BankA', 'BankB', and 'BankC' implement the 'BankInterface' interface, each
defining methods 'getBalance' and 'getInterestRate'. Invoke these methods by instantiating
objects of each class.
BankA provides an interest rate of 7% based on the balance.
BankB offers an interest rate of 7.4% based on the balance.
BankC provides an interest rate of 7.9% based on the balance.
Display the balance and interest rate of each bank separately.*/

interface BankInterface {
  double getBalance();
  double getInterestRate();
}
//BankA implements the interface BankInterface
class BankA implements BankInterface {
  private final double balance;
  private final double interestRate = 7;

  public BankA(double balance) {
    this.balance = balance;
  }

  @Override
  public double getBalance() {
    return balance;
  }

  @Override
  public double getInterestRate() {
    return interestRate;
  }
}
//BankB implements the interface BankInterface
class BankB implements BankInterface {
  private final double balance;
  private final double interestRate = 7.4;

  public BankB(double balance) {
    this.balance = balance;
  }

  @Override
  public double getBalance() {
    return balance;
  }

  @Override
  public double getInterestRate() {
    return interestRate;
  }
}
//BankC implements the interface BankInterface
class BankC implements BankInterface {
  private final double balance;
  private final double interestRate = 7.9;

  public BankC(double balance) {
    this.balance = balance;
  }

  @Override
  public double getBalance() {
    return balance;
  }

  @Override
  public double getInterestRate() {
    return interestRate;
  }
}

public class BankInterfaceProgram {
  public static void main(String[] args) {
    BankInterface bankA = new BankA(10000);
    BankInterface bankB = new BankB(150000);
    BankInterface bankC = new BankC(200000);

    System.out.printf("Bank A: Balance: $%.2f, Interest Rate: %.2f%%\n", bankA.getBalance(), bankA.getInterestRate());
    System.out.printf("Bank B: Balance: $%.2f, Interest Rate: %.2f%%\n", bankB.getBalance(), bankB.getInterestRate());
    System.out.printf("Bank C: Balance: $%.2f, Interest Rate: %.2f%%\n", bankC.getBalance(), bankC.getInterestRate());
  }
}

