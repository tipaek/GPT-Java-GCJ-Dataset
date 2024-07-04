import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         int test = scanner.nextInt();
         while(test-- > 0){
             int n = scanner.nextInt(),trace=0,rowDup=0,colDup=0;
             int[][] arr = new int[n][n];
             Set<Integer> row = new TreeSet<>();
             Set<Integer> col = new TreeSet<>();
             boolean flag = true;
             for(int i=0;i<n;i++){
                 for(int j=0;j<n;j++){
                     arr[i][j] = scanner.nextInt();
                     if(i==j) trace += arr[i][j];
                     if(row.contains(arr[i][j]) && flag){
                        rowDup++;
                        flag = false;
                     }
                     else{
                         row.add(arr[i][j]);
                     }
                 }
                 row.clear();
                 flag = true;
             }
             for(int j=0;j<n;j++){
                 for(int i=0;i<n;i++){
                     if(col.contains(arr[i][j]) && flag){
                         colDup++;
                         flag = false;
                     }
                     else{
                         col.add(arr[i][j]);
                     }
                 }
                 flag = true;
                 col.clear();
             }
             System.out.println(String.format("%d %d %d",trace,rowDup,colDup));
         }
    }
}
