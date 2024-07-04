import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Solution {

	public static void main(String[] args) throws Exception{

BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Integer numberOfTestCases = Integer.parseInt(br.readLine().trim());
		
		for(int i =1; i <= numberOfTestCases;i++)
		{
			Integer numberOFRandC = Integer.parseInt(br.readLine().trim());
			int [][] input = new int[numberOFRandC][numberOFRandC];
			
			for(int j =0; j < numberOFRandC;j++)
			{
				String[] row = br.readLine().split(" ");
				for(int k =0; k < numberOFRandC;k++)
				{
					input[j][k] = Integer.parseInt(row[k]);
				}
			}
			
			int trace = 0;
			int traceRow = 0;
			int traceColumn = 0;
			
			HashSet<Integer> rowSet = new HashSet<Integer>();
			HashSet<Integer> columnSet = new HashSet<Integer>();
			
			for(int j =0; j < numberOFRandC; j++)
			{
				trace += input[j][j];
			}
			
			for(int j =0; j < numberOFRandC;j++)
			{
				rowSet = new HashSet<Integer>();
				columnSet = new HashSet<Integer>();
				for(int k =0; k < numberOFRandC;k++)
				{
					rowSet.add(input[j][k]);
					columnSet.add(input[k][j]);
				}
				if(rowSet.size() != numberOFRandC)
				{
					traceRow++;
				}
				if(columnSet.size() != numberOFRandC)
				{
					traceColumn++;
				}
				
			}
			
			System.out.println("Case #" + i + ": " + trace + " " + traceRow + " " + traceColumn);
		}
	}

}
