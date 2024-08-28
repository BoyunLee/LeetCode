class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = 10001; 
        int[] dp = new int[amount + 1];
        
        for (int i = 1; i <= amount; i++) {
            dp[i] = max;
        }
        
        dp[0] = 0; 
        
        for (int coin : coins) {
            for (int currentAmount=coin; currentAmount<=amount; currentAmount++) {
                if (dp[currentAmount - coin] != max) {
                    dp[currentAmount] = Math.min(dp[currentAmount], dp[currentAmount - coin] + 1);
                }
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }
}