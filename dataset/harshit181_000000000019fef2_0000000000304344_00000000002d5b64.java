import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.valueOf(br.readLine());
		
		
		for(int td=1;td<=t;td++)
		{
			String data[]=br.readLine().split(" ");
			int s=Integer.valueOf(data[0]);
			int r=Integer.valueOf(data[1]);
			ArrayList<Integer> list=new ArrayList<Integer>();
			ArrayList<Integer> listOfS=new ArrayList<Integer>();
			int totalNum=r*s;
			for(int j=1;j<=s;j++)
			{
				listOfS.add(j);
			}
			
			for(int i=0;i<r;i++)
			{
				list.addAll(listOfS);				
			}
			
			int operation=0;
			boolean isDone=false;
			ArrayList<Integer> answer=new ArrayList<Integer>();
			int lastNumber=s;
			while(!isDone)
			{
				
				int temp1=0;
				int temp2=0;
				for(int i=0;i<totalNum;i++)
				{
					if(list.get(i)==lastNumber)
					{
						temp1=i+1;
						break;
					}
				}
				
				for(int i=totalNum-1;i>=0;i--)
				{
					if(list.get(i)<lastNumber)
					{
						temp2=i+1-temp1;
						
						if((totalNum-i)%r==0)
						{
							if(lastNumber==2)
						{
								isDone=true;
						}
							
							lastNumber=list.get(i);
						}
						break;
					}
				}
			
				
				answer.add(temp1);
				answer.add(temp2);
				
				list=swap(temp1, temp2, list);
			}
			
			
			
			System.out.println("Case #"+td+": "+answer.size()/2);
			
			for(int i=0;i<answer.size();i++)
			{
				System.out.println(answer.get(i)+" "+answer.get(i+1));
				i++;
			}

		}
		
		
		
	}
	
	public static ArrayList<Integer> swap(int a,int b,ArrayList<Integer> numbers)
	{
		ArrayList<Integer> A=new ArrayList<Integer>();
		ArrayList<Integer> B=new ArrayList<Integer>();
		ArrayList<Integer> thisWillBe=new ArrayList<Integer>();
		for(int i=0;i<a;i++)
		{
			A.add(numbers.remove(0));
		}
		
		for(int i=0;i<b;i++)
		{
			B.add(numbers.remove(0));
		}
		
		thisWillBe.addAll(B);
		thisWillBe.addAll(A);
		thisWillBe.addAll(numbers);
		return thisWillBe;
		
	}
}
