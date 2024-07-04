import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            sc.nextLine();
            String[] list = new String[N];
            for (int i = 0; i < N; i++) {
                list[i] = sc.nextLine();
            }
            
            int[][] pointers = new int[N][2];
            for (int i = 0; i < N; i++) {
                pointers[i][0] = 0;
                pointers[i][1] = list[i].length() - 1;
            }
            
            String resFront = traverseFront(list, pointers, N);
            if (resFront.equals("*")) {
                System.out.println("Case #" + (t + 1) + ": *");
                continue;
            }
            
            String resBack = traverseBack(list, pointers, N);
            if (resBack.equals("*")) {
                System.out.println("Case #" + (t + 1) + ": *");
                continue;
            }
            
            String resMid = extractMiddle(list, pointers, N);
            String result = resFront + resMid + resBack;
            System.out.println("Case #" + (t + 1) + ": " + result);
        }
        sc.close();
    }
    
    private static String traverseFront(String[] list, int[][] pointers, int N) {
        boolean continued;
        StringBuilder resFront = new StringBuilder();
        boolean invalid = false;
        boolean end = false;
        String endGame = "";
        
        do {
            continued = false;
            char pre = ' ';
            for (int i = 0; i < N; i++) {
                if (pointers[i][0] > list[i].length() - 1) {
                    end = true;
                    endGame = list[i];
                    continue;
                }
                char ch = list[i].charAt(pointers[i][0]);
                if (ch == '*') continue;
                if (pre != ' ' && pre != ch) {
                    invalid = true;
                    break;
                }
                pointers[i][0]++;
                continued = true;
                pre = ch;
            }
            if (invalid) return "*";
            if (pre != ' ') resFront.append(pre);
        } while (continued);
        
        return end ? endGame : resFront.toString();
    }
    
    private static String traverseBack(String[] list, int[][] pointers, int N) {
        boolean continued;
        StringBuilder resBack = new StringBuilder();
        boolean invalid = false;
        
        do {
            continued = false;
            char pre = ' ';
            for (int i = 0; i < N; i++) {
                if (pointers[i][1] <= pointers[i][0]) continue;
                char ch = list[i].charAt(pointers[i][1]);
                if (ch == '*') continue;
                if (pre != ' ' && pre != ch) {
                    invalid = true;
                    break;
                }
                pointers[i][1]--;
                continued = true;
                pre = ch;
            }
            if (invalid) return "*";
            if (pre != ' ') resBack.insert(0, pre);
        } while (continued);
        
        return resBack.toString();
    }
    
    private static String extractMiddle(String[] list, int[][] pointers, int N) {
        StringBuilder resMid = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = pointers[i][0]; j <= pointers[i][1]; j++) {
                char ch = list[i].charAt(j);
                if (ch != '*') {
                    resMid.append(ch);
                }
            }
        }
        return resMid.toString();
    }
}