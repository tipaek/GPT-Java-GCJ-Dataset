import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner reader = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = reader.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int N = reader.nextInt();
            class activity{
                int start, end, index;
                activity(int start, int end, int index){
                    this.start = start;
                    this.end = end;
                    this.index = index;
                }
                int getStart(){
                    return start;
                }
                int getEnd(){
                    return end;
                }
            }
            ArrayList<activity> activities = new ArrayList<>();
            for (int j = 0; j < N; j++){
                activities.add(new activity(reader.nextInt(), reader.nextInt(), j));
            }

            activities.sort(
                    Comparator.comparing(activity :: getStart).thenComparing(activity::getEnd)
            );

            String ans = "";
            boolean imp = false;
            for (int k = 0; k < N; k++) {
                int currEnd = activities.get(k).end;
                int currOverlap = 0;
                int secEnd = 0;
                ans += "C";
                for (int j = k + 1; j < N; j++) {
                    if (activities.get(j).start < currEnd) {
                        if (activities.get(j).start < secEnd) {
                            ans = "IMPOSSIBLE";
                            imp = true;
                            break;
                        } else {
                            k++;
                            secEnd = activities.get(j).end;
                            ans += "J";
                        }
                    } else {
                        break;
                    }
                }
                if (imp)
                    break;
            }
            if (imp){
                System.out.println("Case #" + i + ": " + ans);
                continue;
            }
            char[] finAns = new char[N];
            for (int k = 0; k < N; k++){
                finAns[activities.get(k).index] = ans.charAt(k);
            }
            System.out.println("Case #" + i + ": " + String.valueOf(finAns));
        }
    }
}