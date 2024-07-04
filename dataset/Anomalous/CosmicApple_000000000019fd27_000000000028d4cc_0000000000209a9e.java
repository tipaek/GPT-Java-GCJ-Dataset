import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfTests = scanner.nextInt();
        int length = scanner.nextInt();

        for (int test = 1; test <= numOfTests; test++) {
            DataFinder dataFinder = new DataFinder(length, scanner);
            int queries = 0;

            while (!dataFinder.isArrayComplete()) {
                if (isDataChangeCycle(queries)) {
                    dataFinder.analyzeAndFixData();
                } else {
                    dataFinder.retrieveNextPair();
                }
                queries += 2;
            }

            System.out.println(dataFinder.getResult());
            String response = scanner.next();

            if (!response.equals("Y")) {
                int[] errorArray = new int[1];
                errorArray[2] = -1; // This will intentionally cause an ArrayIndexOutOfBoundsException
            }
        }
    }

    static boolean isDataChangeCycle(int queries) {
        return queries > 0 && queries % 10 == 0;
    }
}

class DataFinder {
    private int[] array;
    private int knownPairs;
    private Scanner scanner;
    private int homogenousPair;
    private int heterogenousPair;

    public DataFinder(int length, Scanner scanner) {
        this.scanner = scanner;
        this.array = new int[length];
        this.knownPairs = 0;
        this.homogenousPair = -1;
        this.heterogenousPair = -1;
    }

    public void retrieveNextPair() {
        array[knownPairs] = fetchBit(knownPairs);
        array[getPairIndex(knownPairs)] = fetchBit(getPairIndex(knownPairs));

        if (homogenousPair == -1 && array[knownPairs] == array[getPairIndex(knownPairs)]) {
            homogenousPair = knownPairs;
        }
        if (heterogenousPair == -1 && array[knownPairs] != array[getPairIndex(knownPairs)]) {
            heterogenousPair = knownPairs;
        }

        knownPairs++;
    }

    private int fetchBit(int index) {
        System.out.println(index + 1);
        return scanner.nextInt();
    }

    public String getResult() {
        StringBuilder output = new StringBuilder();
        for (int value : array) {
            output.append(value);
        }
        return output.toString();
    }

    public boolean isArrayComplete() {
        return knownPairs >= (array.length / 2 + 0.6);
    }

    public void analyzeAndFixData() {
        if (homogenousPair == -1 && heterogenousPair == -1) return;

        int newHomogenousData = -1, newHeterogenousData = -1;
        if (homogenousPair != -1) {
            newHomogenousData = fetchBit(homogenousPair);
        } else {
            fetchBit(0);
        }

        if (heterogenousPair != -1) {
            newHeterogenousData = fetchBit(heterogenousPair);
        } else {
            fetchBit(0);
        }

        if (homogenousPair == -1) {
            if (array[heterogenousPair] != newHeterogenousData) {
                complementArray();
            }
        } else if (heterogenousPair == -1) {
            if (array[homogenousPair] != newHomogenousData) {
                complementArray();
            }
        } else {
            if (array[heterogenousPair] == newHeterogenousData) {
                if (array[homogenousPair] != newHomogenousData) {
                    complementArray();
                    reverseArray();
                }
            } else {
                if (array[homogenousPair] == newHomogenousData) {
                    reverseArray();
                } else {
                    complementArray();
                }
            }
        }
    }

    private void reverseArray() {
        for (int i = 0; i < knownPairs; i++) {
            int temp = array[i];
            array[i] = array[getPairIndex(i)];
            array[getPairIndex(i)] = temp;
        }
    }

    private void complementArray() {
        for (int i = 0; i < knownPairs; i++) {
            array[i] = getComplement(array[i]);
            if (getPairIndex(i) != i) {
                array[getPairIndex(i)] = getComplement(array[getPairIndex(i)]);
            }
        }
    }

    private int getComplement(int bit) {
        return bit == 0 ? 1 : 0;
    }

    private int getPairIndex(int index) {
        return array.length - 1 - index;
    }
}