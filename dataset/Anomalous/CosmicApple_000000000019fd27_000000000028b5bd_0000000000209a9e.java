import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numOfTests = input.nextInt();
        int length = input.nextInt();
        for (int currentTest = 1; currentTest <= numOfTests; currentTest++) {
            DataFinder dataFinder = new DataFinder(length, input);
            int queries = 0;
            while (!dataFinder.isArrayFullyKnown()) {
                if (isDataChange(queries)) {
                    dataFinder.analyzeAndFixData();
                } else {
                    dataFinder.retrieveNextPair();
                }
                queries += 2;
            }
            System.out.println(dataFinder.getOutput());
            input.next();
        }
    }

    static boolean isDataChange(int queries) {
        return queries > 0 && queries % 10 == 0;
    }
}

class DataFinder {
    private int[] arr;
    private int knownPairs;
    private Scanner input;
    private int homogenousPair;
    private int heterogenousPair;

    public DataFinder(int length, Scanner input) {
        this.input = input;
        arr = new int[length];
        knownPairs = 0;
        homogenousPair = -1;
        heterogenousPair = -1;
    }

    public void retrieveNextPair() {
        arr[knownPairs] = queryBit(knownPairs);
        arr[getPairedIndex(knownPairs)] = queryBit(getPairedIndex(knownPairs));

        if (homogenousPair == -1 && arr[knownPairs] == arr[getPairedIndex(knownPairs)]) {
            homogenousPair = knownPairs;
        }
        if (heterogenousPair == -1 && arr[knownPairs] != arr[getPairedIndex(knownPairs)]) {
            heterogenousPair = knownPairs;
        }

        knownPairs++;
    }

    private int queryBit(int index) {
        System.out.println(index + 1);
        return input.nextInt();
    }

    public String getOutput() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            output.append(arr[i]);
        }
        return output.toString();
    }

    public boolean isArrayFullyKnown() {
        return knownPairs >= (int) (length / 2.0 + 0.6);
    }

    public void analyzeAndFixData() {
        if (homogenousPair == -1 && heterogenousPair == -1) return;

        int newHomogenousData = -1, newHeterogenousData = -1;
        if (homogenousPair != -1) {
            newHomogenousData = queryBit(homogenousPair);
        } else {
            queryBit(0);
        }

        if (heterogenousPair != -1) {
            newHeterogenousData = queryBit(heterogenousPair);
        } else {
            queryBit(0);
        }

        if (homogenousPair == -1) {
            if (arr[heterogenousPair] != newHeterogenousData) {
                complementArray();
            }
        } else if (heterogenousPair == -1) {
            if (arr[homogenousPair] != newHomogenousData) {
                complementArray();
            }
        } else {
            if (arr[heterogenousPair] == newHeterogenousData) {
                if (arr[homogenousPair] != newHomogenousData) {
                    complementArray();
                    reverseArray();
                }
            } else {
                if (arr[homogenousPair] == newHomogenousData) {
                    reverseArray();
                } else {
                    complementArray();
                }
            }
        }
    }

    private void reverseArray() {
        for (int i = 0; i < knownPairs; i++) {
            int temp = arr[i];
            arr[i] = arr[getPairedIndex(i)];
            arr[getPairedIndex(i)] = temp;
        }
    }

    private void complementArray() {
        for (int i = 0; i < knownPairs; i++) {
            arr[i] = getComplement(arr[i]);
            if (getPairedIndex(i) != i) {
                arr[getPairedIndex(i)] = getComplement(arr[getPairedIndex(i)]);
            }
        }
    }

    private int getComplement(int n) {
        return n == 0 ? 1 : 0;
    }

    private int getPairedIndex(int index) {
        return arr.length - 1 - index;
    }
}