import java.io.*;
import java.util.*;

public class Solution {

  static Integer[][] neighbours = {{-1, -1}, {-1, 0}, {0, -1}};

  static class Cell {

    int r;
    int c;

    public Cell(int r, int c) {
      this.r = r;
      this.c = c;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Cell cell = (Cell) o;
      return r == cell.r &&
          c == cell.c;
    }

    @Override
    public int hashCode() {
      return Objects.hash(r, c);
    }
  }

  static class Prev {

    Cell prevCell;
    int prevValue;

    public Prev(int r, int c, int prevValue) {
      this.prevCell = new Cell(r, c);
      this.prevValue = prevValue;
    }
  }

  public static void main(String args[]) {
    Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = input.nextInt();
    for (int ks = 1; ks <= T; ks++) {
      System.out.println("Case #" + ks + ":\n");
      pascalPath(input.nextInt());
    }
  }

  private static void pascalPath(int N) {
    List<Integer[]> results = new ArrayList<>();
    Map<Cell, Map<Integer, Prev>> dp = new HashMap<>();

    List<Integer> pascalRow = new ArrayList<>();
    pascalRow.add(1);
    int row = 0;
    Map<Integer, Prev> val = new HashMap<>();
    val.put(1, new Prev(-1, -1, 0));
    dp.put(new Cell(0, 0), val);
    int col = 0;
    boolean found = N == 1;

    while (!found) {
      row++;
      pascalRow = getNewPascalRow(pascalRow);
      for (int c = 0; c < pascalRow.size() && !found; c++) {
        val = new HashMap<>();
        for (int n = 0; n < neighbours.length && !found; n++) {
          Integer[] neighbour = neighbours[n];
          if (valid(row, c, neighbour)) {
            Map<Integer, Prev> integerPrevMap = dp
                .get(new Cell(row + neighbour[0], c + neighbour[1]));
            for (Integer value : integerPrevMap.keySet()) {
              if (!val.containsKey(value + pascalRow.get(c))) {
                val.put(value + pascalRow.get(c),
                    new Prev(row + neighbour[0], c + neighbour[1], value));
              }
              if (value + pascalRow.get(c) == N) {
                found = true;
                col = c;
                break;
              }
            }
          }
        }
        dp.put(new Cell(row, c), val);
      }
    }

    int currentVal = N;
    while (currentVal > 0) {
      results.add(new Integer[]{row, col});
      Prev prev = dp.get(new Cell(row, col)).get(currentVal);
      row = prev.prevCell.r;
      col = prev.prevCell.c;
      currentVal = prev.prevValue;
    }

    for (int i = results.size() - 1; i >= 0; i--) {
      Integer[] result = results.get(i);
      System.out.println((result[0] + 1) + " " + (result[1] + 1));
    }
  }

  private static boolean valid(int row, int c, Integer[] neighbour) {
    if (c + neighbour[1] < 0 || c + neighbour[1] > row + neighbour[0]) {
      return false;
    }
    return true;
  }

  private static List<Integer> getNewPascalRow(List<Integer> pascalRow) {
    List<Integer> newPascalRow = new ArrayList<>();
    newPascalRow.add(1);
    for (int i = 0; i < pascalRow.size() - 1; i++) {
      newPascalRow.add(pascalRow.get(i) + pascalRow.get(i + 1));
    }
    newPascalRow.add(1);
    return newPascalRow;
  }

}