import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String line = in.nextLine();
    int numTests = Integer.parseInt(line.split(" ")[0]);
    int maxBits = Integer.parseInt(line.split(" ")[1]);

    for (int test=0;test<numTests;test++) {
      QueryAndFindArray(maxBits, in);
    }
  }

  private static void QueryAndFindArray(int maxBits, Scanner in) {
    int MAX_RETRIES=150;
    int bitPos=1;
    int[] prevArr = new int[maxBits];
    ArrayList<int[]> results = new ArrayList<>();
    int[] currentArr = new int[maxBits];
    int checkIndex = 20;

    //{1, (1+maxBits)/2, maxBits};
    ArrayList<Integer> checkBits = new ArrayList<>();
    checkBits.add(1);
    checkBits.add((1+maxBits)/2);
    checkBits.add(maxBits);

    StringBuilder sb = new StringBuilder();
    int[] result = new int[prevArr.length];
    for (int query=1;query<=MAX_RETRIES;query++) {
      //Ignoring reading are read bits
      if (results.size() !=0 && checkBits.contains(bitPos)) {
        bitPos++;
        continue;
      }

      //Verification
      if ((query-1) == checkIndex) {
        checkIndex += 10;
        if (compare(result, currentArr)) {
          for (int value : prevArr) {
            sb.append(value);
          }

          break;
        }
      }

      if (bitPos <=10) {
        //Reading Input
        System.out.println(bitPos);
        int bit = Integer.parseInt(in.nextLine());
        currentArr[bitPos-1] = bit;
      } else {
        bitPos = 1;

        if (query %10 == 1) {
          prevArr = currentArr;
          results.add(prevArr);

          //Read three bits: 1st, Middle, End
          int iter=0;
          while (iter < 3) {
            System.out.println(checkBits.get(iter));
            currentArr[checkBits.get(iter)-1] = Integer.parseInt(in.nextLine());
            iter++;
          }

          result = checkPossibleFluctuations(prevArr, currentArr, checkBits);
        }
      }
      bitPos++;
    }

    System.out.println(sb.toString());
    String answer = in.nextLine();
    if (answer.equalsIgnoreCase("N")) {
      System.exit(-1);
    } else if (answer.equalsIgnoreCase("Y")) {
      return;
    }
  }

  private static int[] checkPossibleFluctuations(int[] prevArr, int[] currentArr, ArrayList<Integer> checkBits) {
    int[] complementArr = generateComplement(prevArr);
    int[] reverseArr = generateReverse(prevArr);
    int[] complementAndReverseArr = generateBoth(prevArr);

    boolean isCompletement=false, isReverse=false, isBoth=false, isIndecisive = false;

    if (compareBits(complementArr, currentArr, checkBits))
      isCompletement = true;

    if(compareBits(reverseArr, currentArr, checkBits))
      isReverse = true;

    if(compareBits(complementAndReverseArr, currentArr, checkBits))
      isBoth = true;

    if (isCompletement && isBoth)
      isIndecisive = true;

    if (isReverse && isBoth)
      isIndecisive = true;

    if (isIndecisive)
      return prevArr;
    else if (isCompletement)
      return complementArr;
    else if (isReverse)
      return reverseArr;
    else if (isBoth)
      return complementAndReverseArr;
    else
      return prevArr;
  }

  private static boolean compareBits(int[] complementArr, int[] currentArr, ArrayList<Integer> checkBits) {
    for (int checkBit : checkBits) {
      if (!(complementArr[checkBit - 1] == currentArr[checkBit - 1]))
        return false;
    }

    return true;
  }

  private static boolean compare(int[] arr1, int[] arr2) {
    for (int i=0;i<arr1.length;i++) {
      if (arr1[i] == arr2[i])
        continue;
      else
        return false;
    }

    return true;
  }

  private static int[] generateBoth(int[] prevArr) {
    return generateComplement(generateReverse(prevArr));
  }

  private static int[] generateReverse(int[] prevArr) {
    int[] rArr = new int[prevArr.length];
    for (int i=0,j=prevArr.length-1; i<prevArr.length && j>=0;i++,j--) {
      rArr[i] = prevArr[j];
    }

    return rArr;
  }

  private static int[] generateComplement(int[] prevArr) {
    int[] temp = new int[prevArr.length];
    for (int i=0;i<prevArr.length;i++) {
      temp[i] = (prevArr[i]+1) % 2;
    }

    return temp;
  }
}
