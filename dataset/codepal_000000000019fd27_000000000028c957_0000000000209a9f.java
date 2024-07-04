
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
		    String str = scn.next();
		    int count=0;
		    System.out.print("Case #"+(i+1)+": ");
		    for(int j=0;j<str.length();j++){
		        if(count<str.charAt(j)-'0'){
		            while(count<str.charAt(j)-'0'){
		                System.out.print("(");
		                count++;
		            }
		            System.out.print(str.charAt(j));
		        }
		        else if(count>str.charAt(j)-'0'){
		            while(count>str.charAt(j)-'0'){
        		      System.out.print(")");
        		      count--;  
        		   }
		            System.out.print(str.charAt(j));
		        }else{
		            System.out.print(str.charAt(j));
		        }
		            
		    }
		   while(count>0){
		      System.out.print(")");
		      count--;  
		   }
		    System.out.println();
		}
	}

}
