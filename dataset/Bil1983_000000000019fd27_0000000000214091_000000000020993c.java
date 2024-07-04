import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class Solution {
	static Scanner sc;
  public static void main(String[] args)throws Exception{
	  sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	  //sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream(new File("src/input.txt"))))); 
    
     int t = sc.nextInt();
     
    for(int test = 1;test<=t;test++){
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////    	
    	int N = sc.nextInt();
    	sc.nextLine();
    	
    	int[][] tab = readIntArray2Dims(N, N);
    	List<Set<Integer>> rows = new ArrayList<Set<Integer>>();
    	List<Set<Integer>> cols = new ArrayList<Set<Integer>>();
    	int k =0, c=0, r = 0;
    	for(int i = 0; i<N; i++) {
    		k+= tab[i][i];
    	}
    	
    	for(int i = 0; i<N; i++) {
    		Set<Integer> setR = new HashSet<Integer>();
    		Set<Integer> setC = new HashSet<Integer>();
    		for(int j = 0; j<N; j++) {
    			setR.add(tab[i][j]);
    			setC.add(tab[j][i]);
    		}
    		rows.add(setR);
    		cols.add(setC);
    	}
    	for(Set<Integer> ro : rows) {
    		if(ro.size()!=N) r++;
    	}
    	for(Set<Integer> co : cols) {
    		if(co.size()!=N) c++;
    	}
    	System.out.println("Case #"+test+": "+k+" "+r+" "+c);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    	
    }

    
    
  }
  static int[][] readIntArray2Dims(int nbRows, int nbCols) {
        int[][] array = new int[nbRows][nbCols];
        for (int i = 0; i < nbRows; i++) {
      	  for (int j = 0; j < nbCols; j++) { 
      		  array[i][j] = sc.nextInt();
      	  }
        }	       
        return array;
	  }
}