import java.util.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{
    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int t=Integer.parseInt(br.readLine());
        for(int ti=0;ti<t;ti++){
            int n=Integer.parseInt(br.readLine());
            int m[][]=new int[n][n];
            int sum=0;
            int r=0,c=0;
            for(int i=0;i<n;i++){
                StringTokenizer st=new StringTokenizer(br.readLine());
                HashSet<Integer> hs=new HashSet<Integer>();
                boolean valid=true;
                for(int j=0;j<n;j++){
                    m[i][j]=Integer.parseInt(st.nextToken());
                    
                    if(hs.contains(m[i][j])){
                        valid=false;
                    }
                    hs.add(m[i][j]);
                    if(i==j){
                        sum+=m[i][j];
                    }
                }
                if(!valid)
                    r++;
            }
            for(int i=0;i<n;i++){
                HashSet<Integer> hs=new HashSet<Integer>();
                boolean valid=true;
                for(int j=0;j<n;j++){
                    if(hs.contains(m[j][i])){
                        valid=false;
                    }
                    hs.add(m[j][i]);
                }
                if(!valid)
                    c++;
            }
            bw.write("Case #"+(ti+1)+": "+sum+" "+r+" "+c+"\n");
        }
        bw.flush();
    }
}