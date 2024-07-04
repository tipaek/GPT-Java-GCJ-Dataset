import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    private static class BitSet {
        private Boolean[] values;

        public BitSet(int size) {
            values = new Boolean[size];
        }

        public void set(int idx, boolean value) {
            values[idx] = value;
        }

        public boolean isSame(int idx, boolean value) {
            return values[idx].equals(value);
        }

        public void xor() {
            for (int i = 0; i < values.length; i++) {
                if (values[i] != null) {
                    values[i] = !values[i];
                }
            }
        }

        public void swap() {
            int n = values.length;
            for (int i = 0; i < n / 2; i++) {
                Boolean temp = values[i];
                values[i] = values[n - i - 1];
                values[n - i - 1] = temp;
            }
        }

        public Integer getSameIdx() {
            int n = values.length;
            for (int i = 0; i < n / 2; i++) {
                Boolean first = values[i];
                Boolean second = values[n - i - 1];
                if (first != null && second != null && first.equals(second)) {
                    return i;
                }
            }
            return null;
        }

        public Integer getDifferentIdx() {
            int n = values.length;
            for (int i = 0; i < n / 2; i++) {
                Boolean first = values[i];
                Boolean second = values[n - i - 1];
                if (first != null && second != null && !first.equals(second)) {
                    return i;
                }
            }
            return null;
        }

        public Integer getIndexToAsk() {
            int n = values.length;
            for (int i = 0; i <= n / 2; i++) {
                if (values[i] == null) {
                    return i;
                }
                if (values[n - i - 1] == null) {
                    return n - i - 1;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return Stream.of(values).map(v -> v ? "1" : "0").collect(Collectors.joining(""));
        }
    }

    private static boolean getValueOnIndex(final Scanner scanner, int index) {
        System.out.println(index + 1);
        System.out.flush();
        return scanner.nextInt() == 1;
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int testCount = scanner.nextInt();
        int bitCount = scanner.nextInt();
        
        for (int test = 1; test <= testCount; test++) {
            BitSet bitSet = new BitSet(bitCount);
            int requestsLeft = 10;

            while (true) {
                Integer indexToAsk = bitSet.getIndexToAsk();
                if (indexToAsk == null) break;

                if (requestsLeft == 0) {
                    Set<String> operationsAllowed = new HashSet<>();
                    operationsAllowed.add("nop");
                    operationsAllowed.add("swap");
                    operationsAllowed.add("xor");
                    operationsAllowed.add("swapxor");
                    requestsLeft = 10;

                    Integer sameIdx = bitSet.getSameIdx();
                    if (sameIdx != null) {
                        boolean value = getValueOnIndex(scanner, sameIdx);
                        requestsLeft--;
                        if (bitSet.isSame(sameIdx, value)) {
                            operationsAllowed.remove("xor");
                            operationsAllowed.remove("swapxor");
                        } else {
                            operationsAllowed.remove("nop");
                            operationsAllowed.remove("swap");
                        }
                    }

                    Integer diffIdx = bitSet.getDifferentIdx();
                    if (diffIdx != null) {
                        boolean value = getValueOnIndex(scanner, diffIdx);
                        requestsLeft--;
                        if (bitSet.isSame(diffIdx, value)) {
                            operationsAllowed.remove("swap");
                            operationsAllowed.remove("xor");
                        } else {
                            operationsAllowed.remove("nop");
                            operationsAllowed.remove("swapxor");
                        }
                    }

                    String operation = operationsAllowed.iterator().next();
                    switch (operation) {
                        case "swap":
                            bitSet.swap();
                            break;
                        case "xor":
                            bitSet.xor();
                            break;
                        case "swapxor":
                            bitSet.swap();
                            bitSet.xor();
                            break;
                    }
                } else {
                    bitSet.set(indexToAsk, getValueOnIndex(scanner, indexToAsk));
                    requestsLeft--;
                }
            }
            System.out.println(bitSet.toString());
            System.out.flush();
            if (scanner.next().equalsIgnoreCase("N")) {
                throw new RuntimeException("Oops");
            }
        }
    }
}