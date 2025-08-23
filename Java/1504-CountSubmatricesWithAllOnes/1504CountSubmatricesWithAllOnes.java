class Solution {
    public int numSubmat(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        int sum = 0;
        for(int i = 0; i<rows; i++) {
            for(int j = 1; j<cols; j++) {
                if (mat[i][j] == 1) {
                    mat[i][j] += mat[i][j - 1];
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int minWidth = mat[i][j];
                for (int k = i; k >= 0 && minWidth > 0; k--) {
                    minWidth = Math.min(minWidth, mat[k][j]);
                    sum += minWidth;
                }
            }
        }

        return sum;
    }
}