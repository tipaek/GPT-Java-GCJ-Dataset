import java.util.*;
import java.io.*;
import java.lang.*;

class Solution{

  public static void main(String args[]) throws Exception{
    DataInputStream in = new DataInputStream(System.in);
    String line = in.readLine();
    int a = Integer.parseInt(line.trim());

    for(int testcase = 0; testcase < a; testcase++)
        {
            line = in.readLine();
            String str[] = line.trim().split("\\s+");
            int r = Integer.parseInt(str[0]);
            int s = Integer.parseInt(str[1]);

            int index = 0;
            int R[] = new int[r*s];
            for(int i = 0; i < s; i++)
              for(int j = 0; j < r; j++)
                R[index++] = j+1;

            int count = 0;
            int left = 0;
            int right = R.length-1;

            int n = r*s/2 - 1;
            System.out.println("Case #" + testcase + ": " + n);
            while(n-- >= 0)
            {
              left = 0;
              int leftnum = R[left];
              int rightnum = R[right]-1;

              while(R[left+1] != leftnum)
                left++;
              while(R[right-1] != rightnum)
                right--;
              right--;

              int temp[] = new int[left+1];
              for(int i = 0; i <= left; i++)
                temp[i] = R[i];

              int tempindex = left + 1;
              int leftelement = right - left;
              for(int i = 0; i < leftelement ; i++)
                  R[i] = R[tempindex++];
              tempindex = 0;
              for(int i = leftelement; i <= right; i++)
                  R[i] = temp[tempindex++];
              System.out.println(R[left] + " " +R[right]);
            }

        }
  }
}
