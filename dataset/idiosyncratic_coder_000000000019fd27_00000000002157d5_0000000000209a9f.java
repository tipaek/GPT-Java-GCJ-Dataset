import java.io.*;
import java.util.*;
import java.math.*;
public class Solution {
	public static void main(String[] args) throws Exception{
		Scanner in = new Scanner(System.in);
		int nc = in.nextInt();
		for(int x = 0; x < nc; x++)
		{
			String s = in.next();
			int[] nums = new int[s.length()];
			int temp = 0;
			String ans = "";
			nums[0] = Integer.parseInt(s.substring(0, 1));
			temp = nums[0];
			for(int a = 0; a < temp; a++)
			{
				ans += "(";
			}
			ans+= s.substring(0, 1);
			for(int i = 1; i < s.length(); i++)
			{
				nums[i] = Integer.parseInt(s.substring(i, i+1));
				temp = Math.abs(nums[i] - nums[i-1]);
				if(nums[i] > nums[i-1])
				{
					for(int a = 0; a < temp; a++)
					{
						ans += "(";
					}
				}
				else if(nums[i] < nums[i-1])
				{
					for(int a = 0; a < temp; a++)
					{
						ans += ")";
					}
				}
				ans+= s.substring(i, i+1);
			}
			for(int a = 0; a < nums[s.length() -1]; a++)
			{
				ans += ")";
			}
			System.out.printf("Case #%d: ", x + 1);
			System.out.println(ans);
		}
	}
}
