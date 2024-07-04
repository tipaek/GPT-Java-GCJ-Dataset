import java.util.*;

class Solution {
    public static String build(int arr[])
    {   
        
        StringBuilder str = new StringBuilder();
        for(int i = 0 ; i<arr[0] ; i++)
        {
            str.append("(");
        }
        str.append(Integer.toString(arr[0]));
        for (int i = 0 ; i<(arr.length-1); i++)
        {
            if (arr[i] < arr[i+1])
            {
               for (int j = 0 ; j< arr[i+1]-arr[i] ; j++)
                 {
                     str.append("(");
                 }
               str.append(Integer.toString(arr[i+1]));
            }
            if (arr[i]>arr[i+1])
            { 
                for (int j = 0 ; j<arr[i]-arr[i+1] ; j++)
                  {
                    str.append(")");
                  }
                str.append(Integer.toString(arr[i+1]));
            }
        }
        for (int i = 0 ; i<arr[arr.length-1] ; i++)
        {
            str.append(")");
        }
        return str.toString();
    }
    public static int[] string_to_integer(String str)
    { 
        int arr[]= new int[str.length()];
        for (int i = 0 ; i<str.length() ; i++)
        {
            arr[i] = Character.getNumericValue(str.charAt(i));
        }
        return arr;
    }
    public static void  main (String args[])
    { 
       Scanner in = new Scanner (System.in);
       int testcase = in.nextInt();
       in.nextLine();
       for (int z = 0 ; z < testcase; z++)
       {
         String str = new String();
         str = in.nextLine();
         int arr[] = string_to_integer(str);
         System.out.println(build(arr));
       }
    }
}
