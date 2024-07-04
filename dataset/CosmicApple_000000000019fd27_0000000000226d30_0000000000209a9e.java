import java.util.Scanner;

public class Solution {
    public static void main (String args[]) {
        Scanner input = new Scanner (System.in);
        int numOfTests = input.nextInt ();
        int length = input.nextInt();
        for (int currentTest = 1; currentTest <= numOfTests; currentTest++) {
            int[] arr = new int[length];
            int knownPairs = 0;
            
            int homoPair = -1; //0, 0 or 1, 1
            int heteroPair = -1; //1, 0 or 0, 1
            int queries = 0;
            
            while (knownPairs < (int)(length/2 + 0.6)) {
                if (dataChange(queries)) {
                    int newHomo = -1, newHetero = -1;
                    if (homoPair != -1) 
                        newHomo = getBit (homoPair, input);
                    else getBit(0, input);
                        
                    if (heteroPair != -1) 
                        newHetero = getBit (heteroPair, input);
                    else getBit(0, input);
                        
                    if (homoPair != -1 && heteroPair != -1) {
                        if (arr[heteroPair] == newHetero) {
                            if (arr[homoPair] == newHomo) {
                                //nothing
                            } else {
                                complement(arr, knownPairs);
                                reverse (arr, knownPairs);
                            }
                        } else {
                            if (arr[homoPair] == newHomo) {
                                reverse (arr, knownPairs);
                            } else {
                                complement (arr, knownPairs);
                            }
                        }
                    } else if (homoPair == -1) {
                        if (arr[heteroPair] == newHetero) {
                            //nothing
                        } else {
                            complement (arr, knownPairs);
                        }
                    } else if (heteroPair == -1) {
                        if (arr[homoPair] == newHomo) {
                            //nothing
                        } else {
                            complement (arr, knownPairs);
                        }
                    }
                } else {
                    getNextPair(arr, knownPairs, input);
                    if (homoPair == -1 && 
                        (arr[knownPairs] == arr[findPairIndex(knownPairs, length)])) 
                        homoPair = knownPairs;
                    if (heteroPair == -1 && 
                        (arr[knownPairs] != arr[findPairIndex(knownPairs, length)]))
                        heteroPair = knownPairs;
                    knownPairs++;
                }
                queries += 2;
            }
            
            String output = "";
            for (int i = 0; i < length; i++) {
                output += Integer.toString(arr[i]);
            }
            System.out.print (output);
            System.out.println();
            input.next();
        }
    }
    
    static boolean dataChange (int queries) {
        if (queries > 0) {
            if (queries % 10 == 0) //happens every multiple of 10 
                return true;
        }
        return false;
    }
    
    static void getNextPair (int[] arr, int knownPairs, Scanner input) {
        arr[knownPairs] = getBit (knownPairs, input);
        arr[findPairIndex(knownPairs, arr.length)] = getBit (findPairIndex (knownPairs, arr.length), input);
    }
    
    static int getBit (int bit, Scanner input) {
        System.out.print("" + bit);
        System.out.println();
        return input.nextInt();
    }
    
    static void complement (int[] arr, int knownPairs) {
        for (int i = 0; i < knownPairs; i++) {
            if (arr[i] == 0) 
                arr[i] = 1;
            else if (arr[i] == 1) 
                arr[i] = 0;
            
            if (findPairIndex (i, arr.length) != i) {
                if (arr[findPairIndex(i, arr.length)] == 0) 
                    arr[findPairIndex(i, arr.length)] = 1;
                else if (arr[findPairIndex(i, arr.length)] == 1) 
                    arr[findPairIndex(i, arr.length)] = 0;
            }
        }
    }
    static void reverse (int[] arr, int knownPairs) {
        for (int i = 0; i < knownPairs; i++) {
            int temp = arr[i];
            arr[i] = arr[findPairIndex(i, arr.length)];
            arr[findPairIndex(i, arr.length)] = temp;
        }
    }
    static int findPairIndex (int index, int length) {
        return length - 1 - index;
    }
}