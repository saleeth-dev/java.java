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

import java.util.Scanner;
import java.util.Locale;

class Product {
    private int productID;
    private double basePrice;

    public Product(int productID, double basePrice) {
        this.productID = productID;
        this.basePrice = basePrice;
    }

    public int getProductID() {
        return productID;
    }

    public double getBasePrice() {
        return basePrice;
    }
}

class Electronics extends Product {
    private int warrantyPeriod;

    public Electronics(int productID, double basePrice, int warrantyPeriod) {
        super(productID, basePrice);
        this.warrantyPeriod = warrantyPeriod;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }
}

class Smartphone extends Electronics {
    private int storageGB;
    private double finalPrice;

    public Smartphone(int productID,
                      double basePrice,
                      int warrantyPeriod,
                      int storageGB) {

        super(productID, basePrice, warrantyPeriod);
        this.storageGB = storageGB;

        calculateFinalPrice();
    }

    private void calculateFinalPrice() {

        double price = getBasePrice() * 1.12;

        if (storageGB > 64) {
            price += (storageGB - 64) * 0.50;
        }

        finalPrice = price;
    }

    public int getStorageGB() {
        return storageGB;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void displayDetails(int phoneNum) {

        System.out.printf(
            "Smartphone %d Details: Product ID: %d, Base Price: %.2f, Warranty (months): %d, Storage (GB): %d, Final Price: $%.2f%n",
            phoneNum,
            getProductID(),
            getBasePrice(),
            getWarrantyPeriod(),
            getStorageGB(),
            getFinalPrice()
        );
    }
}

public class Solution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        int id1 = scanner.nextInt();
        double price1 = scanner.nextDouble();
        int warranty1 = scanner.nextInt();
        int storage1 = scanner.nextInt();

        Smartphone phone1 =
                new Smartphone(id1, price1, warranty1, storage1);

        int id2 = scanner.nextInt();
        double price2 = scanner.nextDouble();
        int warranty2 = scanner.nextInt();
        int storage2 = scanner.nextInt();

        Smartphone phone2 =
                new Smartphone(id2, price2, warranty2, storage2);

        phone1.displayDetails(1);
        phone2.displayDetails(2);

        scanner.close();
    }
}
