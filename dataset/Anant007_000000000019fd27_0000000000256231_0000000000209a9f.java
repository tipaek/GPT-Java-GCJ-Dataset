import java.util.Scanner;

public class Solution {
	static StringBuilder ans = new StringBuilder();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inp = new Scanner(System.in);
		int queries= inp.nextInt();
		String newSet = "";
		int prev,brac;
		String open="(";
		String close=")";
		for(int i=0;i < queries;i++)
		{
			prev = -1;
			newSet="";
			String s= inp.next();
			brac = Integer.parseInt(Character.toString(s.charAt(0)));
			String array[] = s.split("");
			for (int j=0;j<array.length;j++)
			{
				int num = Integer.parseInt(array[j]);
				if(brac==0)
					brac=num;
				if(num > prev)
				{
					if((j==0)||(prev==0))
						newSet += repeat(open,brac);
					else{
						newSet += repeat(open,Math.abs(brac-num));
						brac+=Math.abs(brac-num);
					}
						newSet += num;
				}
				else if(num < prev)
				{

					newSet += repeat(close,brac-num);
					brac=(num==0)?(0):(num);
					System.out.println(brac);
					newSet += num;
				}
				else if(num==prev){
					newSet+=Integer.toString(num);
				}
				else if (num==0)
					newSet+='0';
				prev = num;
			}
			if (brac>0)
				newSet+=repeat(close,brac);
			ans.append("Case #"+(i+1)+": ");
			ans.append(newSet+"\n");
		    System.out.println(ans);
		}
		inp.close();

	}

	private static String repeat(String close, int count) {

		String newStr ="";
		for(int i=0;i<count;i++)
			newStr+=close;
		
		return newStr;
	}

}