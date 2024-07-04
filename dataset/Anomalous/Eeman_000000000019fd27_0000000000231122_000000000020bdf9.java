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

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            Store[] stores = new Store[n];

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                stores[i] = new Store(start, end, i, "N");
            }

            Arrays.sort(stores);

            int cEnd = 0, jEnd = 0;
            boolean possible = true;

            for (Store store : stores) {
                if (store.start >= cEnd) {
                    store.assigned = "C";
                    cEnd = store.end;
                } else if (store.start >= jEnd) {
                    store.assigned = "J";
                    jEnd = store.end;
                } else {
                    System.out.println("Case #" + t + ": IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            if (possible) {
                StringBuilder result = new StringBuilder();
                result.append("Case #").append(t).append(": ");
                Store[] sortedByIndex = Arrays.copyOf(stores, stores.length);
                Arrays.sort(sortedByIndex, Comparator.comparingInt(store -> store.index));

                for (Store store : sortedByIndex) {
                    result.append(store.assigned);
                }

                System.out.println(result);
            }
        }

        scanner.close();
    }
}