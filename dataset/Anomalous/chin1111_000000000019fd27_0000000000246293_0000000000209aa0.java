import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

    static int[][] mat;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int numberOfTestCases = Integer.parseInt(br.readLine().trim());
        
        for (int i = 1; i <= numberOfTestCases; i++) {
            String[] input = br.readLine().split(" ");
            int numberOfRandC = Integer.parseInt(input[0]);
            int sumRequired = Integer.parseInt(input[1]);
            
            mat = new int[numberOfRandC][numberOfRandC];
            constructMatrix(numberOfRandC);
            
            int[] sequence = new int[numberOfRandC];
            for (int j = 0; j < numberOfRandC; j++) {
                sequence[j] = j + 1;
            }
            
            ArrayList<Integer> list = new ArrayList<>();
            permute(sequence, 0, list);
            
            int pp = -1;
            for (int j = 0; j < list.size(); j++) {
                int num = list.get(j);
                String str = String.valueOf(num);
                int sum = 0;
                for (int k = 0; k < str.length(); k++) {
                    int index = Character.getNumericValue(str.charAt(k));
                    sum += mat[index - 1][k];
                }
                if (sum == sumRequired) {
                    pp = j;
                    break;
                }
            }
            
            if (pp == -1) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": POSSIBLE");
                String temp = String.valueOf(list.get(pp));
                for (int j = 0; j < temp.length(); j++) {
                    int index = Character.getNumericValue(temp.charAt(j));
                    for (int k = 0; k < numberOfRandC; k++) {
                        System.out.print(mat[index - 1][k]);
                        if (k < numberOfRandC - 1) {
                            System.out.print(" ");
                        }
                    }
                    if (j < numberOfRandC - 1) {
                        System.out.println();
                    }
                }
            }
        }
    }
    
    static void fillRemaining(int i, int j, int n) {
        int x = 2;
        for (int k = i + 1; k < n; k++) {
            mat[k][j] = x++;
        }
        for (int k = 0; k < i; k++) {
            mat[k][j] = x++;
        }
    }
    
    static void constructMatrix(int n) {
        int right = n - 1, left = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                mat[i][right] = 1;
                fillRemaining(i, right, n);
                right--;
            } else {
                mat[i][left] = 1;
                fillRemaining(i, left, n);
                left++;
            }
        }
    }
    
    static void permute(int[] a, int k, ArrayList<Integer> list) {
        if (k == a.length) {
            StringBuilder temp = new StringBuilder();
            for (int value : a) {
                temp.append(value);
            }
            list.add(Integer.parseInt(temp.toString()));
        } else {
            for (int i = k; i < a.length; i++) {
                swap(a, k, i);
                permute(a, k + 1, list);
                swap(a, k, i);
            }
        }
    }
    
    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}