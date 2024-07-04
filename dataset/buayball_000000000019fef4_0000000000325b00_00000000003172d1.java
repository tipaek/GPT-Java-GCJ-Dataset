import java.util.*;
import java.io.*;
import java.lang.Math;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int case_t = 1; case_t <= t; case_t++) {
      
      int N = in.nextInt();
      int D = in.nextInt();
      
      ArrayList<Long> list = new ArrayList<Long>();

      for(int i = 0; i < N ; i++){

        long tmp = in.nextLong();
        
        list.add(tmp);
      }

      Collections.sort(list);

      int count = 0;
      long current = -1;
      int max = 0;
      long max_num = 0;
      boolean first = true;
      boolean cut = true;  

      for(long num : list){

        //System.out.println(num);

        if(first){
          current = num;
          max = 1;
          max_num = num;
          first = false;
          count++;
        } else {

          if(num == current){
            count++;
            if(count == D){
              cut = false;
              break;
            }
          } else {

            if(count == D){
              cut = false;
              break;
            }

            if(count > max){
              max = count;
              max_num = num;
            }

            count = 1;
            current = num;

          }
        }
      }

      int mod = 0;
      
      for(long num : list){
      
        if(num != max_num && num%max_num == 0){
          mod++;
        }
      
      }

      //System.out.println(D);
      //System.out.println(max);
      //System.out.println(mod);

      int result = D - max - mod;

      if(!cut){
        System.out.println("Case #" + case_t + ": 0");  
      } else {
        System.out.println("Case #" + case_t + ": " + result);
        
      }      
    }
  }

}