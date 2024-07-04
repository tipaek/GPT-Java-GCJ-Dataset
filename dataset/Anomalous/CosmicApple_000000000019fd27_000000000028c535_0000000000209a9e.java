import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numOfTests = input.nextInt();
        int length = input.nextInt();

        for (int currentTest = 1; currentTest <= numOfTests; currentTest++) {
            DataFinder dataFinder = new DataFinder(length, input);
            int queries = 0;

            while (!dataFinder.arrayAllKnown()) {
                if (shouldAnalyzeAndFix(queries)) {
                    dataFinder.analyzeAndFixArchives();
                } else {
                    dataFinder.getNextPair();
                }
                queries += 2;
            }

            System.out.println(dataFinder.getOutput());
            String results = input.next();

            if (!results.equals("Y")) {
                throw new RuntimeException("Unexpected result");
            }
        }
    }

    static boolean shouldAnalyzeAndFix(int queries) {
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
        this.arr = new int[length];
        this.knownPairs = 0;
        this.homogenousPair = -1;
        this.heterogenousPair = -1;
    }

    public void getNextPair() {
        arr[knownPairs] = getBit(knownPairs);
        arr[findPairIndex(knownPairs)] = getBit(findPairIndex(knownPairs));

        if (homogenousPair == -1 && arr[knownPairs] == arr[findPairIndex(knownPairs)]) {
            homogenousPair = knownPairs;
        }
        if (heterogenousPair == -1 && arr[knownPairs] != arr[findPairIndex(knownPairs)]) {
            heterogenousPair = knownPairs;
        }

        knownPairs++;
    }

    private int getBit(int index) {
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

    public boolean arrayAllKnown() {
        return knownPairs >= (arr.length + 1) / 2;
    }

    public void analyzeAndFixArchives() {
        if (homogenousPair == -1 && heterogenousPair == -1) return;

        int newHomogenousData = -1, newHeterogenousData = -1;
        if (homogenousPair != -1) {
            newHomogenousData = getBit(homogenousPair);
        } else {
            getBit(0);
        }

        if (heterogenousPair != -1) {
            newHeterogenousData = getBit(heterogenousPair);
        } else {
            getBit(0);
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
            arr[i] = arr[findPairIndex(i)];
            arr[findPairIndex(i)] = temp;
        }
    }

    private void complementArray() {
        for (int i = 0; i < knownPairs; i++) {
            arr[i] = getComplement(arr[i]);
            if (findPairIndex(i) != i) {
                arr[findPairIndex(i)] = getComplement(arr[findPairIndex(i)]);
            }
        }
    }

    private int getComplement(int n) {
        return n == 0 ? 1 : 0;
    }

    private int findPairIndex(int index) {
        return arr.length - 1 - index;
    }
}