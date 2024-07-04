import java.util.Scanner;

public class Solution {
	static StringBuilder answer = new StringBuilder();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int query= in.nextInt();
		String newS = "";
		int prevNum,bracCount;
		String open="(";
		String close=")";
		for(int i=0;i < query;i++)
		{
			prevNum = -1;
			newS="";
			String s= in.next();
			bracCount = Integer.parseInt(Character.toString(s.charAt(0)));
			String array[] = s.split("");
			for (int j=0;j<array.length;j++)
			{
				int num = Integer.parseInt(array[j]);
				if(bracCount==0)
					bracCount=num;
				if(num > prevNum)
				{
					if((j==0)||(prevNum==0))
						newS += repeat(open,bracCount);
					else{
						newS += repeat(open,Math.abs(bracCount-num));
						bracCount+=Math.abs(bracCount-num);
					}
						newS += num;
				}
				else if(num < prevNum)
				{

					newS += repeat(close,bracCount-num);
					bracCount=(num==0)?(0):(num);
					System.out.println(bracCount);
					newS += num;
				}
				else if(num==prevNum){
					newS+=Integer.toString(num);
				}
				else if (num==0)
					newS+='0';
				prevNum = num;
			}
			if (bracCount>0)
				newS+=repeat(close,bracCount);
			answer.append("Case #"+(i+1)+": ");
			answer.append(newS+"\n");
		}
		in.close();

	}

	private static String repeat(String close, int count) {

		String newStr ="";
		for(int i=0;i<count;i++)
			newStr+=close;
		
		return newStr;
	}
}