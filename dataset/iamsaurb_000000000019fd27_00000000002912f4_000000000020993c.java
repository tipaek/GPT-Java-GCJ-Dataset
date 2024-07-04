

import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner sc = new Scanner(System.in); 
        int T = sc.nextInt();
        for(int l = 1; l<=T;l++) {
            int N = sc.nextInt();
            int trace = 0;
            int i,j,k,r = 0, c = 0;
            List<Map<Integer,Integer>> row = new ArrayList<Map<Integer,Integer>>();
            for(i=0;i<N;i++)
            {
                Map<Integer,Integer> values = new HashMap<>();
                Map<Integer,Integer> rowCount;
                for(j=0;j<N;j++)
                {
                    
                    k = sc.nextInt();
                    if(row.size() < N)
                    {
                        row.add(new HashMap<Integer,Integer>());
                    }
                    rowCount = row.get(j);
                    rowCount.put(k,1);
                    values.put(k,1);
                    if(i == j) {
                        trace += k;
                    }
                }
                if (values.size() < N)
                {
                    r++;
                }
            }
            for(Map<Integer,Integer> entry:row)
            {
                if(entry.size()<N)
                {
                    c++;
                }
            }
            System.out.println("Case #"+l+": "+trace+" "+r+" "+c);
        }
	}
}