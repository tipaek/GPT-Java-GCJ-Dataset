import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public enum States {
        REVERSED, // reversed
        COMPLEMENTED, // complemented
        COMPLEMENTED_REVERSED, // complemented and reversed
        SAME // same
    }

    private static int sameIndex = -1, diffIndex = -1, bitLength;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        bitLength = scanner.nextInt();
        scanner.nextLine();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            Set<States> possibilities = new HashSet<>();
            Queue<Integer> unsolvedIndices = new LinkedList<>();
            
            for (int i = 1; i <= bitLength / 2; i++) {
                unsolvedIndices.add(i);
                unsolvedIndices.add(bitLength - i + 1);
            }
            
            List<Integer> bits = new ArrayList<>(Collections.nCopies(bitLength + 1, -1));
            sameIndex = -1;
            diffIndex = -1;
            boolean failed = false;

            for (int queryCount = 1; queryCount <= 150; ) {
                if (queryCount <= 10) {
                    queryCount = queryDigit(scanner, unsolvedIndices, bits, queryCount);
                } else {
                    if (queryCount % 10 == 1) {
                        possibilities.addAll(Arrays.asList(States.SAME, States.REVERSED, States.COMPLEMENTED, States.COMPLEMENTED_REVERSED));

                        if (sameIndex != -1) {
                            queryCount = processIndex(scanner, bits, possibilities, sameIndex, queryCount);
                        }

                        if (diffIndex != -1) {
                            queryCount = processIndex(scanner, bits, possibilities, diffIndex, queryCount);
                        }

                        if (diffIndex == -1 && (possibilities.contains(States.COMPLEMENTED) || possibilities.contains(States.COMPLEMENTED_REVERSED))) {
                            bits = complement(bits);
                        }

                        if (sameIndex == -1 && (possibilities.contains(States.COMPLEMENTED) || possibilities.contains(States.REVERSED))) {
                            bits = complement(bits);
                        }

                        if (possibilities.size() == 1) {
                            switch (possibilities.iterator().next()) {
                                case COMPLEMENTED:
                                    bits = complement(bits);
                                    break;
                                case REVERSED:
                                    reverse(bits);
                                    break;
                                case COMPLEMENTED_REVERSED:
                                    bits = complement(bits);
                                    reverse(bits);
                                    break;
                                case SAME:
                                    break;
                            }
                        }
                    } else {
                        queryCount = queryDigit(scanner, unsolvedIndices, bits, queryCount);
                    }
                }

                if (unsolvedIndices.isEmpty()) {
                    for (int i = 1; i <= bitLength; i++) {
                        System.out.print(bits.get(i));
                    }
                    System.out.println();
                    System.out.flush();
                    scanner.nextLine();
                    if (scanner.nextLine().charAt(0) == 'N') {
                        failed = true;
                    }
                    break;
                }
            }

            if (failed) {
                break;
            }
        }
    }

    private static List<Integer> complement(List<Integer> bits) {
        return bits.stream().map(v -> v != -1 ? 1 - v : v).collect(Collectors.toList());
    }

    private static void swap(List<Integer> bits, int a, int b) {
        int temp = bits.get(a);
        bits.set(a, bits.get(b));
        bits.set(b, temp);
    }

    private static void reverse(List<Integer> bits) {
        for (int i = 1; i <= bitLength / 2; i++) {
            swap(bits, i, bitLength - i + 1);
        }
    }

    private static int queryDigit(Scanner scanner, Queue<Integer> unsolvedIndices, List<Integer> bits, int queryCount) {
        int index = unsolvedIndices.poll();
        System.out.println(index);
        System.out.flush();
        int value = scanner.nextInt();
        bits.set(index, value);

        if (sameIndex == -1 && bits.get(index).equals(bits.get(bitLength - index + 1))) {
            sameIndex = index;
        }
        if (diffIndex == -1 && bits.get(index) == 1 - bits.get(bitLength - index + 1)) {
            diffIndex = index;
        }
        return queryCount + 1;
    }

    private static int processIndex(Scanner scanner, List<Integer> bits, Set<States> possibilities, int index, int queryCount) {
        System.out.println(index);
        System.out.flush();
        int value = scanner.nextInt();

        if (bits.get(index) == value) {
            possibilities.remove(States.COMPLEMENTED);
            possibilities.remove(States.COMPLEMENTED_REVERSED);
        } else {
            possibilities.remove(States.SAME);
            possibilities.remove(States.REVERSED);
        }
        return queryCount + 1;
    }
}