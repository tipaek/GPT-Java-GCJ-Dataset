import java.util.Scanner;

public class Solution {

  private static void reverseArray(int[] array) {
    int length = array.length;
    for (int i = 0; i < length / 2; i++) {
      int temp = array[i];
      array[i] = array[length - i - 1];
      array[length - i - 1] = temp;
    }
  }

  private static void complementArray(int[] array) {
    for (int i = 0; i < array.length; i++) {
      array[i] = (array[i] == 0) ? 1 : 0;
    }
  }

  private static void solveTestCase(Scanner scanner, int size) {
    int queryCount = 0;
    int[] guessedArray = new int[size];
    int sameIndex = -1;
    int diffIndex = -1;
    int currentIndex = 0;

    while (currentIndex < size / 2) {
      if ((queryCount + 1) % 10 == 1 && queryCount != 0) {
        if (sameIndex != -1 && diffIndex != -1) {
          System.out.println(sameIndex + 1);
          if (scanner.nextInt() == guessedArray[currentIndex]) {
            System.out.println(diffIndex + 1);
            if (scanner.nextInt() != guessedArray[diffIndex]) {
              reverseArray(guessedArray);
            }
          } else {
            System.out.println(diffIndex + 1);
            if (scanner.nextInt() == guessedArray[diffIndex]) {
              reverseArray(guessedArray);
            }
            complementArray(guessedArray);
          }
          System.out.println(sameIndex + 1);
          scanner.nextInt();
        } else if (sameIndex == -1) {
          System.out.println(diffIndex + 1);
          if (scanner.nextInt() != guessedArray[diffIndex]) {
            complementArray(guessedArray);
          }
        } else {
          System.out.println(sameIndex + 1);
          if (scanner.nextInt() != guessedArray[currentIndex]) {
            complementArray(guessedArray);
          }
        }
      } else {
        System.out.println(currentIndex + 1);
        guessedArray[currentIndex] = scanner.nextInt();
        System.out.println(size - currentIndex);
        guessedArray[size - 1 - currentIndex] = scanner.nextInt();

        if (guessedArray[currentIndex] == guessedArray[size - 1 - currentIndex]) {
          sameIndex = currentIndex;
        } else {
          diffIndex = currentIndex;
        }

        currentIndex++;
      }
      queryCount += 2;
    }

    StringBuilder output = new StringBuilder();
    for (int value : guessedArray) {
      output.append(value);
    }

    System.out.println(output.toString());
    if (scanner.next().equals("Y")) {
      return;
    } else {
      System.exit(1);
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int testCases = scanner.nextInt();
    int arraySize = scanner.nextInt();
    for (int i = 0; i < testCases; i++) {
      solveTestCase(scanner, arraySize);
    }
  }
}