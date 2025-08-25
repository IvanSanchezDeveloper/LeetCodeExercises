class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[] result = new int[rows * cols];

        int row = 0, col = 0, dir = 1; // dir = 1 means moving up-right, -1 means down-left
        for (int idx = 0; idx < rows * cols; idx++) {
            result[idx] = mat[row][col];

            row -= dir;
            col += dir;

            if (row >= rows) {
                row = rows - 1; col += 2; dir = -dir;
            }
            if (col >= cols) {
                col = cols - 1; row += 2; dir = -dir;
            }
            if (row < 0)  { row = 0; dir = -dir; }
            if (col < 0)  { col = 0; dir = -dir; }
        }
        return result;
    }
}
