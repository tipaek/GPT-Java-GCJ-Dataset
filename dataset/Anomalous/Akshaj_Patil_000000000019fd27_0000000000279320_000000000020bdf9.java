import java.util.*;
import java.io.*;

class Solution {
  
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int testCases = sc.nextInt();
        int testNum = 1;
        
        while (testCases-- > 0) {
            int N = sc.nextInt();
            int[] startTimes = new int[N];
            int[] endTimes = new int[N];
            int[] originalStartTimes = new int[N];
            int[] originalEndTimes = new int[N];
            
            for (int i = 0; i < N; i++) {
                startTimes[i] = sc.nextInt();
                endTimes[i] = sc.nextInt();
                originalStartTimes[i] = startTimes[i];
                originalEndTimes[i] = endTimes[i];
            }
            
            int[] sortedIndices = getSortedIndices(startTimes);
            char[] result = new char[N];
            int[] C = new int[2];
            int[] J = new int[2];
            boolean impossible = false;
            
            for (int index : sortedIndices) {
                int start = startTimes[index];
                int end = endTimes[index];
                
                if (C[1] <= start) {
                    C[0] = start;
                    C[1] = end;
                    result[index] = 'C';
                } else if (J[1] <= start) {
                    J[0] = start;
                    J[1] = end;
                    result[index] = 'J';
                } else {
                    impossible = true;
                    break;
                }
            }
            
            if (impossible) {
                System.out.println("Case #" + testNum + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + testNum + ": ");
                for (char c : result) {
                    System.out.print(c);
                }
                System.out.println();
            }
            
            testNum++;
        }
    }
    
    private static int[] getSortedIndices(int[] array) {
        Integer[] indices = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, Comparator.comparingInt(i -> array[i]));
        return Arrays.stream(indices).mapToInt(Integer::intValue).toArray();
    }
}