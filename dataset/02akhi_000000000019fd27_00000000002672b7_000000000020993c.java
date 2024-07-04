import java.io.*;
import java.util.*;
public class Solution{
    public static void main(String args[])throws IOException{
         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int t=Integer.parseInt(br.readLine());
        for(int v=1;v<=t;v++){
            int n=Integer.parseInt(br.readLine());
            ArrayList<Integer> arr=new ArrayList<>();
            int a[][]=new int[n][n];
            int c=0,tr=0;
            for(int i=0;i<n;i++){
                 int k=0,cnt=0;
                 String s[]=br.readLine().split(" ");
            while(k<n){
                a[i][k]=Integer.parseInt(s[k]);
                if(arr.contains(a[i][k]))
                cnt=1;
                else
                arr.add(a[i][k]);
                if(i==k)
                tr=tr+a[i][k];
                k++;
            }
            arr.clear();
            if(cnt==1)
            c++;
            }
            int cm=0;
            arr.clear();
             for(int i=0;i<n;i++){
                  int cl=0;
                  int k=0;
            while(k<n){
                
                if(arr.contains(a[k][i]))
                cl=1;
                else
                arr.add(a[k][i]);
                 k++;
            }
            arr.clear();
            if(cl==1)
            cm++;
            }
            bw.write("Case #"+v+":"+" "+tr+" "+c+" "+cm);
        bw.write("\n");
            
        }
         bw.flush();
    }
}
             