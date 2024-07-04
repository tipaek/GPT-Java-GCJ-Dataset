import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner inp = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = inp.nextInt();  //no of testCase
        System.out.println();
        boolean overlapping=false;
        String order="";  //  to store schedule
        for (int i = 0; i < t; i++) {
            int N = inp.nextInt();// no of events
            char[] alloc=new char[N];
            int[][][] arr = new int[t][N][3];   //array to store timings of events   c:1  j:2

            for (int j = 0; j < N; j++) {
                int start = inp.nextInt();
                int end = inp.nextInt();
                arr[i][j][0] = start;
                arr[i][j][1] = end;
            }
            //allocating schedule
            int c_start=0;
            int c_end=0;
            int j_start=0;
            int j_end=0;

            for(int j=0;j<N;j++){
                if(overlapping==true)
                {
                    System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
                    break;
                }
                else if(j==0)
                    {
                        arr[i][j][2]=1;order.concat("C");
                        c_start=arr[i][j][0];
                        c_end=arr[i][j][1];
                    }
                else
                {
                    if(arr[i][j][0]>=arr[i][j-1][1])
                    {
                        arr[i][j][2]=1;
                        order.concat("C");
                        c_start=arr[i][j][0];
                        c_end=arr[i][j][1];
                    }
                    else
                    {
                        if(j==0)
                        {arr[i][j][2]=1;order.concat("J");
                            j_start=arr[i][j][0];
                            j_end=arr[i][j][1]; }
                        else
                        {
                            if(arr[i][j][0]<j_end)
                            {
                                arr[i][j][2]=1;order.concat("J");
                                j_start=arr[i][j][0];
                                j_end=arr[i][j][1];
                            }
                            else
                                overlapping=true;
                        }
                    }
                }
            }
           if(overlapping==false) System.out.println("Case #" + (i+1) + ":"+order );
        }

        //  System.out.println("Case #" + (i+1) + ": " + trace + " " + rowrep+" "+colrep);
  }
}