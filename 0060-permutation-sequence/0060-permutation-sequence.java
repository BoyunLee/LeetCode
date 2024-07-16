class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n + 1];
        StringBuilder result = new StringBuilder();

        // 숫자 리스트 생성
        for(int i=1; i<=n; i++) {
            numbers.add(i);
        }

        // 팩토리얼 값 계산
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        // 순열 생성
        for (int i = 1; i <= n; i++) {
            int index = (k - 1) / factorial[n - i];
            result.append(numbers.get(index));
            numbers.remove(index);
            k -= index * factorial[n - i];
        }

        return result.toString();
    }
}