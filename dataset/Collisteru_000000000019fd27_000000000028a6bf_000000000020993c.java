import java.util.*;
import java.io.*;
//Use sets for column and row checking?
public class Solution{
  public static void main(String args[]){
      Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      int limit = in.nextInt();
      for(int l = 0; l<limit; l++){ //Main loop
          int size = in.nextInt();
          int[][] arr = new int[size][size];
          for(int r = 0; r<size; r++){ //Row entry
              for(int c = 0; c<size; c++){ //Column entry
                  arr[r][c] = in.nextInt();
              } 
          } 
          //Generate trace
          int T = 0;
          for(int t = 0; t<size; t++) {
        	  T += arr[t][t];
          }
          //Check rows
          int R = 0;
          for(int r = 0; r<size; r++) {
        	  List<Integer> rlist = new ArrayList<Integer>();
        	  for(int num = 0; num<size; num++) {
        		  if(rlist.contains(arr[r][num])) {
        			  R++;
        			  rlist.add(arr[r][num]);
        			  break;
        		  }
        		  else {rlist.add(arr[r][num]);}
        	  }
          }
        //Check columns
          int C = 0;
          for(int c = 0; c<size; c++) {
        	  List<Integer> clist = new ArrayList<Integer>();
        	  for(int num = 0; num<size; num++) {
        		  if(clist.contains(arr[num][c])) {
        			  C++; 
        			  clist.add(arr[num][c]);
        			  break;
        		  }
        		  else {clist.add(arr[num][c]);}
        	  }
          }
          System.out.print("Case #" + (l+1) + ": ");
          System.out.println(T + " " + R + " " + C + " ");
          
      }
      in.close();
  }
}
