import java.util.*;

public class Solution {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int T = input.nextInt();
    int B = input.nextInt(); // 1 to B
    int counter;
    int[][] bitArr;
    boolean[] cases;
    int queryNum;
    int front, back;
    HashSet<Integer> toQuery = null;
    for (int i=0; i<T; i++) {
      bitArr = new int[4][B];
      for (int j=0; j<B; j++) {
        bitArr[0][j] = -1;
      }
      queryNum = 0;
      front = 1;
      back = B;
      boolean queryFront = true;
      cases = new boolean[4];
      boolean isCorrectBitArr = true;
      counter = 0;
      while (counter < B) {

        if (queryNum > 9 && queryNum%10 == 0) { //11,21,...
          getCases(bitArr);
          isCorrectBitArr = false;
        }

        if (isCorrectBitArr && queryFront) {
          queryNum++;
          System.out.println(front);
          bitArr[0][front-1] = input.nextInt();
          front++;
          queryFront = false;
          counter++;
        }
        else if (isCorrectBitArr && !queryFront){
          queryNum++;
          System.out.println(back);
          bitArr[0][back-1] = input.nextInt();
          back--;
          queryFront = true;
          counter++;
        }
        else {
          toQuery = new HashSet<>();
          int idxToQ = help(bitArr, cases, B, toQuery);
          if (idxToQ == -1) {
            //IGNORE
            Iterator<Integer> itr = toQuery.iterator();
            while(itr.hasNext()){
              int ask = itr.next();
              queryNum++;
              System.out.println(ask+1);
              bitArr[0][ask] = input.nextInt();
            }
            isCorrectBitArr = true;
            cases = new boolean[4];
            continue;
          }
          queryNum++;
          System.out.println(idxToQ+1);
          int chosen = input.nextInt();
          cancel(bitArr, cases, chosen, idxToQ);
          if (checkCases(cases)) { // Finally get out
            isCorrectBitArr = true;
            for (int a=0; a<4; a++) {
              if (!cases[a]) {
                bitArr[0] = bitArr[a].clone();
              }
            }
            cases = new boolean[4];
          }
        }
      }
      while (!isCorrectBitArr) {
        toQuery = new HashSet<>();
        int idxToQ = help(bitArr, cases, B, toQuery);
        if (idxToQ == -1) {
          //IGNORE
          Iterator<Integer> itr = toQuery.iterator();
          while(itr.hasNext()){
            int ask = itr.next();
            queryNum++;
            System.out.println(ask+1);
            bitArr[0][ask] = input.nextInt();
          }
          break;
        }
        queryNum++;
        System.out.println(idxToQ+1);
        int chosen = input.nextInt();
        cancel(bitArr, cases, chosen, idxToQ);
        if (checkCases(cases)) { // Finally get out
          isCorrectBitArr = true;
          for (int a=0; a<4; a++) {
            if (!cases[a]) {
              bitArr[0] = bitArr[a].clone();
            }
          }
        }
      }

      StringBuilder sb = new StringBuilder();
      for (int c=0; c<B; c++) {
        if (bitArr[0][c] == -1) {
          System.out.println(c+1);
          sb.append(input.nextInt());
        }
        else sb.append(bitArr[0][c]);
      }
      System.out.println(sb.toString());
      input.next();
    }
    return;
  }

  public static boolean checkCases(boolean[] cases) {
    int count = 0;
    for (int i=0; i<4; i++) {
      if (!cases[i]) {
        count++;
      }
    }
    if (count == 1) return true;
    return false;
  }

  public static void cancel(int[][] bitArr, boolean[] cases, int chosen, int idx) {
    //cancel the cases based on queried item
    for (int i=0; i<4; i++) {
      if (!cases[i]) {
        if (bitArr[i][idx] != chosen) cases[i] = true;
      }
    }
  }

  public static int help(int[][] arr, boolean[] cases, int len, HashSet<Integer> toQ) {
    int innerC = 0;
    ArrayList<Integer> temp = new ArrayList<>();
    for (int i=0; i<4; i++) {
      if (!cases[i]) {
        innerC++;
        temp.add(i);
      }
    }
    int ans;
    if (innerC == 4) {
      ans =  getIdxToQuery4(arr, len);
    }
    else {
      ans = getIdxToQuery2(arr[temp.get(0)], arr[temp.get(1)], len, toQ);
      if (ans == -1) {
        arr[0] = arr[temp.get(0)].clone();
      }
    }
    return ans;
  }

  public static int getIdxToQuery4(int[][] arr, int len) {

    for (int i=0; i<len; i++) {
      if (arr[0][i] == -1 || arr[1][i] == -1 || arr[2][i] == -1 || arr[3][i] == -1) continue;
      if (!(arr[0][i] == arr[1][i] && arr[1][i] == arr[2][i] && arr[2][i] == arr[3][i])) {
        return i;
      }
    }
    return -1;
  }

  public static int getIdxToQuery2(int[] case1, int[] case2, int len, HashSet<Integer> toQ) {
    toQ = new HashSet<>();
    for (int i=0; i<len; i++) {
      if (case1[i] == -1 || case2[i] == -1) {
        if (!(case1[i] == -1 && case2[i] == -1)) toQ.add(i);
        continue;
      }
      if (!(case1[i] == case2[i])) {
        return i;
      }
    }
    return -1;
  }
  public static void getCases(int[][] arr) {
    int len = arr[0].length;
    //case1
    for (int i=0; i<len; i++) {
      if (arr[0][i] == 1)
        arr[1][i] = 0;
      else if (arr[0][i] == 0)
        arr[1][i] = 1;
      else {
        arr[1][i] = arr[0][i];
      }
    }
    //case 2
    int f = 0;
    int b = len - 1;
    while (f <= b) {
      arr[2][b] = arr[0][f];
      arr[2][f] = arr[0][b];
      f++;
      b--;
    }
    //case 3
    for (int i=0; i<len; i++) {
      if (arr[2][i] == 1)
        arr[3][i] = 0;
      else if (arr[2][i] == 0)
        arr[3][i] = 1;
      else {
        arr[3][i] = arr[2][i];
      }
    }
  }
}
