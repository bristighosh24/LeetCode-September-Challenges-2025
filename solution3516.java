class solution3516 {
    public int findClosest(int x, int y, int z) {
        final int xz = Math.abs(x - z);
        final int yz = Math.abs(y - z);
        if (xz == yz) {
            return 0;
        }
        return xz < yz ? 1 : 2;
    }

    // ✅ Main method to run locally
    public static void main(String[] args) {
        solution3516 sol = new solution3516();
        int result = sol.findClosest(5, 9, 7); // sample input
        System.out.println("Closest result: " + result);
    }
}
