import java.io.*;
import java.util.*;
class Solution {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		for(int i=1;i<=test;++i){
		    long n=sc.nextInt();
		    System.out.println("Case #"+i+":");
		    long sum1=1,temp=1,r1=1,c=1;
		    System.out.println(r1+" "+c);
		    c++;
		    while(sum1+temp<=n){
		        sum1=sum1+temp;
		        temp++;
		        r1++;
		        System.out.println(r1+" "+c);
		        
		    }
		    c--;
		    while(sum1!=n){
                sum1++;
		        
		        System.out.println(r1+" "+c);
		        r1++;
		    }
		}
	}
}