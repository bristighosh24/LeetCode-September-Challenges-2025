import java.util.PriorityQueue;

public class solution1792 {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<T> maxHeap =
            new PriorityQueue<>((a, b) -> Double.compare(b.extraPassRatio, a.extraPassRatio));

        for (int[] c : classes) {
            final int pass = c[0];
            final int total = c[1];
            maxHeap.offer(new T(getExtraPassRatio(pass, total), pass, total));
        }

        for (int i = 0; i < extraStudents; ++i) {
            final int pass = maxHeap.peek().pass;
            final int total = maxHeap.poll().total;
            maxHeap.offer(new T(getExtraPassRatio(pass + 1, total + 1), pass + 1, total + 1));
        }

        double ratioSum = 0;

        while (!maxHeap.isEmpty())
            ratioSum += maxHeap.peek().pass / (double) maxHeap.poll().total;

        return ratioSum / classes.length;
    }

    private double getExtraPassRatio(int pass, int total) {
        return (pass + 1) / (double) (total + 1) - pass / (double) total;
    }

    private record T(double extraPassRatio, int pass, int total){};

    // 🔹 Main method for local testing
    public static void main(String[] args) {
        solution1792 sol = new solution1792();

        int[][] classes = {{1,2},{3,5},{2,2}};
        int extraStudents = 2;

        double result = sol.maxAverageRatio(classes, extraStudents);
        System.out.println("Maximum Average Pass Ratio: " + result);
    }
}
