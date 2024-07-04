/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{
    
    
    
    public static String rec(int x, int y, int curr_x,int curr_y,int curr_in,String res,int[] arr){
        if(x==curr_x&&y==curr_y){
         //   System.out.println(res);
          return res;
        }else if(Math.abs(Math.abs(curr_x)-Math.abs(x))>1000||Math.abs(Math.abs(curr_y)-Math.abs(y))>1000){
            return "PPPPPPPPPPPPPPPPPP00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP";
            
        }
         else if(x==curr_x){
         String a =      rec(x,y,curr_x,curr_y+arr[curr_in],curr_in + 1,res + "N" ,arr);
           String b=    rec(x,y,curr_x,curr_y-arr[curr_in],curr_in + 1,res + "S" ,arr);
              if(a.length()>b.length())
              return b;
              else 
              return a;
          }
          
        else if(y==curr_y){
           String a =     rec(x,y,curr_x+arr[curr_in],curr_y,curr_in + 1,res + "E" ,arr);
            String b=     rec(x,y,curr_x-arr[curr_in],curr_y,curr_in + 1,res + "W" ,arr);
              
             if(a.length()>b.length())
              return b;
              else 
              return a;
          }
          else{
              
          String a =     rec(x,y,curr_x,curr_y+arr[curr_in],curr_in + 1,res + "N" ,arr);
          String b =     rec(x,y,curr_x,curr_y-arr[curr_in],curr_in + 1,res + "S" ,arr);
          String c =     rec(x,y,curr_x+arr[curr_in],curr_y,curr_in + 1,res + "E" ,arr);
          String d =     rec(x,y,curr_x-arr[curr_in],curr_y,curr_in + 1,res + "W" ,arr);
              
             // return res;
             if(a.length()<=b.length()&&a.length()<=c.length()&&a.length()<=d.length())
              return a;
             else   if(b.length()<=a.length()&&b.length()<=c.length()&&b.length()<=d.length())
              return b;
              else if(c.length()<=a.length()&&c.length()<=b.length()&&c.length()<=d.length())
              return c;
              else 
              return d;
              
          }
        
        
        
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc =new Scanner(System.in);
		int[] arr = new int[200];
		arr[0] = 1;
		for(int j =1;j<200;j++)
		 arr[j]= arr[j-1]*2;
		
		int t = sc.nextInt();
		for(int i =0;i<t;i++){
		    int x = sc.nextInt();
		    int y = sc.nextInt();
		    String a ="";
		       String b ="";
		    if((x%2==0&&y%2==0)||(x%2!=0&&y%2!=0)||(x==0&&y%2==0)||(x%2==0&&y==0)){
		      System.out.println("Case #" + (i+1) + ": " +"IMPOSSIBLE");
		      }else{
		       //   String res ="";
		       
		          //make recurseive calls
		          if(x%2==0){
		              //y is odd
	 a =	   rec(x,y,0,1,1,"N",arr);
 b =	    rec(x,y,0,-1,1,"S",arr);
		          }else{
		              //x is odd
	 a =	       rec(x,y,1,0,1,"E",arr);
 b =	      rec(x,y,-1,0,1,"W",arr);
		              
		          }
		          if(a.length()>b.length())
              System.out.println("Case #" + (i+1) + ": " +b);
              else 
             System.out.println("Case #" + (i+1) + ": " +a);
		      }
		        
		    
		    
		   // System.out.println();
		}
	}
}
