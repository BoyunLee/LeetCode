import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(new ArrayList<>(), nums, visited, result);
        for (List<Integer> permutation : result) {
            System.out.println(permutation);
        }
        return result;
    }

    // 순열을 만들어서 result에 추가하는 함수
    void backtrack(List<Integer> curr, int[] nums, boolean[] visited, List<List<Integer>> result) {
        // base case
        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        // recursive call
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;

            curr.add(nums[i]);
            visited[i] = true;
            backtrack(curr, nums, visited, result);
            curr.remove(curr.size() - 1); // remove 마지막 원소
            visited[i] = false;
        }
    }
}