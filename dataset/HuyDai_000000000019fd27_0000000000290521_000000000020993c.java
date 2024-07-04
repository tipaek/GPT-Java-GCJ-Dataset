import java.util.*;
import java.io.*;
public class Solution{
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = Integer.valueOf(in.nextLine());  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; i++) {
      int trace = 0,  row = 0, columns = 0;
      ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
      int tot_size = Integer.valueOf(in.nextLine());
      for(int j = 1; j <= tot_size; j++){
    	  
          String[] parser = in.nextLine().split(" ");
          ArrayList<Integer> line = new ArrayList<Integer>();
          for(String a : parser){
            line.add(Integer.valueOf(a));
          }
          matrix.add(line);
          if(isDuplicate(line)) row += 1; //check if line duplicate
          
      }
      
      for(int k = 1; k <= matrix.size(); k++){
        ArrayList<Integer> column = new ArrayList<Integer>();
        Boolean containsDup = false;
        for(int l = 0; l < matrix.size(); l++){
            if(l==0) column.add(matrix.get(l).get(k-1));
            else{
                int holder = matrix.get(l).get(k-1);
                if(column.contains(holder)) {
                  containsDup = true;
                } else {
                	column.add(holder);
                }
            }
      }
        if(containsDup) columns +=1;
    }
     for(int m=0; m < matrix.size(); m++){
         trace += matrix.get(m).get(m);
      }
    System.out.println("Case "+i+": "+trace+" "+row+" "+columns);
    }
    
  }
    
    public static Boolean isDuplicate(ArrayList<Integer> line){
        Set<Integer> set = new LinkedHashSet<>();
        set.addAll(line);
        if(line.size() != set.size()) return true;
        return false;
    }
    
}
  
 
