import java.io.*;
import java.util.*;
 public class Solution{
    public static void main(String args[])throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int t=Integer.parseInt(br.readLine());
         int y=1;
        while(t-->0){
            int n=Integer.parseInt(br.readLine());
            ArrayList<Integer> ar=new ArrayList<>();
            int a[][]=new int[n][n];
            int cn=0,tr=0;
            for(int i=0;i<n;i++){
                int k=0,c=0;
                String s[]=br.readLine().split(" ");
                while(k<n){
                    a[i][k]=Integer.parseInt(s[k]);
                    if(ar.contains(a[i][k]))
                    c=1;
                    else
                    ar.add(a[i][k]);
                    if(i==k)
                    tr+=a[i][k];
                    k++;
                }
                ar.clear();
                if(c==1)
                cn++;
            }
            int clm=0;
            ar.clear();
            for(int i=0;i<n;i++){
                int cl=0;
                for(int m=0;m<n;m++){
                    if(ar.contains(a[m][i]))
                    cl=1;
                    else
                    ar.add(a[m][i]);
                }
                ar.clear();
                if(cl==1)
                clm++;
            }
           
            bw.write("Case #"+y+":"+" "+tr+" "+cn+" "+clm);
            y++;
            bw.write("\n");
            
            
        }
        bw.flush();
    }
}