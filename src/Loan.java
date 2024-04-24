// The Loan class is an abstract class that implements the LoanConstants interface.
public abstract class Loan implements LoanConstants {

    // Instance variables for the Loan class.
    protected int loanNumber;
    protected String customerLastName;
    protected double loanAmount;
    protected double interestRate;
    protected int term;

    // Static variables to track the total amounts loaned for business and personal categories.
    private static double totalBusinessLoaned = 0;
    private static double totalPersonalLoaned = 0;

    // Constructor for the Loan class, initializing basic loan details.
    public Loan(int loanNumber, String customerLastName, double loanAmount, int term) {
        this.loanNumber = loanNumber;
        this.customerLastName = customerLastName;
        setLoanAmount(loanAmount);  // Set the loan amount through a method to include validation.
        this.term = term;
        setTerm(term); // Set the loan term through a method to include validation.
    }

    // Getter methods to access the instance variables.
    public int getLoanNumber() {
        return loanNumber;
    }
    public String getCustomerLastName() {
        return customerLastName;
    }
    public double getLoanAmount() {
        return loanAmount;
    }
    public double getInterestRate() {
        return interestRate;
    }
    public int getTerm() {
        return term;
    }

    // Setter for loanNumber
    public void setLoanNumber(int loanNumber) {
        this.loanNumber = loanNumber;
    }

    // Setter for customerLastName
    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    // Setter for loanAmount with validation and updating the loaned amounts.
    public void setLoanAmount(double loanAmount) {
        if (loanAmount > MAX_LOAN_AMOUNT) {
            System.out.println("The loan amount exceeds the maximum allowed. Setting to maximum.");
            this.loanAmount = MAX_LOAN_AMOUNT;
        } else {
            this.loanAmount = loanAmount;
        }

        // Update the total amounts loaned based on the type of loan (business or personal).
        if (this instanceof BusinessLoan) {
            totalBusinessLoaned += this.loanAmount;
        } else if (this instanceof PersonalLoan) {
            totalPersonalLoaned += this.loanAmount;
        }
    }

    // Setter for loan term with validation.
    public void setTerm(int term) {
        if (term != SHORT_TERM && term != MEDIUM_TERM && term != LONG_TERM) {
            System.out.println("Invalid term. Setting to short-term.");
            this.term = SHORT_TERM;
        } else {
            this.term = term;
        }
    }

    // Override the toString() method to display the loan details.
    @Override
    public String toString() {
        return "LoanNumber: " + loanNumber +
                ", CustomerLastName: " + customerLastName +
                ", LoanAmount: $" + loanAmount +
                ", InterestRate: " + interestRate + "%" +
                ", Term: " + term + " years";
    }

    // Override the equals() method to compare two Loan objects.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Loan loan = (Loan) obj;
        return loanNumber == loan.loanNumber &&
                Double.compare(loan.loanAmount, loanAmount) == 0 &&
                customerLastName.equals(loan.customerLastName);
    }

    // Method to calculate the total amount due using simple interest formula.
    public double calculateTotalAmountDue() {
        return loanAmount + (loanAmount * interestRate / 100) * term;
    }

    // Static method to display the total amounts loaned for business, personal, and combined categories.
    public static void totalAmountLoaned() {
        System.out.println("Total Amount Loaned for Business: $" + totalBusinessLoaned);
        System.out.println("Total Amount Loaned for Personal: $" + totalPersonalLoaned);
        System.out.println("Total Amount Loaned Overall: $" + (totalBusinessLoaned + totalPersonalLoaned));
    }
}



