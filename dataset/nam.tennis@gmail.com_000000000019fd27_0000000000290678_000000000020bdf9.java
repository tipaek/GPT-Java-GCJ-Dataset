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
          
          //cache the original order of intervals
          //this is bad, this will just copy the reference and not elements
          //any change to one array will reflect the other
          //so when we sort interArray later, tempArray order also changes
          //  Interval[] tempArray = interArray; 
          
          //Correct way
          Interval[] tempArray = new Interval[intervals];
          for (int k = 0; k < intervals; ++k) {
              tempArray[k] = interArray[k]; //is this called deep copy?
          }
          
          HashMap<String, String> map = new HashMap<String,String>();
          // sort the intervals in increasing order of start time  
            Arrays.sort(interArray,new Comparator<Interval>(){ 
                public int compare(Interval i1,Interval i2) 
                { 
                    return i1.start-i2.start; 
                } 
            });
        
        //If one of them is available, put the task in their bucket and update their next end time.
        String temp = "";
        for(Interval inter: interArray){
            if(inter.start>=cend){
                map.put(inter.id, "C");
                cend = inter.end;
            }
            else if(inter.start >= jend){
                map.put(inter.id, "J");
                jend = inter.end;
            }
            else{
                temp = "IMPOSSIBLE";
                break;
            }
        }
        
        if(temp == "IMPOSSIBLE"){
            System.out.println("Case #" + i + ": "+ temp);
            continue;
        }
        
        //Iterate the original order of interval array
        for(Interval inter: tempArray){
            if(map.containsKey(inter.id)){
                temp+=map.get(inter.id);
            }
        }
        
        result = temp;
            
        System.out.println("Case #" + i + ": "+ result);
        }
      }
      
      static class Interval{
          String id;
          int start;
          int end;
          
          Interval(int start, int end){
              this.start = start;
              this.end = end;
              id = start + ":" +end;
          }
      }

      }

