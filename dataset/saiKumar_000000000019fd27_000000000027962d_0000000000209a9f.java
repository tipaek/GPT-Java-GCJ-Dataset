import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = Integer.parseInt(s.nextLine());
		for(int i = 0;i<t;i++)
		{
			int depth = 0,loop = 0,num;
			String str = s.nextLine();
			String str1 = "";
			String[] strArr = str.split("");
			
			while(loop<strArr.length)
			{
				num = Integer.parseInt(strArr[loop]);
				//System.out.println(depth + "\t" + num + "\t" + str1);
				if(depth < num)
				{
					while(depth < num)
					{
						str1 += "(";
						depth++;
					}
					str1 += strArr[loop];
				}
				else if(depth > num)
				{
					while(depth > num)
					{
						str1 += ")";
						depth--;
					}
					str1 += strArr[loop];
				}
				else if(depth == num)
				{
					str1 += strArr[loop];
				}
				loop++;
			}
			if(depth>0)
			{
				while(depth>0)
				{
				str1 += ")";
				depth--;
				}
			}
			System.out.println("Case #"+(i+1)+": " + str1);
		}
		s.close();
	}

}
