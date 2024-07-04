  import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // num of tests
        for (int i = 1; i <= t; ++i) {
          int intervals = in.nextInt(); //num of intervals
          
          //Init variables
          Interval[] interArray = new Interval[intervals];
          String result = "IMPOSSIBLE";
          int cend = 0;
          int jend = 0;
          
          //Prepare interval array
          for (int j = 0; j <intervals; ++j) {
              int start = in.nextInt();
              int end = in.nextInt();
              Interval current = new Interval(start, end);
              interArray[j] = current;
          }
          
          // sort the intervals in increasing order of start time  
            Arrays.sort(interArray,new Comparator<Interval>(){ 
                public int compare(Interval i1,Interval i2) 
                { 
                    return i1.start-i2.start; 
                } 
            });
        
        String temp = "";
        for(Interval inter: interArray){
            if(inter.start>=cend){
                temp += "C";
                cend = inter.end;
            }
            else if(inter.start >= jend){
                temp += "J";
                jend = inter.end;
            }
            else{
                temp = result;
                break;
            }
        }
        
        result = temp;
            
        System.out.println("Case #" + i + ": "+ result);
        }
      }
      
      static class Interval{
          int start;
          int end;
          Interval(int start, int end){
              this.start = start;
              this.end = end;
          }
      }

      }

