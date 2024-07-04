import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.Arrays.*;

public class Solution {
    public static void main(String args[]) throws IOException {
        ArrayList<String> arrayList = new ArrayList<>();
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int num = in.nextInt();
        int count = 0;
        List<String> result = new ArrayList<>();
        while(count < num){
            int size = in.nextInt();
            List<int[]> schedule = new ArrayList<>();
            for(int i = 0; i < size; i++){
                schedule.add(new int[]{in.nextInt(),in.nextInt()});
            }
            result.add(calculate(schedule));
            count++;
        }

        for(int i = 0; i < result.size(); i++){
            System.out.println("Case #" + (i + 1) + ": " + result.get(i));
        }
        return;
    }

    private static String calculate(List<int[]> schedule){
        char[] res = new char[schedule.size()];
        Map<int[], Integer> index = new HashMap<>();
        for(int i = 0; i < schedule.size(); i++) index.put(schedule.get(i), i);
        Collections.sort(schedule, (a,b) ->{
            return a[0] - b[0];
        });
        int count = 0;
        int C = -1;
        int J = -1;
        for(int[] i: schedule){
            if(i[0] >= C){
                res[index.get(i)] = 'C';
                C = i[1];
            }
            else if(i[0] >= J){
                res[index.get(i)] = 'J';
                J = i[1];
            }
            else return "IMPOSSIBLE";
        }
        return new String(res);
    }
}
