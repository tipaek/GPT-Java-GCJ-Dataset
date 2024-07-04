    import java.util.*;
    import java.io.*;
    public class Solution {
    	public static void main(String[] args) throws FileNotFoundException {
    		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    		//File f = new File("tests/1.txt");
    		//Scanner in = new Scanner(f);
    		int testCount = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
			HashSet<Integer> set = new HashSet<Integer>();
			boolean foundRepeat;
    		for (int test = 1; test <= testCount; test++) {
    			int N = in.nextInt();
    			int[][] matrix = new int[N][N];
    			int trace = 0;
    			int traceCount = 0;
    			int repeatRow = 0;
    			int repeatCol = 0;
    			for(int row = 0; row < N; row++) {
    				set.clear();
    				foundRepeat = false;
    				for(int col = 0; col < N; col++) {
    					int current = in.nextInt();
        				if(traceCount == 0) {
        					trace += current;
        					traceCount = N;
        				}
        				else { 
        					traceCount--; 
        				}
        				
        				if(!foundRepeat) {
        					if(set.contains(current)) {
        						repeatRow++;
        						foundRepeat = true;
        					}
        					else {
        						set.add(current);
        					}
        				}
    					matrix[row][col] = current;
        			}
    			}
    			
    			
    			for(int col = 0; col < N; col++) {
    				set.clear();
    				foundRepeat = false;
    				for(int row = 0; row < N; row++) {
    					int current = matrix[row][col];
    					
        				if(!foundRepeat) {
        					if(set.contains(current)) {
        						repeatCol++;
        						foundRepeat = true;
        					}
        					else {
        						set.add(current);
        					}
        				}
        			}
    			}
          
          
          
          
          
          
          
          
          
    			if(test == testCount) {
    				System.out.print("Case #" + test + ": " + trace + " " + repeatRow + " " + repeatCol);
    			}
    			else {
    				System.out.println("Case #" + test + ": " + trace + " " + repeatRow + " " + repeatCol);

    			}
        }
        in.close();
      }
    }