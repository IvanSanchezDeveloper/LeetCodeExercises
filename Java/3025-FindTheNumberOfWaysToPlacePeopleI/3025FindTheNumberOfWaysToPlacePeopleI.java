class Solution {
    public int numberOfPairs(int[][] points) {

        Arrays.sort(points, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(b[1], a[1]);
            }
        });

        int n = points.length;

        int solutionCount = 0;

        for (int left = 0; left < n; left++) {
            for (int right = left + 1; right < n; right++) {
                if (isValidPair(points, left, right)) {
                    solutionCount++;
                }
            }
        }

        return solutionCount;
    }

    private boolean isValidPair(int[][] points, int i, int j) {
        int[] p1 = points[i];
        int[] p2 = points[j];

        if (p1[0] > p2[0] || p1[1] < p2[1]) {
            return false;
        }

        for (int mid = i + 1; mid < j; mid++) {
            int[] pm = points[mid];
            if (p1[0] <= pm[0] && pm[0] <= p2[0] &&
                    p1[1] >= pm[1] && pm[1] >= p2[1]) {
                return false;
            }
        }

        return true;
    }
}