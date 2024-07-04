import java.io.*;
import java.util.*;
class Solution {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int cas=1;cas<=t;++cas){
		    long n=sc.nextInt();
		    System.out.println("Case #"+cas+":");
		    long sum=1,temp=1,r=1,c=1;
		    System.out.println(r+" "+c);
		    c++;
		    while(sum+temp<=n){
		        sum=sum+temp;
		        temp++;
		        r++;
		        System.out.println(r+" "+c);
		        
		    }
		    c--;
		    while(sum!=n){
                sum++;
		        
		        System.out.println(r+" "+c);
		        r++;
		    }
		}
	}
}