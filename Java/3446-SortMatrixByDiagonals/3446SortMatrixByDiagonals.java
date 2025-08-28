class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        Map<Integer, PriorityQueue<Integer>> diagonals = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int diagonalKey = i - j;

                if (i >= j) {
                    diagonals.putIfAbsent(diagonalKey, new PriorityQueue<>(Collections.reverseOrder()));
                } else {
                    diagonals.putIfAbsent(diagonalKey, new PriorityQueue<>());
                }

                diagonals.get(diagonalKey).add(grid[i][j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                grid[i][j] = diagonals.get(key).poll();
            }
        }

        return grid;
    }
}