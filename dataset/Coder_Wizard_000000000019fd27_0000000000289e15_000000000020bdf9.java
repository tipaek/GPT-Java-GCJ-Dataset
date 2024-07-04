import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = scan.nextInt();
    
    for (int i = 0; i < t; ++i) {
        // Initialising and assiging value
        String output = "";
        int number_of_schedule = scan.nextInt();
        int input[][] = new int[number_of_schedule][2];
        
        // Taking input
        for(int j = 0; j < number_of_schedule; ++j)
        {
            input[j][0] = scan.nextInt();
            input[j][1] = scan.nextInt();
        }
        
        int c_time = 0, j_time = 0, c_start = input[0][0], j_start = 0;
        int count = 0;
        
        //Process
        for(int j = 0; j < number_of_schedule; ++j)
        {
            if(c_time <= input[j][0])
            {
                output = output.concat("C");
                c_time = input[j][1];
            }
            else if(c_start >= input[j][1])
            {
                output = output.concat("C");
                c_start = input[j][1];
            }
            else if(j_time <= input[j][0])
            {
                output = output.concat("J");
                j_time = input[j][1];
                count = 1;
            }
            else if(j_start >= input[j][1])
            {
                output = output.concat("J");
                j_start = input[j][1];
            }
            else
            {
                output = "IMPOSSIBLE";
                break;
            }
            
            if(count == 1)
            {
                j_start = input[j][0];
                count = 0;
            }
        }
        
        if(output == "")
        {
            output = output.concat("IMPOSSIBLE");
        }
        
        // Printing Output
        System.out.println("Case #" + (i + 1) + ": " + output);
      
    }
  }
}