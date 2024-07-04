
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

  static List<Integer> listaC = null;
  static List<Integer> listaD = null;
  static Integer result = null;
  static Integer K = null;

  public static void main(String[] args) throws Exception {
    
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings,
                          // chars, etc.
    for (int i = 1; i <= t; ++i) {
      // System.out.println("Inizio");
      // int n = in.nextInt();
      // int m = in.nextInt();
      String output = analizzaTest(in);
      System.out.println("Case #" + i + ": " + output);
    }

  }

  public static String analizzaTest(Scanner in) {
    int size = in.nextInt();
    int[][] square = new int[size][size];
    Integer k = 0;
    Integer r = 0;
    Integer c = 0;
    List<List<Integer>> colonne = new ArrayList<>();
    List<List<Integer>> righe = new ArrayList<>();
    for (int x = 0; x < size; x++) {
      righe.add(new ArrayList<>());
      colonne.add(new ArrayList<>());
    }
    for (int x = 0; x < size; x++) {
      for (int y = 0; y < size; y++) {
        square[x][y] = in.nextInt();
        colonne.get(y).add(square[x][y]);
        righe.get(x).add(square[x][y]);
      }
    }
    for (int x = 0; x < size; x++) {
      k += square[x][x];
    }
    // System.out.println("Colonne");
    for (List<Integer> colonna : colonne) {
      Map<Object, Long> counts = colonna.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
      for (Object chiave : counts.keySet()) {
        if (counts.get(chiave) > 1) {
          c++;
          break;
        }
      }
    }
    for (List<Integer> riga : righe) {
      Map<Object, Long> counts = riga.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
      for (Object chiave : counts.keySet()) {
        if (counts.get(chiave) > 1) {
          r++;
          break;
        }
      }
    }
    return k + " " + r + " " + c + " ";
  }
}