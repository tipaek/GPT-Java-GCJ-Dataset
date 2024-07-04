import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt(); 
        for (int t = 0; t < T; t++) {
            int N = in.nextInt();
            int[] start = new int[N];
            int[] end = new int[N];
            char[] resultArr = new char[N];
            
            for (int i = 0; i < N; i++) {
                start[i] = in.nextInt();
                end[i] = in.nextInt();
            }

            int count = 0;
            int Cin = -1;
            int Jin = -1;
            String result = "";

            for (int i = 0; i <= 1440; i++) {
                for (int j = 0; j < N; j++) {
                    if (end[j] == i) {
                        if (Cin == j) {
                            Cin = -1;
                            count--;
                        } else if (Jin == j) {
                            Jin = -1;
                            count--;
                        }
                    }

                    if (start[j] == i) {
                        if (count < 2) {
                            if (Jin == -1) {
                                Jin = j;
                                count++;
                                resultArr[j] = 'J';
                            } else if (Cin == -1) {
                                Cin = j;
                                count++;
                                resultArr[j] = 'C';
                            }
                        } else {
                            result = "IMPOSSIBLE";
                            break;
                        }
                    }
                }
                if (result.equals("IMPOSSIBLE")) {
                    break;
                }
            }

            if (!result.equals("IMPOSSIBLE")) {
                StringBuilder sb = new StringBuilder();
                for (char c : resultArr) {
                    sb.append(c);
                }
                result = sb.toString();
            }

            System.out.println("Case #" + (t + 1) + ": " + result);
        }
        in.close();
    }
}