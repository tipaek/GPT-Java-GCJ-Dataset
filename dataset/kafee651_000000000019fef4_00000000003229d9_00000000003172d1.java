import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int n = in.nextInt();
          int d = in.nextInt();
          ArrayList<Long> lt = new ArrayList<Long>();
          for(int j = 1;j <= n;j++){
            lt.add(in.nextLong());
          }
          lt.sort(null);
          int count = 1;
          int index = 0;
          int indexset = 0;
          int max = 1;
          for(Long l : lt){
             // System.out.println(l);
          }
          for(int j = 1;j < n;j++){

              if(lt.get(j) == lt.get(j-1)){
                  count++;
                  if(max < count){
                    max = count;
                    index = j;
                  }
              }else{
                  count = 1;
              }
              //System.out.println(j+" "+count);
          }
          if(d == 2 && max >= 2){
            System.out.println("Case #"+i+": 0");
          }else if(d == 2 && max == 1){
            System.out.println("Case #"+i+": 1");
          }else if(d == 3 && max >= 3){
            System.out.println("Case #"+i+": 0");
          }else if(d == 3 && max == 2 && index < (n-1)){
            System.out.println("Case #"+i+": 1");
          }else{
              int temp = 0;
              for(int j = n-1;j > 0;j--){
                  for(int k = j-1;k >= 0;k--){
                    if(lt.get(j) == (2 * lt.get(k))){
                        temp = 1;
                        System.out.println("Case #"+i+": 1");
                        break;
                        
                    }
                  }
                  if(temp == 1){
                      break;
                  }
              }
              if(temp == 0)
                  System.out.println("Case #"+i+": 2");
          }
          
        }
        in.close();
    }
}