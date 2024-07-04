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
              	int[][] arr=new int[n][3];
              	for(int i=0;i<n;i++){
              		int[] zz=int_arr();
              		arr[i][0]=zz[0];arr[i][1]=zz[1];
              	}
              	int[][] arr1=new int[n][3];
                for(int i=0;i<n;i++){
                	arr1[i][0]=arr[i][0];
                	arr1[i][1]=arr[i][1];
                }
              	Arrays.sort(arr,new Comparator<int[]>(){
              		@Override
              		public int compare(int[] a, int[] b){
              			return a[0]-b[0];
              		}
              	});
              int c=0,ce=0,j=0,je=0;
              boolean b=false;
              for(int i=0;i<n;i++){
              	if(ce<=arr[i][0]){c=0;}
              	if(je<=arr[i][0]){j=0;}
              	if(c==0){
              		ce=arr[i][1];c=1;
              		arr[i][2]=1;
              	}
              	else if(j==0){
              		je=arr[i][1];j=1;
              		arr[i][2]=2;
              	}
              	else{b=true;break;}
              }

	            out.write("Case #"+z+": ");
	           if(b){out.write("IMPOSSIBLE\n");}
	           else{
	           	for(int i=0;i<n;i++){
	           		for(int j1=0;j1<n;j1++){
	           			int x=arr1[i][0],y=arr1[i][1],x1=arr[j1][0],y1=arr[j1][1];
	           			if(x==x1&&y==y1){
	           				arr1[i][2]=arr[j1][2];break;
	           			}
	           		}
	           	}
	           	for(int i=0;i<n;i++){
	           		char v=arr1[i][2]==1?'C':'J';
	           		out.write(v+"");
	           	}
	           	out.write("\n");
	           }
	            
	            z++;
	        }
            out.flush();
	        }
	    }
 