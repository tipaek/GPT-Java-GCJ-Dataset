import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

public class Solution {
	
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.valueOf(br.readLine());
		
		for(int tada=1; tada<=t;tada++)
		{
			
			int n=Integer.valueOf(br.readLine());
			ArrayList<ArrayList<String>> data=new ArrayList<ArrayList<String>> ();
			int max=0;
			for(int i=0;i<n;i++)
			{
				String currentData[]=br.readLine().split("\\*");
				if(max<currentData.length)
					max=currentData.length;
				ArrayList<String> temp=new ArrayList<String>();
				temp.addAll(Arrays.asList(currentData));
				data.add(temp);
				
			}
			
			ArrayList<ArrayList<String>> dataAnother=new ArrayList<ArrayList<String>>();
			
			for(int i=0;i<max;i++) {
				ArrayList<String> temp=new ArrayList<String>();
			for(int j=0;j<n;j++)
				{
				String value=null;
				try {
				value=data.get(j).get(i);
				}
				catch(Exception e)
				{
					
				}
				if(value!=null)
					temp.add(value);
					
				}
			Comparator<String> comp = 
					(String o1, String o2)->{return (o2.length()-o1.length()); };
			Collections.sort(temp,comp);
			dataAnother.add(temp);
			}
			
			boolean shouldTrue=true;
			StringBuilder toReturn=new StringBuilder("");
			for(ArrayList<String> xx: dataAnother)
			{
				
				if(isAnySubString(xx))
				{
					toReturn.append(xx.get(0));
				}
				else
				{
					shouldTrue=false;
					break;
				}
			}
			
			if(!shouldTrue)
				System.out.println("Case #"+tada+": *");
			else
			{
				System.out.println("Case #"+tada+": "+toReturn);
			}
		}
		
	}
	
	public static boolean isAnySubString(ArrayList<String> data)
	{
		String first=data.get(0);
		for(int i=1;i<data.size();i++ )
		{
			if(!first.contains(data.get(i))){
				return false;
			}
		}
		return true;
	}

}
