class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            double gainA = gain(a[0], a[1]);
            double gainB = gain(b[0], b[1]);
            return Double.compare(gainB, gainA);
        });

        for(int i = 0; i < classes.length; i++)
        {
            pq.add(classes[i]);
        }

        for (int i = 0; i < extraStudents; i++) {
            int[] pair = pq.poll();
            pair[0]++;
            pair[1]++;
            pq.add(pair);
        }

        double sum = 0;
        while (!pq.isEmpty()) {
            int[] pair = pq.poll();
            sum += (double) pair[0] / pair[1];
        }

        return sum / classes.length;
    }

    private double gain(int pass, int total) {
        return (double) (pass + 1) / (total + 1) - (double) pass / total;
    }
}