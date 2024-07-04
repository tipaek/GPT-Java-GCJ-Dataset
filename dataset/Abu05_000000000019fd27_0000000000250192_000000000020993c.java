import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	
	static boolean DEBUG=false;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		long beginTime = System.nanoTime();
		
		InputStream is = DEBUG ? new FileInputStream("resources/codejam2020/qualification/vestigium.in") : System.in;
		try(Scanner scanner=new Scanner( new BufferedReader(new InputStreamReader(is) ) )){
		
		int testCount = scanner.nextInt();
		
		for (int testNumber = 1; testNumber <= testCount; testNumber++) {
			
			int n=scanner.nextInt();
			
			int[][] elements=new int[n][n];
			
			int trace=0;
			
			int numberOfRepeatedRows=0;
			
			int numberOfRepeatedColumn=0;
			
			for(int i=0;i<n;i++) {
				
				ArrayList<Integer> list=new ArrayList<Integer>();
				
				boolean rowIdentified=false;
				for(int j=0;j<n;j++) {
					elements[i][j]=scanner.nextInt();
					
					if(list.contains(elements[i][j]) && !rowIdentified) {
						numberOfRepeatedRows++;
						rowIdentified=true;
					}
			
				    list.add(elements[i][j]);
			
					if(i==j) {
					trace=trace+elements[i][j];
					
					}
				
				}
			}
			
			
			for(int i=0;i<n;i++) {
				ArrayList<Integer> list=new ArrayList<Integer>();
				boolean columnIdentified=false;
				
				for(int j=0;j<n;j++) {
				
					if(list.contains(elements[j][i]) && !columnIdentified) {
						numberOfRepeatedColumn++;
					    columnIdentified=true;
					}
					
					list.add(elements[j][i]);
						
					}
					
				}
					
		    System.out.println("Case #"+testNumber+":"+
		    " "+trace+" "+numberOfRepeatedRows+" "+numberOfRepeatedColumn);		
		   
		}
		
	}
	}

}
