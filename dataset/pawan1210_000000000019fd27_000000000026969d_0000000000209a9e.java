/*package whatever //do not write package name here */

import java.util.*;
import java.io.*;
public class Solution {
	public static void main (String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
		String arr[]=br.readLine().split(" ");
		br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(arr[0]);
		int b=Integer.parseInt(arr[1]);
		while(t-->0){
		  //  int start=2;
		  //  int end=b;
		  //  int size=1;
		  //  boolean flag=true;
		    int output[]=new int[b+1];
		  //  int zero1=-1;
		  //  int zero2=-1;
		  //  int start1=-1;
		  //  int start2=-1;
		    System.out.println(1);
		    System.out.flush();
		    String judge=br.readLine();
		    br=new BufferedReader(new InputStreamReader(System.in));
		    int temp=Integer.parseInt(judge);
		    output[1]=temp;
		    System.out.println(1);
		    System.out.flush();
		    judge=br.readLine();
		    br=new BufferedReader(new InputStreamReader(System.in));
		    temp=Integer.parseInt(judge);
		    output[1]=temp;
		    if(b==10){
		        for(int i=2;i<=10;i++){
		            System.out.println(i);
		            System.out.flush();
		            judge=br.readLine();
		            br=new BufferedReader(new InputStreamReader(System.in));
		            output[i]=Integer.parseInt(judge);
		        }
		        String answer="";
		        for(int i=1;i<=10;i++){
		            answer=answer+output[i];
		        }
		        System.out.println(answer);
		        System.out.flush();
		        String judgeanswer=br.readLine();
		    }
		  //  for(int i=3;i<=10;i++){
		  //      if(flag==true){
		  //          System.out.println(start);
		  //          System.out.flush();
		  //          judge=s.next();
		  //          s.nextLine();
		  //          output[start]=temp;
		  //          size++;
		  //          start++;
		  //      }
		  //      else{
		  //          System.out.println(end);
		  //          System.out.flush();
		  //          judge=s.next();
		  //          s.nextLine();
		  //          output[end]=temp;
		  //          size++;
		  //         }
		  //  }
		    
		  //  for(int i=1;i<=5;i++){
		  //      if(output[i]==output[b-i+1] && i!=b-i+1){
		            
		  //      }
		  //  }
		    
		   
		}
		
	}
}