
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        int numTestCases = Integer.parseInt(bi.readLine());

        for (int j = 0; j < numTestCases; j++) {
            int n = Integer.parseInt(bi.readLine()); // input

            List<EventRange> eventRanges = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String[] line = bi.readLine().split(" ");
                eventRanges.add(new EventRange(Integer.parseInt(line[0]), Integer.parseInt(line[1]), i));
            }

            Collections.sort(eventRanges, new Comparator<EventRange>() {
                @Override
                public int compare(EventRange p1, EventRange p2) {
                    if (p1.getStart() == p2.start) {
                        return p1.getEnd() - p2.getEnd();
                    }
                    return p1.getStart() - p2.getStart();
                }
            });

            int jEnd = 0;
            int cEnd = eventRanges.get(0).getEnd();
            eventRanges.get(0).setPerson("C");
            boolean impossible = false;

            for (int i = 1; i < eventRanges.size(); i++) {
                EventRange current = eventRanges.get(i);
                if (current.getStart() >= cEnd) {
                    current.setPerson("C");
                    cEnd = current.getEnd();
                } else if (current.getStart() >= jEnd) {
                    current.setPerson("J");
                    jEnd = current.getEnd();
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + (j + 1) + ": IMPOSSIBLE");
            } else {
                Collections.sort(eventRanges, new Comparator<EventRange>() {
                    @Override
                    public int compare(EventRange p1, EventRange p2) {
                        return p1.position - p2.position;
                    }
                });
                String out = "";
                for (EventRange eventRange : eventRanges) {
                    out = out + eventRange.person;
                }
                System.out.println("Case #" + (j + 1) + ": " + out);

            }


//            List<String> list = new ArrayList<>();
//            String out = String.join("", list);
//            System.out.println("Case #" + (j + 1) + ": " + out);
        }

    }

    static class EventRange {
        private int start;
        private int end;
        private int position;
        private String person;

        public EventRange(int st, int end, int position) {
            this.start = st;
            this.end = end;
            this.position = position;
        }

        public int getStart() {
            return this.start;
        }

        public int getEnd() {
            return end;
        }

        public String getPerson() {
            return person;
        }

        public void setPerson(String person) {
            this.person = person;
        }

        @Override
        public String toString() {
            return (start + " " + end + " " + position);
        }
    }
}
