/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int total = Integer.parseInt(br.readLine()); 
        int t = 1;
        while (t<=total) {
            
            int n = Integer.parseInt(br.readLine()); 
            ArrayList<Integer> start = new ArrayList<>();
            ArrayList<Integer> end = new ArrayList<>();
            
            char[] sol = new char[n];
            
            int CEnd = 0;
            int JEnd = 0;
            
            boolean imp = false;
            
            for (int i=0; i<n; i++) {
                String in = br.readLine();
                String[] arr = in.split(" ");
                start.add(Integer.parseInt(arr[0]));
                end.add(Integer.parseInt(arr[1]));
            }
            
            // System.out.println(n + " " + start + " " + end);
            ArrayList<Integer> sortedStart = new ArrayList<Integer>(start);
            Collections.sort(sortedStart);
            
            // System.out.println(sortedStart);
            
            for (int i=0; i<sortedStart.size(); i++) {
                int startTime = sortedStart.get(i);
                int endTime = end.get(start.indexOf(startTime));
                
                if (CEnd <= startTime) {
                    sol[start.indexOf(startTime)] = 'C';
                    CEnd = endTime;
                } else if (JEnd <= startTime) {
                    sol[start.indexOf(startTime)] = 'J';
                    JEnd = endTime;
                } else {
                    imp = true;
                    break;
                }
            }
            String ans = new String(sol);
            if (imp == false) {
                System.out.println("Case #" + t + ": " + ans);
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
            t++;
        }
        
	}
}
