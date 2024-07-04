import java.util.*;
import java.math.*;
public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int cas = 0; cas < t; cas++){
            System.out.print("Case #" + (cas + 1) + ": ");
            boolean badf = false;
            int e = sc.nextInt();
            String output = "";
            int[] starts = new int[e];
            int[] ends = new int[e];
            for(int i = 0; i < e; i++){
                int start = sc.nextInt();
                int end = sc.nextInt();
                starts[i] = start;
                ends[i] = end;
            }
            boolean flag = false;
            for(int prem = 0; prem < (int)Math.pow(2,e); prem++){
                output = "";
                for(int i = 0; i < e; i++){
                    if(prem % ((int)Math.pow(2,i)) == 1){
                        output = output + "C";
                    }else {
                        output = output + "J";
                    }
                }
                if(!check(starts,ends,output)){
                    System.out.println(output);
                    flag = true;
                    break;
                }
            }
            if(!flag){
                System.out.println("IMPOSSIBLE");
            }
        }
    }
    public static boolean check(int[] starts, int[] ends, String output){
        boolean conflict_flag = false;
        for(int i = 0; i < output.length(); i++){
            int start = starts[i];
            int end = ends[i];
            starts[i] = start;
            ends[i] = end;
            for(int j = i + 1; j < output.length(); j++){
                if(output.charAt(j) == output.charAt(i)){
                    if(start <= starts[j] && !(end <= starts[j])) {
                        conflict_flag = true;
                    }else if(start >= starts[j] && !(start>=ends[j])){
                        conflict_flag = true;
                    }
                }
            }
        }
        return conflict_flag;
    }
}
