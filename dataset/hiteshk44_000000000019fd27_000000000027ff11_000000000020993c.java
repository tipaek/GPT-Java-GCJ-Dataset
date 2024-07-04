import java.util.*;
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int[] PRIMES = {
                2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101,103,107,109,113,127,131,137,139,149,151,157,163,167,173,179,181,191,193,197,199,211,223,227,229,233,239,241,251,257,263,269,271,277,281,283,293,307,311,313,317,331,337,347,349,353,359,367,373,379,383,389,397,401,409,419,421,431,433,439,443,449,457,461,463,467,479,487,491,499,503,509,521,523,541,547,557
        };

        int testCases = scanner.nextInt();

        Map<Integer, Integer> mapPrimes = new HashMap<>();

        for(int i=0; i < 102; i++) {
            mapPrimes.put(i+1, PRIMES[i]);
        }
        for(int i=0;i<testCases;i++) {
            int n = scanner.nextInt();

            int colSum[] = new int[n];
            long totalSum = 0;
            for(int j = 1;j <= n; j++) {
                totalSum += (j*mapPrimes.get(j));
            }
            System.err.println("==> total: " + totalSum);
            int noOfRows=0, noOfColumns=0, trace=0;
            for(int rowPointer = 0; rowPointer < n; rowPointer++) {
                long sum = 0;
                for(int colPointer = 0; colPointer < n; colPointer++) {
                    int val = scanner.nextInt();
                    int trVsl = val;
                    val *= mapPrimes.get(trVsl);
                    sum += val;
                    System.err.println("==> " + val);
                    colSum[colPointer] += val;
                    if(rowPointer == colPointer)
                        trace += trVsl;
                }
                System.err.println("==> sum: " + sum);
                if(sum != totalSum)
                    noOfRows++;
            }



            for(int cols = 0; cols < n; cols++){
                System.err.println("==> colSum: " + colSum[cols]);
                if(colSum[cols] != totalSum)
                    noOfColumns++;
            }
            System.out.println("Case #" + i + ": " + trace + " " + noOfRows + " " + noOfColumns);

        }
    }
}
