import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int b = scanner.nextInt();
        int size = (b + 1) / 2;
        StringBuilder sb = new StringBuilder(" ".repeat(b));
        int queryCount = 0;

        for (int i = 0; i < t; i++) {
            Pair[] pairsArray = new Pair[size];
            Queue<Integer> operationsQueue = new LinkedList<>();
            Pair pairSame = null, pairDiff = null;

            for (int j = 0; j < size; j++) {
                if (queryCount % 10 != 0 || j == 0) {
                    int first = j + 1;
                    if (first == size && b % 2 == 1) {
                        System.out.println(first);
                        pairsArray[j] = new Pair(first, false, scanner.nextInt());
                        queryCount++;
                        continue;
                    }

                    System.out.println(first);
                    int firstValue = scanner.nextInt();
                    queryCount++;
                    int last = b - j;
                    System.out.println(last);
                    int lastValue = scanner.nextInt();
                    queryCount++;

                    boolean isDiff = firstValue != lastValue;
                    pairsArray[j] = new Pair(first, isDiff, firstValue);

                    if (isDiff) {
                        pairDiff = pairsArray[j];
                    } else {
                        pairSame = pairsArray[j];
                    }
                } else {
                    System.out.println(pairSame.getIndex());
                    int value1 = scanner.nextInt();
                    System.out.println(pairDiff.getIndex());
                    int value2 = scanner.nextInt();
                    int operation = determineChange(pairSame, pairDiff, value1, value2);
                    queryCount += 2;
                    operationsQueue.add(operation);
                }
            }

            applyOperations(pairsArray, operationsQueue, size);
            generateFinalOutput(scanner, sb, pairsArray, b, size);
        }
    }

    private static int determineChange(Pair pairSame, Pair pairDiff, int value1, int value2) {
        if (pairSame != null && pairDiff != null) {
            if (value1 == pairSame.getPrev()) {
                pairSame.setPrev(value1);
                pairDiff.setPrev(value2);
                return value2 == pairDiff.getPrev() ? 4 : 1;
            } else {
                pairSame.setPrev(value1);
                pairDiff.setPrev(value2);
                return value2 == pairDiff.getPrev() ? 3 : 2;
            }
        }
        return 4;
    }

    private static void applyOperations(Pair[] pairsArray, Queue<Integer> operationsQueue, int size) {
        int iteration = 1;
        while (!operationsQueue.isEmpty()) {
            int operation = operationsQueue.poll();
            int start = iteration * 8;
            for (int i = start; i < size; i++) {
                if (operation == 1) {
                    pairsArray[i].inverse();
                } else if (operation == 2 || operation == 3) {
                    pairsArray[i].inverseBit();
                }
            }
            iteration++;
        }
    }

    private static void generateFinalOutput(Scanner scanner, StringBuilder sb, Pair[] pairsArray, int b, int size) {
        String response = "";
        int operation = 4;

        while (!response.equals("N")) {
            for (int i = 0; i < size; i++) {
                if (operation == 1) {
                    pairsArray[i].inverseFinalValue();
                } else if (operation == 2) {
                    pairsArray[i].inverseBitFinalValue();
                } else if (operation == 3) {
                    pairsArray[i].inverse2FinalValue();
                }
                sb.setCharAt(i, Character.forDigit(pairsArray[i].getFinalValue(), 10));
                sb.setCharAt(b - i - 1, Character.forDigit(pairsArray[i].getReversed(), 10));
            }
            System.out.println(sb.toString());
            response = scanner.nextLine();
            operation--;
        }
    }
}

class Pair {
    private int index;
    private boolean diff;
    private int prev;
    private int finalValue;

    public Pair(int index, boolean diff, int prev) {
        this.index = index;
        this.diff = diff;
        this.prev = prev;
        this.finalValue = -1;
    }

    public int getIndex() {
        return index;
    }

    public void setPrev(int prev) {
        this.prev = prev;
    }

    public int getPrev() {
        return prev;
    }

    public int getFinalValue() {
        return finalValue == -1 ? prev : finalValue;
    }

    public void inverse() {
        if (diff) {
            prev = prev == 0 ? 1 : 0;
        }
    }

    public void inverseBit() {
        prev = prev == 0 ? 1 : 0;
    }

    public void inverseFinalValue() {
        if (diff) {
            finalValue = prev == 0 ? 1 : 0;
        } else {
            finalValue = prev;
        }
    }

    public void inverseBitFinalValue() {
        finalValue = prev == 0 ? 1 : 0;
    }

    public void inverse2FinalValue() {
        if (!diff) {
            finalValue = prev == 0 ? 1 : 0;
        } else {
            finalValue = prev;
        }
    }

    public int getReversed() {
        finalValue = finalValue == -1 ? prev : finalValue;
        return diff ? (finalValue == 0 ? 1 : 0) : finalValue;
    }
}