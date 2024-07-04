import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());

        for (int t = 0; t < T; t++){
            int N = Integer.parseInt(scanner.nextLine());

            int[] sArr = new int[N];
            int[] eArr = new int[N];
            char[] scheduleResult = new char[N];
            boolean isImpossible = false;
            for (int i = 0; i < N; i++){
                String line = scanner.nextLine().trim();
                String[] SEline = line.split(" ");
                sArr[i] = Integer.parseInt(SEline[0]);
                eArr[i] = Integer.parseInt(SEline[1]);

                if(isImpossible){
                    continue;
                }
                if(i == 0){
                    scheduleResult[i] = 'C';
                } else {
                    char persionAssignedTmp = 'Z';
                    for(int j = i - 1; j >= 0; j--){
                        if( (sArr[i] >= sArr[j] && sArr[i] < eArr[j]) || (eArr[i] > sArr[j] && eArr[i] <= eArr[j])){//overlap
                            if(persionAssignedTmp == 'Z') {
                                persionAssignedTmp = scheduleResult[j];
                            } else if(scheduleResult[j] != persionAssignedTmp && scheduleResult[j] != 'Z'){
                                isImpossible = true;
                                break;
                            }
                        }
                    }

                    scheduleResult[i] = (persionAssignedTmp == 'C') ? 'J' : 'C';
                }
            }
            //print result
            StringBuilder sb = new StringBuilder();
            if(isImpossible){
                sb.append("IMPOSSIBLE");
            } else {
                for (int i = 0; i < N; i++){
                    sb.append(scheduleResult[i]);
                }
            }
            System.out.println("Case #" + (t + 1) + ": " + sb.toString());
        }
    }
}
