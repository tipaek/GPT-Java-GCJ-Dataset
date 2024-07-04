import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int q = sc.nextInt();
    
    for(int i = 0; i<q; i++) {
    	System.out.println("case " + (i+1));
    	int t = sc.nextInt();
    	int[][] mat = new int[t][t];
    	
    	int diag = 0;
    	HashSet<Integer> h = new HashSet<Integer>(); 
    	int col = 0;
    	int row = 0;
    	
    	
    	for(int k =0; k<t; k++) {
    		for(int j=0; j<t; j++) {
    			mat[k][j] = sc.nextInt();
    			System.out.println(mat[k][j]);
    			if(k==j) {
    				diag+=mat[k][j];
    				
    			}
    		}
    	}
    	
    	
    	for(int k = 0; k<t; k++) { //rows
    		h = new HashSet<Integer>();
    		for(int a = 0; a<t; a++) {
    			if(h.add(mat[k][a]) == false) {
    				row++;
    				break;
    			}
    		}
    	}
    	for(int k = 0; k<t; k++) { //rows
    		h = new HashSet<Integer>();
    		for(int a = 0; a<t; a++) {
    			if(h.add(mat[a][k]) == false) {
    				col++;
    				break;
    			}
    		}
    	}
    	
    	
    	System.out.println("a"+diag);
    	System.out.println("row"+row);
    	System.out.println("col"+col);
    }
    
    System.out.println("aaa");
  }
}
