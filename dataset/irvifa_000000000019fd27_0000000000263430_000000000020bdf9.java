import java.util.*;
import java.io.*;

class Result {
  List<Job> res;
  Set<Integer> idx;

  public Result(Set<Integer> idx, List<Job> res) {
    this.idx = idx;
    this.res = res;
  }
}

class Job {
  public int start;
  public int finish;
  public int name;

  public Job(int start, int finish, int name){
    this.start=start;
    this.finish=finish;
    this.name=name;
  }
  
  @Override
  public String toString(){
    return "[" + name + ": (" + start + ", " + finish + ")]";
  }
}

public class Solution {
  public static Result findOptimalJobScheule(List<Job> jobs){

    Collections.sort(jobs, Comparator.comparing(p -> p.finish));
    ArrayList<Job> resultList = new ArrayList<>();
    
 
    for(Job currentInterval : jobs) {
        if(resultList.isEmpty()) resultList.add(currentInterval);
        else{
            if(currentInterval.start >= resultList.get(resultList.size()-1).finish){
                resultList.add(currentInterval);
            }
        }
    }

    Set<Integer> idx = new HashSet<>();
    for (Job job: resultList) {
      idx.add(job.name);
    }
    return new Result(idx, resultList);
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


      List<Job> tmp = new ArrayList<>();
      List<Job> newJobs = new ArrayList<>();
      Result res = Solution.findOptimalJobScheule(jobs);
      char r[] = new char[n];
      for (int j = 0; j < n; j++) {
        if (!res.idx.contains(jobs.get(j).name)) {
          newJobs.add(jobs.get(j));
        } else {
          r[jobs.get(j).name] = 'C';
          tmp.add(jobs.get(j));
        }
      }

      res = Solution.findOptimalJobScheule(newJobs);

      for (int j = 0; j < n; j++) {
        if (res.idx.contains(jobs.get(j).name)) {
          r[jobs.get(j).name] = 'J';
          tmp.add(jobs.get(j));
        }
      }

      int cnt = 0;
      StringBuffer sb = new StringBuffer();
      for (int j = 0; j < n; j++) {
        if (r[j] == 'C' || r[j] == 'J') {
          sb.append(r[j]);
          cnt++;
        } else {
          break;
        }
      }
      
      if (tmp.size() != n) {
        System.out.println(String.format("Case #%d: %s", ++i, "IMPOSSIBLE"));
      } else {
        System.out.println(String.format("Case #%d: %s", ++i, sb.toString()));
      }
    }
  } 
}