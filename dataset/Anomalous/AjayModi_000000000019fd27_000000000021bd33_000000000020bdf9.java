import java.util.*;

class Solution {

    static class Store implements Comparable<Store> {
        int start, end, index;
        String assigned;

        Store(int start, int end, int index, String assigned) {
            this.start = start;
            this.end = end;
            this.index = index;
            this.assigned = assigned;
        }

        @Override
        public int compareTo(Store other) {
            return Integer.compare(this.start, other.start);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            Store[] stores = new Store[n];
            Store[] originalOrder = new Store[n];

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                stores[i] = new Store(start, end, i, "N");
                originalOrder[i] = new Store(start, end, i, "N");
            }

            Arrays.sort(stores);

            int cEnd = 0, jEnd = 0;
            boolean possible = true;

            for (int i = 0; i < n; i++) {
                Store current = stores[i];
                if (current.start >= cEnd) {
                    current.assigned = "C";
                    cEnd = current.end;
                } else if (current.start >= jEnd) {
                    current.assigned = "J";
                    jEnd = current.end;
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                Arrays.sort(stores, Comparator.comparingInt(s -> s.index));
                StringBuilder result = new StringBuilder("Case #" + testCase + ": ");
                for (Store store : stores) {
                    result.append(store.assigned);
                }
                System.out.println(result);
            } else {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            }
        }
    }
}