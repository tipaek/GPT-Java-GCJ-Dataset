import java.util.Scanner;
import java.util.*;
import java.util.HashMap;

class Task implements Comparable<Task> {
    int start;
    int end;
    public Task(int start, int end) {
        this.start = start;
        this.end = end;
    }
    
    public int getStart() {
        return start;
    }
    
    public int getEnd() {
	    return end;
    }
    
    @Override
    public int compareTo(Task comparestu) {
        int compareage=((Task)comparestu).getEnd();
        return this.end-compareage;
    }

    @Override
    public String toString() {
        return "[ start=" + start + ", end=" + end + "]";
    }
}

class Parent {
    int end;
    
    public Parent(int end) {
        this.end = end;
    }
    
    public boolean addTask(Task newTask) {
        if (end > newTask.getStart()) {
            return false;
        }
        end = newTask.getEnd();
        return true;
    }
}

public class Solution {
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int T = input.nextInt();
    for (int ks = 1; ks <= T; ks++) {
        int n = input.nextInt();
        Parent C = new Parent(-1);
        Parent J = new Parent(-1);
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        ArrayList<Task> tasks = new ArrayList<Task>();
        for (int i = 0; i < n; i++) {
            int start = input.nextInt();
            int end = input.nextInt();
            Task task = new Task(start, end);
            tasks.add(task);
            map.put("" + start + "|" + end + "", i);
        }
        
        Collections.sort(tasks);
        
        String[] can = new String[n];
        for (Task t : tasks) {
            int index = map.get("" + t.getStart() + "|" + t.getEnd() + "");
            if (C.addTask(t)) {
                can[index] = "C";
            } else if (J.addTask(t)) {
                can[index] = "J";
            } else {
                break;
            }
        }
        
        String y = "";
        for (String c : can) {
            if (c == "J" || c == "C") {
                y += c;
            } else {
                y = "IMPOSSIBLE";
                break;
            }
        }
        
        System.out.println("Case # " + ks + ": " + y);
    }
  }
}