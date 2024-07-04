import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); //Number of cases
        for (int i = 1; i <= t; ++i) {
        	int n = in.nextInt(); //Matrix size
        	int[] matrix = new int[n*n];
        	for(int j = 0; j < matrix.length; j++){
        		matrix[j] = in.nextInt();
        	}
        	int trace = 0;
        	for(int j = 1; j <= matrix.length; j+= n+1){
        		trace += matrix[j-1];
        		//System.out.println(j+","+matrix[j-1]+","+trace);
        	}
        	
        	int a = 0;
        	for(int j = 0; j < n; j++){
        		ArrayList<Integer> items = new ArrayList<Integer>();
        		for(int k = 0; k < n; k++){
        			int item = matrix[k + n*j];
        			if(!items.contains(item)){
        				items.add(item);
        			}
        			else{
        				a++;
        				break;
        			}
        		}
        	}
        	
        	int b = 0;
        	for(int j = 0; j < n; j++){
        		ArrayList<Integer> items = new ArrayList<Integer>();
        		for(int k = 0; k < n; k++){
        			int item = matrix[j + n*k];
        			if(!items.contains(item)){
        				items.add(item);
        			}
        			else{
        				b++;
        				break;
        			}
        		}
        	}
        	
        	System.out.println("Case #"+i+": "+trace+" "+a+" "+b);
        }
	}
}