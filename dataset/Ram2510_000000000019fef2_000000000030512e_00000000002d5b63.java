import java.util.*;

public class Solution {
    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for (int u = 1; u <= t; u++) {
			int a = scn.nextInt(), b = scn.nextInt();
			for(int i=-5;i<=5;i++)
			{
				for(int j=-5;j<=5;j++)
				{
					System.out.println(i + " " + j);
					System.out.flush();
					String r = scn.nextLine();
				}
			}
		}
	}
}