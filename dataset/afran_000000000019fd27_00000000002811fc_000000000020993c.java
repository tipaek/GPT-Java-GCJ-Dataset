import java.io.*;
import java.util.*;
class Solution{
    public static void main(String args[]) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int t= Integer.parseInt(br.readLine().trim());
        while(t-->0){
            int n= Integer.parseInt(br.readLine().trim());
            int arr[][]=new int[n][n];
            int trace=0,rr=0,rc=0;
            for(int i=0;i<n;i++){
                String[] inp= br.readLine().split(" ");
                for(int j=0;j<n;j++){
                    arr[i][j]=Integer.parseInt(inp[j]);
                }
                trace+=arr[i][i];
            }
            rr= findRepeatedRows(arr,n);
            rc= findRepeatedColumns(arr,n);
            System.out.println("Case #"+t+": "+trace+" "+rr+" "+rc);
        }
    }
    public static int findRepeatedRows(int arr[][],int n){
        HashMap<Integer,Integer> map= new HashMap<>();
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map.containsKey(arr[i][j])){
                    count++;
                    break;
                }
                map.put(arr[i][j],1);
            }
            map.clear();
        }
        return count;
    }
    
    public static int findRepeatedColumns(int arr[][],int n){
        HashMap<Integer,Integer> map= new HashMap<>();
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map.containsKey(arr[j][i])){
                    count++;
                    break;
                }
                map.put(arr[j][i],1);
            }
            map.clear();
        }
        return count;
    }
}