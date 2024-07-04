import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        new Solution().solveCases();
    }

    public void solveCases() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nCases = Integer.parseInt(br.readLine());
        for (int idx = 1; idx <= nCases; idx++) {
            solve(idx, br);
        }
    }

    public void solve(int caseNo, BufferedReader br) throws Exception {
        int nJobs = Integer.parseInt(br.readLine());

        List<Job> jobs = new ArrayList<>();
        for (int idx = 0; idx < nJobs; idx++) {
            String[] strJobArr = br.readLine().split(" ");
            jobs.add(new Job(idx, Integer.parseInt(strJobArr[0]), Integer.parseInt(strJobArr[1])));
        }
        printIfPossible(caseNo, jobs);
    }

    public void printIfPossible(int caseNo, List<Job> jobs) {
        StringBuilder resultBld = new StringBuilder();

        Set<Integer> timeSet = new TreeSet<>();
        Map<Integer, List<Job>> startJobs = new HashMap<>();
        Map<Integer, List<Job>> endJobs = new HashMap<>();

        for (Job job : jobs) {
            timeSet.add(job.startTime);
            timeSet.add(job.endTime);

            startJobs.computeIfAbsent(job.startTime, k -> new ArrayList<>()).add(job);
            endJobs.computeIfAbsent(job.endTime, k -> new ArrayList<>()).add(job);
        }

        Person jam = new Person("J");
        Person cam = new Person("C");

        Map<String, Person> persons = new HashMap<>();
        persons.put(jam.name, jam);
        persons.put(cam.name, cam);

        for (int time : timeSet) {
            if (endJobs.containsKey(time)) {
                for (Job endJob : endJobs.get(time)) {
                    Person person = persons.get(endJob.assignedTo);
                    if (person != null) person.freePerson();
                }
            }

            if (startJobs.containsKey(time)) {
                for (Job startJob : startJobs.get(time)) {
                    Person person = getFreePerson(persons);
                    if (person == null) {
                        System.out.println("Case #" + caseNo + ": IMPOSSIBLE");
                        return;
                    }
                    person.assignJob(startJob);
                }
            }
        }

        for (Job job : jobs) {
            resultBld.append(job.assignedTo);
        }
        System.out.println("Case #" + caseNo + ": " + resultBld.toString());
    }

    public Person getFreePerson(Map<String, Person> persons) {
        for (Person person : persons.values()) {
            if (person.isFree) {
                return person;
            }
        }
        return null;
    }

    class Person {
        String name;
        boolean isFree;
        int freeAt;

        public Person(String name) {
            this.name = name;
            this.isFree = true;
            this.freeAt = -1;
        }

        public void freePerson() {
            this.isFree = true;
            this.freeAt = -1;
        }

        public void assignJob(Job job) {
            job.assignedTo = this.name;
            this.isFree = false;
            this.freeAt = job.endTime;
        }
    }

    class Job {
        int idx;
        int startTime;
        int endTime;
        String assignedTo;

        public Job(int idx, int startTime, int endTime) {
            this.idx = idx;
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
}