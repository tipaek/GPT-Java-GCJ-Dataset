import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Solution implements Runnable {
    public static void main(String[] args) {
        new Thread(new Solution()).start();
    }

    @Override
    public void run() {
        try {
            solve();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    BufferedReader rd;
    PrintWriter wr;
    StringTokenizer tok = null;

    String nextToken() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(rd.readLine());
        }
        return tok.nextToken();
    }

    private void solve() throws IOException {
        rd = new BufferedReader(new InputStreamReader(System.in));
        wr = new PrintWriter(System.out);
        int t = Integer.parseInt(nextToken());
        for (int i = 0; i < t; ++i) {
            String res = subsolve();
            wr.println(String.format("Case #%d: %s", i + 1, res));
        }
        rd.close();
        wr.close();
    }

    private String subsolve() throws IOException {
        int n = Integer.parseInt(nextToken());
        List<Schedule> schedules = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int s = Integer.parseInt(nextToken());
            int e = Integer.parseInt(nextToken());

            Schedule schedule = new Schedule(s, e, i);
            schedules.add(schedule);
        }


        schedules.sort(Comparator.comparing(Schedule::getStart));
        List<Schedule> startList = new ArrayList<>(schedules);

        schedules.sort(Comparator.comparing(Schedule::getEnd));
        List<Schedule> endList = new ArrayList<>(schedules);

        boolean cWork = false;
        boolean jWork = false;

        for(int si = 0, ei = 0; si < startList.size() || ei < endList.size(); ) {
            if(si == startList.size()) {
                Schedule s = endList.get(ei);
                if(s.isWorking()) {
                    s.setIsWorking(false);
                    if(s.getParent().equals("C"))
                        cWork = false;
                    if(s.getParent().equals("J"))
                        jWork = false;
                } else
                    return "IMPOSSIBLE";
                ei++;

            } else {
                if(startList.get(si).getStart() < endList.get(ei).getEnd()) {
                    Schedule s = startList.get(si);
                    if(! s.isWorking()) {
                        s.setIsWorking(true);
                        if(!cWork) {
                            s.setParent("C");
                            cWork = true;
                        } else if(!jWork) {
                            s.setParent("J");
                            jWork = true;
                        } else {
                            return "IMPOSSIBLE";
                        }
                    } else
                        return "IMPOSSIBLE";
                    si++;
                } else {
                    Schedule s = endList.get(ei);
                    if(s.isWorking()) {
                        s.setIsWorking(false);
                        if(s.getParent().equals("C"))
                            cWork = false;
                        if(s.getParent().equals("J"))
                            jWork = false;
                    } else
                        return "IMPOSSIBLE";

                    ei++;
                }
            }
        }

        schedules.sort(Comparator.comparing(Schedule::getIndex));

        StringBuilder sb = new StringBuilder();
        for(Schedule s : schedules) {
            sb.append(s.getParent());
        }

        return sb.toString();
    }

    static class Schedule {
        int start;
        int end;
        int index;
        boolean isWorking;
        String parent;

        public Schedule(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
            this.isWorking = false;
        }

        public int getStart() {
            return start;
        }
        public int getEnd() {
            return end;
        }

        public int getIndex() {
            return index;
        }

        public boolean isWorking() {
            return this.isWorking;
        }

        public void setIsWorking(boolean isWorking) {
            this.isWorking = isWorking;
        }

        public String getParent() {
            return this.parent;
        }

        public void setParent(String parent) {
            this.parent = parent;
        }
    }
}