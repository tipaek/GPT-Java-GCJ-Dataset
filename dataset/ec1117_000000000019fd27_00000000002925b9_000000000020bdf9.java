import java.util.*;
import java.io.*;
public class Solution {
	static ArrayList<Pair> nosort=new ArrayList<Pair>();
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n=in.nextInt();
      ArrayList<Integer> J=new ArrayList<Integer>();
      ArrayList<Pair> jobs=new ArrayList<Pair>();
      ArrayList<Pair> alljobs=new ArrayList<Pair>();//sorted
      nosort=new ArrayList<Pair>();
      int[] done=new int[n];
      for(int j=0;j<n;j++) {
    	  int starts=in.nextInt();
    	  int stops=in.nextInt();
    	  alljobs.add(new Pair(starts,stops));
    	  nosort.add(new Pair(starts,stops));
      }
      Collections.sort(alljobs);
      int stop=Integer.MIN_VALUE;
      for(int j=0;j<n;j++) {
    	  int inStart=alljobs.get(j).a;
    	  int inStop=alljobs.get(j).b;
    	  if(inStart>=stop) {
    		  stop=inStop;
    	  }
    	  else {
    		  J.add(j+1);
    		  jobs.add(new Pair(inStart,inStop));
    	  }
      }
      boolean works=true;
      for(int j=1;j<J.size();j++) {
    	  int nStart=jobs.get(j).a;
    	  int nStop=jobs.get(j-1).b;
    	  if(!(nStart>=nStop)) {
    		  works=false;
    	  }
      }
      
      
      
      if(works) {
    	StringBuilder sb=new StringBuilder();
    	for(int j=1;j<=n;j++) {
    		if(J.contains(j)) {
    			int index=find(alljobs.get(j-1).a,alljobs.get(j-1).b);
    			done[index]=1;
    		}
    	}
    	for(Integer a:done) {
    		if(a==1) {
    			sb.append("J");
    		}
    		else {
    			sb.append("C");
    		}
    	}
    	System.out.println("Case #" + i + ": " + sb);
      }
      else {
    	  System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
      }
      
    }
  }
  private static int find(int a, int b) {
	for(int i=0;i<nosort.size();i++) {
		if(nosort.get(i).a==a && nosort.get(i).b==b) {
			return i;
		}
	}
	return 0;
}
static class Pair implements Comparable<Pair>{
	  int a;
	  int b;
	  Pair(int c, int d){
		  a=c;
		  b=d;
	  }
	@Override
	public int compareTo(Pair arg0) {
		// TODO Auto-generated method stub
		return this.a-arg0.a;
	}
  }
}