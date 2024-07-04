import java.util.*;
import java.io.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int query(int n) throws IOException {
        if (n < 1) return -1;
        System.out.println(n);
        System.out.flush();
        return Integer.parseInt(br.readLine());
    }

    static void solve(int t) throws IOException {
        int N = Integer.parseInt(br.readLine());
        boolean[] sameArray = new boolean[N + 1]; 
        boolean[] comparisonArray = new boolean[N + 1];
        
        int initialQuery = query(1);
        List<Integer> sameIndices = new ArrayList<>();
        List<Integer> differentIndices = new ArrayList<>();
        
        for (int i = 1; i <= N / 2; i++) {
            int a = query(i);
            int b = query(N + 1 - i);
            if (a == b) {
                sameArray[i] = true;
                sameIndices.add(i);
            } else {
                sameArray[i] = false;
                differentIndices.add(i);
            }
        }
        
        int sameComparisonIndex = -1;
        int differentComparisonIndex = -1;
        
        if (!sameIndices.isEmpty()) {
            sameComparisonIndex = sameIndices.remove(0);
            comparisonArray[sameComparisonIndex] = true;
        }
        
        if (!differentIndices.isEmpty()) {
            differentComparisonIndex = differentIndices.remove(0);
            comparisonArray[differentComparisonIndex] = true;
        }
        
        int queryCount = 1;
        int sameComparisonValue = query(sameComparisonIndex);
        queryCount++;
        
        while (!sameIndices.isEmpty()) {
            if (queryCount % 10 == 1) {
                sameComparisonValue = query(sameComparisonIndex);
                queryCount++;
                continue;
            }
            comparisonArray[sameIndices.get(0)] = (sameComparisonValue == query(sameIndices.get(0)));
            queryCount++;
            sameIndices.remove(0);
        }
        
        int differentComparisonValue = query(differentComparisonIndex);
        queryCount++;
        
        while (!differentIndices.isEmpty()) {
            if (queryCount % 10 == 1) {
                differentComparisonValue = query(differentComparisonIndex);
                queryCount++;
                continue;
            }
            comparisonArray[differentIndices.get(0)] = (differentComparisonValue == query(differentIndices.get(0)));
            queryCount++;
            differentIndices.remove(0);
        }
        
        if (queryCount % 10 == 0) query(1);
        
        int[] result = new int[N + 1];
        sameComparisonValue = query(sameComparisonIndex);
        differentComparisonValue = query(differentComparisonIndex);
        
        for (int i = 1; i <= N / 2; i++) {
            if (sameArray[i]) {
                result[i] = comparisonArray[i] ? sameComparisonValue : 1 - sameComparisonValue;
                result[N + 1 - i] = result[i];
            } else {
                result[i] = comparisonArray[i] ? differentComparisonValue : 1 - differentComparisonValue;
                result[N + 1 - i] = 1 - result[i];
            }
        }
        
        for (int i = 1; i <= N; i++) System.out.print(result[i]);
        System.out.println();
        
        char response = readChar();
        if (response == 'N') {
            throw new RuntimeException("Wrong answer");
        }
    }

    public static void main(String[] args) throws IOException {
        int testCases = Integer.parseInt(br.readLine());
        for (int t = 1; t <= testCases; t++) {
            solve(t);
        }
    }
    
    static char readChar() throws IOException {
        return (char) br.read();
    }
}