import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        new Solution().solveCases();
    }
    
    public void solveCases() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int nCases = Integer.parseInt(br.readLine());
        for (int idx = 1; idx <= nCases; idx++) {
            solveCase(idx, br);
        }
    }
    
    public void solveCase(int caseNo, BufferedReader br) throws Exception {
        int nJobs = Integer.parseInt(br.readLine());
        List<Job> jobs = new ArrayList<>();
        
        for (int idx = 0; idx < nJobs; idx++) {
            String[] jobDetails = br.readLine().split(" ");
            jobs.add(new Job(idx, Integer.parseInt(jobDetails[0]), Integer.parseInt(jobDetails[1])));
        }
        
        scheduleJobs(caseNo, jobs);
    }
    
    public void scheduleJobs(int caseNo, List<Job> jobs) {
        StringBuilder result = new StringBuilder();
        TreeSet<Integer> times = new TreeSet<>();
        Map<Integer, List<Job>> startJobs = new HashMap<>();
        Map<Integer, List<Job>> endJobs = new HashMap<>();
        
        for (Job job : jobs) {
            times.add(job.startTime);
            times.add(job.endTime);
            
            startJobs.computeIfAbsent(job.startTime, k -> new ArrayList<>()).add(job);
            endJobs.computeIfAbsent(job.endTime, k -> new ArrayList<>()).add(job);
        }
        
        Person jam = new Person("J");
        Person cam = new Person("C");
        Map<String, Person> persons = new HashMap<>();
        persons.put(jam.name, jam);
        persons.put(cam.name, cam);
        
        for (int time : times) {
            if (endJobs.containsKey(time)) {
                for (Job job : endJobs.get(time)) {
                    persons.get(job.assignedTo).free();
                }
            }
            
            if (startJobs.containsKey(time)) {
                for (Job job : startJobs.get(time)) {
                    Person person = getFreePerson(persons);
                    if (person == null) {
                        System.out.println("Case #" + caseNo + ": IMPOSSIBLE");
                        return;
                    }
                    person.assignJob(job);
                }
            }
            
            if (endJobs.containsKey(time)) {
                for (Job job : endJobs.get(time)) {
                    persons.get(job.assignedTo).free();
                }
            }
        }
        
        for (Job job : jobs) {
            result.append(job.assignedTo);
        }
        
        System.out.println("Case #" + caseNo + ": " + result.toString());
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
        
        public Person(String name) {
            this.name = name;
            this.isFree = true;
        }
        
        public void free() {
            this.isFree = true;
        }
        
        public void assignJob(Job job) {
            job.assignedTo = this.name;
            this.isFree = false;
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