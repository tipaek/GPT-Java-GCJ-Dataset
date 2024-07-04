import java.io.*;
import java.util.*;



public class Solution
{

   public static void main(String[] args) throws IOException
   {
      BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(input.readLine());
      int T = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      for(int t = 1; t <= T; t++)
      {
         HashSet<ArrayList<Integer>> options = new HashSet<ArrayList<Integer>>();
         ArrayList<Integer> init = new ArrayList<Integer>();
         for(int i = 0; i < B; i++) init.add(-1);
         options.add(init);
         int query = 0;
         while(true)
         {
            if(query % 10 == 0)
            {
               int sz = options.size();
               for(ArrayList<Integer> arr : (HashSet<ArrayList<Integer>>)options.clone())
               {
                  options.add(complement(arr));
                  options.add(reverse(arr));
                  options.add(complement(reverse(arr)));
               }
            }
            int bestI = 0;
            int maxQ = Integer.MIN_VALUE;
            for(int i = 0; i < B; i++)
            {
               int num0 = 0;
               int num1 = 0;
               int numx = 0;
               int total = 0;
               for(ArrayList<Integer> arr : options)
               {
                  if(arr.get(i) == 0) num0++;
                  else if(arr.get(i) == 1) num1++;
                  else numx++;
                  total++;
               }
               int q = (total == 1 || num0 == 0 || num1 == 0 ? numx : num0 * num1 * 2 + numx);
               if(q > maxQ)
               {
                  bestI = i;
                  maxQ = q;
               }
            }
            System.out.println(bestI + 1);
            System.out.flush();
            int value = Integer.parseInt(input.readLine());
            HashSet<ArrayList<Integer>> cpy = (HashSet<ArrayList<Integer>>)options.clone();
            options.clear();
            for(ArrayList<Integer> arr : cpy)
            {
               if(arr.get(bestI) == -1) arr.set(bestI, value);
               if(arr.get(bestI) == value) options.add(arr);
            }
            if(options.size() == 1)
            {
               ArrayList<Integer> arr = options.iterator().next();
               if(certain(arr))
               {
                  String disp = display(arr);
                  System.out.println(disp);
                  System.out.flush();
                  String verdict = input.readLine();
                  if(verdict.equals("N")) return;
                  break;
               }
            }
            query++;
         }
      }
   }
   
   public static ArrayList<Integer> reverse(ArrayList<Integer> arr)
   {
      ArrayList<Integer> result = new ArrayList<Integer>();
      for(int i = 0; i < arr.size(); i++)
      {
         result.add(arr.get(arr.size() - 1 - i));
      }
      return result;
   }
   
   public static ArrayList<Integer> complement(ArrayList<Integer> arr)
   {
      ArrayList<Integer> result = new ArrayList<Integer>();
      for(int n : arr)
      {
         if(n == 0) result.add(1);
         else if(n == 1) result.add(0);
         else result.add(-1);
      }
      return result;
   }
   
   public static boolean certain(ArrayList<Integer> arr)
   {
      for(int n : arr)
      {
         if(n == -1) return false;
      }
      return true;
   }
   
   public static String display(ArrayList<Integer> arr)
   {
      String result = "";
      for(int n : arr)
      {
         result += n;
      }
      return result;
   }

}