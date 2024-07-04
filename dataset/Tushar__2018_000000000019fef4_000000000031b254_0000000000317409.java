import java.util.*;
import java.io.*;
class Solution{
    public static void main(String[] args)throws IOException{
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(in.readLine()),tc=1;
        while(t-->0){
            String[] s=in.readLine().split(" ");
            int x=Integer.parseInt(s[0]),y=Integer.parseInt(s[1]);
            int xc=0,yc=0,ans=-1,cnt=0;
            for(int i=0;i<s[2].length();i++){
                if(xc==x && yc==y){
                    ans=cnt;
                    break;
                }
                char ch=s[2].charAt(i);
                if(ch=='N')y+=1;
                else if(ch=='S')y-=1;
                else if(ch=='E')x+=1;
                else x-=1;
                if(x-xc>0)xc+=1;
                else if(y-yc>0)yc+=1;
                else if(xc-x>0)xc-=1;
                else if(yc-y>0)yc-=1;
                //System.out.println(x+" "+y+" "+xc+" "+yc);
                cnt+=1;
            }
            if(ans!=-1){
                System.out.println("Case #"+tc+": "+ans);
            }
            else{
                if(xc==x && yc==y)System.out.println("Case #"+tc+": "+cnt);
                else System.out.println("Case #"+tc+": "+"IMPOSSIBLE");
            }
            tc+=1;
        }
    }
}
class FastReader{
    public static StringTokenizer st;
    public static BufferedReader in;
    public static PrintWriter pw;
    FastReader(){
    	in = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        st = new StringTokenizer("");
    }
    public static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
    public static long nextLong() throws IOException {
        return Long.parseLong(next());
    }
    public static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
    public static String next() throws IOException {
        while(!st.hasMoreElements() || st == null){
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }
}