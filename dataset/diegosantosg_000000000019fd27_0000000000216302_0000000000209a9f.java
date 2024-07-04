import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int times=sc.nextInt();
		for(int i=1; i<=times; i++) { //case number
			String s=sc.next();
			for(int k=0; k<s.length(); k++)
				if(s.substring(k,k+1).equals("1"))
					s=s.substring(0,i)+"("+s.substring(i,i+1)+")"+s.substring(i+1);
			for(int j=0; j<s.length()-1; j++)
				if(s.substring(j,j+1).equals("(") && s.substring(j+1,j+2).contentEquals(")"))
					s=s.substring(0,j)+s.substring(j+2);
			System.out.println("Case #"+i+": "+s);
		}
		sc.close();
	}
}
