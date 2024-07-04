import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());

        for (int t = 0; t < T; t++){
            int N = Integer.parseInt(scanner.nextLine());

            Act[] actArr = new Act[N];
            boolean isImpossible = false;
            for (int i = 0; i < N; i++) {
                String line = scanner.nextLine().trim();
                String[] SEline = line.split(" ");
                actArr[i] = new Act();
                actArr[i].tStart = Integer.parseInt(SEline[0]);
                actArr[i].tEnd = Integer.parseInt(SEline[1]);
                actArr[i].idx = i;
            }

            Arrays.sort(actArr, new Comparator<Act>() {
                @Override
                public int compare(Act act, Act t1) {
                     if(act.tStart > t1.tStart){
                         return 1;
                     } else if(act.tStart < t1.tStart){
                         return -1;
                     }
                     return 0;
                }
            });

            for (int i = 0; i < N; i++){
                if(i == 0){
                    actArr[i].assigned = 'C';
                } else {
                    char persionAssignedTmp = 'Z';
                    for(int j = i - 1; j >= 0; j--){
                        if( (actArr[i].tStart >= actArr[j].tStart && actArr[i].tStart < actArr[j].tEnd) || (actArr[i].tEnd > actArr[j].tStart && actArr[i].tEnd <= actArr[j].tEnd)){//overlap
                            if(persionAssignedTmp == 'Z') {
                                persionAssignedTmp = actArr[j].assigned;
                            } else if(actArr[j].assigned != persionAssignedTmp){
                                isImpossible = true;
                                break;
                            }
                        }
                    }

                    actArr[i].assigned = (persionAssignedTmp == 'C') ? 'J' : 'C';
                }
            }

            Arrays.sort(actArr, new Comparator<Act>() {
                @Override
                public int compare(Act act, Act t1) {
                    if(act.idx > t1.idx){
                        return 1;
                    } else if(act.idx < t1.idx){
                        return -1;
                    }
                    return 0;
                }
            });
            //print result
            String resultString;
            if(isImpossible){
                resultString = "IMPOSSIBLE";
            } else {
                char[] result = new char[N];
                for(int i = 0; i < N; i++) {
                    result[i] = actArr[i].assigned;
                }
                resultString = new String(result);
            }
            System.out.println("Case #" + (t + 1) + ": " + resultString);
        }
    }

    static class Act {
        int tStart;
        int tEnd;
        int idx;
        char assigned;
    }
}
