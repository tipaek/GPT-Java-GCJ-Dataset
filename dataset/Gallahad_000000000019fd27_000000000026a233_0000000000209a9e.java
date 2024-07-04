import java.util.*;
class Soltion
{
    static void print(int arr[]){
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]);
    }
  public static void main (String[]args)
  {
      Scanner ob = new Scanner (System.in);
      int t = ob.nextInt ();
      int b = ob.nextInt ();
      for (int i = 0; i < t; i++)
      {
          int arr[] = new int[b];
          int k = 1;
          while (k <= 100)
          {
              System.out.println (k);
              arr[k-1] = ob.nextInt ();
              if (k == b){
                  print(arr);
                  char ok = ob.next ().charAt (0);
                  if(ok == 'N')
                  System.exit(0);
                  else
                break;
              }
	  	    k++;
          }
      }
  }
}
