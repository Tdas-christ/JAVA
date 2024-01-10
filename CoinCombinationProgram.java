import java.util.Scanner;
import java.util.concurrent.*;

//This program uses dynamic programming approach. This can also be done using recursion. 

public class CoinCombinationProgram{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //User input for the size of the array, target sum, and coin values
           // Do-while loop ensures that no negative size of the array is entered
           int N;
           do {
               System.out.print("Enter the size of the array (positive integer): ");
               while (!sc.hasNextInt()) {
                   System.out.println("Invalid input. Please enter a positive integer.");
                   sc.next(); // Consuming the invalid input
               }
               N = sc.nextInt();
           } while (N <= 0);
   
           // Do-while loop ensures that the target sum entered is not a negative integer
           int sum;
           do {
               System.out.print("Enter the target sum (positive integer): ");
               while (!sc.hasNextInt()) {
                   System.out.println("Invalid input. Please enter a positive integer.");
                   sc.next(); // Consume the invalid input
               }
               sum = sc.nextInt();
           } while (sum <= 0);
   
           // Do-while loop ensures that the coin values entered are not negative integers
           int[] coins = new int[N];
           System.out.print("Enter the coin values: ");
           for (int i = 0; i < N; i++) {
               int coin;
               do {
                   System.out.print("Enter coin value " + (i + 1) + " (positive integer): ");
                   while (!sc.hasNextInt()) {
                       System.out.println("Invalid input. Please enter a positive integer.");
                       sc.next(); // Consume the invalid input
                   }
                   coin = sc.nextInt();
               } while (coin <= 0);
               coins[i] = coin;
           }
   
           CoinCombinationProgram cc = new CoinCombinationProgram();
           int ways = cc.calculateWays(coins, sum);
           System.out.println("Number of ways to make the sum: " + ways);
   
           sc.close();
       }


    public int calculateWays(int[] coins, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1;

        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        try {
            for (int coin : coins) {
                executorService.submit(() -> {
                    for (int j = coin; j <= sum; j++) {
                        dp[j] += dp[j - coin];
                    }
                }).get();
            }
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("An error occurred: " + e.getMessage());
            return -1;
        } finally {
            executorService.shutdown();
        }

        return dp[sum];
    }
}
 
