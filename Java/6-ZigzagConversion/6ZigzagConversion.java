class Solution {
    public String convert(String s, int numRows) {

        if(numRows == 1) {
            return s;
        }

        String[] solStrings = new String[numRows];

        for (int i = 0; i < numRows; i++) {
            solStrings[i] = "";
        }

        int row = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            solStrings[row] += c;

            // flip direction
            if (row == 0 || row == numRows - 1) {
                goingDown = !goingDown;
            }

            row += goingDown ? 1 : -1;
        }

        String solution = "";
        for (int i = 0; i < numRows; i++) {
            solution  += solStrings[i];
        }

        return solution;
    }
}