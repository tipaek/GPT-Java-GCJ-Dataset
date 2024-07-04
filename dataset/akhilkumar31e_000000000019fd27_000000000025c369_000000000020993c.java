import java.util.*;
import java.io.*;
class Solution{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int test=Integer.parseInt(br.readLine());
        for(int t=1;t<=test;t++){
            int n=Integer.parseInt(br.readLine());
            int arr[][]=new int[n][n];
            int rc=0;
            int trace=0;
            for(int i=0;i<n;i++){
                String s[]=br.readLine().split(" ");
                HashSet<Integer> hs=new HashSet<Integer>();
                for(int j=0;j<n;j++){
                    arr[i][j]=Integer.parseInt(s[j]);
                    hs.add(arr[i][j]);
                    if(i==j) trace+=arr[i][j];
                }
                if(hs.size()<n) rc++;
            }
            int cc=0;
            for(int i=0;i<n;i++){
                HashSet<Integer> hs=new HashSet<Integer>();
                for(int j=0;j<n;j++){
                    if(hs.contains(arr[j][i])){
                        cc++;
                        break;
                    }
                    hs.add(arr[j][i]);
                }
            }
            System.out.println("Case #"+t+":"+" "+trace+" "+rc+" "+cc);
        }
    }
}