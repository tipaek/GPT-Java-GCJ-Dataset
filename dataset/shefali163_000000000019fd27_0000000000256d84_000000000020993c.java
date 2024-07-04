import java.util.*;
import java.io.*;  

public class Solution{
    public static class pair{
        int x;
        int y;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            int n=Integer.parseInt(br.readLine());
            int[][] arr=new int[n][n];
            for(int i=0;i<n;i++){
                String line=br.readLine();
                String[] strs=line.trim().split(" ");
                for(int j=0;j<n;j++){
                    arr[i][j]=Integer.parseInt(strs[j]);
                }
            }
            int sum=0;
            for(int i=0;i<n;i++){
                sum+=arr[i][i];
            }
            int c1=0,c2=0;
            for(int i=0;i<n;i++){
                HashSet<Integer> set=new HashSet<>();
                for(int j=0;j<n;j++){
                    if(set.contains(arr[i][j])){
                        c1++;
                        break;
                    }else{
                        set.add(arr[i][j]);
                    }
                }
            }
            for(int i=0;i<n;i++){
                HashSet<Integer> set=new HashSet<>();
                for(int j=0;j<n;j++){
                    if(set.contains(arr[j][i])){
                        c2++;
                        break;
                    }else{
                        set.add(arr[j][i]);
                    }
                }
            }
            System.out.println(sum+" "+c1+" "+c2);
        }
    }
}