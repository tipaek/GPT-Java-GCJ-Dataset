import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		String[] list = new String[T];
		
		for(int i = 0; i < T; i++)
			list[i] = "";
		
		for(int i = 0; i < T; i++)
		{
			int X = sc.nextInt();
			int Y = sc.nextInt();
			
			String result = recurse(0 , 0, X, Y, 0, "", list, i);
		}
				
		for(int i = 0; i < list.length; i++)
		{
			String s = list[i];
			
			if(s.equals(""))
				System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
			else
				System.out.println("Case #" + (i + 1) + ": " + s);
		}

	}
	
	public static String recurse(int x, int y,int X, int Y ,int p, String result, String[] list, int i)
	{
		if(x == X && y == Y)
		{
				if(list[i].equals(""))
				list[i] = result;
				
				if(list[i].length() > result.length())
				list[i] = result;
			
			return result;
		}
		
		if(Math.abs(x) > Math.abs(X) * Math.pow(2, 5) || Math.abs(y) > Math.abs(Y) * Math.pow(2, 5))
			return "";
		
		int value = (int) Math.pow(2, p);
		
		recurse(x + value, y, X, Y, p + 1, result + "E", list, i);
		recurse(x - value, y, X, Y, p + 1, result + "W", list, i);
		recurse(x, y + value, X, Y, p + 1, result + "N", list, i);
		recurse(x, y - value, X, Y, p + 1, result + "S", list, i);
		
		return result;
	}

}
