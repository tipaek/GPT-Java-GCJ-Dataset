import java.util.Scanner;

public class que1 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int test = scn.nextInt();
        StringBuilder sb=new StringBuilder();
        A:for (int t = 1; t <= test; t++) {
            int x = scn.nextInt();
            int y = scn.nextInt();
            String s = scn.next();
            int time = 0;
            if (x == 0 && y == 0) {
              sb.append("Case #"+(t)+": "+0+"\n");
            }
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch == 'N') {
                    y++;
                } else if (ch == 'S') {
                    y--;
                } else if (ch == 'E') {
                    x++;
                } else {
                    x--;
                }
                time++;
                int req = Math.abs(x) + Math.abs(y);
                if(req<=time){
                    sb.append("Case #"+(t)+": "+time+"\n");
                    continue A;
                }
            }
            sb.append("Case #"+(t)+": "+"IMPOSSIBLE\n");
        }
        System.out.println(sb);
    }

}