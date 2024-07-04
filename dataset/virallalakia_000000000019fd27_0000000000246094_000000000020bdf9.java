/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) 2020 Viral Lalakia                                           *
 ******************************************************************************
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * This is a solution for one of the problems for Google Code Jam 2020.
 * Competition: Google Code Jam 2020
 * Round: Qualification
 * Problem: Problem C (Parenting Partnering Returns)
 * Year: 2020
 */
public class Solution {

  private static final Scanner SYS_IN = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
  private static final String RESULT_IMPOSSIBLE = "IMPOSSIBLE";
  private static final char CHAR_C = 'C';
  private static final char CHAR_J = 'J';

  public static void main(String[] args) {
    int _T_ = SYS_IN.nextInt();
    SYS_IN.nextLine();
    for (int t = 0; t < _T_; t++) {
      System.out.println(evaluateCase(t + 1, SYS_IN.nextInt()));
    }
    SYS_IN.close();
  }

  private static String evaluateCase(final int t, final int _N_) {
    List<Task> IP_tasks = new ArrayList<>(_N_);
    char[] OP_assignedTasks = new char[_N_];
    try {
      SYS_IN.nextLine();
      for (int i = 0; i < _N_; i++) {
        IP_tasks.add(new Task(SYS_IN.nextInt(), SYS_IN.nextInt(), i));
        SYS_IN.nextLine();
      }
      Collections.sort(IP_tasks);
      List<Task> opList1 = new ArrayList<>();
      List<Task> opList2 = new ArrayList<>();
      if (splitTaskListIfNeeded(IP_tasks, opList1, opList2)) {
        for (Task task : opList1) {
          OP_assignedTasks[task.seq] = CHAR_C;
        }
        for (Task task : opList2) {
          OP_assignedTasks[task.seq] = CHAR_J;
        }
        return String.format("Case #%d: %s", t, new String(OP_assignedTasks));
      }
    } catch (Exception e) {
    }
    return String.format("Case #%d: %s", t, RESULT_IMPOSSIBLE);
  }

  private static boolean splitTaskListIfNeeded(List<Task> ipList, List<Task> opList1, List<Task> opList2) {
    opList1.add(ipList.get(0));
    for (int i = 0; i < ipList.size(); i++) {
      for (int j = i + 1; j < ipList.size(); j++) {
        if (ipList.get(i).doesOverlap(ipList.get(j))) {
          opList2.add(ipList.get(j));
        } else {
          opList1.add(ipList.get(j));
          i = j - 1;
          break;
        }
      }
    }
    for (int i = 0; i < opList2.size() - 1; i++) {
      if (opList2.get(i).doesOverlap(opList2.get(i + 1))) {
        return false;
      }
    }
    return true;
  }

  static class Task implements Comparable<Task> {
    int s;
    int e;
    int seq;

    public Task(int s, int e, int seq) {
      this.s = s;
      this.e = e;
      this.seq = seq;
    }

    public boolean doesOverlap(Task o) {
      if ((this.s < o.s && this.e <= o.s) || (this.s >= o.e && this.e > o.e)) {
        return false;
      }
      return true;
    }

    @Override
    public int compareTo(Task o) {
      if (this.s - o.s != 0) {
        return this.s - o.s;
      }
      if (this.e - o.e != 0) {
        return this.s - o.s;
      }
      return this.seq - o.seq;
    }
  }

}
