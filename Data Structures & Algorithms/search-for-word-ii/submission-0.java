class Solution {


    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word; // Stores complete word at the end node
    }

    TrieNode root = new TrieNode();
    List<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {

        // Build Trie
        for (String word : words) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
            }
            node.word = word;
        }

        int m = board.length;
        int n = board[0].length;

        // Start DFS from every cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root);
            }
        }

        return result;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node) {

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
            return;

        char ch = board[i][j];

        if (ch == '#')
            return;

        TrieNode next = node.children[ch - 'a'];

        if (next == null)
            return;

        // Found a complete word
        if (next.word != null) {
            result.add(next.word);
            next.word = null; // Avoid duplicates
        }

        board[i][j] = '#';

        dfs(board, i + 1, j, next);
        dfs(board, i - 1, j, next);
        dfs(board, i, j + 1, next);
        dfs(board, i, j - 1, next);

        board[i][j] = ch;
    }

}
