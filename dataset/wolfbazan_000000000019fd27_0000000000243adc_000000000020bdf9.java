import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    static int LIMIT_TIME = 1440;
    PrintStream out = System.out;
        Scanner in  = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    private void solve(int testcase) {
        int numTasks = in.nextInt();
        ArrayList<Integer> CTimeLines = new ArrayList<>();
        ArrayList<Integer> JTimeLines = new ArrayList<>();

        StringBuffer stringBuffer = new StringBuffer();
        for(int i= 0; i < numTasks; ++i) {
            int start = in.nextInt();
            int end = in.nextInt();

            if(canAssign(CTimeLines, start, end)) {
                stringBuffer.append("C");
            } else if(canAssign(JTimeLines, start, end)) {
                stringBuffer.append("J");
            } else {
                stringBuffer = new StringBuffer();
                stringBuffer.append("IMPOSSIBLE");
                break;
            }
        }

        out.println("Case #" + testcase + ": " + stringBuffer.toString());
    }

    boolean canAssign(ArrayList<Integer> listTimeLines, int start, int end) {
        if(start > end) return false;
        if(end > LIMIT_TIME) return false;
        if(start < 0) return false;

        int size = listTimeLines.size();
        if(size == 0) {
            listTimeLines.add(start);
            listTimeLines.add(end);
            Collections.sort(listTimeLines);
            return true;
        }
        int timeBusy = listTimeLines.get(0);
        int timeFree = listTimeLines.get(size -1);

        if(start >= timeFree || end <= timeBusy) {
            listTimeLines.add(start);
            listTimeLines.add(end);
            Collections.sort(listTimeLines);
            return true;
        }

        return false;
    }

    void run() {
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            solve(i);
        }
        in.close();
        out.close();
    }

    public static void main(String[] args) {
        new Solution().run();
    }
}
