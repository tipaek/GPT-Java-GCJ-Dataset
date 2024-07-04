import java.io.*;
import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int x = 1;
        while(t-->0){
            int s = sc.nextInt();
            int[][] arr = new int[s][s];
            for(int i = 0;i<s;i++){
                for(int j=0;j<s;j++){
                    arr[i][j] = sc.nextInt();
                }
            }
            System.out.println("Case #"+x+": "+trace(s,arr)+" "+row(s,arr)+" "+column(s,arr));
            x++;
        }
    }
    
    public static int trace(int s, int[][] arr){
        int sum = 0;
        for(int i = 0;i<s;i++){
            sum+=arr[i][i];
        }
        return sum;
    }
    
    public static int row(int s, int[][] arr){
        int sum = 0;
        for(int i = 0;i<s;i++){
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int j = 0;j<s;j++){
                map.put(arr[i][j],map.getOrDefault(map.get(arr[i][j]),0)+1);
            }
            if(map.size()<s)
                sum++;
        }
        return sum;
    }
    
    public static int column(int s, int[][] arr){
        int sum = 0;
        for(int i = 0;i<s;i++){
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int j = 0;j<s;j++){
                map.put(arr[j][i],map.getOrDefault(map.get(arr[j][i]),0)+1);
            }
            if(map.size()<s)
                sum++;
        }
        return sum;
    }
}