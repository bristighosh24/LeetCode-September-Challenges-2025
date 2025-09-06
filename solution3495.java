public class solution3495 {
    public long minOperations(int[][] queries) {
        long total = 0;

        for (int[] query : queries) {
            int l = query[0], r = query[1];
            total += solve(r) - solve(l - 1);
        }

        return total;
    }

    // helper: number of operations to make [1..x] zero
    private long solve(int x) {
        long ops = 0;
        while (x > 0) {
            ops += x / 2; // in each round, we can pair numbers
            x /= 2;
        }
        return ops;
    }

    // Add a main method for testing locally
    public static void main(String[] args) {
        solution3495 sol = new solution3495();
        int[][] queries = { {1, 2}, {2, 4} };
        System.out.println(sol.minOperations(queries)); // expected output: 3
    }
}
