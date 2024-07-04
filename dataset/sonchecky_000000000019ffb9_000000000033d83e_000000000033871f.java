import java.util.*;
import java.io.*;
public class Solution {
  static int [][] rules;
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t; i ++) {
      int c = in.nextInt();
      int d = in.nextInt();
      Computer [] computers = new Computer[c];
      int [] linkTimes = new int[d];
      for (int j = 0; j < d; j ++) linkTimes[j] = 1000000; // start all links at 1e6
      // initialize computers
      computers[0] = new Computer(0);
      for (int j = 1; j < c; j ++) computers[j] = new Computer(-in.nextInt());
      // initialize links
      for (int j = 0; j < d; j ++) {
        int int1 = in.nextInt()-1;
        int int2 = in.nextInt()-1;
        //System.out.println(int1 + " " + int2);
        Computer comp1 = computers[int1];
        Computer comp2 = computers[int2];
        comp1.neighbors.add(comp2);
        comp1.linkIndices.add(j);
        comp2.neighbors.add(comp1);
        comp2.linkIndices.add(j);
      }
      // loop through the computers in order of x
      for (int j = 1; j < c; j ++) {
        // find the computer with the smallest x not already reached
        int minX = Integer.MAX_VALUE;
        Computer minC = null;
        for (Computer comp : computers) {
          if (comp.x < minX && !(comp.reached)) {
            minC = comp;
            minX = comp.x;
          }
        }
        if (minC == null) break;
        // find a link between this computer and one already reached
        for (int k = 0; k < minC.neighbors.size(); k ++) {
          Computer neighbor = minC.neighbors.get(k);
          if (neighbor.x < minC.x) {
            linkTimes[minC.linkIndices.get(k)] = minC.x - neighbor.x;
            break;
          }
        }
        minC.reached = true;
      }
      // print output
      System.out.print("Case #" + i + ": ");
      for (int link : linkTimes)
        System.out.print(link + " ");
      System.out.println();
    }
  }
}

class Computer {
  public int x; // really -X in problem, order in which computers are reached
  public ArrayList<Computer> neighbors = new ArrayList<Computer>();
  public ArrayList<Integer> linkIndices = new ArrayList<Integer>();
  public boolean reached = false;
  public Computer (int order) {
    x = order;
    if (x == 0) reached = true;
  }
}
