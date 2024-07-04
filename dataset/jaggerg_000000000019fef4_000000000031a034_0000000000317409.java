import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);

	    int numTests = Integer.parseInt(sc.nextLine());

	    for(int t = 1; t <= numTests; t++){
            String[] cur = sc.nextLine().split(" ");
            int x = Integer.parseInt(cur[0]);
            int y = Integer.parseInt(cur[1]);
            String moves = cur[2];

            int result = -1;

            for(int i = 0; i < moves.length(); i++){
                switch(moves.charAt(i)){
                    case 'N':
                        y++;
                        break;
                    case 'E':
                        x++;
                        break;
                    case 'W':
                        x--;
                        break;
                    case 'S':
                        y--;
                        break;
                }
                if(Math.abs(x) + Math.abs(y) <= i + 1){
                    result = i + 1;
                    break;
                }
            }

            if(result == -1){
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + t + ": " + result);
            }
        }
    }
}
