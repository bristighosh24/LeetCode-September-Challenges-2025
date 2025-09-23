public class solution165 {

    public int compareVersion(String version1, String version2) {
        final String[] levels1 = version1.split("\\.");
        final String[] levels2 = version2.split("\\.");
        final int length = Math.max(levels1.length, levels2.length);

        for (int i = 0; i < length; ++i) {
            final Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
            final Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
            final int compare = v1.compareTo(v2);
            if (compare != 0)
                return compare;
        }
        return 0;
    }

    // Main method for testing
    public static void main(String[] args) {
        solution165 sol = new solution165();

        // Example test cases
        System.out.println(sol.compareVersion("1.01", "1.001")); // 0
        System.out.println(sol.compareVersion("1.0", "1.0.0"));   // 0
        System.out.println(sol.compareVersion("0.1", "1.1"));     // -1
        System.out.println(sol.compareVersion("1.0.1", "1"));     // 1
        System.out.println(sol.compareVersion("7.5.2.4", "7.5.3")); // -1
    }
}

