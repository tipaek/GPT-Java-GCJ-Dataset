import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;


public class Solution 
{
    static class Query
    {
        public long Q;
        public String R;
        
        public Query(long q, String r)
        {
            Q = q;
            R = r;
        }
    }
    
    static class QuerySort implements Comparator<Query>
    {
        @Override
        public int compare(Query o1, Query o2)
        {
            return Long.compare(o1.Q, o2.Q);
        }
        
    }
    
    public static void main(String[] args) throws IOException 
    {
       BufferedReader input = new BufferedReader(new InputStreamReader(System.in));      
       int t = Integer.parseInt(input.readLine());   
       
       for(int currCase = 1; currCase <= t; currCase++)
       {
           ArrayList<Query> queries = new ArrayList<>();
           input.readLine();
           
           for(int i = 0; i < 10000; i++)
           {
               String[] params = input.readLine().split(" ");
               queries.add(new Query(Long.parseLong(params[0]), params[1]));
           }
           
           queries.sort(new QuerySort());
           String solution = "";
           HashSet<Character> seen = new HashSet<>(); 
           //System.out.println("Done inputting");
           
           for(int i = 0; i < queries.size(); i++)
           {
               String R = queries.get(i).R;
               
               for(int j = 0; j < R.length(); j++)
               {
                   char currChar = R.charAt(j);
                   
                   if(!seen.contains(currChar))
                   {
                       //System.out.println("adding " + currChar);
                       seen.add(currChar);
                       solution += currChar;
                   }
                   
               }
           }
           
           solution = solution.charAt(solution.length() - 1) + solution.substring(0, solution.length() - 1);
           System.out.println("Case #" + currCase + ": " + solution);
       }
    }
}
