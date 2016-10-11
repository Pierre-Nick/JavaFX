package assignment1;

/**
 * Created by NickPierre on 9/4/16.
 */
import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        //Create Scanner object
        Scanner input = new Scanner(System.in);

        //Enter Coins Value
        System.out.println("Enter the amount of Quarters: ");
        int q = input.nextInt();
        System.out.println("Enter the amount of Dimes: ");
        int d = input.nextInt();
        System.out.println("Enter the amount of Nickles: ");
        int n = input.nextInt();
        System.out.println("Enter the amount of Pennies: ");
        int p = input.nextInt();

        //Value
        double totalQuarter = q * .25;
        double totalDime = d * .10;
        double totalNickle = n * .05;
        double totalPenny = p * .01;

        //Output Value
        System.out.println("Quarters: " + totalQuarter);
        System.out.println("Dimes: " + totalDime);
        System.out.println("Nickles: " + totalNickle);
        System.out.println("Pennies: " + totalPenny);

        //Dollars
        double totalDollars =(totalQuarter + totalDime + totalNickle + totalPenny);
        //Cents
        double totalCents = (totalDollars * 100.0) % 100.0;

        //Dollars and Cents
        System.out.println("");
        System.out.println("Dollars: " + (int)totalDollars);
        System.out.println("Cents: " + (int)totalCents);
    }
}
