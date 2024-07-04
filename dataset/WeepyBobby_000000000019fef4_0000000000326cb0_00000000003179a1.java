import java.io.*;
import java.util.*;
class Solution {
    public static void main(String args[] ) throws Exception
    {
      BufferedReader st = new BufferedReader(new InputStreamReader(System.in));//FileReader("sample.in.txt"));//InputStreamReader(System.in));
      int cases = Integer.parseInt(st.readLine());
      int cur_c = 0;
      next_case:
      while(++cur_c <= cases)
      {
         int u = Integer.parseInt(st.readLine());
         HashSet<String> all = new HashSet<String>();
         /*ArrayList<String>[] data = new ArrayList[11];
         for(int i = 0; i < 11; i++)
         {
            data[i] = new ArrayList<String>();
         }*/
         int[][] freq = new int[26][2];
         for(int i = 0; i < 26; i++)
         {
            freq[i][1] = i;
         }
         for(int i = 0; i < 10000; i++)
         {
            StringTokenizer s = new StringTokenizer(st.readLine());
            long num = Long.parseLong(s.nextToken());
            String string = s.nextToken();
            String temp = ""+num;
            if(u == string.length())
            {
               char nn = string.charAt(0);
               freq[(int)nn-'A'][0]++;
            }
            for(int j = 0; j < string.length(); j++)
               all.add(""+string.charAt(j));
         }

         Arrays.sort(freq, new Comparator<int[]>()
         {
            public int compare(int[] a, int[] b)
            {
               return a[0]-b[0];
            }
         });
/*         for(int i = 0; i < 26; i++)
         {
            System.out.println("\n\nfreq["+i+"][0]: "+freq[i][0]);
            System.out.println("freq["+i+"][1]: "+freq[i][1]);

         }
*/         HashSet<String> set = new HashSet<String>();
         String[] ans = new String[11];
         int cur = 0;
         while(freq[cur][0] == 0) cur++;
         for(int i = cur; i < 26; i++)
         {
            char ch = (char)('A'+(char)freq[i][1]);
            //System.out.println("For "+i+": "+ch);
            int el = i-cur;
            ans[9-el] = ""+ch;//((char)'A'+freq[cur][1]);
            all.remove(""+ch);
            /*for(String j : data[i])
            {
               if(!set.contains(j))
               {
                  ans[i] = ""+j;
                  set.add(""+j);
                  all.remove(""+j);
                  break;
               }
            }*/
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