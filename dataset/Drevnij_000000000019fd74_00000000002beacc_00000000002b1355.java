
import java.util.*;
import java.io.*;

public class Solution {
	  public static void main(String[] args) {
		    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		    int t = in.nextInt();  
		    for (int x = 1; x <= t; x++) {
		    	int r = in.nextInt();
		    	int c = in.nextInt();
		    	
		    	int[][] floor = new int[r][c];
		    	for (int i=0; i<r; i++) {
		    		for (int j=0; j<c; j++) {
		    			floor[i][j] = in.nextInt();
		    		}
		    	}
		    	
		    	int solution =0;
		    	
		    	boolean elim = true;
		    	while (elim) {
		    		elim=false;
			    	int[][] newFloor = new int[r][c];

			    	for (int i=0; i<r; i++) {
			    		for (int j=0; j<c; j++) {
			    			solution+=floor[i][j];
			    			if (floor[i][j] !=0 && eliminate(floor, i, j)) {
			    				newFloor[i][j]=0;
			    				elim = true;
			    			}else
			    				newFloor[i][j]=floor[i][j];
			    		}
			    	}

			    	floor=newFloor;
		    		
		    	}
		    	
		    		
		    	System.out.println("Case #"+ x+": "+solution);

		    }
		}
	  
	  private static boolean eliminate(int[][] floor, int r, int c) {
		  boolean result = false;
		  int up=0;
		  for (int i=r-1; i>=0; i--) 
			  if (floor[i][c]>0) {
				  up=floor[i][c];
				  break;
			  }
		  int down=0;
		  for (int i=r+1; i<floor.length; i++) 
			  if (floor[i][c]>0) {
				  down=floor[i][c];
				  break;
			  }
		  int left=0;
		  for (int i=c-1; i>=0; i--) 
			  if (floor[r][i]>0) {
				  left=floor[r][i];
				  break;
			  }
		  int right=0;
		  for (int i=c+1; i<floor[r].length; i++) 
			  if (floor[r][i]>0) {
				  right=floor[r][i];
				  break;
			  }
		  int partners=0;
		  if (up>0) partners++;
		  if (down>0) partners++;
		  if (left>0) partners++;
		  if (right>0) partners++;
		  if (partners==0) return false;
		  if (up+down+left+right>floor[r][c]*partners) return true;
		  return result;
	  }
	  

}