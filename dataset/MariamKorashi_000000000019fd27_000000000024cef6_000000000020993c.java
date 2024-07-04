package Solution;
import java.util.*;
import java.util.Map.Entry;
import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; i++) {
          int N = in.nextInt();
          //int m = in.nextInt();
          int [][] matrix = new int[N][N];
          int trace = 0;
          int rowsWithDuplicates = 0;
          int colsWithDuplicates = 0;
        
          		for(int j = 0; j< matrix.length; j++) {
          			for(int k = 0; k<matrix.length; k++) {
          				matrix[j][k] = in.nextInt();
          			}
          		}
          		
          		//get the trace of the matrix & row duplicates:
          		for(int j = 0; j< matrix.length; j++) {
          			 Map<Integer,Integer> map = new HashMap<>(); 
          			 int count = 0;
          			for(int k = 0; k<matrix.length; k++) {
          				if(j == k) {
          					trace += matrix[j][k];
          				}
          				System.out.println(j);
          				System.out.println(k);
          		       
          				if(map.containsKey(matrix[j][k])){ 
          	                count = map.get(matrix[j][k]); 
          	                map.put(matrix[j][k], count + 1); 
          	            } 
          	            else{ 
          	                map.put(matrix[j][k], 1); 
          	            } 
          			}
          			for(Entry <Integer,Integer> entry : map.entrySet()) 
          	        { 
          	            // if frequency is more than 1 
          	            // print the element 
          	            if(entry.getValue() > 1){ 
          	                rowsWithDuplicates++;
          	                break;
          	            } 
          	        } 
          		}
          		
          		for(int k = 0; k< matrix.length; k++) {
          			Map<Integer,Integer> map = new HashMap<>(); 
         			 int count = 0;
          			for(int j = 0; j<matrix.length; j++) {
          				if(map.containsKey(matrix[j][k])){ 
          	                count = map.get(matrix[j][k]); 
          	                map.put(matrix[j][k], count + 1); 
          	            } 
          	            else{ 
          	                map.put(matrix[j][k], 1); 
          	            } 
          			}
          			for(Entry <Integer,Integer> entry : map.entrySet()) 
          	        { 
          	            // if frequency is more than 1 
          	            // print the element 
          	            if(entry.getValue() > 1){ 
          	                colsWithDuplicates++;
          	                break;
          	            } 
          	        }
          		}
  
          System.out.println("Case #" + i + ": " + trace + " " + rowsWithDuplicates + " " + colsWithDuplicates);// + " " + (n * m));
        }
        
      }
    }