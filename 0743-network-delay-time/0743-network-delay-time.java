class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] cost = new int[n+1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[k] = 0;

        for (int i = 0; i < n; i++) {
            boolean update = false;

            for (int[] t : times) {
                int src = t[0];
                int dst = t[1];
                int price = t[2];

                if (cost[src] == Integer.MAX_VALUE) {
                    continue;
                }

                if (cost[dst] > cost[src] + price) {
                    cost[dst] = cost[src] + price;
                    update = true;
                }
            }

            if (update == false) {
                break;
            }
        }

        int ans = -1;
        for (int i = 1; i < n+1; i++) {
            ans = Math.max(ans, cost[i]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}