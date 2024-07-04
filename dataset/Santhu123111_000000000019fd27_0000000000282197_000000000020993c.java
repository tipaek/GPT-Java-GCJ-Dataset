
import java.util.*;
public class TraceProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("here");
		int n=sc.nextInt();
		ArrayList<String> res=new ArrayList<String>();
		for(int i=0;i<n;i++) 
		{
			String sres="";
			int mn=sc.nextInt();
			ArrayList<ArrayList<Integer>> ai=new ArrayList<>();
			int trace=0;
			int repeatedrow=0;
			for(int j=0;j<mn;j++) 
			{
				boolean flag=false;
				ArrayList<Integer> ai2=new ArrayList<Integer>();
				for(int k=0;k<mn;k++) 
				{
					int number=sc.nextInt();
					if(ai2.contains(number)&&!flag) 
					{
						repeatedrow++;
						flag=true;
					}
					ai2.add(number);
					if(k==j) 
					{
						trace+=number;
					}
				}
				ai.add(ai2);
			}
			sres+=trace+" "+repeatedrow;
			int repeatedcolumn=0;
			for(int j=0;j<mn;j++) 
			{
				boolean flag=false;
				ArrayList<Integer> ai2=new ArrayList<Integer>();
				for(int k=0;k<mn;k++) 
				{
					int number=ai.get(k).get(j);
					
					if(ai2.contains(number)&&!flag) 
					{
						repeatedcolumn++;
						flag=true;
					}
					ai2.add(number);

				}
			}
			sres+=" "+repeatedcolumn;
			res.add(sres);
		}
		System.out.println(res);
		
	}

}
