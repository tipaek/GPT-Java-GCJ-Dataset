import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public enum States {
        REVERSED, COMPLEMENTED, COMPLEMENTED_REVERSED, SAME
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();
        scanner.nextLine();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            Set<States> possibilities = EnumSet.allOf(States.class);
            Queue<Integer> unsolvedIndices = new LinkedList<>();
            for (int i = 1; i <= bitLength / 2; i++) {
                unsolvedIndices.add(i);
                unsolvedIndices.add(bitLength - i + 1);
            }
            List<Integer> bits = new ArrayList<>(Collections.nCopies(bitLength + 1, -1));
            int sameIndex = -1;
            int diffIndex = -1;
            boolean failed = false;

            for (int queryCount = 1; queryCount <= 150; queryCount++) {
                if (queryCount <= 10) {
                    assert !unsolvedIndices.isEmpty();
                    int position = unsolvedIndices.poll();
                    System.out.println(position);
                    System.out.flush();
                    int value = scanner.nextInt();
                    bits.set(position, value);

                    if (sameIndex == -1 && bits.get(position).equals(bits.get(bitLength - position + 1))) {
                        sameIndex = position;
                    }
                    if (diffIndex == -1 && bits.get(position) == 1 - bits.get(bitLength - position + 1)) {
                        diffIndex = position;
                    }
                } else {
                    if (queryCount % 10 == 1) {
                        possibilities = EnumSet.allOf(States.class);
                    }
                    if (sameIndex != -1) {
                        System.out.println(sameIndex);
                        System.out.flush();
                        int value = scanner.nextInt();
                        if (bits.get(sameIndex) == value) {
                            possibilities.remove(States.COMPLEMENTED);
                            possibilities.remove(States.COMPLEMENTED_REVERSED);
                        } else {
                            possibilities.remove(States.SAME);
                            possibilities.remove(States.REVERSED);
                        }
                    }
                    if (diffIndex != -1) {
                        System.out.println(diffIndex);
                        System.out.flush();
                        int value = scanner.nextInt();
                        if (bits.get(diffIndex) == value) {
                            possibilities.remove(States.COMPLEMENTED);
                            possibilities.remove(States.REVERSED);
                        } else {
                            possibilities.remove(States.COMPLEMENTED_REVERSED);
                            possibilities.remove(States.SAME);
                        }
                    }
                    if (diffIndex == -1 && !possibilities.contains(States.SAME)) {
                        Collections.reverse(bits);
                    }
                    if (sameIndex == -1 && possibilities.contains(States.COMPLEMENTED)) {
                        bits = bits.stream().map(v -> v != -1 ? 1 - v : v).collect(Collectors.toList());
                    }
                    if (!unsolvedIndices.isEmpty()) {
                        int position = unsolvedIndices.poll();
                        System.out.println(position);
                        System.out.flush();
                        int value = scanner.nextInt();
                        bits.set(position, value);
                    }
                }

                if (unsolvedIndices.isEmpty()) {
                    for (int i = 1; i <= bitLength; i++) {
                        System.out.print(bits.get(i));
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
}