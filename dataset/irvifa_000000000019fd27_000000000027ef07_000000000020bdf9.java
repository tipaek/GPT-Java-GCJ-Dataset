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
  public static Set<Integer> findOptimalJobScheule(List<Job> jobs){
    Collections.sort(jobs, Comparator.comparing(p -> p.start));
    ArrayList<Job> resultList = new ArrayList<>();
    
    for(Job currentInterval : jobs) {
        if(resultList.isEmpty()) resultList.add(currentInterval);
        else if(currentInterval.start >= resultList.get(resultList.size() - 1).finish) {
          resultList.add(currentInterval);
        } 
    }

    Set<Integer> idx = new HashSet<>();
    for (Job job: resultList) {
      idx.add(job.name);
    }

    return idx;
  }
  
  
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(reader.readLine());
    for (int i = 0; i < t;) {
      int n = Integer.parseInt(reader.readLine());
      Map<Integer, Job> map = new HashMap<>();
      for (int j = 0; j < n; j++) {
        String[] tmp = reader.readLine().split(" ");
        Job job = new Job(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]), j);
        map.put(j, job);
      }

      Set<Integer> scheduled = Solution.findOptimalJobScheule(new ArrayList(map.values()));
      char r[] = new char[n];

      for (int key: scheduled) {
        if (map.containsKey(key)) {
          map.remove(key);
          r[key] = 'C';
        }
      }

      Set<Integer> newScheduled = Solution.findOptimalJobScheule(new ArrayList(map.values()));
      for (int key: newScheduled) {
        if (map.containsKey(key)) {
          map.remove(key);
          r[key] = 'J';
        }
      }

      StringBuffer sb = new StringBuffer();
      for (int j = 0; j < n; j++) {
        if (r[j] == 'C' || r[j] == 'J') {
          sb.append(r[j]);
        } else {
          break;
        }
      }
      
      if (map.size() != 0) {
        System.out.println(String.format("Case #%d: %s", ++i, "IMPOSSIBLE"));
      } else {
        System.out.println(String.format("Case #%d: %s", ++i, sb.toString()));
      }
    }
  } 
}