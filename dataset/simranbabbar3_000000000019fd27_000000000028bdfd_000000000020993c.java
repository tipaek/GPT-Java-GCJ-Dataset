import java.util.*;
public class Solution{
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        for(int i=0;i<n;i++){
            int rows=s.nextInt();
            int cols=rows;
            int arr[][]=new int[rows][cols];
            
            printTrace(arr,rows,cols,i+1);
        }
    }
    public static void printTrace(int[][] arr,int rows,int cols,int k){
      //  HashMap<Integer,Boolean> map=new HashMap<>();
        int frows=0;
        int fcols=0;
        for(int i=0;i<rows;i++){
            HashMap<Integer,Boolean> map=new HashMap<>();
            for(int j=0;j<cols;j++){
               if(map.containsKey(arr[i][j])) {
                   frows++;
                   break;
               }else{
                   map.put(arr[i][j],true);
               }
            }
        }
        int trace=0;
        for(int i=0;i<cols;i++){
            HashMap<Integer,Boolean> map=new HashMap<>();
            for(int j=0;j<rows;j++){
                if(i==j){
                    trace+=arr[i][j];
                }
               if(map.containsKey(arr[j][i])) {
                   fcols++;
                   break;
               }else{
                   map.put(arr[j][i],true);
               }
            }
        }
        System.out.println("Case #"+k+": "+trace+" "+frows+" "+fcols);
        
    }
}