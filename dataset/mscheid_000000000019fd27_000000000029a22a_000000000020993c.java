import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();

            // matrix value
            int value;
            
            // If a row (or col) have no duplicates then they will have these values
            int gaussSum = n*(n+1)/2;
            int factorial = factorial(n);
            
            // Variables to track stats needed for the output
            int duplicateRow = 0;
            int duplicateColumn = 0;
            int[] columnSums = new int[n];
            int[] columnMultiples = new int[n];
            int trace = 0;


            // Loop over the matrix once indices: j,k
            for (int j = 0; j < n; j++) {
                int sum = 0;
                int multiple = 1;
                
                for (int k = 0; k < n; k++) {
                    value = in.nextInt();
                    sum += value;
                    multiple *= value;
                    columnSums[k] += value;
                    if(j==0){
                        columnMultiples[k] = value;
                    }else {
                        columnMultiples[k] *= value;
                    }
                    if(j==k){
                        trace += value;
                    }
                }
                
                if(sum!=gaussSum || multiple != factorial){
                    duplicateRow++;
                }
            }

            for(int columnIndex=0;columnIndex<n;columnIndex++){
                if(columnSums[columnIndex] != gaussSum || columnMultiples[columnIndex] != factorial){
                    duplicateColumn++;
                }
            }
            
            System.out.println("Case #"+i+": "+trace+" "+duplicateRow+" "+duplicateColumn);

        }
    }

    private static int factorial(int n){
        if(n==0)
            return 1;
        return n*factorial(n-1);
    }
}