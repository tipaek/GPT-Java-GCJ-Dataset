import java.io.*;
import java.util.*;
class Solution {
    public static void main(String args[] ) throws Exception
    {
      BufferedReader st = new BufferedReader(new InputStreamReader(System.in));//FileReader("sample.in.txt"));
      int cases = Integer.parseInt(st.readLine());
      int cur_c = 0;
      next_case:
      while(++cur_c <= cases)
      {
         int u = Integer.parseInt(st.readLine());
         HashSet<String> all = new HashSet<String>();
         ArrayList<String>[] data = new ArrayList[11];
         for(int i = 0; i < 11; i++)
         {
            data[i] = new ArrayList<String>();
         }
         for(int i = 0; i < 10000; i++)
         {
            StringTokenizer s = new StringTokenizer(st.readLine());
            long num = Long.parseLong(s.nextToken());
            String string = s.nextToken();
            String temp = ""+num;
            if(temp.length() == string.length())
            {
               int nn = Character.getNumericValue(temp.charAt(0));
               data[nn].add(""+string.charAt(0));
            }
            for(int j = 0; j < string.length(); j++)
               all.add(""+string.charAt(j));
         }

         HashSet<String> set = new HashSet<String>();
         String[] ans = new String[11];
         for(int i = 1; i <= 10; i++)
         {
            for(String j : data[i])
            {
               if(!set.contains(j))
               {
                  ans[i] = ""+j;
                  set.add(""+j);
                  all.remove(""+j);
                  break;
               }
            }
         }
         Iterator<String> i = all.iterator(); 
         while (i.hasNext()) 
            ans[0] = i.next(); 
         System.out.print("Case #"+cur_c+": ");
         for(int j = 0; j < 10; j++)
         {
            System.out.print(ans[j]);
         }
         System.out.println("");
      }
   }
}
