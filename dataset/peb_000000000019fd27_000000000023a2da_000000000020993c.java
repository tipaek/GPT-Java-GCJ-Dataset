
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

  static List<int[][]> matrices = new ArrayList<>();

  public static void main(String[] args) {

    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {

      int size = in.nextInt();
      int[][] matrice = new int[size][size];

      for (int x = 0; x < size; x++) {
        for (int y = 0; y < size; y++) {
          int n = in.nextInt();
          matrice[x][y] = n;
        }
      }

      matrices.add(matrice);
    }

    for (int i = 0; i < matrices.size(); i++) {
      printOutput(i + 1, matrices.get(i));
    }

  }

  private static void printOutput(int i, int[][] matrice) {
    int size = matrice.length;

    int trace = 0;
    int nbRows = 0;
    int nbColumns = 0;
    // check row
    for (int x = 0; x < size; x++) {
      for (int y = 0; y < size; y++) {
        int n = matrice[x][y];
        if (x == y) {
          trace += n;
        }
      }

      if (isDuplicatedRow(matrice, x)) {
        nbRows++;
      }

      if (isDuplicatedColumn(matrice, x)) {
        nbColumns++;
      }
    }

    System.out.println("Case #" + i + ": " + trace + " " + nbRows + " " + nbColumns);

  }

  private static boolean isDuplicatedRow(int[][] matrice, int row) {
    int size = matrice.length;

    for (int i = 0; i < size; i++) {

      int n = matrice[row][i];

      for (int z = i + 1; z < size; z++) {
        if (matrice[row][z] == n) {
          return true;
        }
      }
    }

    return false;
  }

  private static boolean isDuplicatedColumn(int[][] matrice, int column) {
    int size = matrice.length;

    for (int i = 0; i < size; i++) {

      int n = matrice[i][column];

      for (int z = i + 1; z < size; z++) {
        if (matrice[z][column] == n) {
          return true;
        }
      }
    }

    return false;
  }

  private static void debugMatrice(int[][] matrice) {
    for (int x = 0; x < matrice.length; x++) {
      for (int y = 0; y < matrice.length; y++) {
        System.out.print(" " + matrice[x][y]);
      }
      System.out.println("");
    }
  }

}