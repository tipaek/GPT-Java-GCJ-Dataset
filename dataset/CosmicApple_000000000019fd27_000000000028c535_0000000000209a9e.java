import java.util.Scanner;

public class Solution {
    public static void main (String args[]) {
        Scanner input = new Scanner (System.in);
        int numOfTests = input.nextInt ();
        int length = input.nextInt();
        for (int currentTest = 1; currentTest <= numOfTests; currentTest++) {
            DataFinder dataFinder = new DataFinder (length, input);
            int queries = 0;
            while (!dataFinder.arrayAllKnown()) {
                if (dataChange(queries)) {
                    dataFinder.analyzeAndFixArchives();
                } else {
                    dataFinder.getNextPair();
                }
                queries += 2;
            }
            System.out.println (dataFinder.getOutput());
            String results = input.next();
            
            
            if (!results.equals("Y")) {
                int[] a = new int[1];
                a[2] = -1;
            }
            
        }
    }
    
    static boolean dataChange (int queries) {
        if (queries > 0) {
            if (queries % 10 == 0) //happens every multiple of 10 
                return true;
        }
        return false;
    }
}

class DataFinder {
    int[] arr;
    int knownPairs;
    Scanner input;
    
    int homogenousPair;
    int heterogenousPair;
    
    public DataFinder (int length, Scanner input) {
        this.input = input;
        arr = new int[length];
        knownPairs = 0;
        
        homogenousPair = -1;
        heterogenousPair = -1;
    }
    
    public void getNextPair () {
        arr[knownPairs] = getBit (knownPairs);
        arr[findPairIndex(knownPairs)] = getBit (findPairIndex (knownPairs));
        
        if (homogenousPair == -1 && (arr[knownPairs] == arr[findPairIndex(knownPairs)])) 
            homogenousPair = knownPairs;
        if (heterogenousPair == -1 && (arr[knownPairs] != arr[findPairIndex(knownPairs)]))
            heterogenousPair = knownPairs;
        
        knownPairs++;
    }
    
    int getBit (int index) {
        System.out.println ("" + (index+1));
        return input.nextInt();
    }
    
    public String getOutput () {
        String output = "";
        for (int i = 0; i < 10; i++) {
            output += arr[i];
        }
        return output;
    } 
    
    public boolean arrayAllKnown () {
        return (knownPairs >= (int)(((float)arr.length)/2 + 0.6));
    }
    
    //manipulation
    public void analyzeAndFixArchives () { //requires two queries
        if (homogenousPair == -1 && heterogenousPair == -1) return;
        
        int newHomogenousData = -1, newHeterogenouseData = -1;
        if (homogenousPair != -1) 
            newHomogenousData = getBit (homogenousPair);
        else getBit(0);
            
        if (heterogenousPair != -1) 
            newHeterogenouseData = getBit (heterogenousPair);
        else getBit(0);
        
        if (homogenousPair == -1) {
            if (arr[heterogenousPair] == newHeterogenouseData) {
                //nothing
            } else {
                complementArray ();
            }
        } else if (heterogenousPair == -1) {
            if (arr[homogenousPair] == newHomogenousData) {
                //nothing
            } else {
                complementArray ();
            }
        } else {
            if (arr[heterogenousPair] == newHeterogenouseData) {
                if (arr[homogenousPair] == newHomogenousData) {
                    //nothing
                } else {
                    complementArray();
                    reverseArray ();
                }
            } else {
                if (arr[homogenousPair] == newHomogenousData) {
                    reverseArray ();
                } else {
                    complementArray ();
                }
            }
        }
    }
    
    void reverseArray () {
        for (int i = 0; i < knownPairs; i++) {
            int temp = arr[i];
            arr[i] = arr[findPairIndex(i)];
            arr[findPairIndex(i)] = temp;
        }
    }
    void complementArray () {
        for (int i = 0; i < knownPairs; i++) {
            arr[i] = getComplement (arr[i]);
            if (findPairIndex (i) != i) {
                arr[findPairIndex(i)] = getComplement (arr[findPairIndex(i)]);
            }
        }
    }
    int getComplement (int n) {
        if (n == 0) return 1;
        else if (n == 1) return 0;
        return -1;
    }
    int findPairIndex (int index) {
        return arr.length - 1 - index;
    }
    
}