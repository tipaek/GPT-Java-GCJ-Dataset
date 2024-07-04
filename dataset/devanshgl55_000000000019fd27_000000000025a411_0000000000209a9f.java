/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Solution {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int w=0;
        while(w++<t){
            String s=sc.next();
            String ans="";
            int x=0;
            System.out.print("Case #"+w+":");
            for(int i=0;i<s.length();i++){
                int e=s.charAt(i)-48;
                while(x<e){
                    System.out.print("(");
                    x++;
                }
                while(x>e){
                    System.out.print(")");
                    x--;
                }
                if(x==e){
                    System.out.print(s.charAt(i));
                }
            }
            while(x>0){
                System.out.print(")");
                    x--;
            }            
            System.out.println();
                    
        }
	}
}