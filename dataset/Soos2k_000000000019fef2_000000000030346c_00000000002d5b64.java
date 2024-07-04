import java.util.*;

public class Solution {
    static class Node {
        public int x,y;
        public String first, second;
        public Node(int x, int y, String first, String second){
            this.x = x;
            this.y = y;
            this.first = first;
            this.second = second;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        String[] results = new String[cases];
        for (int i = 0; i < cases; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            results[i] = "Case #" + (i+1) + ": " + sort(x,y);
        }
        sc.close();
        for (String str : results){
            System.out.println(str);
        }
    }
    public static String sort(int R, int S){
        String result = "" + (R-1)*(S-1) + "\n";
        for (int i = R; i > 1; i--){
            int index = 1;
            while (index < S){
                int one = i*(S-1) - (index-1);
                int two = i - 1;
                result += one + " " + two + "\n";
                index++;
            }
        }
        return result.substring(0,result.length()-1);
    }
}