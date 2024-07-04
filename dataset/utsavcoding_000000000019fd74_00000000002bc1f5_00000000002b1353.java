import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	void run(){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		int cnt=0;
		while(cnt<t){
		    cnt++;
		    int n=sc.nextInt();
		    System.out.println("Case #"+cnt+":");
		    int x=1,y=1,start=1;
		    System.out.println("1 1");
		    if(n==501){
		        System.out.println("2 2");
		        System.out.println("3 2");
		        System.out.println("3 3");
		        x=3;
		        y=3;
		        start=4;
		        n-=1;
		    }
		    for(int i=start;i<n;i++){
		        x++;
		        y++;
		        System.out.println(x+" "+y);
		    }
		}
	}
	
	public static void main(String[] args) throws IOException{
		new Solution().run();
	}
}