public class Trading {
    static int maxProfit;

    public static int Profit(int[] price)
    {
        int n = price.length;
        int profit = 0;
        int buyingPrice = price[0];

        for(int i=1;i<n;i++) {
            if(price[i] < price[i-1]) {
                profit += price[i-1] - buyingPrice;
                buyingPrice = price[i];
            }

        }

        profit += price[n-1] -buyingPrice;
        return profit;
    }
    public static void main(String[] args) {
        int[] pri1 = {10, 22, 5, 75, 65, 80};
        int[] pri2 = {2, 30, 15, 10, 8, 25, 80};
        System.out.println("Prices 1: " + Profit(pri1));
        System.out.println("Prices 2: " + Profit(pri2));
}
}


