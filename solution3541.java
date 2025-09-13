public class solution3541 {
    public int maxFreqSum(String s) {
        int[] count = new int[26];
        int maxVowel = 0;
        int maxConsonant = 0;

        // Count frequency of each character
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // Find maximum vowel and consonant frequency
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                maxVowel = Math.max(maxVowel, count[c - 'a']);
            } else {
                maxConsonant = Math.max(maxConsonant, count[c - 'a']);
            }
        }

        return maxVowel + maxConsonant;
    }

    // Helper function to check vowel
    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }

    // Main method for local testing
    public static void main(String[] args) {
        solution3541 obj = new solution3541();
        System.out.println(obj.maxFreqSum("successes")); // Expected 6
        System.out.println(obj.maxFreqSum("aeiaeia"));   // Expected 3
    }
}
