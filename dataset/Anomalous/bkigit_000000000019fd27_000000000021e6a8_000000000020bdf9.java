import java.util.*;

class Solution {
    static class Store implements Comparable<Store> {
        int start, end, index;
        String character;

        Store(int start, int end, int index, String character) {
            this.start = start;
            this.end = end;
            this.index = index;
            this.character = character;
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
            Store[] sortedByIndex = new Store[n];

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                stores[i] = new Store(start, end, i, "N");
            }

            Arrays.sort(stores);

            int cEnd = 0, jEnd = 0;
            boolean isPossible = true;

            for (int i = 0; i < n; i++) {
                int start = stores[i].start;
                int end = stores[i].end;

                if (i == 0) {
                    stores[i].character = "C";
                    cEnd = end;
                } else if (i == 1) {
                    stores[i].character = "J";
                    jEnd = end;
                } else {
                    if (start >= cEnd) {
                        stores[i].character = "C";
                        cEnd = end;
                    } else if (start >= jEnd) {
                        stores[i].character = "J";
                        jEnd = end;
                    } else {
                        isPossible = false;
                        break;
                    }
                }

                sortedByIndex[stores[i].index] = stores[i];
            }

            if (!isPossible) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                StringBuilder result = new StringBuilder("Case #" + testCase + ": ");
                for (Store store : sortedByIndex) {
                    result.append(store.character);
                }
                System.out.println(result);
            }
        }
        scanner.close();
    }
}