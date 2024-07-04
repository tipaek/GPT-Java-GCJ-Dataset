class Solution {

    public static void main(String[] args) {
        Vestigium();
    }
    public static void Vestigium() {
        Scanner scanner = new Scanner(System.in);
        int testCount = scanner.nextInt();
        for (int i = 1; i <= testCount; i++) {
            int N = scanner.nextInt();

            int trace = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;

            List<Set<Integer>> cols = new ArrayList<>();

            for (int r = 1; r <= N; r++) {
                Set<Integer> rows = new HashSet<>();
                for (int c = 1; c <= N; c++) {
                    int value = scanner.nextInt();
                    if (r == c) {
                        trace += value;
                    }
                    rows.add(value);
                    if (r == 1) {
                        cols.add(new HashSet<>());
                    }
                    cols.get(c - 1).add(value);
                }
                
                if (rows.size() < N) {
                    duplicateRows++;
                }
            }
            for (Set<Integer> c : cols) {
                if (c.size() < N) {
                    duplicateColumns++;
                }
            }
            System.out.printf("\nCase #%d: %d %d %d", i, trace, duplicateRows, duplicateColumns);
        }
        scanner.close();
    }
}