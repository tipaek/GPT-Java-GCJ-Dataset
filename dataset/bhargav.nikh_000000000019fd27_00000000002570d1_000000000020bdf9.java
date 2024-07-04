import java.util.*;
import java.io.*;

class Solution {
    public static void main (String[] args) throws Exception {
        new Solution().solveCases();
    }
    
    public void solveCases() throws Exception {
        BufferedReader br =  
                   new BufferedReader(new InputStreamReader(System.in)); 
        int nCases = Integer.valueOf(br.readLine());
        for (int idx = 1 ; idx <= nCases ; idx++) {
            solve (idx, br);
        }
    }
    
    public void solve(int caseNo, BufferedReader br) throws Exception {
        int nJobs = Integer.valueOf(br.readLine());
        
        List<Job> jobs = new ArrayList();
        for (int idx = 0 ; idx < nJobs ; idx++) {
            String[] strJobArr = br.readLine().split(" ");
            
            jobs.add(new Job(idx, Integer.valueOf(strJobArr[0]), 
                        Integer.valueOf(strJobArr[1])));
        }
        printIfPossible(caseNo, nJobs, jobs);
    }
    
    public void printIfPossible(int caseNo, int nJobs, List<Job> jobs) {
        StringBuilder resultBld = new StringBuilder();
        
        // Jobs
        Set<Integer> timeTreeSet = new TreeSet();
        Map<Integer, List<Job>> startJobs = new HashMap();
        Map<Integer, List<Job>> endJobs = new HashMap();
        
        for (Job job : jobs) {
            timeTreeSet.add(job.startTime);
            timeTreeSet.add(job.endTime);
            
            List<Job> startList = startJobs.getOrDefault(job.startTime, new ArrayList());
            startJobs.put(job.startTime, startList);
            startList.add(job);
            
            List<Job> endList = endJobs.getOrDefault(job.endTime, new ArrayList());
            endJobs.put(job.endTime, endList);
            endList.add(job);
        }
        // Persons
        Person jam = new Person("J");
        Person cam = new Person("C");
        
        Map<String, Person> persons = new HashMap();
        persons.put(jam.name, jam);
        persons.put(cam.name, cam);
        
        // Schedule Jobs
        for (int time : timeTreeSet) {
            // Free person(endTime)
            if (endJobs.containsKey(time)) {
                for (Job endJob : endJobs.get(time)) {
                    Person person = persons.get(endJob.assignedTo);
                    if (person != null)
                        person.freePerson();
                }
            }
            // Assign Jobs(startTime)
            if (startJobs.containsKey(time)) {
                for (Job startJob : startJobs.get(time)) {

                    Person person = getFreePerson(persons);
                    if (person == null) {
                        System.out.println("Case #"+caseNo+": IMPOSSIBLE");
                        return;
                    }
                    // Assign Job
                    person.assignJob(startJob);
                }
            }
            // Free person(endTime)
            // if (endJobs.containsKey(time)) {
            //     for (Job endJob : endJobs.get(time)) {
            //         Person person = persons.get(endJob.assignedTo);
            //         person.freePerson();
            //     }
            // }
        }
        
        // Print results
        for (Job job : jobs) {
            resultBld.append(job.assignedTo);
        }
        System.out.println("Case #"+caseNo+": "+resultBld.toString());
    }
    
    public Person getFreePerson (Map<String, Person> persons) {
        for (String name : persons.keySet()) {
            Person person = persons.get(name);
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
        
        public void assignJob (Job job) {
            // Update Job
            job.assignedTo = this.name;
            // Update Person
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