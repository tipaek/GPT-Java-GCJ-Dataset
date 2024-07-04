import java.util.*;

class Solution{
    public static void main(string[] srgs){
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while(t>0){
            int n = input.nextInt();
            int[][] arr = new int[n][n];
            int trace = 0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr[i][j] = input.nextInt();
                    if(i==j){
                        trace += arr[i][j];
                    }
                }
            }
            
            int row = getSumRow(arr);
            int col = getSumCol(arr);
            System.out.println(trace+" "+row+" "+col);
            t--;
        }
    }
    
    public int getSumRow(int[][] arr){
        int count = 0;
        for(int i=0;i<arr.length;i++){
            int[] arr = new int[arr.length+1];
            for(int j=0;j<arr.length;j++){
                if(arr[arr[i][j]]>0){
                    count++;
                    break;
                }
                arr[arr[i][j]]++;
            }
        }
        return count;
    }
    
    public int getSumCol(int[][] arr){
        int count = 0;
        for(int j=0;j<arr.length;j++){
            int[] arr = new int[arr.length+1];
            for(int i=0;i<arr.length;i++){
                if(arr[arr[i][j]]>0){
                    count++;
                    break;
                }
                arr[arr[i][j]]++;
            }
        }
        return count;
    }
    
}