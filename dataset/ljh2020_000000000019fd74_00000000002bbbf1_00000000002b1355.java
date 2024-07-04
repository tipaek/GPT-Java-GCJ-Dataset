
import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
	  //System.out.prlongln("HI");
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t; i++) {
    	System.out.print("Case #" + i + ": ");
      	solve(in);
    }
  }
  public static void solve(Scanner in){	 
	  int r = in.nextInt();
	  int c = in.nextInt();
	  long[][] square = new long[r][c];
	  for(int i = 0; i < r; i++) {
		  for(int x = 0; x < c; x++) {
			  square[i][x] = in.nextLong();
		  }
	  }
	  long ret = sum(square);
	  ArrayList<Integer[]> list = new ArrayList<Integer[]>();
	  iterate(square, list);
	  while(list.size() != 0) {
		  //System.out.prlongln(ret);
		  for(Integer[] elem: list) {
			  //System.out.prlongln(elem[0] + " " + elem[1]);
			  square[elem[0]][elem[1]] = -1;
		  }
		  ret += sum(square);
		  list = new ArrayList<Integer[]>();
		  iterate(square, list);
	  }
	  System.out.println(ret);
	  
  }
  public static void iterate(long[][] square, ArrayList<Integer[]> list) {
	  for(int i = 0; i < square.length; i++) {
		  for(int x = 0; x < square[i].length; x++) {
			  //System.out.prlongln(i + " " + x + " " + square[i][x]);
			  if(square[i][x] == -1) continue;
			  long validNeighbors = 0;
			  long sumOfNeighbors = 0;
			  for(int n = i - 1; n >= 0; n--) {
				  if(square[n][x] != -1) {
					  //System.out.prlongln("N");
					  validNeighbors++;
					  sumOfNeighbors += square[n][x];
					  break;
				  }
			  }
			  for(int s = i + 1; s < square.length; s++) {
				  if(square[s][x] != -1) {
					  //System.out.prlongln("S: " + square[s][x]);
					  validNeighbors++;
					  sumOfNeighbors += square[s][x];
					  break;
				  }
			  }
			  for(int w = x - 1; w >= 0; w--) {
				  if(square[i][w] != -1) {
					  //System.out.prlongln("W: " + square[i][w]);
					  validNeighbors++;
					  sumOfNeighbors += square[i][w];
					  break;
				  }
			  }
			  for(int e = x + 1; e < square[i].length; e++) {
				  if(square[i][e] != -1) {
					  //System.out.prlongln("E: " + square[i][e]);
					  validNeighbors++;
					  sumOfNeighbors += square[i][e];
					  break;
				  }
			  }
			  //System.out.prlongln("(" + i + ", " + x + ") " + validNeighbors + " " + sumOfNeighbors);
			  if(validNeighbors == 0) continue;
			  if(square[i][x]*validNeighbors < sumOfNeighbors) {
				  list.add(new Integer[] {i, x});
			  }
			  
			  
		  }
	  }
  }
  public static long sum(long[][] square) {
	  long ret = 0;
	  for(int i = 0; i < square.length; i++) {
		  for(int x = 0; x < square[i].length; x++) {
			  if(square[i][x] != -1) ret+=square[i][x];
			  //System.out.prlong(square[i][x] + " ");
			  
		  }
		  //System.out.prlongln();
	  }
	  return ret;
  }


}