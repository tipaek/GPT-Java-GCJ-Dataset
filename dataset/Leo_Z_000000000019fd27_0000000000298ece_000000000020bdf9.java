
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = sc.nextInt();
        String[] sol = new String[cases];
        outerloop: for(int z = 0; z<cases; z++){
            int[] time = new int[1441];
            int acts = sc.nextInt();
            HashMap<Integer, String> name = new HashMap<Integer, String>();
            boolean[] jamie = new boolean[1441];
            boolean[] cameron = new boolean[1441];
            sol[z] = "";
            for(int i = 1; i<=acts; i++){
                int s = sc.nextInt();
                int e = sc.nextInt();

                boolean jamieGood = true;
                for(int j=s; j<e; j++){
                    time[j]++;
                    if(time[j]>2) {
                        sol[z] = "IMPOSSIBLE";
                        continue outerloop;
                    }
                    if(jamie[j]){
                        jamieGood = false;
                    }
                }

                if(jamieGood){
                    for(int j = s; j<e; j++){
                        jamie[j] = true;
                    }
                    sol[z]+="J";
                } else{
                    for(int j = s; j<e; j++){
                        cameron[j] = true;
                    }
                    sol[z]+="C";
                }
            }
        }
        for(int i = 0; i<cases; i++){
            System.out.println("Case #" + (i+1) + ": " + sol[i]);
        }
    }


}
