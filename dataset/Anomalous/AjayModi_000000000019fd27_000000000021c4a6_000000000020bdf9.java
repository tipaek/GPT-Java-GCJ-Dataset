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

    static class IndexedStore implements Comparable<IndexedStore> {
        int start, end, index;
        String assigned;

        IndexedStore(int start, int end, int index, String assigned) {
            this.start = start;
            this.end = end;
            this.index = index;
            this.assigned = assigned;
        }

        @Override
        public int compareTo(IndexedStore other) {
            return Integer.compare(this.index, other.index);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            Store[] stores = new Store[n];
            IndexedStore[] indexedStores = new IndexedStore[n];

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                stores[i] = new Store(start, end, i + 1, "N");
            }

            Arrays.sort(stores);

            for (int i = 0; i < n; i++) {
                indexedStores[i] = new IndexedStore(stores[i].start, stores[i].end, stores[i].index, stores[i].assigned);
            }

            int cameronEnd = 0, jamieEnd = 0;
            boolean impossible = false;

            for (int i = 0; i < n; i++) {
                int start = stores[i].start;
                int end = stores[i].end;

                if (i == 0) {
                    stores[i].assigned = "C";
                    indexedStores[i].assigned = "C";
                    cameronEnd = end;
                } else if (i == 1) {
                    stores[i].assigned = "J";
                    indexedStores[i].assigned = "J";
                    jamieEnd = end;
                } else {
                    if (start >= cameronEnd) {
                        stores[i].assigned = "C";
                        indexedStores[i].assigned = "C";
                        cameronEnd = end;
                    } else if (start >= jamieEnd) {
                        stores[i].assigned = "J";
                        indexedStores[i].assigned = "J";
                        jamieEnd = end;
                    } else {
                        System.out.println("Case #" + t + ": IMPOSSIBLE");
                        impossible = true;
                        break;
                    }
                }
            }

            if (!impossible) {
                Arrays.sort(indexedStores);
                System.out.print("Case #" + t + ": ");
                for (IndexedStore indexedStore : indexedStores) {
                    System.out.print(indexedStore.assigned);
                }
                System.out.println();
            }
        }
        scanner.close();
    }
}