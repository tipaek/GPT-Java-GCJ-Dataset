import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {

            int N = scanner.nextInt();
            int[] J = new int[24*60];
            int[] C = new int[24*60];
            char[] schedule = new char[N];
            boolean cantMakeSchedule = false;
            
            int[] SArr = new int[N];
            int[] EArr = new int[N];
            
            for(int j = 0; j < N; j++) {
                SArr[j] = scanner.nextInt();
                EArr[j] = scanner.nextInt();
            }

            for (int j = 0; j < N; j++) {
                int S = SArr[j];
                int E = EArr[j];
                boolean Jfull = false, Cfull = false;

                //is J full?
                for (int k = S; k < E; k++)
                    if (J[k] == 1){
                        Jfull = true;
                        break;
                    }

                if (!Jfull) { // J is empty
                    for (int k = S; k < E; k++)
                        J[k] = 1;
                    schedule[j] = 'J';
                }
                else{ // J is full

                    // is C full?
                    for (int k = S; k < E; k++)
                        if (C[k] == 1){
                            Cfull = true;
                            break;
                        }

                    if (!Cfull) { // C is empty
                        for (int k = S; k < E; k++)
                            C[k] = 1;
                        schedule[j] = 'C';
                    }
                    else { // C is full and J is full
                        cantMakeSchedule = true;
                        break;
                    }
                }

            }
            if (cantMakeSchedule)
                System.out.printf("Case #%d: IMPOSSIBLE\n", i + 1);
            else{
                String scheduleString = new String(schedule);
                System.out.printf("Case #%d: %s\n", i + 1, scheduleString);
            }
        }


    }
}