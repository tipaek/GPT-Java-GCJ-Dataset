import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt(); // Number of tasks

            List<List<Short>> minutes = new ArrayList<>(1440); // 24 * 60 minutes
            for (short j = 0; j < 1440; j++) {
                minutes.add(new ArrayList<>(2));
            }
            char[] result = new char[n];

            boolean impossible = false;

            for (short j = 0; j < n; j++) {
                short s = in.nextShort();
                short e = in.nextShort();

                if (!impossible) {
                    for (short k = s; k < e; k++) {
                        List<Short> list = minutes.get(k);
                        if (list.size() >= 2) {
                            impossible = true;
                            break;
                        } else {
                            list.add((short) (j + 1)); // Index
                        }
                    }
                }
            }
            short cameron = 0;
            short prevCameron = 0;
            short jamie = 0;
            short prevJamie = 0;
            if (!impossible) {
                for (short j = 0; j < minutes.size(); j++) {
                    List<Short> list = minutes.get(j);
                    short task1 = list.size() >= 1 ? list.get(0) : -1;
                    short task2 = list.size() >= 2 ? list.get(1) : -1;
                    if (task1 == -1 && task2 == -1){
                        continue;
                    }
                    
                    if (task1 != -1 && task2 != -1){
                        boolean isCameronFree = task1 != prevCameron && task2 != prevCameron;
                        boolean isJamieFree = task1 != prevJamie && task2 != prevJamie;
                        boolean isTask1Free = task1 != prevCameron && task1 != prevJamie;
                        boolean isTask2Free = task2 != prevCameron && task2 != prevJamie;
                        
                        if (isCameronFree && isTask1Free){
                            cameron = task1;
                            result[task1 - 1] = 'C';
                            isTask1Free = false;
                        }else if (isCameronFree && isTask2Free){
                            cameron = task2;
                            result[task2 - 1] = 'C';
                            isTask2Free = false;
                        }

                        if (isJamieFree && isTask1Free){
                            jamie = task1;
                            result[task1 - 1] = 'J';
                        }else if (isJamieFree && isTask2Free){
                            jamie = task2;
                            result[task2 - 1] = 'J';
                        }
                    }else if (task1 != -1){
                        boolean isCameronFree = task1 != prevCameron;
                        boolean isJamieFree = task1 != prevJamie;
                        boolean isTask1Free = task1 != prevCameron && task1 != prevJamie;
                        if (isCameronFree && isTask1Free){
                            cameron = task1;
                            result[task1 - 1] = 'C';
                        } else if (isJamieFree && isTask1Free){
                            jamie = task1;
                            result[task1 - 1] = 'J';
                        }
                    }else {
                        boolean isCameronFree = task2 != prevCameron;
                        boolean isJamieFree = task2 != prevJamie;
                        boolean isTask2Free = task2 != prevCameron && task2 != prevJamie;
                        if (isCameronFree && isTask2Free){
                            cameron = task2;
                            result[task2 - 1] = 'C';
                        } else if (isJamieFree && isTask2Free){
                            jamie = task2;
                            result[task2 - 1] = 'J';
                        }
                    }

                    prevCameron = cameron;
                    prevJamie = jamie;
                }
            }

            System.out.println("Case #" + i + ": " + (impossible ? "IMPOSSIBLE" : String.valueOf(result)));
        }
    }
}