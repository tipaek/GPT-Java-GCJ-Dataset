import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static class TwoItems{
        int firstItem;
        int secondItem;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        for (int k = 1; k <= t; k++) {
            List<TwoItems> list = new ArrayList<>();

            String[] s_n = bf.readLine().trim().split(" ");
            int n = Integer.parseInt(s_n[0]);

            for (int i = 1; i <= n; i++) {
                String[] s_a = bf.readLine().trim().split(" ");
                int startTime = Integer.parseInt(s_a[0]);
                int endTime = Integer.parseInt(s_a[1]);
                TwoItems twoItems = new TwoItems();
                twoItems.firstItem = startTime;
                twoItems.secondItem = endTime;
                list.add(twoItems);
            }
            Collections.sort(list,(e1,e2)->e1.firstItem-e2.firstItem);
            findAnswer(list, k);
        }
    }

        public static void findAnswer(List<TwoItems> list, int testCaseNo){
            int cameron = 0;
            int jamie = 0;
            String answer = "";
            for(TwoItems twoItems : list) {
                if(cameron<=twoItems.firstItem) {
                    cameron = twoItems.secondItem;
                    answer = answer + "C";
                }else if(jamie<=twoItems.firstItem){
                    jamie = twoItems.secondItem;
                    answer = answer + "J";
                }else{
                    answer = "IMPOSSIBLE";
                    break;
                }
             }
            System.out.println("Case #"+testCaseNo+": "+answer);
    }
}
