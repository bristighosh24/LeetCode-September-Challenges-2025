import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class solution2785 {
    public String sortVowels(String s) {
        StringBuilder sb = new StringBuilder();
        List<Character> vowels = new ArrayList<>();

        for (final char c : s.toCharArray()) {
            if (isVowel(c)) {
                vowels.add(c);
            }
        }

        Collections.sort(vowels);

        int i = 0; // vowels' index
        for (final char c : s.toCharArray()) {
            sb.append(isVowel(c) ? vowels.get(i++) : c);
        }

        return sb.toString();
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }

    // ✅ Add this for local execution
    public static void main(String[] args) {
        solution2785 sol = new solution2785();
        String input = "leetcode";
        String output = sol.sortVowels(input);
        System.out.println("Input: " + input);
        System.out.println("Output: " + output);
    }
}

