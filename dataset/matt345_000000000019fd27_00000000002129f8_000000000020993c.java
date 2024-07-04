import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
public class Solution {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int cases=Integer.parseInt(br.readLine());
		ArrayList<Integer>tracevalues=new ArrayList<Integer>();
		ArrayList<Integer>repeatingrowvalues=new ArrayList<Integer>();
		ArrayList<Integer>repeatingcolvalues=new ArrayList<Integer>();
		for(int a=0;a<cases;a++) {
			int size=Integer.parseInt(br.readLine());
			int[][]grid=new int[size][size];
			int[]nums=new int[size+1]; //keep track of how many of each number are in the matrix
			int repeatingrows=0;
			int repeatingcol=0;
			int trace=0;
			
			
			
			//read input
			for(int i=0;i<size;i++) {
				String []s=br.readLine().split(" ");
				for(int j=0;j<size;j++) {
					grid[i][j]=Integer.parseInt(s[j]);
				}
			}
			
			
			//check rows
			for(int i=0;i<size;i++) {
				for(int j=0;j<size;j++) {
					if(nums[grid[i][j]]>0) { //if a number has already occured
						repeatingrows++;
						break;
					}
					nums[grid[i][j]]+=1;
				}
				Arrays.fill(nums, 0);
			}
			
			
			
			//check cols
			for(int i=0;i<size;i++) {
				for(int j=0;j<size;j++) {
					if(nums[grid[j][i]]>0) { //if a number has already occured IN COL
						repeatingcol++;
						break;
					}
					nums[grid[j][i]]+=1;
				}
				Arrays.fill(nums, 0);
			}
			
			//trace value
			for(int i=0;i<size;i++) {
				trace+=grid[i][i];
			}
			
			
			//store all
			tracevalues.add(trace);
			repeatingrowvalues.add(repeatingrows);
			repeatingcolvalues.add(repeatingcol);
		}
		
		for(int i=0;i<tracevalues.size();i++) {
			System.out.println("Case #"+(i+1)+": "+tracevalues.get(i)+" "+repeatingrowvalues.get(i)+" "+repeatingcolvalues.get(i));
		}
	}

}
