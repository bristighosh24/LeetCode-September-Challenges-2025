import java.util.*;

public class solution2197 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[] nums1 = {6, 4, 3, 2, 7, 6, 2};
        int[] nums2 = {2, 2, 1, 1, 3, 3, 3};

        System.out.println(sol.replaceNonCoprimes(nums1)); // Output: [12, 7, 6]
        System.out.println(sol.replaceNonCoprimes(nums2)); // Output: [2, 1, 1, 3]
    }
}

class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        LinkedList<Integer> ans = new LinkedList<>();
        for (int num : nums) {
            while (!ans.isEmpty() && gcd(ans.getLast(), num) > 1) {
                num = lcm(ans.removeLast(), num);
            }
            ans.addLast(num);
        }
        return ans;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
}

