import java.util.Arrays;
import java.util.Comparator;

public class solution3025 {

    public int numberOfPairs(int[][] points) {
        int ans = 0;

        Arrays.sort(points, Comparator.comparingInt((int[] point) -> point[0])
                                .thenComparingInt((int[] point) -> -point[1]));

        for (int i = 0; i < points.length; ++i) {
            int maxY = Integer.MIN_VALUE;
            for (int j = i + 1; j < points.length; ++j)
                if (points[i][1] >= points[j][1] && points[j][1] > maxY) {
                    ++ans;
                    maxY = points[j][1];
                }
        }

        return ans;
    }

    // 🔹 Main method for local testing
    public static void main(String[] args) {
        solution3025 sol = new solution3025();
        int[][] points = {{1,3},{2,2},{3,1}};
        int result = sol.numberOfPairs(points);
        System.out.println("Number of pairs: " + result);
    }
}
