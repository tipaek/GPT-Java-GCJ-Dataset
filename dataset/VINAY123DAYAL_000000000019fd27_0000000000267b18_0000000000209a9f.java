import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

class Solution
{ 

        public static void main(String [] args) 
        { 
            Scanner input=new Scanner(System.in);
            int test=input.nextInt();
            for(int i=0;i<test;i++) {
            	String s=input.next();
            	String temp=s;
            	int j=0;
            	int difference=0;
            	System.out.print("Case #"+(i+1)+": ");
            	if(temp.length()==1) {
        			String s1=Character.toString(s.charAt(0));
        			int m=Integer.parseInt(s1);
        			//System.out.println(addopen(m));
        			temp=addopen(m)+temp+addend(m);
        			System.out.print(temp);
            	}
            	int start=1;
            	while(j<s.length()-1) {
            			String s1=Character.toString(s.charAt(j));
            			String s2=Character.toString(s.charAt(j+1));
            			int m=Integer.parseInt(s1);
            			int n=Integer.parseInt(s2);
            			if(m>n) {
            				String pqr=addend(m-n);
            				temp=temp.substring(0,start)+pqr+s.substring(j+1);
            				start+=m-n;
            			}else if(m<n) {
            				String pqr=addopen(n-m);
            				temp=temp.substring(0,start)+pqr+s.substring(j+1);
            				start+=n-m;
            			}
            			start++;
            			j++;
            			
            	}
            	if(s.length()>1) {
            		String s1=Character.toString(s.charAt(0));
        			String s2=Character.toString(s.charAt(s.length()-1));
        			int m=Integer.parseInt(s1);
        			int n=Integer.parseInt(s2);
            		System.out.print(addopen(m)+temp+addend(n));
            	}
            	System.out.println();
            }
            }
        static String addopen(int number) {
        	String k="";
        	for(int i=0;i<number;i++) {
        		k+="(";
        	}
        	return k;
        }
        static String addend(int number) {
        	String k="";
        	for(int i=0;i<number;i++) {
        		k+=")";
        	}
        	//String j=s+k;
        	return k;
        }
 }


 