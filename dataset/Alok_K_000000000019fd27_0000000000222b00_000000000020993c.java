import java.util.*;
import java.io.*;
import java.math.BigInteger; 
 
   class Solution{
// taking inputs
static BufferedReader s1;
static BufferedWriter out;
static String read() throws IOException{String line="";while(line.length()==0){line=s1.readLine();continue;}return line;}
static int int_v (String s1){return Integer.parseInt(s1);}
static long long_v(String s1){return Long.parseLong(s1);}
static int[] int_arr() throws IOException{String[] a=read().split(" ");int[] b=new int[a.length];for(int i=0;i<a.length;i++){b[i]=int_v(a[i]);}return b;}
static long[] long_arr() throws IOException{String[] a=read().split(" ");long[] b=new long[a.length];for(int i=0;i<a.length;i++){b[i]=long_v(a[i]);}return b;}
static void assign(){s1=new BufferedReader(new InputStreamReader(System.in));out=new BufferedWriter(new OutputStreamWriter(System.out));}

public static void main(String[] args) throws  IOException{
	        		  assign();
              int t=int_v(read()), z=1;
              while(t--!=0){
	        	int n=int_v(read());
	        	int[][] arr=new int[n][n];
	        	int k=0;
	        	for(int i=0;i<n;i++){
	        		arr[i]=int_arr();
	        		k+=arr[i][i];
	        	}
	        	Set<Integer> s1=new HashSet<>();
	        	int r=0,c=0;
	        	for(int i=0;i<n;i++){
	        		for(int j=0;j<n;j++){
	        			s1.add(arr[i][j]);
	        		}
	        		if(s1.size()!=n){r++;}
	        		s1.clear();
	        	}
	        	for(int i=0;i<n;i++){
	        		for(int j=0;j<n;j++){
	        			s1.add(arr[j][i]);
	        		}
	        		if(s1.size()!=n){c++;}
	        		s1.clear();
	        	}

	            out.write("Case #"+z+": ");
	            out.write(k+" "+r+" "+c+"\n");
	            z++;
	        }
            out.flush();
	        }
	    }
 