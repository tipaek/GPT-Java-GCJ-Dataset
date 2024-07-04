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

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            Store[] stores = new Store[n];
            Store[] sortedByIndex = new Store[n];

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                stores[i] = new Store(start, end, i, "N");
            }

            Arrays.sort(stores);

            int cameronEnd = 0, jamieEnd = 0;
            boolean impossible = false;

            for (int i = 0; i < n; i++) {
                Store current = stores[i];
                if (i == 0) {
                    current.character = "C";
                    cameronEnd = current.end;
                } else if (i == 1) {
                    current.character = "J";
                    jamieEnd = current.end;
                } else {
                    if (current.start >= cameronEnd) {
                        current.character = "C";
                        cameronEnd = current.end;
                    } else if (current.start >= jamieEnd) {
                        current.character = "J";
                        jamieEnd = current.end;
                    } else {
                        System.out.println("Case #" + t + ": IMPOSSIBLE");
                        impossible = true;
                        break;
                    }
                }
                sortedByIndex[current.index] = current;
            }

            if (!impossible) {
                Arrays.sort(sortedByIndex, Comparator.comparingInt(s -> s.index));
                System.out.print("Case #" + t + ": ");
                for (Store store : sortedByIndex) {
                    System.out.print(store.character);
                }
                System.out.println();
            }
        }
    }
}