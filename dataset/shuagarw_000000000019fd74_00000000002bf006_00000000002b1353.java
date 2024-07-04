import java.util.ArrayList;
import java.util.HashSet;

import java.util.List;
import java.util.PriorityQueue;

import java.util.Scanner;


public class Solution {
  public static int[][] dir = {{1,1},{1,0},{0,1},{-1,0},{0,-1},{-1,-1}};
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    int cases = Integer.parseInt(in.nextLine());
    List<List<Integer>> triangle = generate(20);

    for(int i = 1; i<=cases ;i++) {
      int sum = Integer.parseInt(in.nextLine());
      List<List<Integer>> result = new ArrayList<>();
      answer(triangle, sum, 0, 0, result, new HashSet<>());

      System.out.println("Case #" + (i) + ": ");
      System.out.println("1 1");
      for(int  j = result.size() -1 ;j >=0 ;j--)
        System.out.println((result.get(j).get(0)) + " " + (result.get(j).get(1)));
      }


    }

  public static List<List<Integer>> generate(int numRows) {
    List<List<Integer>> triangle = new ArrayList<List<Integer>>();

    // First base case; if user requests zero rows, they get zero rows.
    if (numRows == 0) {
      return triangle;
    }

    // Second base case; first row is always [1].
    triangle.add(new ArrayList<>());
    triangle.get(0).add(1);

    for (int rowNum = 1; rowNum < numRows; rowNum++) {
      List<Integer> row = new ArrayList<>();
      List<Integer> prevRow = triangle.get(rowNum-1);

      // The first row element is always 1.
      row.add(1);

      // Each triangle element (other than the first and last of each row)
      // is equal to the sum of the elements above-and-to-the-left and
      // above-and-to-the-right.
      for (int j = 1; j < rowNum; j++) {
        row.add(prevRow.get(j-1) + prevRow.get(j));
      }

      // The last row element is always 1.
      row.add(1);

      triangle.add(row);
    }

    return triangle;
  }

  public static boolean answer(List<List<Integer>> triangle, int sum, int r, int c, List<List<Integer>> result, HashSet<String> visited) {
    if(r < 0 || c < 0 || r >= triangle.size() || c >= triangle.get(r).size() || (sum - triangle.get(r).get(c)) < 0){
      return false;
    }
    sum-=triangle.get(r).get(c);
    if(sum == 0) {
      return true;
    }


    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> {
      return triangle.get(b[0]).get(b[1]) - triangle.get(a[0]).get(a[1]);
    });
    for(int [] d : dir) {
      int nRow = r + d[0];
      int nCol = c + d[1];
      if (nRow < 0 || nCol < 0 || nRow >= triangle.size() || nCol >= triangle.get(nRow).size()) {
        continue;
      }
      priorityQueue.add(new int[]{nRow, nCol});
    }
    while(!priorityQueue.isEmpty()){
      int d[] = priorityQueue.poll();
      List<Integer> current = new ArrayList<>();
      current.add(d[0]+1);
      current.add(d[1]+1);

      if(visited.contains(current.get(0) + " " + current.get(1))){
        continue;
      }

      visited.add(current.get(0) + " " + current.get(1));
      if(answer(triangle, sum,d[0], d[1], result, visited)){
        result.add(current);
        return true;
      }
      visited.remove(current.get(0) + " " + current.get(1));
    }

    return false;
  }

}
