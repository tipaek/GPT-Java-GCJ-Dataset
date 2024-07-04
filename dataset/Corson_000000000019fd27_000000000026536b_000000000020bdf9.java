import java.util.*;
import java.io.*;
    public class Solution {
        public static void main(String[] args) {
            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int T = in.nextInt();
            in.nextLine();
    
            for(int tt = 0; tt < T; tt++) {
                int N = in.nextInt();
                String output = "";
                int []dzienC = new int[1450]; // same 0 //1440
                int []dzienJ = new int[1450];
                boolean impossible = false;
                for(int i = 0; i < N; i++) {
                    boolean c = true;
                    int s,e;
                    s = in.nextInt();
                    e = in.nextInt();
    
                    if (!impossible) {
                        boolean zajety = false;
                        for (int j = s; j < e; j++) {
                            if (dzienC[j] != 0) {
                                zajety = true;
                                break;
                            }
                        }
                        if(!zajety) {
                            for (int j = s; j < e; j++) {
                                dzienC[j]++;
                            }
                        }
                        if (zajety) {
                            c = false;
                            zajety = false;
                            for (int j = s; j < e; j++) {
                                if (dzienJ[j] != 0) {
                                    zajety = true;
                                    break;
                                }
                            }
                            if(!zajety) {
                                for (int j = s; j < e; j++) {
                                    dzienJ[j]++;
                                }
                            }
                        }
                        if (zajety) {
                            impossible = true;
                        }
                    }
                    if (c)
                        output += "C";
                    else
                        output += "J";
                }
                if (impossible)
                    output = "IMPOSSIBLE";
    
                System.out.println("Case #" + (tt+1) + ": " + output);
            }
        }
    }
