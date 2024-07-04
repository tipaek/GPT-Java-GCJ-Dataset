import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
public static void main (String[] args) throws java.lang.Exception
{
Scanner sc = new Scanner(System.in);
int T = sc.nextInt();
for(int t = 1; t <= T; t++) {
   int N = sc.nextInt();
   int[][] matrix = new int[N][N];
   
   int trace = 0;
   int row = 0;
   HashSet<Integer> set = new HashSet();
   boolean found = false;
   for(int i = 0; i < N; i++) {
       for(int j = 0; j < N; j++) {
           matrix[i][j] = sc.nextInt();
           if(i == j) {
               trace += matrix[i][j];
           }
           if(set.contains(matrix[i][j]) && !found) {
               found = true;
               ++row;
           }
           if(!found) {
               set.add(matrix[i][j]);
           }
       }
       set.clear();
       found = false;
   }
   int col = 0;
   for(int j = 0; j < N; j++) {
       for(int i = 0; i < N; i++) {
           if(set.contains(matrix[i][j]) && !found) {
               found = true;
               ++col;
           }
           if(!found) {
               set.add(matrix[i][j]);
           }
       }
       set.clear();
       found = false;
   }
   System.out.println("Case #" + t + ": " + trace + " " + row + " " + col);
}
}
}

