/**
 * The PersonalLoan class represents a type of Loan specifically for individual applicants.
 * This class extends the general Loan class and sets a particular interest rate for personal loans.
 */
public class PersonalLoan extends Loan {

    public PersonalLoan(int loanNumber, String customerLastName, double loanAmount, int term, double primeInterestRate) {
        // Call the constructor of the parent (Loan) class
        super(loanNumber, customerLastName, loanAmount, term);
        // Set the interest rate for this personal loan to be 2.7% more than the given prime interest rate
        this.interestRate = primeInterestRate + 2.7; // setting interest rate to 2.7% more than the prime interest rate
    }
}
