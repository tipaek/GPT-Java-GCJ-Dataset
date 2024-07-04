import java.util.*;
 class Solution {
    
    public static int[][] sorted_by_first(int arr[][] , int num)
    {       
        int sorted[][] = new int[num][2];
        
        for (int i = 0 ; i < num ; i++)
        {
            int position = -1;
            int count = 100001;
            for (int j = 0 ; j< num ; j++)
            {
                  if (arr[j][0] < count)
                  {
                      count = arr[j][0];
                      position = j;
                  }
            }
            sorted[i][0] = arr[position][0];
            sorted[i][1] = arr[position][1];
            arr[position][0] = 100000;
            arr[position][1] = 100000;
        }
        return sorted;
    }
    
    public static String Scheduler(int arr[][] , int num)
    {
      int J_start = arr[0][0];
      int J_end = arr[0][1];
      int C_start = arr[1][0];
      int C_end = arr[1][1];
      StringBuilder sb = new StringBuilder();
      sb.append("JC");
      
      for (int i = 2 ; i< num ; i++)
      {
          if (arr[i][0]>= J_end)
          {
              sb.append("J");
              J_start = arr[i][0];
              J_end = arr[i][1];
              continue;
          }
          if (arr[i][0]>= C_end)
          {
              sb.append("C");
              C_start = arr[i][0];
              C_end = arr[i][1];
              continue;
          }
      }
      return sb.toString();
    }
    public static String Answer(int arr[][] , int num)
    { 
        for (int i = 2 ; i<num ; i++)
        {
            if (arr[i][0] < arr[i-1][1] && arr[i][0]< arr[i-2][1])
            {
                return "IMPOSSIBLE";
            }
        }
        return Scheduler(arr ,num);
    }
    
    public static String unsorter(int copy[][] , int sorted[][] , String str , int num)
    {
        
        StringBuilder sb = new StringBuilder();
        sb.append("");
        for (int i = 0 ; i< num ; i++)
        {   
            int to_find = copy[i][0];
            
            for (int j = 0 ; j< num ; j++)
            {
                
                if(sorted[j][0] == to_find)
                {   
                
                    Character c = str.charAt(j);
                    sb.append(c.toString());
                    sorted[j][0] = 0;
                }
            }
        }
        
        return sb.toString();
    }
    public static void main (String args[])
    {
        Scanner in = new Scanner(System.in);
        int testcase = in.nextInt();
        for (int z = 0 ; z<testcase ; z++)
        {
           int num = in.nextInt();
           int arr[][] = new int[num][2];
           for (int i = 0 ; i < num ; i++)
           { 
               arr[i][0] = in.nextInt();
               arr[i][1] = in.nextInt();
           }
           int copy[][] = new int [num][2];
           
           for (int i = 0 ; i < num ; i++)
           {
               copy[i][0] = arr[i][0];
               copy[i][1] = arr[i][1];
           }
           int sorted[][] = sorted_by_first(arr,num);
           String result = Answer(sorted , num);
          
            if (!result.equals("IMPOSSIBLE"))
           {
               String ans = unsorter( copy, sorted , result, num);
               System.out.println("Case #" + (z+1) + ": " + ans);
           }
           else
           {
               System.out.println("Case #" + (z+1) + ": " + "IMPOSSIBLE");
           }
        }
    }
}
