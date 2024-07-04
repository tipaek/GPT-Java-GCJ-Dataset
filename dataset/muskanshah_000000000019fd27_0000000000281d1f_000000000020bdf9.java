

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;
import org.javatuples.Pair;


public class Solution {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int t=sc.nextInt();int kk=1;
	while(t-->0)
	{
		ArrayList<Pair<Integer,Pair<Integer,Integer>>>apos=new ArrayList<Pair<Integer,Pair<Integer,Integer>>>();
		
		int n=sc.nextInt();
		int k=0;
		for (int ll = 0; ll <n; ll++)
		{
			int i=sc.nextInt();
			int j=sc.nextInt();
			
			apos.add(new Pair(k,(new Pair(i, j))));
			k++;
		}
	apos.sort(new Comparator<Pair<Integer,Pair<Integer,Integer>>>() {

			@Override
			public int compare(Pair<Integer, Pair<Integer, Integer>> o1, Pair<Integer, Pair<Integer, Integer>> o2) 
			{
				if(o1.getValue().getKey()>o2.getValue().getKey())
				{
				return 1;
				}
					
				else if(o1.getValue().getKey().equals(o2.getValue().getKey()))
				{
					return 0;
				}
				else {
					return -1;
				}
				
			}
		
		});
		Vector<Pair<Integer,Character>>v=new Vector<>();
		v.add(new Pair(apos.get(0).getKey(),'C'));
		int flag=1;
		for (int i = 1; i < n; i++) {
			int sub=apos.get(i).getValue().getKey()-apos.get(i-1).getValue().getValue();
			if(sub<0)
			{
				if(v.get(i-1).getValue()=='C')
				{ 	if((i-2)>=0)
						{
						if(apos.get(i).getValue().getKey()-apos.get(i-2).getValue().getValue()<0 && v.get(i-2).getValue()=='J')
						{
						 flag=0;
						 break;
						}
						else {
							v.add(new Pair(apos.get(i).getKey(),'J'));
					     	}
													}
					else
					{
						v.add(new Pair(apos.get(i).getKey(),'J'));
					}
							
					
				}
				else
				{
					if(i-2>=0)
					{ 
						if(apos.get(i).getValue().getKey()-apos.get(i-2).getValue().getValue()<0 && v.get(i-2).getValue()=='C')
							{
							   
							   flag=0;
							   break;
							}
						else
							{
							
						    v.add(new Pair(apos.get(i).getKey(),'C'));
				     		}
					}
					else
					{
						v.add(new Pair(apos.get(i).getKey(),'C'));
					}
						
					
				}
			}
			else
			{
				v.add(new Pair(apos.get(i).getKey(),v.get(i-1).getValue()));
			}
		}
		v.sort(new Comparator<Pair<Integer, Character>>() {

			@Override
			public int compare(Pair<Integer, Character> o1, Pair<Integer, Character> o2) {
				if(o1.getKey()>o2.getKey())
					return 1;
				else if(o1.getKey().equals(o2.getKey()))
					return 0;
				else
					return -1;
			}
		});
		System.out.print("Case #"+kk+": ");
		if(flag==0)
			System.out.print("IMPOSSIBLE");
		else
		for (int j = 0; j < v.size(); j++) {
			System.out.print(v.get(j).getValue());
		}
		System.out.println();
		kk++;
		
	}
	
}
}
