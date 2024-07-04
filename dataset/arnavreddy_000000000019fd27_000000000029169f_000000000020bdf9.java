//package USACO;
import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int t = in.nextInt();
		for(int count = 1; count <= t; count++){
			
			int n= in.nextInt();
			
			Interval[] intervals = new Interval[n];
			for(int i = 0; i<n; i++){
				intervals[i] = new Interval(in.nextInt(), in.nextInt(), i);
			}
			Arrays.sort(intervals);
			
			Interval cam = null, jam = null;		
			String[] ans = new String[n];
			boolean impos = false;
			for(int index = 0; index<intervals.length; index++){
				
				if(cam == null) {
					
					cam = intervals[index];
					ans[intervals[index].ogIndex] = "C";
				}
				
				else{
					
					if(cam.end <= intervals[index].start){
						cam = intervals[index];
						ans[intervals[index].ogIndex] = "C";
					}
					else{
						if(jam == null){
							
							jam = intervals[index];
							ans[intervals[index].ogIndex] = "J";
							
						}
						else{
							if(jam.end <= intervals[index].start){
								jam= intervals[index];
								ans[intervals[index].ogIndex] = "J";
							}
							else {
								System.out.println("Case #" + count + ": IMPOSSIBLE");
								impos = true;
							}
							
						}
				}
				}
				
			}
			if(impos==false){
					
					System.out.print("Case #" + count +": ");
					
					for(String str : ans) System.out.print(str);
					System.out.println();
			}
		}
	}
}

class Interval implements Comparable<Interval>{
	int ogIndex;
	int start;
	int end;
	

	public Interval(int start, int end, int index){
		this.ogIndex = index;
		this.start = start;
		this.end = end;
		

	}

	public int compareTo(Interval i){
		if(i.start == start){
			return ((Integer)end).compareTo(i.end);
		}
		return ((Integer)start).compareTo(i.start);
	}
}




/*import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for(int i = 1; i<=t;i++) {
    	int n = in.nextInt();
    	int[][] mat = new int[n][n];
    	for(int r = 0; r<n;r++) {
    		for(int c = 0; c<n;c++) {
    			mat[r][c] = in.nextInt();
        	}
    		//System.out.println(n);
    	}
    	
    	System.out.println("Case #"+i + ": " + trace(mat,n,t) + " " + row(mat,n) + " " + col(mat,n));
    }   
  }
  public static long trace(int[][] mat, int n, int t){
	 // System.out.println("hi");
	 long count = 0;
	 for(int r = 0; r<n;r++) {
 		for(int c = 0; c<n;c++) {
 			if(c==r)count+=mat[r][c];
     	}
 	}
	return count;  
  }
  
  public static int col(int[][] mat, int n) {
	  //System.out.println("hiye");
	  int count = 0;  
		 for(int c = 0; c<n;c++) {
			 String s = "";
	 		for(int r = 0; r<n;r++) {
	 			if(s.contains(mat[r][c]+"")) {
	 				count++;
	 				break;
	 			}
	 			s+=mat[r][c]+"";
	     	}
	 	}
	  return count;
  }
  public static int row(int[][] mat, int n) {
	  //System.out.println("hello");
	  int count = 0;  
		 for(int r = 0; r<n;r++) {
			 String s = "";
	 		for(int c = 0; c<n;c++) {
	 			if(s.contains(mat[r][c]+"")) {
	 				count++;
	 				break;
	 			}
	 			s+=mat[r][c]+"";
	     	}
	 	}
	  return count;
  }
}*/