import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringBuilder sb = new StringBuilder();

            int T = Integer.parseInt(br.readLine());

            for (int t = 1; t <= T; t++) {
                StringBuilder assignResult = new StringBuilder();

                int N = Integer.parseInt(br.readLine());
                List<Job> jobs = new ArrayList<>();
                for (int i = 0; i < N; i++) {
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    int startTime = Integer.parseInt(st.nextToken());
                    int endTime = Integer.parseInt(st.nextToken());
                    jobs.add(new Job(startTime, endTime));
                }
                List<Job> sortedJobs = new ArrayList<>(jobs);
                Collections.sort(sortedJobs);

                List<Person> people = new ArrayList<>();
                people.add(new Person("C"));
                people.add(new Person("J"));

                boolean assigned = false;
                for (Job job : sortedJobs) {
                    assigned = false;
                    for (Person person : people) {
                        if (person.getEndTime() <= job.startTime) {
                            assigned = true;
                            person.setEndTime(job.getEndTime());
                            job.setAssignee(person);
                            break;
                        }
                    }

                    if (!assigned) {
                        break;
                    }
                }
                if (!assigned) {
                    assignResult = new StringBuilder("IMPOSSIBLE");
                } else {
                    for (Job job : jobs) {
                        assignResult.append(job.getAssignee().getNickName());
                    }
                }

                sb.append("Case #").append(t).append(": ").append(assignResult.toString()).append('\n');
            }

            bw.write(sb.toString());
            bw.flush();
        }
    }

    static class Person {
        private final String nickName;
        private int endTime;

        Person(String nickName) {
            this.nickName = nickName;
        }

        public String getNickName() {
            return nickName;
        }

        public int getEndTime() {
            return endTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }
    }

    static class Job implements Comparable<Job> {
        private final int startTime;
        private final int endTime;
        private Person assignee;

        Job(int startTime, int endTime) {
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

        public void setAssignee(Person person) {
            this.assignee = person;
        }

        @Override
        public int compareTo(Job o) {
            return Integer.compare(startTime, o.startTime);
        }
    }
}