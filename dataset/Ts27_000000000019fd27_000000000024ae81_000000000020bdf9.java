import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String a[]) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine()),test=1;
		while(t-->0) {
			int n=Integer.parseInt(br.readLine());
			int arr[][]=new int[2][n];
			int flag=0;
			TreeMap<Integer,Integer> tree_map=new TreeMap<Integer,Integer>();
			TreeMap<Integer,Integer> c_map=new TreeMap<Integer,Integer>();
			TreeMap<Integer,Integer> j_map=new TreeMap<Integer,Integer>();
			LinkedHashMap<Integer,Character> hash_map=new LinkedHashMap<Integer,Character>();
			for(int i=0;i<n;i++) {
				String str=br.readLine();
				String temp[]=str.split(" ");
				tree_map.put(Integer.parseInt(temp[0]),Integer.parseInt(temp[1]));
				hash_map.put(Integer.parseInt(temp[0])*10000+Integer.parseInt(temp[1]),'A');
			}
			for(Map.Entry<Integer,Integer> entry : tree_map.entrySet()) {
				
				if(c_map.isEmpty()) {
					c_map.put(entry.getKey(),entry.getValue());
					hash_map.put(entry.getKey()*10000+entry.getValue(),'C');
					//System.out.println("value"+entry.getKey()+"added in C");
				}
				else if(c_map.lastEntry().getValue()<=entry.getKey()) {
					c_map.put(entry.getKey(),entry.getValue());
					hash_map.put(entry.getKey()*10000+entry.getValue(),'C');
					//System.out.println("value"+entry.getKey()+"added in C");
				}
				else if(j_map.isEmpty()) {
					j_map.put(entry.getKey(),entry.getValue());
					hash_map.put(entry.getKey()*10000+entry.getValue(),'J');
					//System.out.println("value"+entry.getKey()+"added in J");
				}
				else if(j_map.lastEntry().getValue()<=entry.getKey()) {
					j_map.put(entry.getKey(),entry.getValue());
					hash_map.put(entry.getKey()*10000+entry.getValue(),'J');
					//System.out.println("value"+entry.getKey()+"added in J");
				}
				else {
					//System.out.println("Case #"+test+": IMPOSSIBLE");
					flag=1;

					continue;
				}
			}
				
			
			if(flag==1)
				System.out.print("Case #"+test+": IMPOSSIBLE");
			else
			{	System.out.print("Case #"+test+": ");
				for(Map.Entry<Integer,Character> entry : hash_map.entrySet()) {
					System.out.print(entry.getValue());
				}
			}
			System.out.println();
			tree_map.clear();
			hash_map.clear();
			c_map.clear();
			j_map.clear();
			test++;
			//HashMap<int,int> c;
			//HashMap<int,int> j;			
		}
	}
}