import java.util.Scanner;

public class FinancialForecast {

    // Recursive method to calculate future value
    public static double futureValue(double principal, double rate, int years) {
        if (years == 0)
            return principal;
        return futureValue(principal, rate, years - 1) * (1 + rate);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter initial investment amount: ");
        double principal = sc.nextDouble();

        System.out.print("Enter annual growth rate (in %): ");
        double rate = sc.nextDouble() / 100.0;

        System.out.print("Enter number of years to forecast: ");
        int years = sc.nextInt();

        double result = futureValue(principal, rate, years);
        System.out.printf("Future value after %d years: ₹%.2f\n", years, result);

        
    }
}