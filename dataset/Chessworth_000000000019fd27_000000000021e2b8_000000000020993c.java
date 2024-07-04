import java.util.*;
import java.io.*;
class Solution {
    public static int checkRow(int[] matrix,int n){
        int duplicates=0;
        for(int i = n-1; i < n*n; i+=n){
            Set<Integer> lump = new HashSet<Integer>();
            for(int j = i-(n-1); j<=i;j++){
                    if (lump.contains(matrix[j])) {
                        duplicates += 1;
                        break;
                    }
                    lump.add(matrix[j]);
            }
        }
        return duplicates;
    }
    public static int checkColumn(int[] matrix,int n){
        int duplicates = 0;
        for(int i = 0; i<n; i++){
            Set<Integer> lump = new HashSet<Integer>();
            for(int j = i; j<n*n;j+=n){
                if (lump.contains(matrix[j])) {
                    duplicates += 1;
                    break;
                }
                lump.add(matrix[j]);
            }
        }
        return duplicates;
    }
    public static int getTrace(int[] matrix,int n){
        int sum=0;
        for(int i = 0; i<n; i++){
            sum += matrix[i + i*n];
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = input.nextInt();
            int[] matrix = new int[n*n];
            for(int j = 0; j < n*n; j++){
                    matrix[j] = input.nextInt();
                }
            int rows = checkRow(matrix,n);
            int columns = checkColumn(matrix,n);
            int trace = getTrace(matrix,n);

            System.out.println("Case #" + i + ": " +trace + " " + rows + " " + columns);
        }
    }
}
