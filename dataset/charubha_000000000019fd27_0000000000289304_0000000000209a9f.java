import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		int tc=Integer.parseInt(sc.nextLine());	
		String[]output=new String[tc];
		for(int h=0;h<tc;h++)
		{
			output[h]="";
		}
		for(int i=0;i<tc;i++)
		{ 
			String input=sc.nextLine();
			//int arr[]=new int[100];
			String tempout="";
			String res[]=input.split("");
			int resint[]=new int[res.length];
			
			for(int k=0;k<res.length;k++)
			resint[k]=Integer.parseInt(res[k]);	
			
			
			int index=0;
			int flag=0;
			
			int temp=resint[0];
			while(temp>0)
			{
				tempout+="(";
				temp--;
			}
			tempout+=""+resint[0];
			
			for(int j=1;j<resint.length;j++)
			{
				if(resint[j]<resint[j-1])
				{
					int diff=resint[j-1]-resint[j];
					while(diff>0)
					{
						tempout+=")";
						diff--;
					}
					tempout+=""+resint[j];
				}
				else if(resint[j]>resint[j-1])
				{
					int diff=resint[j]-resint[j-1];
					while(diff>0)
					{
						tempout+="(";
						diff--;
					}
					tempout+=""+resint[j];
				}
				else if(resint[j]==resint[j-1])
				{
					tempout+=""+resint[j];
				}
				
			}
			if(tempout.charAt(resint.length)!='0')
			tempout+=")";
			output[i]=tempout;
			
		}
		

		for(int h=0;h<tc;h++)
		{System.out.print("Case #"+(h+1)+": "+output[h]);
			System.out.println();
		}
	}
	
}
