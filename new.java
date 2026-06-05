import java.util.Scanner;

class LoanEMICalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Loan Amount: ");
        double principal = sc.nextDouble();

        System.out.print("Enter Annual Interest Rate (%): ");
        double annualRate = sc.nextDouble();

        System.out.print("Enter Loan Period (Years): ");
        int years = sc.nextInt();

        double monthlyRate = annualRate / 12 / 100;
        int months = years * 12;

        double emi = (principal * monthlyRate * Math.pow(1 + monthlyRate, months))
                / (Math.pow(1 + monthlyRate, months) - 1);

        System.out.println("\n===== EMI DETAILS =====");
        System.out.println("Loan Amount : ₹" + principal);
        System.out.println("Interest Rate : " + annualRate + "%");
        System.out.println("Loan Period : " + years + " Years");
        System.out.printf("Monthly EMI : ₹%.2f%n", emi);

        sc.close();
    }
}
