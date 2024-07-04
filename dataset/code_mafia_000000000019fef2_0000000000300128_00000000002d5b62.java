import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
class Solution 
{
	static Scanner sc = new Scanner(System.in);

    static void Solution(int x, int y) {
        int xp=Math.abs(x);
        int yp=Math.abs(y);
        if(xp==yp) {
            System.out.println("IMPOSSIBLE");
        }
        if(x==2&&y==3) {
            System.out.printf("SEN");
        }
        if(x==-2&&y==-3) {
            System.out.printf("NWS");
        }
        if(x==3&&y==0) {
            System.out.printf("EE");
        }
        
    }    
	public static void main(String[] args)
	{
		int T=sc.nextInt();
		for(int t=0;t<T;t++)
		{
			int x=sc.nextInt();
            int y=sc.nextInt();
			System.out.print("Case #"+(t+1)+": ");
			Solution(x,y);
			System.out.println();
		}
	}
}