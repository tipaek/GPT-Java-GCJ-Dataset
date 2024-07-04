/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
 public class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc =new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = sc.nextInt();
		String inx = sc.nextLine();
		for(int i =0;i<t;i++){
		    String input = sc.nextLine();
		  //   System.out.println("input "+ input);
		    input = "0"+input+"0";
	//	    System.out.println("input after adding 0s "+ input);
		    int len = input.length();
	//	    System.out.println("len "+ len);
		    ArrayList<String> res = new ArrayList<String>();
		   // res.add(0);
		    for(int j =0;j<len-1;j++){
		         
		       int s = Integer.parseInt(String.valueOf(input.charAt(j)));  
		       int e = Integer.parseInt(String.valueOf(input.charAt(j+1)));   
		    //   System.out.println("s : "+ s+"e : "+e);
		        //right case
		        if(s<e){
		            int diff = e-s;
		            for(int k = 0;k<diff;k++){
		                res.add("(");
		                
		            }
		            res.add(String.valueOf(input.charAt(j+1)));
		            
		            
		            
		        }else if (s>e){
		            // left case
		            int diff = s-e;
		            for(int k = 0;k<diff;k++){
		                res.add(")");
		                
		            }
		            res.add(String.valueOf(input.charAt(j+1)));
		            
		        }else{
		            res.add(String.valueOf(input.charAt(j+1)));
		        }
		    }
		    System.out.print("Case #" + (i+1) + ": ");
		    for(int k=0;k<res.size()-1;k++){
		        System.out.print(res.get(k));
		    }
		    System.out.println();
		}
	}
}
