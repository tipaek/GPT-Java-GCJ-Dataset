
import java.io.*;
import java.util.*;
class Solution {
    public static void main(String args[]) {
        Scanner br = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//        Scanner br = new Scanner(new BufferedReader(new FileReader("test.txt")));

//        PrintWriter System.out = new PrintWriter(System.out);
        int t = br.nextInt();
        int counter = 1;
        while(counter <= t) {
            int n = br.nextInt();
            int k = br.nextInt();
            int arr[][] = new int[n][n];
            boolean possible = fillDiagonal(arr, k, n);
            if(possible) {
//                printArray(arr, n);
                System.out.flush();
                System.out.println("Case #"+counter+": POSSIBLE");
                fillRemainingArray(arr, n);
                printArray(arr, n);
            }else {
                System.out.println("Case #"+counter+": IMPOSSIBLE");
            }
            counter++;

        }
        System.out.flush();
    }

    public static void printArray(int arr[][], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void fillRemainingArray(int arr[][], int n) {
        boolean isBacktracking = false;
        Map<Integer, ArrayList<Integer>> iMap = new HashMap<Integer, ArrayList<Integer>>();
        Map<Integer, ArrayList<Integer>> jMap = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            iMap.put(i, new ArrayList<Integer>());
            jMap.put(i, new ArrayList<Integer>());
        }
        for (int i = 0; i < n; i++) {
            iMap.get(i).add(arr[i][i]);
            jMap.get(i).add(arr[i][i]);
        }
        int counter = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
//                    printArray(arr, n);
                    int valueToFill = findNotFilledValue(iMap.get(i), jMap.get(j), n, arr[i][j]+1);
//                    System.out.println(i+" "+j+" "+valueToFill);
//                    System.out.println(i+" "+j+" "+valueToFill);
                    if (valueToFill <= n) {
                        arr[i][j] = valueToFill;
                        iMap.get(i).add(valueToFill);
                        jMap.get(j).add(valueToFill);
                    } else {
                        arr[i][j] = 0;
                        if (j == 0){
                            i--;
                            j = n-1;
                        }
                        else
                            j--;
                        if (i == j) {
                            if (j == 0){
                                i--;
                                j = n-1;
                            }
                            else
                                j--;
                        }
                        int previousValue = arr[i][j];
                        iMap.get(i).remove(Integer.valueOf(previousValue));
                        jMap.get(j).remove(Integer.valueOf(previousValue));
//                        arr[i][j] = 0;
                        if (j == 0){
                            i--;
                            j = n-1;
                        }
                        else
                            j--;
                    }

                }
            }
        }
    }

    public static int findNotFilledValue(ArrayList<Integer> rowList, ArrayList<Integer> columnList, int n, int counter) {
        while(rowList.contains(counter) || columnList.contains(counter)) {
            counter++;
        }
        return counter;
    }

    public static boolean fillDiagonal(int arr[][], int k, int n) {
        if(k == n+1)
            return false;
        int q = k/n;
        int r = k%n;
        for(int i = 0 ; i < n ; i++) {
            arr[i][i] = q;
        }

        int counter = 0;
        while(r > 0) {
            arr[counter][counter]++;
            r--;
            counter++;
        }

        int max = Math.max(arr[0][0], arr[n-1][n-1]);
        if(arr[0][0] != arr[n-1][n-1]) {
            arr[0][0] = max;
            arr[1][1]++;
            arr[n-1][n-1] = max;
        }
        return true;
    }
}
