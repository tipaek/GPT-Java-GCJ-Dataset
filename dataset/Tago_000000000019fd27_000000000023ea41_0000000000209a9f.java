import java.util.*;
import java.io.*;
public class Solution
{
	public static void main(String[] args)
	{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++)
        {
            int j,diff,prevNum = 0;
            String str = sc.next();
            String appStr;
            StringBuilder res = new StringBuilder();
            for(j=0;j<str.length();j++)
            {
                int curNum = Integer.parseInt(Character.toString(str.charAt(j)));
                if(prevNum != curNum)
                {
                    appStr = prevNum<curNum?"(":")";
                    diff = prevNum<curNum?curNum-prevNum:prevNum-curNum;
                    for(int a=0;a<diff;a++)
                    {
                        res.append(appStr);
                    }
                }
                prevNum = curNum;
                res.append(Integer.toString(curNum));
            }
            for(int a=0;a<Integer.parseInt(Character.toString(str.charAt(str.length()-1)));a++)
            {
                res.append(")");
            }
            System.out.println("Case #"+(i+1)+": "+res);
        }    
	}
}
