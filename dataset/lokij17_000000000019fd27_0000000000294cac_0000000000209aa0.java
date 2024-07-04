import java.util.*;

class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    for (int t = 0; t < T; t++) {
      int n = in.nextInt();
      int k = in.nextInt();

      if (k == n + 1 || k == n*n - 1) {
        System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
        continue;
      }
      int arr[][] = new int[n][n];
      HashMap<Integer, HashSet<Integer>> colSet = new HashMap<>();
      Map<Integer, Integer> num = new HashMap<>();
      for (int i = 0; i < n; i++) {
        colSet.put(i, new HashSet<>());
        num.put(i, 0);
      }
      if (k == n*n) {
        num.put(n-1, n);
      } else if (k == n) {
        num.put(0, n);
      } else {
        Integer total = 0;
        if (!populateTrace(num, k, 1, total)) {
          System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
          continue;
        }
//        int total = 0;
//        for (int i = n - 2; i >= 0; i--) {
//          int effeectivek = k - i;
//          int effectivei = n;
//          if (effeectivek <= n * (n - i)) {
//            num.put(0, i);
//            total += i;
//            while (effeectivek > 0) {
//              while ((effectivei - 1 >= 0 && num.get(effectivei - 1) == n - 2) || (
//                  effeectivek <= effectivei && total < n - 1) || (
//                  effeectivek - effectivei - 1 >= 0
//                      && effeectivek - effectivei - 1 < n
//                      && num.get(effeectivek - effectivei - 1) == n - 2)) {
//                System.out.println(
//                    "effectivek " + effeectivek + " effi " + effectivei + " i "
//                        + i);
//                effectivei--;
//              }
//              if (effectivei <= 0) {
//                break;
//              }
//              if (effeectivek < effectivei) {
//                effectivei = effeectivek;
//              }
//              total += 1;
//              num.put(effectivei - 1, num.get(effectivei - 1) + 1);
//              effeectivek -= effectivei;
//            }
//            if (total == n) {
//              break;
//            } else {
//              for (int j = 1; j < n; j++) {
//                num.put(j, 0);
//                total = 0;
//              }
//            }
//          }
//        }
      }

      int i = 0;
      for (Map.Entry<Integer, Integer> entry : num.entrySet()) {
        for (int j = 1; j <= entry.getValue(); j++) {
          arr[i][i] = entry.getKey() + 1;
          colSet.get(i).add(entry.getKey() + 1);
          i++;
        }
      }

      //print(arr);


      populate(arr, colSet);
      System.out.println("Case #" + (t + 1) + ": POSSIBLE");
      print(arr);
      //verifyArr(arr);
    }
  }

  private static boolean populateTrace(Map<Integer, Integer> num, int trace,
      int i, Integer total) {
    int n = num.size();
    if (trace == 0 && total == n) {
      return true;
    } else if (i > n || total > n || trace < 0) {
      return false;
    }
    for (int j = n-2; j >= 0; j--) {
      num.put(i-1, j);
      if (populateTrace(num, trace - (i*j), i + 1, total + j)) {
        return true;
      } else {
        //num.put(i-1, num.get(i-1) - 1);
      }
    }
    return false;
  }

  private static void print(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {
        System.out.print(arr[i][j] + (j < arr.length - 1 ? " " : ""));
      }
      System.out.println();
    }
  }

  private static void populate(int[][] arr, HashMap<Integer, HashSet<Integer>> colSet) {
      HashSet<Integer> rowSet = new HashSet<>();
      for (int j = 0; j < arr.length; j++) {
        if (arr[0][j] != 0) {
          rowSet.add(arr[0][j]);
        }
      }
      populateRow(0, arr, colSet, rowSet, 0);
  }

  private static boolean populateRow(int i, int[][] arr, HashMap<Integer, HashSet<Integer>> colSet,
      HashSet<Integer> rowSet, int j) {
    //System.out.println("ROW "+ i +" COL "+j);
    //print(arr);
    //print(colSet);
    if (j == arr.length || i == arr.length - 1) {
      if (i == arr.length - 1 && j == arr.length) {
        return true;
      } else if (i < arr.length - 1) {
        HashSet<Integer> nextRowSet = new HashSet<>();
        for (int k = 0; k < j; k++) {
          colSet.get(k).add(arr[i][k]);
          if (i < arr.length - 1 && arr[i+1][k] != 0) {
            nextRowSet.add(arr[i+1][k]);
          }
        }
        if (populateRow(i + 1, arr, colSet, nextRowSet, 0)) {
          return true;
        } else {
          for (int k = 0; k < j; k++) {
            if (k != i) {
              colSet.get(k).remove(arr[i][k]);
            }
          }
          return false;
        }
      }
    }
    if (arr[i][j] == 0) {
      for (int e = 1; e <= arr.length; e++) {
        if (!rowSet.contains(e) && !colSet.get(j).contains(e)) {
          arr[i][j] = e;
          rowSet.add(e);
          if (populateRow(i, arr, colSet, rowSet, j + 1)) {
            return true;
          } else {
            rowSet.remove(e);
            arr[i][j] = 0;
          }
        }
      }
      return false;
    } else {
      return populateRow(i, arr, colSet, rowSet, j + 1);
    }
  }

  private static void print(HashMap<Integer, HashSet<Integer>> colSet) {
    for (Map.Entry<Integer, HashSet<Integer>> entry : colSet.entrySet()) {
      System.out.println(""+(entry.getKey()+1)+" "+entry.getValue().toString());
    }
  }

  public static void verifyArr(int[][] array) {
      int n = array.length;
      int dupRows = 0, dupCols = 0;
      int trace = 0;
      ArrayList<HashSet<Integer>> arr = new ArrayList<>(n);
      for (int k = 0; k < n; k++) {
        HashSet<Integer> rowSet = new HashSet<>();
        for (int j = 0; j < n; j++) {
          if (arr.size() < n) {
            arr.add(new HashSet<>());
          }
          int ele = array[k][j];
          arr.get(j).add(ele);
          rowSet.add(ele);
          if (j == k) {
            trace += ele;
          }
        }
        if (rowSet.size() < n) {
          dupRows++;
        }
      }

      for (HashSet set : arr) {
        if (set.size() < n) {
          dupCols++;
        }
      }

      System.out.println(
          "Case #" + ": " + trace + " " + dupRows + " " + dupCols);
    }

}