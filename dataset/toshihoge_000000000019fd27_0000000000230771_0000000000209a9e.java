import java.util.*;

interface Judge {
  String putQuery(String query);
}

class OnlineJudge implements Judge {
  final Scanner scanner;
  
  OnlineJudge() {
    scanner = new Scanner(System.in);
  }
  
  public String putQuery(String query) {
    if (query != null) {
      System.out.println(query);
    }
    return scanner.nextLine();
  }
}

class ProblemInstance {
  final char[] initialBits;
  final int[] operations;
  final int n;
  char[] currentBits;
  int count;

  ProblemInstance(char[] initialBits, int[] operations) {
    this.initialBits = initialBits;
    this.n = initialBits.length;
    this.currentBits = initialBits;
    this.operations = operations;
    this.count = 0;
  }

  private void flip() {
    char[] nextBits = new char[n];
    for (int i = 0; i < n; i++) {
      nextBits[i] = (char)('0' + '1' - currentBits[i]);
    }
    currentBits = nextBits;
  }

  private void reverse() {
    char[] nextBits = new char[n];
    for (int i = 0; i < n; i++) {
      nextBits[i] = currentBits[n - 1 - i];
    }
    currentBits = nextBits;
  }

  private void runOperation(int index) {
    int operation = operations[index];
    if (operation % 2 == 1) {
      System.err.println("FLIP");
      flip();
    }
    if (operation / 2 == 1) {
      System.err.println("REVERSE");
      reverse();
    }
  }

  public char resolveQuery(int index) {
    if (count >= 150) {
      throw new RuntimeException();
    }
    if (count % 10 == 0) {
      System.err.println("OPERATION");
      runOperation(count / 10);
    }
    count++;
    return currentBits[index - 1];
  }

  public boolean verify(char[] guessBits) {
    for (int i = 0; i < n; i++) {
      if (currentBits[i] != guessBits[i]) {
        return false;
      }
    }
    return true;
  }
}

class OfflineJudge implements Judge {
  final ProblemInstance[] problemInstances;
  final int b;
  int index;

  OfflineJudge(ProblemInstance[] problemInstances) {
    this.problemInstances = problemInstances;
    this.b = problemInstances[0].n;
    this.index = 0;
  }
  
  public String putQuery(String query) {
    if (query == null) {
      return String.format("%d %d", problemInstances.length, b);
    }

    if (query.length() == b) {
      int currentIndex = index;
      index++;
      return problemInstances[currentIndex].verify(query.toCharArray()) ? "Y" : "N";
    }
    return "" + problemInstances[index].resolveQuery(Integer.parseInt(query));
  }
}

class JudgeWrapper {
  Judge judge;
  
  JudgeWrapper(Judge judge) {
    this.judge = judge;
  }
  
  String putQuery(String query) {
    System.err.println("Query: " + query);
    String judgeResponse = judge.putQuery(query);
    System.err.println("Judge: " + judgeResponse);
    return judgeResponse;
  }
}

class Solver {
  final JudgeWrapper judgeWrapper;
  final int b;

  int count;
  char[] guessBits;
  int knownSameBitPairIndex;
  int knownDifferentBitPairIndex;

  Solver(JudgeWrapper judgeWrapper, int b) {
    this.judgeWrapper = judgeWrapper;
    this.b = b;
  }

  private int getUknownBitIndex() {
    for (int i = 0; i < b; i++) {
      if (guessBits[i] == '?') {
        return i;
      }
    }
    return -1;
  }

  private char query(int index) {
    return judgeWrapper.putQuery("" + (index + 1)).charAt(0);
  }

  private void swapDifferentBitPair() {
    for (int i = 0; i < b / 2 && guessBits[i] != '?'; i++) {
      int opposite = b - 1 - i;
      if (guessBits[i] == guessBits[opposite]) {
        continue;
      }
      char v = guessBits[i];
      guessBits[i] = guessBits[opposite];
      guessBits[opposite] = v;
    }
  }

  private void flipSameBitPair() {
    for (int i = 0; i < b / 2 && guessBits[i] != '?'; i++) {
      int opposite = b - 1 - i;
      if (guessBits[i] != guessBits[opposite]) {
        continue;
      }
      guessBits[i] = (char)('0' + '1' - guessBits[i]);
      guessBits[opposite] = guessBits[i];
    }
  }

  public boolean solve() {
    guessBits = new char[b];
    Arrays.fill(guessBits, '?');
    count = 0;
    knownSameBitPairIndex = -1;
    knownDifferentBitPairIndex = -1;
    while (true) {
      int unknownBitIndex = getUknownBitIndex();
      if (unknownBitIndex < 0) {
        break;
      }
      if (count > 0 && count % 10 == 0) {
        if (knownDifferentBitPairIndex >= 0) {
          char c = query(knownDifferentBitPairIndex);
          if (guessBits[knownDifferentBitPairIndex] != c) {
            swapDifferentBitPair();
          }
        } else {
          // Dispose
          query(0);
        }

        if (knownSameBitPairIndex >= 0) {
          char c = query(knownSameBitPairIndex);
          if (guessBits[knownSameBitPairIndex] != c) {
            flipSameBitPair();
          }
        } else {
          // Dispose
          query(0);
        }
      } else {
        int opposite = b - 1 - unknownBitIndex;
        guessBits[unknownBitIndex] = query(unknownBitIndex);
        guessBits[opposite] = query(opposite);
        if (guessBits[unknownBitIndex] == guessBits[opposite]) {
          knownSameBitPairIndex = unknownBitIndex;
        } else {
          knownDifferentBitPairIndex = unknownBitIndex;
        }
      }
      count += 2;
    }
    String result = judgeWrapper.putQuery(new String(guessBits));
    return result.equals("Y");
  }
}

class SolverRunner {
  final JudgeWrapper judgeWrapper;
  
  SolverRunner(JudgeWrapper judgeWrapper) {
    this.judgeWrapper = judgeWrapper;
  }
  
  public void run() {
    // Replace here.
    
    String[] tAndB = judgeWrapper.putQuery(null).split(" ");
    int t = Integer.parseInt(tAndB[0]);
    int b = Integer.parseInt(tAndB[1]);
    for (int i = 0; i < t; i++) {
      Solver solver = new Solver(judgeWrapper, b);
      if (!solver.solve()) {
        return;
      }
    }
  }
}

public class Solution {
  public static void main(String[] args) {
    boolean online = true;
    
    Judge judge;
    if (online) {
      judge = new OnlineJudge();
    } else {
      ProblemInstance[] problemInstances = new ProblemInstance[]{
        new ProblemInstance(
          "00000000111111111111110000000111111111101111111000000".toCharArray(),
          new int[]{0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3}
        )
      };
      judge = new OfflineJudge(problemInstances);
    }
    JudgeWrapper judgeWrapper = new JudgeWrapper(judge);
    SolverRunner runner = new SolverRunner(judgeWrapper);
    runner.run();
  }
}

