
public class solution3005 {
    public int maxFrequencyElements(int[] nums) {
        // Maximum possible value as per constraints (1 <= nums[i] <= 100)
        final int MAX = 100;
        int ans = 0;

        // Count frequency of each number
        int[] count = new int[MAX + 1];
        for (int num : nums) {
            count[num]++;
        }

        // Find the maximum frequency
        int maxFreq = 0;
        for (int freq : count) {
            maxFreq = Math.max(maxFreq, freq);
        }

        // Sum up all occurrences that match the maximum frequency
        for (int freq : count) {
            if (freq == maxFreq) {
                ans += freq;
            }
        }

        return ans;
    }

    // For testing
    public static void main(String[] args) {
        solution3005 sol = new solution3005();
        int[] nums1 = {1, 2, 2, 3, 1, 4};
        int[] nums2 = {1, 2, 3, 4, 5};

        System.out.println(sol.maxFrequencyElements(nums1)); // Output: 4
        System.out.println(sol.maxFrequencyElements(nums2)); // Output: 5
    }
}
