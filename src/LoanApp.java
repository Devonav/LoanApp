/** Devon Villalona COP3330 CRN12565 9/10/2023
 *User Inputs:
 * Prime Interest Rate: The user provides the current prime rate.
 * Loan Details (for 5 loans): Type (business/personal), Loan Number, Customer's Last Name, Loan Amount, and Loan Term (short, medium, long).
 * Outputs Displayed:
 * Loan Entries: Displays all the details of the five entered loans, including the bank's name.
 * Loan Comparison: Indicates if the second and fourth loans are equivalent.
 * Total Amount Due: Shows the total due for the third loan.
 * Loan Summary: Shows the total loaned amount for business, personal, and overall categories.
 * The program is designed to simulate a loan management system for a company named "Java Programmers Loan (JPL) Company".
 * named "Java Programmers Loan (JPL) Company". The system allows the creation of both business and personal loans.
 * Each type of loan has a unique interest rate associated with it, based on the current prime interest rate.
 * The system provides functionality to track the loans, calculate the total amount due using simple interest,
 * and determine the total amount loaned in each category (business/personal) as well as in total.
 */



import java.util.Scanner;

public class LoanApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an array of five Loans.
        Loan[] loans = new Loan[5];

        // Prompt the user for the current prime interest rate.
        System.out.print("Enter the current prime interest rate: ");
        double primeInterestRate = scanner.nextDouble();

        // In a loop, prompt the user for the loan type and all relevant information for each loan.
        for (int i = 0; i < 5; i++) {
            System.out.println("\nEnter details for Loan " + (i + 1) + ":");

            System.out.print("Enter loan type (1 for Business, 2 for Personal): ");
            int choice = scanner.nextInt();

            System.out.print("Enter loan number: ");
            int loanNumber = scanner.nextInt();

            System.out.print("Enter customer's last name: ");
            String customerLastName = scanner.next();

            System.out.print("Enter loan amount: ");
            double loanAmount = scanner.nextDouble();

            System.out.print("Enter loan term (3 for short-term, 7 for medium-term, 15 for long-term): ");
            int term = scanner.nextInt();

            if (choice == 1) {
                loans[i] = new BusinessLoan(loanNumber, customerLastName, loanAmount, term, primeInterestRate);
            } else if (choice == 2) {
                loans[i] = new PersonalLoan(loanNumber, customerLastName, loanAmount, term, primeInterestRate);
            }
        }

        // Display the bank name, and all of the loans.
        System.out.println("\n" + LoanConstants.COMPANY_NAME + "\n");
        for (Loan loan : loans) {
            System.out.println(loan.toString());
        }

        // Display a message that indicates whether the second loan is equal to the fourth loan in the array.
        if (loans[1].equals(loans[3])) {
            System.out.println("\nThe second loan is equal to the fourth loan.");
        } else {
            System.out.println("\nThe second loan is NOT equal to the fourth loan.");
        }

        // Display a message that indicates the total amount due for the third loan in the array.
        System.out.printf("\nTotal amount due for the third loan: $%.2f\n", loans[2].calculateTotalAmountDue());

        // Display a message that shows the total amount JPL loaned in each category, as well as the total amount loaned for all loans in the array.
        Loan.totalAmountLoaned();

        scanner.close();
    }
}
