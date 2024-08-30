class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] cost = new int[n+1];
        int max = Integer.MAX_VALUE;
        Arrays.fill(cost, max);
        cost[k] = 0;

        for(int i=0; i<n; i++) {
            boolean check = false;

            for(int[] time : times) {
                int u = time[0];
                int v = time[1];
                int w = time[2];

                if(cost[u] == max) {
                    continue;
                }

                if(cost[v] > cost[u] + w) {
                    cost[v] = cost[u] + w;
                    check = true;
                }
            }

            if(!check) break;
        }

        int answer = -1;
        for(int i=1; i<=n; i++) {
            answer = Math.max(answer, cost[i]);
        }

        return answer == max ? -1 : answer;
    }
}