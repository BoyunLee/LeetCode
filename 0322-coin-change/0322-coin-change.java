class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;

        Queue<Entry> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[amount + 1];
        queue.add(new Entry(amount, 0));

        while (!queue.isEmpty()) {
            Entry cur = queue.remove();
            for (int i = 0; i < coins.length; i++) {	
                int nextAmount = cur.amount - coins[i];
                if (nextAmount == 0) {
                    return cur.count + 1;
                } else if (nextAmount > 0 && !visited[nextAmount]) {
                    queue.add(new Entry(nextAmount, cur.count + 1));
                    visited[nextAmount] = true;
                }
            }
        }
        return -1;
    }

    static class Entry {
        int amount;
        int count;

        public Entry(int amount, int count) {
            this.amount = amount;
            this.count = count;
        }
    }
}