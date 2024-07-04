import java.io.*;
import java.util.*;

class NestingDepth{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 1; i < t+1; i++)
		{
			String s = sc.next();
			for(int j = 0; j < s.length(); j++)
			{
				String s1 = s.substring(j,j+1);
				int s2 = Integer.parseInt(s1);
				System.out.print("Case #" + i + ": ");
				for(int k = 0; k < s2; k++)
					System.out.print("(");
				System.out.print(s.charAt(j));
				for(int k = 0; k < s2; k++)
					System.out.print(")");
			}
			System.out.println();
		}
	}
}