import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		
		for(int i = 0; i < t; ++i)
		{
			String str = sc.next();
			func(i, str);
		}
		
	}
	static void func(int tcase, String s) {
		
		String arr1[] = new String[] {"","(","((","(((","((((","(((((","((((((","(((((((","((((((((","((((((((("};
		String arr2[] = new String[] {"",")","))",")))","))))",")))))","))))))",")))))))","))))))))",")))))))))"};
		
		
		String res = "";
		int last = 0;
		for(int i=0; i<s.length(); i++)
		{
			char start = s.charAt(i);
			int index = Integer.parseInt(Character.toString(start));
			last = index;
			if(i==0)
			{
				res += arr1[index];	
				res += index;	
				continue;
			}
			
			int vIndex = Integer.parseInt(Character.toString(s.charAt(i-1)));
			if(index < vIndex)
			{
				res += arr2[vIndex-index];
			}
			else if(index > vIndex)
			{
				res += arr1[index-vIndex];
			}
			res += index;
		}
		res+= arr2[last];
		System.out.println("Case #" + ++tcase + ": " + res);
    }

}