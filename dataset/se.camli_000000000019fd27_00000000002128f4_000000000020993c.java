import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//     owner: sedatcamli
//     04.04.2020
public class Solution {

    public static void main(String[] args){
        Solution s = new Solution();
        s.start();
    }

    public void start(){
        Scanner scanIn = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = scanIn.nextInt();
        for (int i = 1; i <= numberOfTestCases; i++) {
            int t = 0;
            int r = 0;
            int c = 0;
            int N = scanIn.nextInt();
            int[][] matrix = new int[N][N];
            for(int j = 0;j<N ; j++){
                Set<Integer> rowSet = new HashSet<>();
                for(int k = 0; k<N;k++){
                    int readValue = scanIn.nextInt();
                    matrix[j][k] = readValue;
                    rowSet.add(readValue);
                    if(j==k){
                        t+=matrix[j][k];
                    }
                }
                if(rowSet.size()!=N){
                    r++;
                }
            }
            for(int k=0;k<N;k++){
                Set<Integer> columnSet = new HashSet<>();
                for(int j = 0 ; j<N;j++){
                    columnSet.add(matrix[j][k]);
                }
                if(columnSet.size()!= N){
                    c++;
                }
            }
            System.out.println("Case #"+i+": "+ t + " " + r + " " + c);
        }
    }
}
