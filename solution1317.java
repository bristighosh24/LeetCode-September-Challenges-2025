public class solution1317 {

    public int[] getNoZeroIntegers(int n) {
        for (int A = 1; A < n; ++A) {
            int B = n - A;
            if (!String.valueOf(A).contains("0") && !String.valueOf(B).contains("0")) {
                return new int[] {A, B};
            }
        }
        throw new IllegalArgumentException();
    }

    // Main method to run locally
    public static void main(String[] args) {
        solution1317 sol = new solution1317();
        int n = 11; // Example input
        int[] result = sol.getNoZeroIntegers(n);

        System.out.println("Input: " + n);
        System.out.println("Output: [" + result[0] + ", " + result[1] + "]");
    }
}
