import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

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

    private BufferedReader reader;
    private PrintWriter writer;
    private StringTokenizer tokenizer = null;

    private String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    private void solve() throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(System.out);
        int testCases = Integer.parseInt(nextToken());
        for (int i = 0; i < testCases; ++i) {
            String result = processCase();
            writer.println(String.format("Case #%d: %s", i + 1, result));
        }
        reader.close();
        writer.close();
    }

    private String processCase() throws IOException {
        int n = Integer.parseInt(nextToken());
        List<Schedule> schedules = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int start = Integer.parseInt(nextToken());
            int end = Integer.parseInt(nextToken());
            schedules.add(new Schedule(start, end, i));
        }

        schedules.sort(Comparator.comparingInt(Schedule::getStart));
        List<Schedule> startList = new ArrayList<>(schedules);

        schedules.sort(Comparator.comparingInt(Schedule::getEnd));
        List<Schedule> endList = new ArrayList<>(schedules);

        boolean cBusy = false;
        boolean jBusy = false;

        for (int si = 0, ei = 0; si < startList.size() || ei < endList.size(); ) {
            if (si == startList.size()) {
                Schedule s = endList.get(ei);
                if (s.isWorking()) {
                    s.setWorking(false);
                    if ("C".equals(s.getParent())) cBusy = false;
                    if ("J".equals(s.getParent())) jBusy = false;
                } else {
                    return "IMPOSSIBLE";
                }
                ei++;
            } else {
                if (startList.get(si).getStart() < endList.get(ei).getEnd()) {
                    Schedule s = startList.get(si);
                    if (!s.isWorking()) {
                        s.setWorking(true);
                        if (!cBusy) {
                            s.setParent("C");
                            cBusy = true;
                        } else if (!jBusy) {
                            s.setParent("J");
                            jBusy = true;
                        } else {
                            return "IMPOSSIBLE";
                        }
                    } else {
                        return "IMPOSSIBLE";
                    }
                    si++;
                } else {
                    Schedule s = endList.get(ei);
                    if (s.isWorking()) {
                        s.setWorking(false);
                        if ("C".equals(s.getParent())) cBusy = false;
                        if ("J".equals(s.getParent())) jBusy = false;
                    } else {
                        return "IMPOSSIBLE";
                    }
                    ei++;
                }
            }
        }

        schedules.sort(Comparator.comparingInt(Schedule::getIndex));
        StringBuilder result = new StringBuilder();
        for (Schedule s : schedules) {
            result.append(s.getParent());
        }

        return result.toString();
    }

    static class Schedule {
        private final int start;
        private final int end;
        private final int index;
        private boolean working;
        private String parent;

        public Schedule(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
            this.working = false;
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
            return working;
        }

        public void setWorking(boolean working) {
            this.working = working;
        }

        public String getParent() {
            return parent;
        }

        public void setParent(String parent) {
            this.parent = parent;
        }
    }
}