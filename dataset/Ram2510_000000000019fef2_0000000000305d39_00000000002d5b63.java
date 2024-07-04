import java.util.*;

public class Solution {
    public static String run() {
            int a = scn.nextInt(), b = scn.nextInt();
			for(int i=-5;i<=5;i++)
			{
				for(int j=-5;j<=5;j++)
				{
					System.out.println(i + " " + j);
					System.out.flush();
					String r = scn.nextLine();
					if(r.equals("CENTER")) return r;
				}
			}
			return " ";
    }
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
		
		int t = scn.nextInt();
		for (int u = 1; u <= t; u++) {
			if(run().equals("WRONG")) break;
		}
	}
}