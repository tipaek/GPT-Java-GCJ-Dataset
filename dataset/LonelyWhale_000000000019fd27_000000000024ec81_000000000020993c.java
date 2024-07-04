import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args){
Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
int trials= scan.nextInt();
for(int i =0 ; i< trials ; i++){
    int N = scan.nextInt();
    int[][] matrix = new int[N][N];
    for(int j =0 ; j<N ; j++){
        for(int k =0 ; k<N ; k++){
            matrix[j][k]= scan.nextInt();
        }
    }
    System.out.println(Arrays.deepToString(matrix));
}
}
}