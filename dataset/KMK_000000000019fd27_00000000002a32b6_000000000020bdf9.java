import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            int[][] tasks = new int[n][2];
            for (int j=0; j<n; j++) {
                tasks[j][0] = scanner.nextInt();
                tasks[j][1] = scanner.nextInt();
            }
            List<Integer> starts = new ArrayList<>();
            for (int z =0; z < n; z++) {
                starts.add(tasks[z][0]);
            }
            String[] strings = new String[n];
            Arrays.sort(tasks, Comparator.comparingDouble(o -> o[0]));
            int day = 24 * 60;
            int J[] = new int[1];
            int C[] = new int[1];
            //StringBuilder sb = new StringBuilder();
            int task = 0;
            boolean imp = false;
            for (int time =tasks[0][0]; time < day; time ++) {
                if (J[0] == time) {
                    //check if that task is completing
                    J[0] = 0;
                }
                if (C[0] == time) {
                    //check if that task is completing
                    C[0] = 0;
                }
                if (task == n && C[0] == 0 && J[0] ==0) {
                    break;
                }
                if (task == n) {
                    continue;
                }
                if (tasks[task][0] == time) {
                    int pos = starts.indexOf(time);
                    if (J[0] == 0) {
                        J[0] = tasks[task][1];
                        strings[pos] = "J";
                        //sb.append('J');
                        task++;
                    } else if (C[0] == 0) {
                        C[0] = tasks[task][1];
                        strings[pos] = "C";
                        //sb.append('C');
                        task++;
                    } else {
                        //sb = new StringBuilder();
                        //sb.append("IMPOSSIBLE");
                        imp = true;
                        break;
                    }
                    if (task < n && tasks[task][0] == time) {
                        if (J[0] == 0) {
                            J[0] = tasks[task][1];
                            for (int v = pos+1; v < n; v++) {
                                if (starts.get(v) == time) {
                                    pos = v;
                                    break;
                                }
                            }
                            strings[pos] = "J";
                            //sb.append('J');
                            task++;
                        } else if (C[0] == 0) {
                            C[0] = tasks[task][1];
                            for (int v = pos+1; v < n; v++) {
                                if (starts.get(v) == time) {
                                    pos = v;
                                    break;
                                }
                            }
                            strings[pos] = "C";
                            //sb.append('C');
                            task++;
                        } else {
                            //sb = new StringBuilder();
                            //sb.append("IMPOSSIBLE");
                            imp = true;
                            break;
                        }
                    }
                    if (task < n && tasks[task][0] == time) {
                        imp = true;
                        break;
                    }
                }

            }
            if (imp) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
            else {
                StringBuilder sb = new StringBuilder();
                for (int z=0; z < n; z++) {
                    sb.append(strings[z]);
                }
                System.out.println("Case #" + i + ": " + sb.toString());
            }
        }
    }
}