import java.util.*;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }
    private void backtrack(int start, int n, int k, List<Integer> curr, List<List<Integer>> result) {
        // base case
        if (curr.size() == k) {
            result.add(new ArrayList<>(curr));
            return;
        }
        // recursive call
        for(int i=start; i<=n; i++) {
            curr.add(i);
            backtrack(i+1, n, k, curr, result);
            curr.remove(curr.size()-1);
        }
    }
}