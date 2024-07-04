import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numCases; i++) {
            CaseInputs inputs = readCase(reader);
            CaseOutputs outputs = processCase(inputs);
            printOutput(i + 1, outputs);
        }
    }

    private static CaseOutputs processCase(CaseInputs inputs) {
        CaseOutputs outputs = new CaseOutputs();
        inputs.schedule.sort(Comparator.comparing(Event::getStart).thenComparing(Event::getFinish));

        Event jamieEvent = null;
        Event cameronEvent = null;

        for (Event event : inputs.schedule) {
            if (jamieEvent != null && jamieEvent.getFinish() <= event.getStart()) {
                jamieEvent = null;
            }
            if (cameronEvent != null && cameronEvent.getFinish() <= event.getStart()) {
                cameronEvent = null;
            }

            if (jamieEvent == null) {
                jamieEvent = event;
                event.setExecutor("J");
            } else if (cameronEvent == null) {
                cameronEvent = event;
                event.setExecutor("C");
            } else {
                outputs.result = "IMPOSSIBLE";
                return outputs;
            }
        }

        inputs.schedule.sort(Comparator.comparing(Event::getOrder));
        StringBuilder resultBuilder = new StringBuilder();
        for (Event event : inputs.schedule) {
            resultBuilder.append(event.getExecutor());
        }
        outputs.result = resultBuilder.toString();

        return outputs;
    }

    private static CaseInputs readCase(BufferedReader reader) throws IOException {
        CaseInputs inputs = new CaseInputs();
        int lines = Integer.parseInt(reader.readLine());
        inputs.activities = lines;
        inputs.schedule = new ArrayList<>();

        for (int i = 0; i < lines; i++) {
            String[] split = reader.readLine().split(" ");
            int start = Integer.parseInt(split[0]);
            int finish = Integer.parseInt(split[1]);
            Event event = new Event(start, finish, i);
            inputs.schedule.add(event);
        }

        return inputs;
    }

    private static void printOutput(int caseNum, CaseOutputs outputs) {
        System.out.printf("Case #%d: %s%n", caseNum, outputs.result);
    }

    static class Event {
        private int start;
        private int finish;
        private int order;
        private String executor;

        public Event(int start, int finish, int order) {
            this.start = start;
            this.finish = finish;
            this.order = order;
        }

        public int getStart() {
            return start;
        }

        public int getFinish() {
            return finish;
        }

        public int getOrder() {
            return order;
        }

        public String getExecutor() {
            return executor;
        }

        public void setExecutor(String executor) {
            this.executor = executor;
        }
    }

    static class CaseInputs {
        public int activities;
        public List<Event> schedule;
    }

    static class CaseOutputs {
        public String result;
    }
}