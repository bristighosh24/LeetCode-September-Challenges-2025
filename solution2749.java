public class solution2749 {
    static class Solution {
        public int makeTheIntegerZero(int num1, int num2) {
            for (int k = 1; k <= 60; k++) {
                long val = (long) num1 - (long) k * (long) num2;
                if (val < 0) continue;

                int bitsCount = Long.bitCount(val);
                if (bitsCount <= k && k <= val) {
                    return k;
                }
            }
            return -1;
        }
    }

    // ✅ Main method to run locally
    public static void main(String[] args) {
        Solution sol = new Solution();
        int result = sol.makeTheIntegerZero(5, 2); // sample input
        System.out.println("Result: " + result);
    }
}

