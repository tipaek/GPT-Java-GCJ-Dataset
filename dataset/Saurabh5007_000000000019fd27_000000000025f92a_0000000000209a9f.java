import java.util.Scanner;

public class Solution {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int T = 1; T <= tc; T++) {
			String input = sc.next();
			String out = "";
			
			int outIndex=0;
			for (int i = 0; i < input.length(); i++) {
				int num = input.charAt(i) - 48;
				for(int j=0;j<num;j++)
				{
					out=out+"(";
				}
				out=out+num;
				for(int j=0;j<num;j++)
				{
					out=out+")";
				}
			}
			int len=out.length();
			char[] fout=new char[len+1];
			fout[0]=out.charAt(0);
			for(int i=1;i<len;i++)
			{
				if(out.charAt(i)=='(' && fout[outIndex]==')')
				{
					outIndex--;
				}
				else
				{
					outIndex++;
					fout[outIndex]=out.charAt(i);	
				}
			}
			String res="";
			int foutLen=fout.length;
			for(int i=0;i<foutLen;i++)
			{
				if(fout[i]!=' ')
				{
					res=res+fout[i];
				}
			}

			System.out.println("Case #" + T + ":" + res);
		}

	}

}
