import java.util.*;
import java.io.*;

class Result {
  List<Job> jobs;
  List<Job> res;

  public Result(List<Job> jobs, List<Job> res) {
    this.jobs = jobs;
    this.res = res;
  }
}

class Job implements Comparable<Job> {
  public int start;
  public int finish;
  public int name;

  public Job(int start, int finish, int name){
    this.start=start;
    this.finish=finish;
    this.name=name;
  }

  //Compare jobs by finish time
  @Override
  public int compareTo(Job job) {
    return this.start - job.start;
  }
  
  @Override
  public String toString(){
    return "[" + name + ": (" + start + ", " + finish + ")]";
  }
}

public class Solution {
  public static Result findOptimalJobScheule(List<Job> jobs){
    Collections.sort(jobs);

    LinkedList<Job> jobsSelected = new LinkedList<Job>();
    jobsSelected.add(jobs.get(0)); 
    Job lastJobAdded = jobs.get(0);
    int i = 1;
    for(; i<jobs.size(); i++){
      if(jobs.get(i).start >= lastJobAdded.finish) {
        jobsSelected.add(jobs.get(i));
        lastJobAdded = jobs.get(i);
        jobs.remove(i);
      }
    }

    jobs.remove(0);
    if(jobs.size() != 0 && jobs.get(0).start >= lastJobAdded.finish) {
        jobsSelected.add(jobs.get(0));
        lastJobAdded = jobs.get(0);
        jobs.remove(0);
    }

    return new Result(jobs, jobsSelected);
  }
  
  
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(reader.readLine());
    for (int i = 0; i < t;) {
      int n = Integer.parseInt(reader.readLine());
      List<Job> jobs = new ArrayList<>();
      for (int j = 0; j < n; j++) {
        String[] tmp = reader.readLine().split(" ");
        jobs.add(new Job(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]), j));
      }
      Result res = Solution.findOptimalJobScheule(jobs);
      char[] seq = new char[n];
      jobs = res.jobs;
      int cnt = res.res.size();
      for (int j = 0; j < res.res.size(); j++) {
        seq[res.res.get(j).name] = 'C';
      }
      if (jobs.size() > 0) {
        res = Solution.findOptimalJobScheule(jobs);
        cnt += res.res.size();
        for (int j = 0; j < res.res.size(); j++) {
          seq[res.res.get(j).name] = 'J';
        }
      }
      if (cnt != n) {
        System.out.println(String.format("Case #%d: %s", ++i, "IMPOSSIBLE"));
      } else {
        System.out.println(String.format("Case #%d: %s", ++i, new String(seq)));
      }
    }
    
  }
}