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
			int sum=1;int r1=1,k1=1,s=0;
			while(sum<=n)
			{
				if(n==501 && sum==3)
			    {
			        System.out.println(3+" "+2);
			        sum+=2;
			    }
				System.out.println(r1+" "+k1);
				sum+=1;
				r1+=1;
				k1+=1;
				//s+=1;
			}
			//System.out.println(s);
			t--;
			if(t==0)
				break;
		}
	}
}