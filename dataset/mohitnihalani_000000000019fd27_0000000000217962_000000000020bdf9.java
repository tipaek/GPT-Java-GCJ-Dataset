
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has f

        for(int i = 1; i <= t; i++){
            int intervals = in.nextInt();
            in.nextLine();
            PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);
            for(int k = 1; k <= intervals; k++){
                int a = in.nextInt();
                int b = in.nextInt();
                pq.add(new int[]{a,b,k-1});
            }
            int clast = 0;
            int jlast = 0;
            char[] result = new char[intervals];
            boolean check = true;
            while(!pq.isEmpty()){
                int[] last = pq.remove();
                
                if(last[0] < clast && last[0] < jlast){
                    check = false;
                    break;
                }else {
                    if(last[0] >= clast){
                        result[last[2]] = 'C';
                        clast = last[1];
                    }else if(last[0] >= jlast){
                        result[last[2]] = 'J';
                        jlast = last[1];
                    }
                }
            }
            
            String output = (!check) ? "IMPOSSIBLE" : new String(result);
            System.out.println("Case #" + i + ": " + output);
        }
    }
}