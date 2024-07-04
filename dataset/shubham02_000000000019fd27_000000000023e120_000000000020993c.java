
import java.util.*;
class Solution{
    public static void main(String[] args){
     Scanner sc = new Scanner(System.in);
     int test = sc.nextInt();
     int[][] input;
     int n;
     int i , j;
     Set<Integer> set;
     int k , r , c;
     k = r = c = 0;
     boolean flag = false;
     int item;
     for(int l = 1 ; l <= test ; l++){
         n = sc.nextInt();
         input = new int[n][n];
         k = r = c = 0;
         for(i = 0 ; i < n ; i++){
             for(j = 0 ; j < n ; j++){
              input[i][j] =  sc.nextInt();

         }}
         for(i = 0 ; i < n ; i++){
             set = new HashSet<>();
             for(j = 0 ; j < n ; j++){
              if(!set.add(input[i][j])){
               r++;
               break;
             }
         }}
        for(i = 0 ; i < n ; i++)
          k = k + input[i][i];

        for(i = 0 ; i < n  ; i++){
          set = new HashSet<>();
          for(j = 0 ; j < n ; j++){
            if(!set.add(input[j][i])){
              c++;
              break;
            }
          }
        }
          System.out.println("Case #" + l + ": " + k + " " + r + " " + c);
   }

    }

}
