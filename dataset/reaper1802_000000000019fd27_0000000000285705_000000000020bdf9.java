import java.util.*;
import java.io.*;

class Solution{

  public static void main(String args[]) throws Exception{

    DataInputStream in = new DataInputStream(System.in);
    String line = in.readLine();
    int a = Integer.parseInt(line.trim());

    for(int test_case = 1; test_case <= a; test_case++)
    {
      line = in.readLine();
      int activities = Integer.parseInt(line.trim());
      int S_times[] = new int[activities];
      int E_times[] = new int[activities];
      for(int i = 0; i < activities; i++)
        {
          line = in.readLine();
          String str[] = line.trim().split("\\s+");
          S_times[i] = Integer.parseInt(str[0]);
          E_times[i] = Integer.parseInt(str[1]);
        }

      Arrays.sort(S_times);
      Arrays.sort(E_times);

      int S_index = 0;
      int E_index = 0;
      int max_person = 0;
      int person = 0;
      while(S_index < activities && E_index < activities)
      {
        if(S_times[S_index] < E_times[E_index])
          {
              person++;
              max_person = person>max_person?person:max_person;
              S_index++;
          }
        else{
          person--;
          E_index++;
        }
      }

      String ans ="";
      if(max_person == 1)
        for(int i = 0; i < activities; i++)
          ans+="C";
      if(max_person > 2)
          ans+="IMPOSSIBLE";

      if(max_person == 2)
          {
            int i = 0;
            int j = 0;
            int C_busy = 0;
            int J_busy = 0;
            int ans_index = 0;
            while(i < activities && j < activities)
            {
              
              if(S_times[i] < E_times[j])
                {

                    if(C_busy == 0)
                      {C_busy = 1; ans = ans + "C";  }
                    else if(J_busy == 0)
                      {J_busy = 1; ans = ans + "J";  }
                    i++;
                }
              else{
                if(ans.charAt(ans_index) == 'C')
                  C_busy = 0;
                else
                  J_busy = 0;
                j++;
                ans_index++;
              }
            }
          }
      System.out.println("ans is " + ans);
    }
  }
}
