import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
        int T = scn.nextInt();
        int t = 0;
        while(++t <= T){
            int N = scn.nextInt();
            int[][] arr = new int[N][N];
            for(int i = 0; i<N; i++) {
                for(int j = 0; j<N; j++) {
                    arr[i][j] = scn.nextInt();
                }
            }
            int k = getTraces(arr);
            int r = getRepeatedRows(arr);
            int c = getRepeatedCols(arr);
            System.out.println("Case #" + t + ": " + k + " " + r + " " + c);
        }
	}

	public static int getTraces(int[][] arr) {
        int trace = 0;
        for(int i = 0; i<arr.length; i++){
            trace += arr[i][i];
        }
        return trace;
    }
    
    public static int getRepeatedRows(int[][] arr){
        int r = 0;
        for(int i = 0; i<arr.length; i++){
            if(checkRepeatedRow(arr, i)){
                r+=1;
            }
        }
        return r;
    }
    
    public static boolean checkRepeatedRow(int[][] arr, int i){
        for(int j = 0; j<arr.length; j++){
                for(int k = j+1; k<arr.length; k++){
                    if(arr[i][j] == arr[i][k]){
                        return true;
                }
            }
        }
        return false;
    }
    
    public static int getRepeatedCols(int[][] arr){
        int c = 0;
        for(int i = 0; i<arr.length; i++){
            if(checkRepeatedCol(arr, i)){
                c+=1;
            }
        }
        return c;
    }
    
    public static boolean checkRepeatedCol(int[][] arr, int i){
        for(int j = 0; j<arr.length; j++){
                for(int k = j+1; k<arr.length; k++){
                    if(arr[j][i] == arr[k][i]){
                        return true;
                }
            }
        }
        return false;
    }
	
}