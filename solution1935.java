public class solution1935 {
    public static void main(String[] args) {
        String text = "hello world";
        String brokenLetters = "ad";

        solution1935 sol = new solution1935();
        int result = sol.canBeTypedWords(text, brokenLetters);

        System.out.println("Output: " + result); // Expected: 1
    }

    public int canBeTypedWords(String text, String brokenLetters) {
        int ans = 0;
        boolean[] broken = new boolean[26];

        // Mark broken letters
        for (char c : brokenLetters.toCharArray()) {
            broken[c - 'a'] = true;
        }

        // Check each word
        for (String word : text.split(" ")) {
            if (canBeTyped(word, broken)) {
                ans++;
            }
        }

        return ans;
    }

    private boolean canBeTyped(String word, boolean[] broken) {
        for (char c : word.toCharArray()) {
            if (broken[c - 'a']) return false;
        }
        return true;
    }
}
