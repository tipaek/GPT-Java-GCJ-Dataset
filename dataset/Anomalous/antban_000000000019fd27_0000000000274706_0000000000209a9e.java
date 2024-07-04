import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    private static class BitSet {
        private Boolean[] bits;

        public BitSet(int size) {
            bits = new Boolean[size];
        }

        public void set(int index, boolean value) {
            bits[index] = value;
        }

        public boolean isSame(int index, boolean value) {
            return bits[index].equals(value);
        }

        public void xor() {
            for (int i = 0; i < bits.length; ++i) {
                if (bits[i] != null) {
                    bits[i] = !bits[i];
                }
            }
        }

        public void swap() {
            for (int i = 0; i < bits.length / 2; ++i) {
                Boolean temp = bits[i];
                bits[i] = bits[bits.length - i - 1];
                bits[bits.length - i - 1] = temp;
            }
        }

        public Integer getSameIndex() {
            for (int i = 0; i < bits.length / 2; ++i) {
                Boolean first = bits[i];
                Boolean second = bits[bits.length - i - 1];
                if (first != null && second != null && first.equals(second)) {
                    return i;
                }
            }
            return null;
        }

        public Integer getDifferentIndex() {
            for (int i = 0; i < bits.length / 2; ++i) {
                Boolean first = bits[i];
                Boolean second = bits[bits.length - i - 1];
                if (first != null && second != null && !first.equals(second)) {
                    return i;
                }
            }
            return null;
        }

        public Integer getIndexToAsk() {
            for (int i = 0; i <= bits.length / 2; ++i) {
                if (bits[i] == null) {
                    return i;
                }
                if (bits[bits.length - i - 1] == null) {
                    return bits.length - i - 1;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return Stream.of(bits).map(bit -> bit ? "1" : "0").collect(Collectors.joining(""));
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

            while (bitSet.getIndexToAsk() != null) {
                if (requestsLeft == 0) {
                    Set<String> operations = new HashSet<>();
                    operations.add("nop");
                    operations.add("swap");
                    operations.add("xor");
                    operations.add("swapxor");
                    requestsLeft = 10;

                    Integer sameIndex = bitSet.getSameIndex();
                    if (sameIndex != null) {
                        boolean value = getValueOnIndex(scanner, sameIndex);
                        requestsLeft -= 1;
                        if (bitSet.isSame(sameIndex, value)) {
                            operations.remove("xor");
                            operations.remove("swapxor");
                        } else {
                            operations.remove("nop");
                            operations.remove("swap");
                        }
                    }

                    Integer diffIndex = bitSet.getDifferentIndex();
                    if (diffIndex != null) {
                        boolean value = getValueOnIndex(scanner, diffIndex);
                        requestsLeft -= 1;
                        if (bitSet.isSame(diffIndex, value)) {
                            operations.remove("swap");
                            operations.remove("xor");
                        } else {
                            operations.remove("nop");
                            operations.remove("swapxor");
                        }
                    }

                    String operation = operations.iterator().next();
                    if (operation.equals("swap")) {
                        bitSet.swap();
                    } else if (operation.equals("xor")) {
                        bitSet.xor();
                    } else if (operation.equals("swapxor")) {
                        bitSet.swap();
                        bitSet.xor();
                    }
                } else {
                    bitSet.set(bitSet.getIndexToAsk(), getValueOnIndex(scanner, bitSet.getIndexToAsk()));
                    requestsLeft -= 1;
                }
            }

            System.out.println(bitSet.toString());
            System.out.flush();
        }
    }
}