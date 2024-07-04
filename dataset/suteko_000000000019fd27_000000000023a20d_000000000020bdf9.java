import java.util.*;
import java.io.*;
class Solution{
    public static void main(String args[])
	{
		    try{
		    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		    in.nextLine(); //skipping the first line with number of cases.
		    int N=0;
		    int[][] times;

		    for (int i = 1; i <= t; ++i) {
		      N = in.nextInt();
		      in.nextLine();
		      times = new int[N][3];
		      for(int j=0; j< N; j++)
		      {
		          times[j][0] = in.nextInt();
		          times[j][1] = in.nextInt();
		          times[j][2] = j;
		          try{
		            in.nextLine();
		          }catch(Exception e){}
		      }
		      System.out.println("Case #" + i + ": "+ assign(N, times));

		      }
		    in.close();
		    }catch(Exception e){}
	}
	
	private static String assign(int N, int[][] times)
	{
	    Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] entry1, int[] entry2) {
                 int time1 = entry1[0];
                 int time2 = entry2[0];
                return new Integer(time1).compareTo(new Integer(time2));
            }});
        char[] out = new char[N];
        BitSet c = new BitSet(1441);
        BitSet j = new BitSet(1441);
        boolean cfree = false;
        boolean jfree = false;
        for(int i=0; i< N; i++)
        {
            cfree = (c.get(times[i][0], times[i][1])).cardinality() == 0;
            jfree = (j.get(times[i][0], times[i][1])).cardinality() == 0;
            if(!cfree && !jfree)
             return "IMPOSSIBLE";
            if(cfree)
            {
                c.set(times[i][0], times[i][1]);
                out[times[i][2]] = 'C';
            }else if(jfree)
            {
                j.set(times[i][0], times[i][1]);
                out[times[i][2]] = 'J';                
            }
            
        }
        return new String(out);
	}
}