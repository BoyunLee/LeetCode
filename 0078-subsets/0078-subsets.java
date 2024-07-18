import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> curr, int[] nums, int start) {
        result.add(new ArrayList<>(curr));
        for (int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            backtrack(result, curr, nums, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}