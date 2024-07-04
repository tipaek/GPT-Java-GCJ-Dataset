import java.util.*;

public class Solution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int testNr = 1; testNr <= t; testNr++) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();

            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextLong() * d;
            }

            if (n == 1) {
                System.out.println("Case #" + testNr + ": " + (d - 1));
                continue;
            }

            Arrays.sort(a);

            Map<Integer, Integer> indexes = new HashMap<>();
            Map<Integer, Long> duplicateCounts = getSmallestDuplicateCounts(a, indexes);

            if (d == 2) {
                if (duplicateCounts.get(2) != null) {
                    System.out.println("Case #" + testNr + ": 0");
                } else {
                    System.out.println("Case #" + testNr + ": 1");
                }
                continue;
            }

            if (d == 3) {
                if (duplicateCounts.get(3) != null) {
                    System.out.println("Case #" + testNr + ": 0");
                } else {
                    boolean isFound = false;
                    for (int i = 0; i < n; i++) {
                        for (int j = i + 1; j < n; j++) {
                            if (a[j] == 2 * a[i]) {
                                System.out.println("Case #" + testNr + ": 1");
                                isFound = true;
                                break;
                            } else if (a[j] > 2 * a[i]) {
                                break;
                            }
                        }
                        if (isFound) {
                            break;
                        }
                    }
                    if (!isFound) {
                        System.out.println("Case #" + testNr + ": 2");
                    }
                }
                continue;
            }

            boolean isDone = false;

            for (int key = n; key > 1; key--) {
                Long value = duplicateCounts.get(key);
                if (value == null) {
                    continue;
                }

                if (key >= d) {
                    System.out.println("Case #" + testNr + ": 0");
                    isDone = true;
                    break;
                }

                if (d % 2 == 0 && key >= d / 2) {
                    System.out.println("Case #" + testNr + ": " + (d / 2));
                    isDone = true;
                    break;
                }

                if (d % 2 != 0 && key > d / 2) {
                    System.out.println("Case #" + testNr + ": " + ((d / 2) + 1));
                    isDone = true;
                    break;
                }

                int piecesNeeded = d - key;
                int cuts = 0;
                int i = indexes.get(key) + 1;

                Set<Long> multipleSet = new HashSet<>();

                for (int j = i; j < a.length; j++) {
                    if (a[j] % value == 0) {
                        multipleSet.add(a[j]);
                        long newPieces = a[j] / value;
                        piecesNeeded -= newPieces;
                        cuts += newPieces - 1;

                        if (piecesNeeded <= 0) {
                            cuts += piecesNeeded + 1;
                            piecesNeeded = 0;
                            break;
                        }
                    }
                }

                if (piecesNeeded > 0) {
                    for (int j = i; j < a.length; j++) {
                        if (!multipleSet.contains(a[j])) {
                            long newPieces = a[j] / value;
                            if (piecesNeeded < newPieces) {
                                newPieces = piecesNeeded;
                            }
                            piecesNeeded -= newPieces;
                            cuts += newPieces;

                            if (piecesNeeded == 0) {
                                break;
                            }
                        }
                    }
                }

                if (piecesNeeded == 0) {
                    System.out.println("Case #" + testNr + ": " + cuts);
                    isDone = true;
                    break;
                }
            }

            if (!isDone) {
                // TODO - (d - 1) but not really
                System.out.println("Case #" + testNr + ": " + (d - 1));
            }
        }
    }

    private static Map<Integer, Long> getSmallestDuplicateCounts(long[] a, Map<Integer, Integer> indexes) {
        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            long value = a[i];
            int count = 1;
            while (i + 1 < a.length) {
                if (a[i + 1] == value) {
                    count++;
                    i++;
                } else {
                    break;
                }
            }
            if (count > 1) {
                map.putIfAbsent(count, value);
                indexes.putIfAbsent(count, i);
            }
        }
        return map;
    }
}
