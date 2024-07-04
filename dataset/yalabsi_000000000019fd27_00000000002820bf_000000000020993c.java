import java.util.*;
import java.io.*;
public class Solution {
          
    private static int duplicates(int [] matrix){
        HashSet<Integer> set = new HashSet<Integer>();
        for(int x : matrix)
          set.add(x);
        return set.size() != matrix.length ? 1 : 0;
    }

    private static String vest(int[][] matrix){
        int k =0, r =0 , c =0;
        for(int i=0; i<matrix.length; i++){
            k += matrix[i][i];
            r += duplicates(matrix[i]);
        }

        for(int j=0; j<matrix.length; j++){
            HashSet<Integer> set = new HashSet<>();
            for(int i=0; i <matrix.length; i++){
                set.add(matrix[i][j]);
            }
            c += set.size()!=matrix.length ? 1 : 0;
        }
        return k+" " + r + " " + c;
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int cur=1;
        while(num > 0){
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            for(int i=0; i< n; i++)
                for(int j=0; j< n; j++)
                    matrix[i][j] = scanner.nextInt();
            System.out.println("Case #"+cur+": "+ vest(matrix));
            num--;
            cur++;
        }

    }
}