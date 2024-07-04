import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public enum States {
        REVERSED, // reversed
        COMPLEMENTED, // complemented
        COMPLEMENTED_REVERSED, // complemented and reversed
        SAME // same
    }

    private static int sameIndex = -1;
    private static int diffIndex = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();
        scanner.nextLine();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            Set<States> possibleStates = new HashSet<>();
            Queue<Integer> unsolvedIndices = new LinkedList<>();
            for (int i = 1; i <= bitLength / 2; i++) {
                unsolvedIndices.add(i);
                unsolvedIndices.add(bitLength - i + 1);
            }
            List<Integer> bitArray = new ArrayList<>(Collections.nCopies(bitLength + 1, -1));
            sameIndex = -1;
            diffIndex = -1;
            boolean failed = false;

            for (int queryCount = 1; queryCount <= 150; ) {
                if (queryCount <= 10) {
                    queryCount = queryBit(scanner, bitLength, unsolvedIndices, bitArray, queryCount);
                } else {
                    if (queryCount % 10 == 1) {
                        possibleStates.add(States.SAME);
                        possibleStates.add(States.REVERSED);
                        possibleStates.add(States.COMPLEMENTED);
                        possibleStates.add(States.COMPLEMENTED_REVERSED);
                    }

                    if (sameIndex != -1) {
                        System.out.println(sameIndex);
                        System.out.flush();
                        int value = scanner.nextInt();
                        if (bitArray.get(sameIndex) == value) {
                            possibleStates.remove(States.COMPLEMENTED);
                            possibleStates.remove(States.COMPLEMENTED_REVERSED);
                        } else {
                            possibleStates.remove(States.SAME);
                            possibleStates.remove(States.REVERSED);
                        }
                        queryCount++;
                    }

                    if (diffIndex != -1) {
                        System.out.println(diffIndex);
                        System.out.flush();
                        int value = scanner.nextInt();
                        if (bitArray.get(sameIndex) == value) {
                            possibleStates.remove(States.COMPLEMENTED);
                            possibleStates.remove(States.REVERSED);
                        } else {
                            possibleStates.remove(States.COMPLEMENTED_REVERSED);
                            possibleStates.remove(States.SAME);
                        }
                        queryCount++;
                    }

                    if (diffIndex == -1) {
                        if (possibleStates.contains(States.COMPLEMENTED) || possibleStates.contains(States.COMPLEMENTED_REVERSED)) {
                            bitArray = complement(bitArray);
                        }
                    }

                    if (sameIndex == -1) {
                        if (possibleStates.contains(States.COMPLEMENTED) || possibleStates.contains(States.REVERSED)) {
                            bitArray = complement(bitArray);
                        }
                    }

                    if (!unsolvedIndices.isEmpty()) {
                        queryCount = queryBit(scanner, bitLength, unsolvedIndices, bitArray, queryCount);
                    }
                }

                if (unsolvedIndices.isEmpty()) {
                    for (int i = 1; i <= bitLength; i++) {
                        System.out.print(bitArray.get(i));
                    }
                    System.out.println();
                    System.out.flush();
                    scanner.nextLine();
                    char response = scanner.nextLine().charAt(0);
                    if (response == 'N') {
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

    private static List<Integer> complement(List<Integer> bitArray) {
        return bitArray.stream()
                .map(value -> value != -1 ? 1 - value : value)
                .collect(Collectors.toList());
    }

    private static int queryBit(Scanner scanner, int bitLength, Queue<Integer> unsolvedIndices, List<Integer> bitArray, int queryCount) {
        assert !unsolvedIndices.isEmpty();
        int index = unsolvedIndices.poll();
        System.out.println(index);
        System.out.flush();
        int value = scanner.nextInt();
        bitArray.set(index, value);

        if (sameIndex == -1 && bitArray.get(index).equals(bitArray.get(bitLength - index + 1))) {
            sameIndex = index;
        }

        if (diffIndex == -1 && bitArray.get(index) == 1 - bitArray.get(bitLength - index + 1)) {
            diffIndex = index;
        }

        queryCount++;
        return queryCount;
    }
}