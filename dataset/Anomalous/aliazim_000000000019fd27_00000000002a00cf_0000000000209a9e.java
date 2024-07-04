import java.util.*;
import java.io.*;

public class QuantumArray {
    private char[] bits;
    private List<Integer> unknowns;
    private List<char[]> states;
    private int B;

    public QuantumArray(int B) {
        this.B = B;
        this.bits = new char[B];
        Arrays.fill(this.bits, '_');
        this.unknowns = new ArrayList<>();
        for (int i = 0; i < B; i++) {
            this.unknowns.add(i);
        }
        read(10);
        run();
    }

    private void read(int n) {
        for (int i = 0; i < n; i++) {
            int index = this.unknowns.remove(this.unknowns.size() - 1);
            this.bits[index] = readBit(index + 1);
            Collections.reverse(this.unknowns);
        }
        updateStates();
    }

    private char readBit(int index) {
        System.out.println(index);
        System.out.flush();
        Scanner scanner = new Scanner(System.in);
        return scanner.next().charAt(0);
    }

    private void updateStates() {
        char[] bitsComplement = complement(this.bits);
        char[] bitsComplementReversed = reverse(bitsComplement);
        char[] bitsReversedComplement = complement(bitsComplementReversed);
        this.states = Arrays.asList(this.bits, bitsComplement, bitsComplementReversed, bitsReversedComplement);
    }

    private char[] complement(char[] bits) {
        char[] result = new char[bits.length];
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] == '_') {
                result[i] = '_';
            } else if (bits[i] == '0') {
                result[i] = '1';
            } else {
                result[i] = '0';
            }
        }
        return result;
    }

    private char[] reverse(char[] bits) {
        char[] result = new char[bits.length];
        for (int i = 0; i < bits.length; i++) {
            result[i] = bits[bits.length - 1 - i];
        }
        return result;
    }

    private int[] getTestIdx() {
        Set<Integer> candidates = new HashSet<>();
        for (int i = 0; i < B; i++) {
            if (!this.unknowns.contains(i)) {
                candidates.add(i);
            }
        }
        int maxStates = new HashSet<>(this.states).size();
        for (int[] idx : combinations(candidates, 2)) {
            Set<String> numStates = new HashSet<>();
            for (char[] state : this.states) {
                numStates.add(Arrays.toString(Arrays.copyOfRange(state, idx[0], idx[1] + 1)));
            }
            if (numStates.size() == maxStates) {
                return idx;
            }
        }
        return new int[0];
    }

    private List<int[]> combinations(Set<Integer> set, int k) {
        List<int[]> result = new ArrayList<>();
        Integer[] arr = set.toArray(new Integer[0]);
        combinationsHelper(arr, new int[k], 0, 0, result);
        return result;
    }

    private void combinationsHelper(Integer[] arr, int[] data, int start, int index, List<int[]> result) {
        if (index == data.length) {
            result.add(data.clone());
            return;
        }
        for (int i = start; i < arr.length; i++) {
            data[index] = arr[i];
            combinationsHelper(arr, data, i + 1, index + 1, result);
        }
    }

    private void collapse() {
        int[] testIdx = getTestIdx();
        char[] test = new char[testIdx.length];
        for (int i = 0; i < testIdx.length; i++) {
            test[i] = readBit(testIdx[i] + 1);
        }
        for (char[] state : this.states) {
            if (Arrays.equals(test, Arrays.copyOfRange(state, testIdx[0], testIdx[1] + 1))) {
                this.bits = state;
                break;
            }
        }
    }

    private void run() {
        while (true) {
            collapse();
            try {
                read(8);
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int B = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            QuantumArray array = new QuantumArray(B);
            System.out.println(String.valueOf(array.bits));
            System.out.flush();
            if (scanner.next().equals("N")) {
                System.exit(0);
            }
        }
    }
}