import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        input.nextLine();
        for(int i = 0; i < t; i++) {
            String[] temp = input.nextLine().split(" ");
            int x = Integer.parseInt(temp[0]);
            int y = Integer.parseInt(temp[1]);
            String line = temp[2];
            boolean works = false;
            int answer = 0;
            for(int k = 0; k < line.length(); k++) {
                if(line.charAt(k) == 'N') {
                    y++;
                } else if(line.charAt(k) == 'E') {
                    x++;
                } else if(line.charAt(k) == 'S') {
                    y--;
                } else {
                    x--;
                }
                if(Math.abs(x) + Math.abs(y) <= (k + 1)) {
                    works = true;
                    answer = k + 1;
                    break;
                }
            }
            System.out.print("Case #" + (i + 1) + ": ");
            if(works) {
                System.out.print(answer);
            } else {
                System.out.print("IMPOSSIBLE");
            }
            System.out.println();
        }
    }
}
