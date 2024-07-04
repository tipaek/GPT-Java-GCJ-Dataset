import java.util.*;
public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int cas = 0; cas < t; cas++){
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
                boolean conflict = false;
                for(int j = 0; j < output.length(); j++){
                    if(output.charAt(j) == 'C'){
                        if(start <= starts[j] && !(end <= starts[j])) {
                            conflict = true;
                        }else if(start >= starts[j] && !(start>=ends[j])){
                            conflict = true;
                        }
                    }
                }
                if(!conflict){
                    output = output + 'C';
                }else{
                    boolean conflict_j = false;
                    for(int j = 0; j < output.length(); j++){
                        if(output.charAt(j) == 'J'){
                            if(start <= starts[j] && !(end <= starts[j])) {
                                conflict_j = true;
                            }else if(start >= starts[j] && !(start>=ends[j])){
                                conflict_j = true;
                            }
                        }
                    }
                    if(!conflict_j){
                        output = output + 'J';
                    }else{
                        badf = true;
                        break;
                    }
                }
            }
            if(badf){
                System.out.println("Case #" + (cas + 1) + ": " + "IMPOSSIBLE");
                //System.out.println("Case #" + (cas + 1) + ": " +output);
            }else{
                System.out.println("Case #" + (cas + 1) + ": " +output);
            }
        }
    }
}
