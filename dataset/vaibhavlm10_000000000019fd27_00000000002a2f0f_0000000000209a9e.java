import java.io.*;
import java.util.*;
public class Solution {
	public static void main (String[] args)throws IOException 
	{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    Scanner sc = new Scanner(System.in);
		    String[] s =br.readLine().trim().split(" ");
		    int t=Integer.parseInt(s[0]);
		    int b=Integer.parseInt(s[1]);
		    int no = 1;
		    char[] arr = new char[b];
		    while(t-->0){
		       int x = new Random().nextInt(149 + 1) + 1;
		       for(int i=0;i<x;i++){
		           int q = new Random().nextInt(b-1 + 1) + 1;
		           System.out.println(q);
		           char in = br.readLine().charAt(0);
		           if(in=='N') break;
		           arr[q-1]=in;
		       }
		       String fs="";
		      for(int i=0;i<b;i++) fs=fs+arr[i];
		      
		      System.out.println(fs);
		      
		      String result = br.readLine();
		      if(result.equals("Y")) t--;
		      else break;
		    }
	}
}