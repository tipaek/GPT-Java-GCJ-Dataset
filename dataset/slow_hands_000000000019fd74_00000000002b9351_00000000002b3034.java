import java.util.*;
import java.io.*;


class pair{
	int a ;int b;
	public pair(int a,int b){
		this.a=a;
		this.b=b;
	}}
public class Solution { 
	 static boolean sub(String str1,  
             String str2, int m, int n) 
{ 
 int j = 0; 
   
// str1 ko str2 se match
 // m           n
 
 for (int i = 0; i < n && j < m; i++) {
     if (str1.charAt(j) == str2.charAt(i)) 
         j++; 
     else {
    	 
     }}

 return (j == m);  
} 

	public static String solve(int n,String[] arr) {
		String ans="";
		int maxlen=0;
		
		Arrays.sort(arr);
		ArrayList<String> jj=new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			{
				if(arr[i].length()>maxlen)
					maxlen=arr[i].length();
				
			}
			//System.out.println(arr[i]);	
		}
		for (int i = 0; i < arr.length; i++) {
			if(arr[i].length()==maxlen) {
				jj.add(arr[i].substring(1));
			}
		}
		//System.out.println(jj);
		for (String hh:jj) {
			int count=0;
			for (int i = 0; i < arr.length; i++) {
				if(hh.contains(arr[i].substring(1))){
					count++;
				}
			}
			if(count==n) {
				ans=hh;
			}
		}
		if(ans.equals("")) return "*";
		return ans;
	}
	public static void main(String args[])throws IOException { 
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String[] temp=reader.readLine().split(" ");	

		int t=Integer.parseInt(temp[0]);
		int c=1;
		while(t-->0) {
			String[] tem1=reader.readLine().split(" ");	
		int n=Integer.parseInt(tem1[0]);
		

		String[] arr=new String[n];
		
		for(int i=0;i<n;i++) {
			arr[i]=reader.readLine();
			
		}
		
		String ans=solve(n,arr);
		System.out.println("Case #"+(c)+":"+" "+ans);
		c++;
		}

	} 
} 
