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
        int t=int_v(read()),zq=1;;
        while(t--!=0){
            int n=int_v(read());
            String[] arr=new String[n];
            int l=0,li=-1;
            Set<Character> s1=new HashSet<>();
            for(int i=0;i<n;i++){
                arr[i]=new StringBuilder(read()).reverse().toString();
               if(arr[i].length()>l){l=arr[i].length();li=i;}
            }
            boolean b1=true; int j=0,sc=0;
            boolean[] b=new boolean[n];
            while(true){
                for(int i=0;i<n;i++){
                if(b[i]){continue;}
                if(arr[i].charAt(j)=='*'){sc++;b[i]=true;continue;}
                s1.add(arr[i].charAt(j));
            }
            j++;
            if(s1.size()>1){b1=false;break;}
            if(sc==n){break;}
            s1.clear();
            }

            out.write("Case #"+zq+": ");

            if(b1){for(int i=l-2;i>=0;i--){out.write(arr[li].charAt(i));}}
            else{out.write("*");}
                out.write("\n");zq++;
            }
            out.flush();
            }
            
        }
        
       
        
        
        
        
        


/*
*/