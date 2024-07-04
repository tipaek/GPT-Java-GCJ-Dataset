import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Solution {
    public static void main(String[] args){
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));   
            int t = Integer.parseInt(br.readLine());
            int x = 1;
            while(t-- > 0){
            int k = 0, r = 0, c = 0;
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];
            for(int i = 0; i < n; i++){
                String str = br.readLine();
                String[] temp = str.split(" ");
                for(int j = 0; j < n; j++){
                    arr[i][j] = Integer.parseInt(temp[j]);
                }
            }
            for(int i = 0; i < n; i++){
                k += arr[i][i];
                if(duplicate(arr[i])) r++;
                if(duplicateColumn(arr,i)) c++;
            }
            System.out.println("Case #"+x+": "+k+" "+r+" "+c);x++;
            
        }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static boolean duplicate(int[] arr){
        int n = arr.length+1;
        boolean[] boolArr = new boolean[n];
        java.util.Arrays.fill(boolArr, false);
        for(int i : arr){
            if(!boolArr[i]) boolArr[i] = true;
            else return true;
        }
        return false;
    }
    public static boolean duplicateColumn(int[][] arr, int j){
        int n = arr[0].length+1;
        boolean[] boolArr = new boolean[n];
        java.util.Arrays.fill(boolArr, false);
        for(int i = 0; i < arr[0].length; i++){
            if(!boolArr[arr[i][j]]) boolArr[arr[i][j]] = true;
            else return true;
        }
        return false;
    }
}