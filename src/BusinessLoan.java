/**
 * The BusinessLoan class represents a type of Loan specifically for businesses.
 * This class extends the general Loan class and sets a particular interest rate for business loans.
 */
public class BusinessLoan extends Loan {

    public BusinessLoan(int loanNumber, String customerLastName, double loanAmount, int term, double primeInterestRate) {
        // Call the constructor of the parent (Loan) class
        super(loanNumber, customerLastName, loanAmount, term);
        this.interestRate = primeInterestRate + 3.2; // setting interest rate to 3.2% more than the prime interest rate
    }
}
