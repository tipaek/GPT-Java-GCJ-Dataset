import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = Integer.parseInt(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
        System.out.printf("\nCase #" + i + ": ");
        
      int n = Integer.parseInt(in.nextLine());

      int[] ctable = new int[1440] ;
      int[] jtable = new int[1440] ;
      String[] timetable = new String[n];


      int[][] holder = new int[n][2];       //contains start time, index
      int[][] time_holder = new int[n][2];       //contains start time, send time
      int j =0;
      while (j < n) {

            String current = in.nextLine();
            String str[] = current.split(" ");
            int start = Integer.parseInt(str[0]);
            int end = Integer.parseInt(str[1]);


            time_holder[j][0]=start;
            time_holder[j][1]=end;

            holder[j][0]=start;
            holder[j][1]=j;
            j+=1;
      }
      
      sortbyColumn(holder, 0) ;

int imposs_flag=0;
int k = 0;

while (k<holder.length){
    int index = holder[k][1];
    int start = time_holder[index][0];   //start
    int end = time_holder[index][1];   //end

    int cfull=0;
    int jfull=0;
    

    int counter = start;
    while (counter<end){

        if (ctable[counter]>0){
            cfull=1;
        }
        if (jtable[counter]>0){ 
            jfull=1;
        }


        counter+=1;
    }

    if (cfull==1){
        if(jfull==1){
            System.out.printf("IMPOSSIBLE");
            imposs_flag=1;
        }
        else{
            timetable[index]="J";
            //System.out.printf("J");
            int m=start;
            while (m<end){
                jtable[m]+=1;
                m+=1;
            }
            
        }
}
else{
    timetable[index]="C";
    //System.out.printf("C");
    int m=start;
            while (m<end){
                ctable[m]+=1;
                m+=1;
            }
}
k+=1;
}
     if (imposs_flag==0){for (int p = 0; p < timetable.length; p++) { 
            
                System.out.printf(timetable[p]+""); 
       }
        } 
         
    }
    
      
      
  }


  public static void sortbyColumn(int arr[][], int col) 
    { 
        // Using built-in sort function Arrays.sort 
        Arrays.sort(arr, new Comparator<int[]>() { 
            
          @Override              
          // Compare values according to columns 
          public int compare(final int[] entry1,  
                             final int[] entry2) { 
  
            // To sort in descending order revert  
            // the '>' Operator 
            if (entry1[col] > entry2[col]) 
                return 1; 
            else
                return -1; 
          } 
        });  // End of function call sort(). 
    }

}




