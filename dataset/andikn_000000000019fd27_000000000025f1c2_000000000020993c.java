import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
   public static void main(String[] args){
       Scanner in = new Scanner(System.in);
       int test, n;
       int k, r, c;
       int tmp;
       HashMap<Integer,HashSet<Integer>> cols = new HashMap<>();
       HashSet<Integer> row = new HashSet<>();
       boolean[] repcol;
       boolean reprow;
       
       test = in.nextInt();
       for(int t = 0; t < test; t++){
           n = in.nextInt();
           repcol = new boolean[n];
           for(int i = 0; i < n; i++)
               cols.put(i, new HashSet<Integer>());
           reprow = false;
           r = c = k = 0;
           // computing test
           for(int i = 0; i < n; i++){
               reprow = false;
               row.clear();
               for(int j = 0; j < n; j++){
                    tmp = in.nextInt();
                    if(i == j)
                        k += tmp;

                    // check row
                    if(!reprow && row.contains(tmp)){
                        r++;
                        reprow = true;
                    }
                    row.add(tmp);

                    // check col
                    if(!repcol[j] && cols.get(j).contains(tmp)){
                        c++;
                        repcol[j] = true;
                    }
                    cols.get(j).add(tmp);
               }
           }
           System.out.println("Case #" + (t+1) + ": " + k + " " + r + " " + c);
       }
   } 
}
