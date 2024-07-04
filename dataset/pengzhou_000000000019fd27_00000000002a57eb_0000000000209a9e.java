import java.util.*;

public class Solution {
  static Integer firstPointer = null;
  static Integer secondPointer = null;
  static boolean otherSide = false;
  static Boolean[] guess = null;
  static int N = 0;
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int T = input.nextInt();
    N = input.nextInt();
    for (int ks = 1; ks <= T; ks++) {
        boolean result = solve(input);
        if (!result) break;
    }
  }

  public static boolean solve(Scanner input) {
    System.out.println(1);
    String received = input.nextLine();
    guess = new Boolean[N];
    boolean foundSamePair = false;
    boolean foundDiffPair = false;
    boolean otherSide = false;
    boolean resetIndex = false;
    int currentCount = 1;
    int currentIndex = 0;
    while (currentCount <= 150) {
        for (int i = 0; i<2; i++) {
            System.out.println(currentIndex + 1);
            boolean firstReceived = getResponse(input.nextLine());
            currentIndex = N - 1 - currentIndex;
            System.out.println(currentIndex + 1);
            boolean secondReceived = getResponse(input.nextLine());
            if (currentCount > 10 && ((currentCount % 10) == 1)) {
                if (foundSamePair && foundDiffPair) {
                    analyze(firstReceived, secondReceived);
                    continue;
                }
            }
            currentIndex = N - 1 - currentIndex;
            guess[currentIndex] = firstReceived;
            currentIndex = N - 1 - currentIndex;
            guess[currentIndex] = secondReceived;
            if (!(foundSamePair && foundDiffPair)) {
                if (firstReceived == secondReceived) {
                    if (!foundSamePair) {
                        foundSamePair = true;
                    }
                } else {
                    if (!foundDiffPair) {
                        foundDiffPair = true;
                    }
                }
                if (firstPointer == null) {
                    firstPointer = currentIndex;
                } else {
                    secondPointer = currentIndex;
                }
                if (foundSamePair && foundDiffPair) {
                    if (guess[firstPointer] == guess[secondPointer]) {
                        firstPointer = N - 1 - firstPointer;
                        secondPointer = N - 1 - secondPointer;
                    }
                    otherSide = guess[N - 1 - firstPointer];
                    if (currentCount > 10) {
                        resetIndex = true;
                    }
                }
            } // end check if 
            currentCount += 2;
        }  // end for
        if (currentIndex == N / 2) {
            String answer = getResult();
            System.out.println(answer);
            System.out.flush();
            String result = input.nextLine();
            if (result == "Y") return true;
            else return false;
        }
        currentIndex = N - currentIndex;
        if (resetIndex) currentIndex = 0;
    }
    return false;
  }

  private static String getResult() {
    String result = "";
    for (int i=0; i<N; i++) {
      if (guess[i] == false) {
        result += "0";
      } else {
        result += "1";
      }
    }
    return result;
  }
  
  private static void analyze (boolean first, boolean second) {
      // fluctuation did nothing
      if (first == true && second == false) {
          return;
      }
      // fluctuation did complement
      else if (first == false && second == true) {
          negateArray();
          int temp = firstPointer;
          firstPointer = secondPointer;
          secondPointer = temp;
          otherSide = !otherSide;
      }
      // fluctuation did reverse 
      else if (first == second && first == otherSide) {
        converseArray();
        firstPointer = N - 1 - firstPointer;
        secondPointer = N - 1 - secondPointer;
        int temp = firstPointer;
        firstPointer = secondPointer;
        secondPointer = temp;
      }
      // fluctuation did both 
      else if (first == second && first != otherSide) {
        converseArray();
        negateArray();
        firstPointer = N - 1 - firstPointer;
        secondPointer = N - 1 - secondPointer;
      }
  }
  
  private static boolean getResponse(String input) {
      if (input == "0") return false;
      return true;
  }
  
  private static void converseArray() {
    for (int i=0; i < N/2; i++) {
        Boolean temp = guess[i];
        guess[i] = guess[N-i];
        guess[N-i] = temp;
    }
  }
  
  private static void negateArray() {
    for (int i=0; i<N; i++) {
      if (guess[i] != null) {
        guess[i] = !guess[i];
      }
    }
  }
}