
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

// Aliaksei Sviattsau
public class Solution
{
  private static boolean DEBUG = false;

  // Solution //////////////////////////////////////////////////////////////////////////////////////////////////////////

  private static void readCaseInput(int caseNumber, Scanner in) throws Exception
  {
    R = in.nextInt();
    C = in.nextInt();
    s = new int[R][C];
    for (int i = 0; i < R; ++ i) {
      for (int j = 0; j < C; ++ j) {
        s[i][j] = in.nextInt();
      }
    }
  }


  static int T;

  static int R, C;
  static int[][] s;



  private static void solveCase(int caseNumber, PrintStream out) throws Exception
  {
    final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;

    long competitionSkills = 0L;
    long actualSkills = 0L;
    int[][][] nextLook = new int[R][C][4];
    for (int i = 0; i < R; ++ i) {
      for (int j = 0; j < C; ++ j) {
        actualSkills += s[i][j];

        nextLook[i][j][UP] = i - 1;
        nextLook[i][j][DOWN] = i + 1;
        nextLook[i][j][LEFT] = j - 1;
        nextLook[i][j][RIGHT] = j + 1;
      }
    }

    int eliminatedPlayers;
    do {
      competitionSkills += actualSkills;
      eliminatedPlayers = 0;

      List<int[]> elimination = new ArrayList<>();
      for (int i = 0; i < R; ++ i) {
        for (int j = 0; j < C; ++ j) {
          if (s[i][j] != 0) {
            int compassCount = 0;
            int compassSkills = 0;

            // Up
            int row = nextLook[i][j][UP];
            while (row >= 0 && s[row][j] == 0) -- row;
            if (row >= 0) {
              ++ compassCount;
              compassSkills += s[row][j];
            }
            nextLook[i][j][UP] = row;

            // Down
            row = nextLook[i][j][DOWN];
            while (row < R && s[row][j] == 0) ++ row;
            if (row < R) {
              ++ compassCount;
              compassSkills += s[row][j];
            }
            nextLook[i][j][DOWN] = row;

            // Left
            int col = nextLook[i][j][LEFT];
            while (col >= 0 && s[i][col] == 0) -- col;
            if (col >= 0) {
              ++ compassCount;
              compassSkills += s[i][col];
            }
            nextLook[i][j][LEFT] = col;

            // Right
            col = nextLook[i][j][RIGHT];
            while (col < C && s[i][col] == 0) ++ col;
            if (col < C) {
              ++ compassCount;
              compassSkills += s[i][col];
            }
            nextLook[i][j][RIGHT] = col;

            if (compassCount > 0 && (s[i][j] * compassCount < compassSkills)) {
              elimination.add(new int[] {i, j});
            }
          }
        }
      }

      for (int[] pos : elimination) {
        actualSkills -= s[pos[0]][pos[1]];
        ++ eliminatedPlayers;
        s[pos[0]][pos[1]] = 0;
      }
    }
    while (eliminatedPlayers > 0);

    writeCaseResult(out, caseNumber, String.valueOf(competitionSkills));
  }


  private static void writeCaseResult(PrintStream out, int caseNumber, String formattedResult) throws IOException
  {
    out.println("Case #" + caseNumber + ": " + formattedResult);
    out.flush();
  }


  // Helpers ///////////////////////////////////////////////////////////////////////////////////////////////////////////

  static final DecimalFormat DOUBLE_FORMAT = new DecimalFormat("#0.000000");

  public static void main(String[] args)
  {
    try {
      Locale.setDefault(Locale.US);

      try (Scanner in = openInput(args);
           PrintStream out = openOutput(args)) {

        T = in.nextInt();
        for (int caseNumber = 1; caseNumber <= T; caseNumber ++) {
          readCaseInput(caseNumber, in);
          solveCase(caseNumber, out);
          out.flush();
        }
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }


  private static Scanner openInput(String[] args) throws FileNotFoundException
  {
    if (DEBUG) {
      String inPathName = args[0];
      File inFile = new File(inPathName);
      return new Scanner(new BufferedReader(new FileReader(inFile)));
    }
    else {
      return new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    }
  }


  private static PrintStream openOutput(String[] args) throws IOException
  {
    if (DEBUG) {
      String inPathName = args[0];
      String inPathBase = inPathName.substring(0, inPathName.lastIndexOf('.'));
      File outFile = new File(inPathBase + ".out");
      return new PrintStream(new BufferedOutputStream(new FileOutputStream(outFile)));
    }
    else {
      return System.out;
    }

  }
}
