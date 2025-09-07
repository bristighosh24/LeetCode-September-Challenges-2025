public class solution1304 {

    // Method required by the LeetCode problem
    public int[] sumZero(int n) {
        int[] ans = new int[n];

        for (int i = 0; i < n; ++i)
            ans[i] = i * 2 - n + 1;

        return ans;
    }

    // Main method to run locally
    public static void main(String[] args) {
        solution1304 obj = new solution1304();
        int n = 5; // example input
        int[] result = obj.sumZero(n);

        System.out.print("Output: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}

