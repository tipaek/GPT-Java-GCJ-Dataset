import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int tasks = in.nextInt();
            String result = "";
            List<Integer> jTasks = new ArrayList<>();
            List<Integer> cTasks = new ArrayList<>();
            for(int j = 0; j < tasks; j++){
                int start = in.nextInt();
                int end = in.nextInt();
                if ( jTasks.size() == 0 ){
                    jTasks.add(start);
                    jTasks.add(end);
                    result += "J";
                } else {
                    boolean canJ = true;
                    for ( int z = 0; z < jTasks.size(); z +=2){
                        if (!(jTasks.get(z + 1) <= start || jTasks.get(z) >= end)) {
                            canJ = false;
                            break;
                        }
                    }
                    if( canJ ){
                        jTasks.add(start);
                        jTasks.add(end);
                        result += "J";
                    } else {
                        if ( cTasks.size() == 0) {
                            cTasks.add(start);
                            cTasks.add(end);
                            result += "C";
                        } else {
                            boolean canC = true;
                            for (int x = 0; x < cTasks.size(); x +=2 ){
                                if (!(cTasks.get(x + 1) <= start || cTasks.get(x) >= end)){
                                    canC = false;
                                    break;
                                }
                            }
                            if ( canC ){
                                cTasks.add(start);
                                cTasks.add(end);
                                result += "C";
                            } else {
                                result = "IMPOSSIBLE";
                                break;
                            }

                        }
                    }
                }

            }

            System.out.println("Case #" + i + ": " + result);
        }
    }
}