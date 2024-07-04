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
        //int sorted_input[][] = new int[number_of_schedule][2];
        int unsorted_input[][] = new int[number_of_schedule][2];
        //char output_sorted[] = new char[number_of_schedule];
        
        // Taking input
        for(int j = 0; j < number_of_schedule; ++j)
        {
            input[j][0] = scan.nextInt();
            input[j][1] = scan.nextInt();
        }
        // Creating unsorted input
        for(int j = 0; j < number_of_schedule; ++j)
        {
            unsorted_input[j][0] = input[j][0];
            unsorted_input[j][1] = input[j][1];
        }
        
        // Creating sorted input
        for(int j =0; j< number_of_schedule;++j)
        {
            boolean swapped = false;
            int k = 0;
            while(k<number_of_schedule-1)
            {
               if (input[k][0] > input[k+1][0])
               {
                   int temp1 = input[k][0];
                   int temp2 = input[k][1];
                    input[k][0] = input[k+1][0];
                    input[k][1] = input[k+1][1];
                    input[k+1][0] = temp1;
                    input[k+1][1] = temp2;
                    swapped = true;
               }
               k++;
            }
            if (!swapped)
                break;
        }
        int c_time = 0, j_time = 0;
        //Process
        for(int j = 0; j < number_of_schedule; ++j)
        {
            if(c_time <= input[j][0])
            {
                output = output.concat("C");
                c_time = input[j][1];
            }
            else if(j_time <= input[j][0])
            {
                output = output.concat("J");
                j_time = input[j][1];
            }
            else{
                
             if(j > 2)
             {
                if(input[j][0] <= input[j - 1][1] && input[j - 1][0] <= input[j - 2][1])
                {
                    output = "IMPOSSIBLE";
                    break;
                }
             }
             else
             {
                 output = "IMPOSSIBLE";
                 break;
             }
            }
        }
        
        if(output == "")
        {
            output = "IMPOSSIBLE";
        }
        
        // Printing Output
        System.out.println("Case #" + (i + 1) + ": " + output);
      
    }
  }
}