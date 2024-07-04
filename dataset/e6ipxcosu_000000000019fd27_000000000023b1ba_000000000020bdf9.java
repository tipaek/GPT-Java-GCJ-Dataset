import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Vector;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;

public class Solution {
    public static class task{
        int start;
        int end;
        int orig;
    }
    
	public static void main(String[] args) throws IOException {
		Scanner s1 = new Scanner(System.in);
		int T = Integer.parseInt(s1.nextLine());
	    for(int i = 1; i <= T; i++)
	    {
	        int n = Integer.parseInt(s1.nextLine());
	        ArrayList<task> tasks = new ArrayList<>();
	        Set<Integer> c = new HashSet<>();
	        for(int j = 0; j < n; j++)
	        {
	            String[] s = s1.nextLine().split(" ");
	            task k = new task();
	            k.start = Integer.parseInt(s[0]);
	            k.end = Integer.parseInt(s[1]);
	            k.orig = j;
	            tasks.add(k);
	        }
	        ArrayList<task> origlist = new ArrayList(tasks); 
	        Collections.sort(tasks, (Comparator.<task>
                        comparingInt(t1 -> t1.end)));
	        int currtime = 0;
	        for(int j = 0; j < n; j++)
	        {
	            if(tasks.get(j).start >= currtime)
	            {
	                c.add(tasks.get(j).orig);
	                currtime = tasks.get(j).end;
	            }
	        }
	        String o = "";
	        for(int j = 0; j < n; j++)
	        {
	            if(c.contains(j))
	                o += "C";
	            else
	                o += "J";
	        }
	        currtime = 0;
	        for(int j = 0; j < n; j++)
	        {
	            if(o.charAt(j) == 'J')
	            {
	                if(origlist.get(tasks.get(j).orig).start < currtime)
	                {
	                    o = "IMPOSSIBLE";
	                    break;
	                }
	                else
	                {
	                    currtime = origlist.get(tasks.get(j).orig).end;
	                }
	            }
	        }
	        System.out.println("Case #" + i + ": " + o);
	    }
	}

}
