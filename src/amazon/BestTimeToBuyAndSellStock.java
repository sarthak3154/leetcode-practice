package amazon;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(prices[i] - min, max);
        }

        return max;
    }

    public static void main(String[] args) {
        int maxProfit = new BestTimeToBuyAndSellStock().maxProfit(new int[]{7,6,4,3,1});
        System.out.println(maxProfit);
    }
}
