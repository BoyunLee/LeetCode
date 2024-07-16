class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        boolean[] used = new boolean[n+1];

        int[] factorial = new int[n+1];
        factorial[0] = 1;
        for (int i=1; i<=n; i++) {
            factorial[i] = factorial[i-1]*i;
        }

        for (int i=1; i<=n; i++) {
            numbers.add(i);
        }

        backtrack(n, k, used, numbers, factorial, result);

        return result.toString();
    }

    private void backtrack(int n, int k, boolean[] used, List<Integer> numbers, int[] factorial, StringBuilder result) {
        if (result.length() == n) {
            return;
        }

        int remaining = n - result.length() -1;

        for (int i=1; i<=n; i++) {
            if (used[i]) continue;

            int count = factorial[remaining];

            if (k > count) {
                k -= count;
            } else {
                result.append(i);
                used[i] = true;
                backtrack(n, k, used, numbers, factorial, result);
                return;
            }
        }

    }
}