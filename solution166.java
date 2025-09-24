import java.util.*;

public class solution166 {

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        StringBuilder sb = new StringBuilder();

        // Handle negative sign
        if ((numerator < 0) ^ (denominator < 0)) {
            sb.append("-");
        }

        // Convert to long to avoid overflow
        long n = Math.abs((long) numerator);
        long d = Math.abs((long) denominator);

        // Append integer part
        sb.append(n / d);
        n %= d;

        if (n == 0) return sb.toString();

        sb.append(".");
        Map<Long, Integer> seen = new HashMap<>();

        while (n != 0) {
            if (seen.containsKey(n)) {
                sb.insert(seen.get(n), "(");
                sb.append(")");
                break;
            }
            seen.put(n, sb.length());
            n *= 10;
            sb.append(n / d);
            n %= d;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        solution166 sol = new solution166();

        // Test cases
        System.out.println(sol.fractionToDecimal(1, 2));   // "0.5"
        System.out.println(sol.fractionToDecimal(2, 1));   // "2"
        System.out.println(sol.fractionToDecimal(4, 333)); // "0.(012)"
        System.out.println(sol.fractionToDecimal(1, 6));   // "0.1(6)"
    }
}
