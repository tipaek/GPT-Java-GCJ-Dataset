import java.util.*;
import java.util.Map.Entry;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int testcase=Integer.parseInt(sc.nextLine());
		for(int test=1;test<=testcase;test++)
		{
			int N=Integer.parseInt(sc.nextLine());
			int x=0;
			int square[][]=new int[N][N];
			for(int i=0;i<N;i++)
			{
				String s[]=sc.nextLine().split("\\s");
				for (int j = 0; j < N; j++) {
	                square[x][j] = Integer.parseInt(s[j]);
	            }
				x++;
			
			}
			
			int k=countdiag(square);
			int r=countDuplicateRow(square);
			int c=countDuplicateCol(square);
			System.out.println("Case #"+test+": "+k+" "+r+" "+c);
		}
	}
	
	private static int countDuplicateCol(int[][] square) {
		int count=0;
		int x=0;
		for(int i=0;i<square.length;i++)
		{
			HashMap<Integer, Integer> map = new HashMap<>();
			for(int j=0;j<square.length;j++)
			{
				if(map.get(square[j][x]) == null)
				{
					map.put(square[j][x], 1);
				}
				else
				{
					map.put(square[j][x], map.get(square[j][x])+1);
				}
			}
			x++;
			 for(Entry<Integer, Integer> entry : map.entrySet()) 
		        {
				 	if(entry.getValue() > 1){ 
				 		count++;
				 		break;
				 	}
		        }
		}
		return count;
		
	}

	public static int countdiag(int square[][])
	{
		int count =0;
		for (int i = 0; i < square.length; i++) { 
            count += square[i][i];   
        } 
		return count;
		
	}
	public static int countDuplicateRow(int square[][])
	{
		int count=0;
		int x=0;
		for(int i=0;i<square.length;i++)
		{
			HashMap<Integer, Integer> map = new HashMap<>();
			for(int j=0;j<square.length;j++)
			{
				if(map.get(square[x][j]) == null)
				{
					map.put(square[x][j], 1);
				}
				else
				{
					map.put(square[x][i], map.get(square[x][i])+1);
				}
			}
			x++;
			 for(Entry<Integer, Integer> entry : map.entrySet()) 
		        {
				 	if(entry.getValue() > 1){ 
				 		count++;
				 		break;
				 	}
		        }
		}
		return count;
	}

}