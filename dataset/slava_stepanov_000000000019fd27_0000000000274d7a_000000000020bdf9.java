import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int caseNum = in.nextInt();

        for (int caseIndex = 1; caseIndex <= caseNum; caseIndex++) {
            int periodsNum = in.nextInt();

            List<TimePeriod> activities = new ArrayList<>();
            for (int i = 0; i < periodsNum; i++) {
                activities.add(new TimePeriod(in.nextInt(), in.nextInt()));
            }
            List<TimePeriod> byStartTime = new ArrayList<>(activities);
            List<TimePeriod> byEndTime = new ArrayList<>(activities);

            byStartTime.sort(Comparator.comparingInt(TimePeriod::getStartTime));
            byEndTime.sort(Comparator.comparingInt(TimePeriod::getEndTime));

            List<Person> people = new ArrayList<>();
            people.add(new Person("C"));
            people.add(new Person("J"));

            int startIndex = 0;
            int endIndex = 0;
            boolean impossible = false;
            while (startIndex < byStartTime.size() || endIndex < byEndTime.size()) {
                if (startIndex < byStartTime.size() &&
                        byStartTime.get(startIndex).getStartTime() < byEndTime.get(endIndex).endTime) {
                    // start new activity
                    Person toAssign = null;
                    for (Person person : people) {
                        if (person.isFree()) {
                            toAssign = person;
                            break;
                        }
                    }
                    if (toAssign == null) {
                        impossible = true;
                        break;
                    }
                    toAssign.setFree(false);
                    byStartTime.get(startIndex).setAssignee(toAssign);
                    startIndex++;
                } else {
                    // end ongoing activity
                    byEndTime.get(endIndex).getAssignee().setFree(true);
                    endIndex++;
                }
            }

            String result;
            if (impossible) {
                result = "IMPOSSIBLE";
            } else {
                result = activities.stream()
                        .map(TimePeriod::getAssignee)
                        .map(Person::getName)
                        .collect(Collectors.joining(""));
            }

            System.out.println("Case #" + caseIndex + ": " + result);
        }
    }

    public static class Person {
        private boolean free;
        private String name;

        public Person(final String name) {
            this.name = name;
            free = true;
        }

        public boolean isFree() {
            return free;
        }

        public void setFree(final boolean free) {
            this.free = free;
        }

        public String getName() {
            return name;
        }
    }

    public static class TimePeriod {
        private int startTime;
        private int endTime;
        private Person assignee;

        public TimePeriod(final int startTime, final int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public Person getAssignee() {
            return assignee;
        }

        public void setAssignee(final Person assignee) {
            this.assignee = assignee;
        }

    }

}