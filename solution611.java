import java.util.Arrays;

public class solution611 {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;

        for (int i = nums.length - 1; i >= 2; i--) {
            int left = 0, right = i - 1;

            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    count += (right - left);
                    right--;
                } else {
                    left++;
                }
            }
        }

        return count;
    }

    // Main method for testing
    public static void main(String[] args) {
        solution611 sol = new solution611();

        int[] nums1 = {2, 2, 3, 4};
        System.out.println("Output: " + sol.triangleNumber(nums1)); // Expected: 3

        int[] nums2 = {4, 2, 3, 4};
        System.out.println("Output: " + sol.triangleNumber(nums2)); // Expected: 4
    }
}

