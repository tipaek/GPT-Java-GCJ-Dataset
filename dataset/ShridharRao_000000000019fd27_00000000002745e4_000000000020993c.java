import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;


public class Solution {
	public static void main(String[] args) {
    	
    	/*File initialFile = new File("Vestigium1.txt");
		InputStream targetStream=null;
	    try {
			targetStream = new FileInputStream(initialFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
        //Scanner in = new Scanner(new BufferedReader(new InputStreamReader(targetStream)));
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        for (int testCase = 1;  testCase<= t; ++testCase) 
        {
        	int array[][];
            int n = in.nextInt();
            array = new int[n][n];
            
           
            int repeatedRows=0;
            for(int i=0;i<n;i++){
            	HashSet<Integer> setRow = new HashSet<>();
            	
            	for(int j=0;j<n;j++)
            	{
            		int current = in.nextInt();
            		
            		setRow.add(current);
            		array[i][j] = current;
            	}
            	if(setRow.size()<n)
            		repeatedRows++;
            	
            }
            
            
            int repeatedCols=0;
            int trace=0;
            for(int i=0;i<n;i++){
            	 HashSet<Integer> setCol = new HashSet<>();
            	 innercol:
            	for(int j=0;j<n;j++)
            	{
            		
            		setCol.add(array[j][i]);
            		if(i==j)
            			trace+=array[j][i];
            		
            	}
            	if(setCol.size()<n)
            		repeatedCols++;
            }
            System.out.println("Case #"+testCase+": "+trace+" "+repeatedRows+" "+repeatedCols);
//            System.out.println("trace:"+trace);
//            System.out.println("repeatedRows:" + repeatedRows);
//            System.out.println("repeatedCols:" + repeatedCols);
            	
            
        }
	}
	

}