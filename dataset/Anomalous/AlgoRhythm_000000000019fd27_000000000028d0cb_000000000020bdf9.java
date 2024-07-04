import java.util.Scanner;
import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] jamie = new int[1440];
        int[] cameron = new int[1440];
        
        for (int l = 0; l < t; l++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][2];
            String result = "";
            Arrays.fill(jamie, 0);
            Arrays.fill(cameron, 0);
            
            for (int i = 0; i < n; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }
            
            for (int j = arr[0][0]; j < arr[0][1]; j++) {
                jamie[j] = 1;
            }
            result += "J";
            result = evaluate(jamie, cameron, n, 1, arr, result);
            System.out.println("Case #" + (l + 1) + ": " + result);
        }
    }

    static String evaluate(int[] jamie, int[] cameron, int n, int start, int[][] arr, String result) {
        for (int i = start; i < n; i++) {
            int s = arr[i][0];
            int e = arr[i][1];
            boolean canAssignToJamie = true;
            boolean canAssignToCameron = true;
            
            for (int j = s; j < e; j++) {
                if (jamie[j] == 1) {
                    canAssignToJamie = false;
                    break;
                }
            }
            
            for (int j = s; j < e; j++) {
                if (cameron[j] == 1) {
                    canAssignToCameron = false;
                    break;
                }
            }
            
            if (canAssignToJamie && !canAssignToCameron) {
                Arrays.fill(jamie, s, e, 1);
                result += "J";
            } else if (canAssignToCameron && !canAssignToJamie) {
                Arrays.fill(cameron, s, e, 1);
                result += "C";
            } else if (canAssignToJamie && canAssignToCameron) {
                Arrays.fill(jamie, s, e, 1);
                String result1 = evaluate(jamie, cameron, n, i + 1, arr, result + "J");
                
                Arrays.fill(jamie, s, e, 0);
                Arrays.fill(cameron, s, e, 1);
                String result2 = evaluate(jamie, cameron, n, i + 1, arr, result + "C");
                
                if (result1.equals("IMPOSSIBLE")) {
                    result = result2.equals("IMPOSSIBLE") ? result1 : result2;
                } else {
                    result = result1;
                }
                break;
            } else {
                result = "IMPOSSIBLE";
                break;
            }
        }
        return result;
    }
}