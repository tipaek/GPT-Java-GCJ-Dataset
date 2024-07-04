import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int testCases = Integer.parseInt(tokenizer.nextToken());
        int bitLength = Integer.parseInt(tokenizer.nextToken());

        for (int testCase = 0; testCase < testCases; testCase++) {
            int[] bits = new int[bitLength + 1];
            int differingIndex = -1, matchingIndex = -1;
            int leftPointer = 1, rightPointer = 1;
            int half = (bitLength + 1) / 2;
            int queryCount = 1;
            int even = 0;

            while (rightPointer <= bitLength) {
                if ((queryCount > 1) && (queryCount % 10 == 1)) {
                    handleSpecialCase(reader, bits, differingIndex, matchingIndex, leftPointer, bitLength);
                    queryCount += 2;
                } else {
                    if (even == 0) {
                        handleEvenCase(reader, bits, leftPointer);
                        even = 1;
                        rightPointer++;
                    } else {
                        handleOddCase(reader, bits, leftPointer, bitLength);
                        if (differingIndex == -1 && bits[leftPointer] != bits[bitLength - leftPointer + 1]) {
                            differingIndex = leftPointer;
                        }
                        if (matchingIndex == -1 && bits[leftPointer] == bits[bitLength - leftPointer + 1]) {
                            matchingIndex = leftPointer;
                        }
                        even = 0;
                        leftPointer++;
                        rightPointer++;
                    }
                    queryCount++;
                }
            }
            printResult(bits, testCase, bitLength);
            if (!isCorrectAnswer(reader)) {
                break;
            }
        }
    }

    private static void handleSpecialCase(BufferedReader reader, int[] bits, int differingIndex, int matchingIndex, int leftPointer, int bitLength) throws IOException {
        if (differingIndex == -1 && matchingIndex == -1) {
            flipBits(reader, bits, 1, leftPointer, bitLength);
        } else if (differingIndex == -1) {
            flipBits(reader, bits, matchingIndex, leftPointer, bitLength);
        } else if (matchingIndex == -1) {
            flipBits(reader, bits, differingIndex, leftPointer, bitLength);
        } else {
            int current1 = queryBit(reader, differingIndex);
            int current2 = queryBit(reader, matchingIndex);
            if ((current2 != bits[matchingIndex]) && (current1 != (1 - bits[differingIndex]))) {
                swapAndFlipBits(bits, leftPointer, bitLength);
            }
            if ((current2 != bits[matchingIndex]) && (current1 == (1 - bits[differingIndex]))) {
                flipAllBits(bits, leftPointer, bitLength);
            }
            if ((current2 == bits[matchingIndex]) && (current1 != bits[differingIndex])) {
                swapBits(bits, leftPointer, bitLength);
            }
        }
    }

    private static void handleEvenCase(BufferedReader reader, int[] bits, int leftPointer) throws IOException {
        System.out.println(leftPointer);
        System.out.flush();
        bits[leftPointer] = Integer.parseInt(new StringTokenizer(reader.readLine()).nextToken());
    }

    private static void handleOddCase(BufferedReader reader, int[] bits, int leftPointer, int bitLength) throws IOException {
        int rightPointer = bitLength - leftPointer + 1;
        System.out.println(rightPointer);
        System.out.flush();
        bits[rightPointer] = Integer.parseInt(new StringTokenizer(reader.readLine()).nextToken());
    }

    private static void flipBits(BufferedReader reader, int[] bits, int index, int leftPointer, int bitLength) throws IOException {
        System.out.println(index);
        System.out.flush();
        int temp = Integer.parseInt(new StringTokenizer(reader.readLine()).nextToken());
        if (temp != bits[index]) {
            flipAllBits(bits, leftPointer, bitLength);
        }
    }

    private static int queryBit(BufferedReader reader, int index) throws IOException {
        System.out.println(index);
        System.out.flush();
        return Integer.parseInt(new StringTokenizer(reader.readLine()).nextToken());
    }

    private static void flipAllBits(int[] bits, int leftPointer, int bitLength) {
        for (int i = 1; i <= leftPointer; i++) {
            bits[i] = 1 - bits[i];
            bits[bitLength + 1 - i] = 1 - bits[bitLength + 1 - i];
        }
    }

    private static void swapAndFlipBits(int[] bits, int leftPointer, int bitLength) {
        for (int i = 1; i <= leftPointer; i++) {
            int temp = bits[i];
            bits[i] = 1 - bits[bitLength + 1 - i];
            bits[bitLength + 1 - i] = 1 - temp;
        }
    }

    private static void swapBits(int[] bits, int leftPointer, int bitLength) {
        for (int i = 1; i <= leftPointer; i++) {
            int temp = bits[i];
            bits[i] = bits[bitLength + 1 - i];
            bits[bitLength + 1 - i] = temp;
        }
    }

    private static void printResult(int[] bits, int testCase, int bitLength) {
        StringBuilder result = new StringBuilder("Case # " + testCase + ": ");
        for (int i = 1; i <= bitLength; i++) {
            result.append(bits[i]);
        }
        System.out.println(result);
        System.out.flush();
    }

    private static boolean isCorrectAnswer(BufferedReader reader) throws IOException {
        String answer = reader.readLine();
        return answer.charAt(0) == 'Y';
    }
}