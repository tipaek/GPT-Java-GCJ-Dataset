import java.io.*;
import java.util.*;

class Solution{
    public static void main(String[] args)throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new PrintStream(System.out));

        int t=Integer.parseInt(f.readLine());
        for(int q=0;q<t;q++){
            int n=Integer.parseInt(f.readLine());
            pair[]arr=new pair[2*n];
            for(int i=0;i<n;i++){
                StringTokenizer st=new StringTokenizer(f.readLine());
                int a=Integer.parseInt(st.nextToken());
                int b=Integer.parseInt(st.nextToken());
                arr[i*2]=new pair(a,0,i*2+1,i*2);
                arr[i*2+1]=new pair(b,1,i*2,i*2+1);
            }
            out.print("Case #"+(q+1)+": ");
            Arrays.sort(arr);
            String ans="";
            int a=-1;
            int b=-1;
            String[]d=new String[n];
            for(int i=0;i<2*n;i++){
                if(a!=-1 && b!=-1 && arr[i].start==0){
                    ans="IMPOSSIBLE";
                    Arrays.fill(d,"");
                    break;
                }
                if(arr[i].start==1 && a==arr[i].otheridx){
                    a=-1;
                }
                else if(arr[i].start==1){
                    b=-1;
                }
                if(arr[i].start==0 && a==-1){
                    d[arr[i].now/2]="C";
                    a=arr[i].now;
                }
                else if(arr[i].start==0 && b==-1){
                    d[arr[i].now/2]="J";
                    b=arr[i].now;
                }
            }
            for(int j=0;j<n;j++){
                ans+=d[j];
            }
            out.println(ans);
        }

        f.close();
        out.close();
    }
}
class pair implements Comparable <pair>{
    int first;
    int start;
    int otheridx;
    int now;
    public int compareTo(pair other)
    {
        return first==other.first?other.start-start:first-other.first;
    }


    pair(int a, int c,int b,int d)
    {
        first=a;
        start=c;
        otheridx=b;
        now=d;
    }
}