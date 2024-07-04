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
	        	char[] c=read().toCharArray();
	        	int n=c.length;
	        	Stack<Character> s=new Stack<>();
	        	int pp=0;
	        	for(int i=0;i<n;i++){
	        		int x=c[i]-'0';
	        		if(x==pp){s.push(c[i]);}
	        		else if(x>pp){
	        			int x1=x-pp;
	        			pp+=x1;
	        			while(x1--!=0){s.push('(');}
	        			s.push(c[i]);
	        		}
	        		else{
	        		     int x1=pp-x;
	        		     pp-=x1;
	        			while(x1--!=0){s.push(')');}	
	        			s.push(c[i]);
	        		}
	        	}
	        	while(pp--!=0){s.push(')');}

	            out.write("Case #"+z+": ");
	            char[] cc=new char[s.size()];
	            int j=cc.length-1;
	            while(!s.isEmpty()){
	            	cc[j]=s.pop();j--;
	            }
	            for(int i=0;i<cc.length;i++){
	            	out.write(cc[i]+"");
	            }
	            out.write("\n");
	            z++;
	        }
            out.flush();
	        }
	    }
 