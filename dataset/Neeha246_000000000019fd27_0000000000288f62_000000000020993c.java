import java.io.*; 
import java.util.*;  
class Trace { 
  
  
 public static int findTrace(int mat[][], int n) 
{ 
    int sum = 0; 
    for (int i=0; i<n; i++) 
        sum += mat[i][i]; 
    return sum; 
} 

    public static int countIdenticalRows(int mat[][]) 
    { 
        int count = 0; 
        for (int i = 0; i < mat.length; i++) { 
            HashSet<Integer> hs = new HashSet<>(); 
            for (int j = 0; j < mat[i].length; j++) { 
                hs.add(mat[i][j]); 
            } 
            if (hs.size() == 1) 
                count++; 
        } 
        return count; 
    } 
     public static int countIdenticalCols(int mat[][]) 
    { 
        int count = 0; 
        for (int i = 0; i < mat.length; i++) { 
            HashSet<Integer> hs = new HashSet<>(); 
            for (int j = 0; j < mat[i].length; j++) { 
                hs.add(mat[j][i]); 
            } 
            if (hs.size() == 1) 
                count++; 
        } 
        return count; 
    }
 static int calculate(int mat[][], int n, int count){
     int trace = findTrace(mat, n);
     int row = countIdenticalRows(mat);
     int col = countIdenticalCols(mat);
     System.out.println("Case #"+count+": "+trace+" "+row+" "+col);
 }
 
public static void main (String[] args) {
 
Scanner in = new Scanner(System.in);
int noofmatrix = in. nextInt();
int[][] first ;
for(int k = 0 ; k< noofmatrix ; k++){
    int matrixsize = in. nextInt();
    first = new int[matrixsize][matrixsize];
    for (int i = 0; i < matrixsize; i++) {
                for (int j = 0; j < matrixsize; j++){ 
                    first[i][j] = in.nextInt();}}
    calculate(first,matrixsize,k);                
}


}
  
} 
  