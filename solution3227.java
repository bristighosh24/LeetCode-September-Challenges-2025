public class solution3227 {

    public boolean doesAliceWin(String s) {
        int vowelCount = 0;

        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                vowelCount++;
            }
        }

        // Alice wins if she has at least one vowel and the count is odd.
        // If no vowels → Alice cannot move → Bob wins.
        return vowelCount > 0 && vowelCount % 2 == 1;
    }

    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }

    // For local testing
    public static void main(String[] args) {
        solution3227 sol = new solution3227();
        System.out.println(sol.doesAliceWin("leetcode")); // true
        System.out.println(sol.doesAliceWin("bbcd"));     // false
    }
}
