package amazon.dynamicprogramming;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] coinsCount = new int[amount + 1];

        coinsCount[0] = 0;
        for (int i = 1; i < coinsCount.length; i++) {
            coinsCount[i] = amount + 1;
        }

        for (int i = 1; i < coinsCount.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    coinsCount[i] = Math.min(coinsCount[i], coinsCount[i - coins[j]] + 1);
                }
            }
        }
        return coinsCount[coinsCount.length - 1] > amount ? -1 : coinsCount[coinsCount.length - 1];
    }

    public static void main(String[] args) {
        int coins = new CoinChange().coinChange(new int[]{2}, 3);
        System.out.println(coins);
    }
}