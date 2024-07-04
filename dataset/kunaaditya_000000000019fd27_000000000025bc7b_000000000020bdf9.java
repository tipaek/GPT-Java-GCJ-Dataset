import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int T=Integer.parseInt(br.readLine());
        int temp=1;
        while(T-->0){
            int n=Integer.parseInt(br.readLine());
            int[][] arr=new int[n][3];
            for(int i=0;i<n;i++){
                String[] str=br.readLine().split(" ");
                arr[i][0]=Integer.parseInt(str[0]);
                arr[i][1]=Integer.parseInt(str[1]);
                arr[i][2]=i;
            }
            Arrays.sort(arr, new Comparator<int[]>() {
                public int compare(final int[] entry1,final int[] entry2) {
                    if (entry1[0] > entry2[0]) 
                        return 1; 
                    else
                        return -1; 
                } 
            });
            int cend=arr[0][1];
            int cstart=0;
            int jend=0;
            int jstart=0;
            char[] ans=new char[n];
            ans[arr[0][2]]='C';
            boolean flag=true;
            for(int i=1;i<arr.length;i++){
                if(arr[i][0]>=cend){
                    cend=arr[i][1];
                    ans[arr[i][2]]='C';
                }
                else if(arr[i][0]>=jend){
                    jend=arr[i][1];
                    ans[arr[i][2]]='J';
                    
                }
                else{
                    flag=false;
                    break;
                }
            }
            if(flag){
                bw.write("Case #"+(temp++)+": ");
                for(int i=0;i<ans.length;i++)
                    bw.write(ans[i]);
                bw.write("\n");
            }
            else{
                bw.write("Case #"+(temp++)+": ");
                bw.write("IMPOSSIBLE"+"\n");
            }
            
        }
        bw.flush();
    }
}