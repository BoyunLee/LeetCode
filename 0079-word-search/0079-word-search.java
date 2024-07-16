public class Solution {
        public boolean exist(char[][] board, String word) {
            int m = board.length; 
            int n = board[0].length;
            boolean[][] visited = new boolean[m][n];
    
            // 격자의 모든 셀을 탐색
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    // 단어의 첫 글자와 현재 셀의 문자가 일치하고, dfs를 통해 단어를 찾을 수 있는 경우 true 반환
                    if (board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0, visited)) {
                        return true;
                    }
                }
            }
            
            return false;  // 모든 셀에서 단어를 찾지 못한 경우 false 반환
        }
        
        private boolean dfs(char[][] board, String word, int i, int j, int idx, boolean[][] visited) {
            // 단어의 모든 문자를 찾은 경우 true 반환
            if (idx == word.length()) {
                return true;
            }
            
            // 인덱스 범위를 벗어난 경우, 이미 방문한 셀인 경우, 현재 셀의 문자가 단어의 해당 위치의 문자와 일치하지 않는 경우 false 반환
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(idx)) {
                return false;
            }
            
            // 현재 셀을 방문 처리
            visited[i][j] = true;
            
            // 상하좌우 인접 셀을 탐색하여 단어의 다음 문자를 찾는 재귀 호출
            boolean found = dfs(board, word, i + 1, j, idx + 1, visited) ||
                            dfs(board, word, i - 1, j, idx + 1, visited) ||
                            dfs(board, word, i, j + 1, idx + 1, visited) ||
                            dfs(board, word, i, j - 1, idx + 1, visited);
            
            // 백트래킹: 현재 셀을 다시 방문할 수 있도록 방문 처리 취소
            visited[i][j] = false;
            
            // 단어를 찾은 경우 true 반환, 찾지 못한 경우 false 반환
            return found;
        }
    }