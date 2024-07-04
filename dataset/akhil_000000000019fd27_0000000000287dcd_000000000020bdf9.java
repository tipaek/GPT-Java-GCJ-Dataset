import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    int numCases = Integer.parseInt(scanner.nextLine());

    for (int index = 1; index <= numCases; index++) {
      int numTasks = Integer.parseInt(scanner.nextLine());
      int[][] chores = new int[numTasks][2];
      for (int id = 0; id < numTasks; id++) {
        String line = scanner.nextLine();
        String[] tokens = line.split(" ");
        chores[id][0] = Integer.parseInt(tokens[0]);
        chores[id][1] = Integer.parseInt(tokens[1]);
      }
      System.out.println("Case #" + index + ": " + allocateToCJ(chores, 1440));
    }
  }


  public static String allocateToCJ(int[][] activities, int totalSlots) {

    StringBuilder toReturn = new StringBuilder();

    boolean[] c = new boolean[totalSlots];
    boolean[] j = new boolean[totalSlots];

    for (int i = 0; i < totalSlots; i++) {
      c[i] = false;
      j[i] = false;
    }

    for (int[] tuple: activities) {
      if (isFree(c, tuple[0], tuple[1])) {
        for (int id = tuple[0]; id < tuple[1]; id++) {
          c[id] = true;
        }
        toReturn.append('C');
      } else if (isFree(j, tuple[0], tuple[1])) {
        for (int id = tuple[0]; id < tuple[1]; id++) {
          j[id] = true;
        }
        toReturn.append('J');
      } else {
        toReturn.setLength(0);
        toReturn.append("IMPOSSIBLE");
        break;
      }
    }
    return toReturn.toString();
  }

  public static boolean isFree (boolean[] array, int begin, int end) {

    for (int index = begin; index < end; index++) {
      if (array[index]) {
        return false;
      }
    }
    return true;
  }
}