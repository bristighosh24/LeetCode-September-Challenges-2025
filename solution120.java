import java.util.*;

public class solution120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        // Bottom-up DP approach
        for (int row = n - 2; row >= 0; row--) {
            List<Integer> currentRow = triangle.get(row);
            List<Integer> belowRow = triangle.get(row + 1);

            for (int col = 0; col < currentRow.size(); col++) {
                int minBelow = Math.min(belowRow.get(col), belowRow.get(col + 1));
                currentRow.set(col, currentRow.get(col) + minBelow);
            }
        }

        return triangle.get(0).get(0);
    }

    public static void main(String[] args) {
        solution120 sol = new solution120();

        // Example 1
        List<List<Integer>> triangle1 = new ArrayList<>();
        triangle1.add(Arrays.asList(2));
        triangle1.add(Arrays.asList(3, 4));
        triangle1.add(Arrays.asList(6, 5, 7));
        triangle1.add(Arrays.asList(4, 1, 8, 3));
        System.out.println("Minimum total (Example 1): " + sol.minimumTotal(triangle1)); // Output: 11

        // Example 2
        List<List<Integer>> triangle2 = new ArrayList<>();
        triangle2.add(Arrays.asList(-10));
        System.out.println("Minimum total (Example 2): " + sol.minimumTotal(triangle2)); // Output: -10
    }
}

