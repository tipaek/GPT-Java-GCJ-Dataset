import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = sc.nextInt();
        for(int k=0; k<n; k++){
            //variables
            int arrSize = sc.nextInt();
            int[][] arr = new int[arrSize][arrSize];
            int sum = 0;
            int rowCounter = 0, colCounter = 0;
            int[] arrMem = new int[arrSize];

            //read input
            for(int i=0; i<arrSize; i++){
                for(int j=0; j<arrSize; j++){
                    arr[i][j] = sc.nextInt();
                    arrMem[j] = arr[i][j];
                }
                if(isRepeat(arrMem, arrSize)){
                    rowCounter++;
                }
            }

            //computing
            for(int i=0; i<arrSize; i++){
                sum += arr[i][i];
            }
            for(int i=0; i<arrSize; i++){
                for(int j=0; j<arrSize; j++){
                    arrMem[j] = arr[j][i];
                }
                if(isRepeat(arrMem, arrSize)){
                    colCounter++;
                }
            }
            //Print
            System.out.println("Case #" + (k+1) + ": " + sum + " " + rowCounter + " " + colCounter);
        }
        sc.close();
    }
    public static boolean isRepeat(int[] arr, int length){
        int[] arrMem = new int[length];
        for(int i=0; i<length; i++){
            arrMem[arr[i]-1]++;
        }
        for(int i=0; i<length; i++){
            if(arrMem[i]>1){
                return true;
            }
        }
        return false;
    }
} 