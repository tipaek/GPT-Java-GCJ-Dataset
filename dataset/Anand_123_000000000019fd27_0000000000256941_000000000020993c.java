package practice;
import java.util.*;
public class codejam{
public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-->0){
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        int sum = 0;
        for(int i=0;i<n;i++){
            sum = sum + matrix[i][i];
        }
        int duplicaterow = 0;
        int duplicatecol = 0;
        for(int i=0;i<n;i++){
            if(hasduplicaterow(i, matrix)){
                duplicaterow++;
            }
            if(hasduplicatecol(i, matrix)){
                duplicatecol++;
            }
        }
        System.out.println(sum+" "+duplicaterow+" "+duplicatecol);
    }
}
    public static boolean hasduplicaterow(int i, int[][] matrix){
    	int n = matrix.length;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int j=0;j<n;j++){
            arr.add(matrix[i][j]);
        }
        return hasduplicate(arr);
    }
    public static boolean hasduplicatecol(int i, int[][] matrix){
    	int n = matrix.length;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int j=0;j<n;j++){
            arr.add(matrix[j][i]);
        }
        return hasduplicate(arr);
    }
    public static boolean hasduplicate(ArrayList<Integer> arr){
        Collections.sort(arr);
        for(int i=0;i<(arr.size()-1);i++){
            if(arr.get(i)==arr.get(i+1)){
                return true;
            }
        }
        return false;
    }
}