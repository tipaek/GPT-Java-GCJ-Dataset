import java.util.*;
class Solution
{
	public static void main(String[] args) {
		int t;
		Scanner in=new Scanner(System.in);
		t=in.nextInt();
		while(true)
		{
			long n;
			n=in.nextLong();
			
			System.out.println("Case #"+t+":");
			int sum=1;int r1=1,k1=1;
			while(sum<=n)
			{
				
				System.out.println(r1+" "+k1);
				sum+=1;
				r1+=1;
				k1+=1;
			}
			t--;
			if(t==0)
				break;
		}
	}
}