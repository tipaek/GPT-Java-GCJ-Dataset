import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeSet;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.valueOf(br.readLine());
		
		for(int tada=1; tada<=t;tada++)
		{
			
			int n=Integer.valueOf(br.readLine());
			
			
			int sum=0;
			ArrayList<TreeSet<Integer>> row=new ArrayList<TreeSet<Integer>>();
			ArrayList<TreeSet<Integer>> column=new ArrayList<TreeSet<Integer>>();
			for(int i=0;i<n;i++)
			{
				String inputData[]=br.readLine().split(" ");
				TreeSet<Integer> currentRowData=new TreeSet<Integer>();
				row.add(currentRowData);
				for(int j=0;j<n;j++ )
				{
					Integer number=Integer.valueOf(inputData[j]);
					currentRowData.add(number);
					if(i==0)
					{
						column.add(new TreeSet<Integer>());
					}
					column.get(j).add(number);
					if(i==j)
						sum=sum+number;
					
				}
			}
			int rowSum=0;
			int columnSum=0;
			for(TreeSet<Integer> currentRow:row)
			{
				if(currentRow.size()<n)
					rowSum++;
			}
			
			
			for(TreeSet<Integer> currentColumn:column)
			{
				if(currentColumn.size()<n)
					columnSum++;
			}
			
			System.out.println("Case #"+tada+": "+sum+" "+rowSum+" "+columnSum);
		
		}
	}

}
