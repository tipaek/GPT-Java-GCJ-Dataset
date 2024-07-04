import java.util.*;
import java.io.*;
 class Solution {
     
static BufferedReader s1;
static BufferedWriter out;
static String read() throws IOException{String line="";while(line.length()==0){line=s1.readLine();continue;}return line;}
static int int_v (String s1){return Integer.parseInt(s1);}
static long long_v(String s1){return Long.parseLong(s1);}
static int[] int_arr() throws IOException{String[] a=read().split(" ");int[] b=new int[a.length];for(int i=0;i<a.length;i++){b[i]=int_v(a[i]);}return b;}
static long[] long_arr() throws IOException{String[] a=read().split(" ");long[] b=new long[a.length];for(int i=0;i<a.length;i++){b[i]=long_v(a[i]);}return b;}
static void assign(){s1=new BufferedReader(new InputStreamReader(System.in));out=new BufferedWriter(new OutputStreamWriter(System.out));}

  public static void main(String args[]) throws  IOException {
         assign();
              int t=int_v(read()),cn=1;
              while(t--!=0){
                String[] s=read().split(" ");
                int x=int_v(s[0]),y=int_v(s[1]);
                String path=s[2]; int cc=0;
                boolean bb=false;
                for(int i=0;i<path.length();i++){
                  if(Math.abs(x)+Math.abs(y)<=cc){
                    bb=true; break;
                  }
                   char c=path.charAt(i);
                   if(c=='N'){y++;}
                   else if(c=='S'){y--;}
                   else if(c=='E'){x++;}
                   else{x--;} cc++;
                }
                if(Math.abs(x)+Math.abs(y)<=cc){
                    bb=true;
                  }
                out.write("Case #"+cn+": ");
                if(!bb){
                  out.write("IMPOSSIBLE\n");
                }
                else{
                  out.write(cc+"\n");
                }
                cn++;
              }
              out.flush();
    }
           
}
