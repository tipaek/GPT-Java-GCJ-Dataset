import java.io.*;
import java.util.*;

public class Solution {
    static int[] d;
    static int z=0;
    public static int fun(int n,int k){
        if(k==0) return 1;
        int sum=0;
        for(int i=1;i<=n;i++){
            for(int j=n;j>0;j-=2){
                if(k-(j*i)>=0){
                    if(d[k-(j*i)]==-1){
                        d[k-(j*i)]=fun(n,k-(j*i));
                    //System.out.println(z++);
                }
                sum=(sum+d[k-(j*i)])%1000000007;
                }
            }
        }
        return sum;
    }
    public static void main(String[] args)throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int T=Integer.parseInt(br.readLine());
        int a=T;
        d=new int[50*50];
        Arrays.fill(d,-1);
        while(T-->0){
            Arrays.fill(d,-1);
            String[] str=br.readLine().split(" ");
            int n=Integer.parseInt(str[0]);
            int k=Integer.parseInt(str[1]);
            //for(int i=0;i<n;i++)
                
            bw.write(fun(n,k)>0?"POSSIBLE":"IMPOSSIBLE");
            bw.write("\n");
            //z=0;
            //break;
        }
        bw.flush();
    }
}