import java.util.*;
class Solution
{
    public static void main(String[] args)
    {
      Scanner ob=new Scanner(System.in);
      int t=ob.nextInt();
      int b=ob.nextInt();
      for(int it=1;it<=t;it++)
      {
      int arr[]=new int[b];
      
      for(int i=0;i<b;i++)
      {
          System.out.println(i+1);
          arr[i]=ob.nextInt();
      }
      for(int i=0;i<b;i++)
      {
          System.out.print(arr[i]);
      }
      System.out.println();
      if(ob.next().equals("N"))
      break;
      }
    }
}
