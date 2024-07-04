import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numOfTests = input.nextInt();
        int length = input.nextInt();
        
        for (int currentTest = 1; currentTest <= numOfTests; currentTest++) {
            int[] arr = new int[length];
            int knownPairs = 0;
            int homoPair = -1;
            int heteroPair = -1;
            int queries = 0;
            
            while (knownPairs < (int) (length / 2 + 0.6)) {
                if (shouldCheckDataChange(queries)) {
                    int newHomo = -1, newHetero = -1;
                    if (homoPair != -1) {
                        newHomo = getBit(homoPair, input);
                    } else {
                        getBit(0, input);
                    }
                    
                    if (heteroPair != -1) {
                        newHetero = getBit(heteroPair, input);
                    } else {
                        getBit(0, input);
                    }
                    
                    handleDataChange(arr, knownPairs, homoPair, newHomo, heteroPair, newHetero);
                } else {
                    fetchNextPair(arr, knownPairs, input);
                    updatePairs(arr, knownPairs, length, homoPair, heteroPair);
                    knownPairs++;
                }
                queries += 2;
            }
            
            printArray(arr);
            input.next();
        }
    }
    
    static boolean shouldCheckDataChange(int queries) {
        return queries > 0 && queries % 10 == 0;
    }
    
    static void fetchNextPair(int[] arr, int knownPairs, Scanner input) {
        arr[knownPairs] = getBit(knownPairs, input);
        arr[getPairIndex(knownPairs, arr.length)] = getBit(getPairIndex(knownPairs, arr.length), input);
    }
    
    static int getBit(int bit, Scanner input) {
        System.out.println(bit);
        return input.nextInt();
    }
    
    static void handleDataChange(int[] arr, int knownPairs, int homoPair, int newHomo, int heteroPair, int newHetero) {
        if (homoPair != -1 && heteroPair != -1) {
            if (arr[heteroPair] == newHetero) {
                if (arr[homoPair] != newHomo) {
                    complementAndReverse(arr, knownPairs);
                }
            } else {
                if (arr[homoPair] == newHomo) {
                    reverse(arr, knownPairs);
                } else {
                    complement(arr, knownPairs);
                }
            }
        } else if (homoPair == -1) {
            if (arr[heteroPair] != newHetero) {
                complement(arr, knownPairs);
            }
        } else if (heteroPair == -1) {
            if (arr[homoPair] != newHomo) {
                complement(arr, knownPairs);
            }
        }
    }
    
    static void updatePairs(int[] arr, int knownPairs, int length, int homoPair, int heteroPair) {
        if (homoPair == -1 && arr[knownPairs] == arr[getPairIndex(knownPairs, length)]) {
            homoPair = knownPairs;
        }
        if (heteroPair == -1 && arr[knownPairs] != arr[getPairIndex(knownPairs, length)]) {
            heteroPair = knownPairs;
        }
    }
    
    static void complementAndReverse(int[] arr, int knownPairs) {
        complement(arr, knownPairs);
        reverse(arr, knownPairs);
    }
    
    static void complement(int[] arr, int knownPairs) {
        for (int i = 0; i < knownPairs; i++) {
            arr[i] = 1 - arr[i];
            int pairIndex = getPairIndex(i, arr.length);
            if (pairIndex != i) {
                arr[pairIndex] = 1 - arr[pairIndex];
            }
        }
    }
    
    static void reverse(int[] arr, int knownPairs) {
        for (int i = 0; i < knownPairs; i++) {
            int pairIndex = getPairIndex(i, arr.length);
            int temp = arr[i];
            arr[i] = arr[pairIndex];
            arr[pairIndex] = temp;
        }
    }
    
    static int getPairIndex(int index, int length) {
        return length - 1 - index;
    }
    
    static void printArray(int[] arr) {
        StringBuilder output = new StringBuilder();
        for (int value : arr) {
            output.append(value);
        }
        System.out.println(output.toString());
    }
}