import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int casei = 1; casei <= t; ++casei) {
            int n = in.nextInt();
            boolean isImpossible = false;
            int s[] = new int[n];
            int e[] = new int[n];
            Act acts[] = new Act[n];
            int slot[] = new int[24 * 60];
            char assign[] = new char[n];
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < n; i++) {
                assign[i] = 'X';
                int si = in.nextInt();
                int ei = in.nextInt();
                acts[i] = new Act(i, si, ei, 'X');
                //                s[i] = in.nextInt();
                //                e[i] = in.nextInt();
                for (int j = si; j < ei; j++) {
                    slot[j]++;
                    if (slot[j] == 3) {
                        isImpossible = true;
                        break;
                    }
                }
                if (isImpossible) {
                    break;
                }
            }
            if (isImpossible) {
                System.out.println("Case #" + casei + ": IMPOSSIBLE");
                continue;
            }
            List<Act> actsl = Arrays.asList(acts);
            actsl.stream().sorted(Comparator.comparing(Act::getEnd)).sorted(Comparator.comparing(Act::getStart));

            int lastCstart = 0;
            int lastCend = 0;
            int lastJstart = 0;
            int lastJend = 0;
            //            for (Act act : actsl) {
            //                System.out.println("# " + casei +"# " + act.id + "# " + act.start +"# " + act.end );
            //
            //            }
            Collections.sort(actsl, new MyComp());
            for (int i = 0; i < actsl.size(); i++) {
                //System.out.println("# " + casei +"# " + actsl.get(i).id + "# " + actsl.get(i).start +"# " + actsl.get(i).end );

                if (lastCend <= actsl.get(i).start) {
                    //assign to c
                    lastCend = actsl.get(i).end;
                    assign[actsl.get(i).id] = 'C';
                } else if (lastJend <= actsl.get(i).start) {
                    lastJend = actsl.get(i).end;
                    assign[actsl.get(i).id] = 'J';
                }
            }
            actsl.stream().sorted(Comparator.comparing(Act::getId));
            for (int i = 0; i < actsl.size(); i++) {
                sb.append(assign[i]);
            }
            //            int ii=0;
            //            while (ii<5) {
            ////                Act fastestAct = .orElseThrow(NoSuchElementException::new);
            ////                System.out.println("t:"+casei+" fast:"+fastestAct.start);
            //                ii++;
            //            }

            System.out.println("Case #" + casei + ": " + sb.toString());
        }
    }
}

class MyComp implements Comparator<Act> {
    public int compare(Act c1, Act c2) {
        if (c1.getStart() < c2.getStart()) {
            return -1;
        } else if (c1.getEnd() > c2.getEnd()) {
            return 1;
        } else {
            return 0;
        }
    }
}

class Act {

    public Act(int id, int start, int end, char assignee) {
        super();
        this.id = id;
        this.start = start;
        this.end = end;
        this.assignee = assignee;
    }

    public char getAssignee() {
        return assignee;
    }

    public void setAssignee(char assignee) {
        this.assignee = assignee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    int id;
    int start;
    int end;
    char assignee;
}
