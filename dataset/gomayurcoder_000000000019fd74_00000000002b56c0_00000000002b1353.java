import java.util.*;
import java.io.*;

public class Solution {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = s.nextInt();
		for(int ti=1;ti<=t;ti++)
		{
			int n = s.nextInt();
			System.out.println("Case #"+ti+": ");
			if(n<=500) {
				for(int i=1;i<=n;i++) {
					System.out.println(i+" 1");
				}
			}
			else {
				System.out.println("1 1");
				System.out.println("2 2");
				for(int i=3;i<=500;i++) {
					System.out.println(i+" 1");
				}
			}
			//System.out.println("Case #"+ti+": "+ans);

		}
	}
}