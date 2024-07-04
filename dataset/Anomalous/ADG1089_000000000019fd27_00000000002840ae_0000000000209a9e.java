import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public enum States {
        REVERSED,
        COMPLEMENTED,
        COMPLEMENTED_AND_REVERSED,
        SAME
    }

    private static int sameIndex = -1;
    private static int differentIndex = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();
        scanner.nextLine();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            Set<States> possibleStates = new HashSet<>(Arrays.asList(States.values()));
            Queue<Integer> unsolvedIndices = new LinkedList<>();
            for (int i = 1; i <= bitLength / 2; i++) {
                unsolvedIndices.add(i);
                unsolvedIndices.add(bitLength - i + 1);
            }

            List<Integer> bits = new ArrayList<>(Collections.nCopies(bitLength + 1, -1));
            sameIndex = -1;
            differentIndex = -1;
            boolean failed = false;

            for (int queryCount = 1; queryCount <= 150; ) {
                if (queryCount <= 10) {
                    queryCount = queryBit(scanner, bitLength, unsolvedIndices, bits, queryCount);
                } else {
                    if (queryCount % 10 == 1) {
                        possibleStates.addAll(Arrays.asList(States.values()));
                    }

                    if (sameIndex != -1) {
                        queryCount = handleSameIndex(scanner, bits, possibleStates, queryCount);
                    }

                    if (differentIndex != -1) {
                        queryCount = handleDifferentIndex(scanner, bits, possibleStates, queryCount);
                    }

                    if (differentIndex == -1 && !possibleStates.contains(States.SAME)) {
                        Collections.reverse(bits);
                    }

                    if (sameIndex == -1 && possibleStates.contains(States.COMPLEMENTED)) {
                        bits = bits.stream().map(v -> v != -1 ? 1 - v : v).collect(Collectors.toList());
                    }

                    if (!unsolvedIndices.isEmpty()) {
                        queryCount = queryBit(scanner, bitLength, unsolvedIndices, bits, queryCount);
                    }
                }

                if (unsolvedIndices.isEmpty()) {
                    printResult(bits, bitLength);
                    if (scanner.next().charAt(0) == 'N') {
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

    private static int queryBit(Scanner scanner, int bitLength, Queue<Integer> unsolvedIndices, List<Integer> bits, int queryCount) {
        int position = unsolvedIndices.poll();
        System.out.println(position);
        System.out.flush();
        int value = scanner.nextInt();
        bits.set(position, value);

        if (sameIndex == -1 && bits.get(position).equals(bits.get(bitLength - position + 1))) {
            sameIndex = bitLength - position + 1;
        }

        if (differentIndex == -1 && bits.get(position) == 1 - bits.get(bitLength - position + 1)) {
            differentIndex = bitLength - position + 1;
        }

        return ++queryCount;
    }

    private static int handleSameIndex(Scanner scanner, List<Integer> bits, Set<States> possibleStates, int queryCount) {
        System.out.println(sameIndex);
        System.out.flush();
        int value = scanner.nextInt();
        if (bits.get(sameIndex) == value) {
            possibleStates.remove(States.COMPLEMENTED);
            possibleStates.remove(States.COMPLEMENTED_AND_REVERSED);
        } else {
            possibleStates.remove(States.SAME);
            possibleStates.remove(States.REVERSED);
        }
        return ++queryCount;
    }

    private static int handleDifferentIndex(Scanner scanner, List<Integer> bits, Set<States> possibleStates, int queryCount) {
        System.out.println(differentIndex);
        System.out.flush();
        int value = scanner.nextInt();
        if (bits.get(sameIndex) == value) {
            possibleStates.remove(States.COMPLEMENTED);
            possibleStates.remove(States.REVERSED);
        } else {
            possibleStates.remove(States.COMPLEMENTED_AND_REVERSED);
            possibleStates.remove(States.SAME);
        }
        return ++queryCount;
    }

    private static void printResult(List<Integer> bits, int bitLength) {
        for (int i = 1; i <= bitLength; i++) {
            System.out.print(bits.get(i));
        }
        System.out.println();
        System.out.flush();
    }
}