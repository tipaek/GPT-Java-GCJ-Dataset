import java.io.*;
import java.util.*;
public class Solution {
	public static void main (String[] args)throws IOException 
	{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    Scanner sc = new Scanner(System.in);
		    int t = Integer.parseInt(br.readLine());
		    int no = 1;
		    while(t-->0){
		       int n=Integer.parseInt(br.readLine());
		      int start[] = new int[n];
		      int end[] = new int[n];
		      int index[] = new int[n];
		       for(int i=0;i<n;i++){
		           String[] s1=br.readLine().trim().split(" ");
		           start[i]=Integer.parseInt(s1[0]);
		           end[i]=Integer.parseInt(s1[1]);
		           index[i]=i;
		          }
		         
		           int j=0;
		           int c=0;
		           String s="";
		           int temp1=0,temp2=0,temp3=0;
		           for(int i=0;i<n;i++){
		               for(int k=1;k<n-i;k++){
		                   if(start[k-1]>start[k]){
		                       temp1=start[k-1];
		                       start[k-1]=start[k];
		                       start[k]=temp1;
		                       temp2=end[k-1];
		                       end[k-1]=end[k];
		                       end[k]=temp2;
		                       temp3=index[k-1];
		                       index[k-1]=index[k];
		                       index[k]=temp3;
		                   }
		               } }
		               
		               int f=0;
		               char ch[]= new char[n];
		              
		               for(int i=0;i<n;i++){
		                if(start[i]<j && start[i]<c){
		                    System.out.println("Case #"+no+": IMPOSSIBLE");
		                    f=1;
		                    break;
		                }
		                if(start[i]>=c){
		                    ch[index[i]]='C';
		                    c=end[i];
		                }
		                else{
		                    ch[index[i]]='J';
		                    j=end[i];
		                }
		               }
		               if(f==0){
		                   for(int i=0;i<n;i++) s=s+ch[i];
		               
		          System.out.println("Case #"+no+": "+s); }
		            no++;
             }
		    }
     }
