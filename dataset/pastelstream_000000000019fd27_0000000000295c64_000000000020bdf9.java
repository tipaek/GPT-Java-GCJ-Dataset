import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = Integer.parseInt(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
        System.out.printf("\nCase #" + i + ": ");
        
      int n = Integer.parseInt(in.nextLine());
      int[] CTable = new int[1440] ;
      int[] JTable = new int[1440] ;
      int[] timetable = new int[1440];
      String[] tasksheet = new String[n];
      int flag=0;
      
      int j =1;
      while (j <= n) {
          int Cfull=0;
          int Jfull=0;
          if(flag==0){
            String current = in.nextLine();
               
            String str[] = current.split(" ");
            int start = Integer.parseInt(str[0]);
            int end = Integer.parseInt(str[1]);
            int counter = start;
            
            while ((counter<end)&&(flag==0)){
                timetable[counter]+=1;
                if (CTable[counter]>0){
                    Cfull = 1;
                }
                if (JTable[counter]>0){
                    Jfull = 1;
                }
                if (timetable[counter]==3){
                    flag = 1;
                }
                counter+=1;
            }
            if ((Cfull==1)&&(flag==0)){
                tasksheet[j-1]="J";
                counter = start;
                while ((counter<end)&&(flag==0)){
                JTable[counter]+=1;
                
                counter+=1;
                
                if (Jfull==1){
                   flag=1;
                }
            }
            }
            if ((Cfull==0)&&(flag==0)){
                tasksheet[j-1]="C";
                counter = start;
                while ((counter<end)&&(flag==0)){
                CTable[counter]+=1;
                
                counter+=1;
            }
            }
          }
          

          else{
              String current = in.nextLine();
          }
            
            j+=1;
      }
      
      
      if (flag == 1){
          System.out.printf("IMPOSSIBLE");
      }
      else{
          int k =0;
          while (k<n){
              System.out.printf(tasksheet[k]);
              k+=1;
          }
      }
      
    }
    
      
      
  }
}