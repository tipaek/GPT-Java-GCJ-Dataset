import java.util.*;
class Solution{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		int p=1;
		while(t-->0)
		{
			String s=sc.next();
			String s1="";
			
			int dif=0;
			char arr[]=s.toCharArray();
			for(int i=0;i<arr.length;i++)
			{
				int v=((int)arr[i])-48;
				//System.out.println(v);
				if(dif<v)
				{
					int val=v-dif;
					//System.out.println(val);
					for(int j=0;j<val;j++)
					{
						s1+='(';
					}
					s1+=arr[i];
					dif=v;
				}
				else if(dif>v)
				{
					int val=dif-v;
					for(int j=0;j<val;j++)
					{
						s1+=')';
					}
					s1+=arr[i];
					dif=v;
				}
				else
				s1+=arr[i];	
			}
			int n=arr.length;
			int val=arr[n-1]-48;
			for(int i=0;i<val;i++)
			{
				s1+=')';
			}
			
			System.out.println("Case #"+p+": "+s1);
			p++;
		}

	}

}
