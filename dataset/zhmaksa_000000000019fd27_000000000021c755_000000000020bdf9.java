import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

            Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

            int line = scanner.nextInt();

            for (int i = 0; i < line; i++) {

                int n = scanner.nextInt();
                int[][] j = new int[n][2];
                int jC = 0;
                int[][] c = new int[n][2];
                int cC = 0;
                String result = "";

                for (int k = 0; k < n; k++) {
                    int start = scanner.nextInt();
                    int end = scanner.nextInt();

                    if(!result.equals("IMPOSSIBLE")){
                        if(jC == 0){
                            j[jC][0] = start;
                            j[jC++][1] = end;
                            result = "C";
                        } else {
                            boolean jSatisfy = true;
                            for (int t = 0; t < j.length; t++) {
                                if((start > j[t][0] && start < j[t][1]) ||  (end > j[t][0] && end < j[t][1]) || (start >= j[t][0] && end <= j[t][1]) || (start <= j[t][0] && end >= j[t][1])){
                                    jSatisfy = false;
                                    break;
                                }
                            }
                            if (jSatisfy){
                                j[jC][0] = start;
                                j[jC++][1] = end;
                                result = result  + "C";
                            } else {
                                if(cC == 0){
                                    c[cC][0] = start;
                                    c[cC++][1] = end;
                                    result = result  + "J";
                                } else {
                                    boolean cSatisfy = true;
                                    for (int t = 0; t < j.length; t++) {
                                        if((start > c[t][0] && start < c[t][1]) ||  (end > c[t][0] && end < c[t][1]) || (start >= c[t][0] && end <= c[t][1]) || (start <= c[t][0] && end >= c[t][1])){
                                            cSatisfy = false;
                                            break;
                                        }
                                    }
                                    if (cSatisfy){
                                        c[cC][0] = start;
                                        c[cC++][1] = end;
                                        result = result  + "J";
                                    } else {
                                        result = "IMPOSSIBLE";
                                    }
                                }
                            }
                        }
                    }
                }

                System.out.println("Case #" + (i + 1) + ": " + result);
            }
        }
    }
