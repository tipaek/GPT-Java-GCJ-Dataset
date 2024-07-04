import java.util.Scanner;

public class Solution {

    public static void FindPepper(int no, int X, int Y, String moves)
    {
        int dist = X + Y;

        for(int i=0; i<=moves.length(); i++)
        {
            if(i>=Math.abs(dist))
            {
                System.out.println("Case #" + no + ": " + i);
                return;
            }

            if(i==moves.length()) break;

            char move = moves.charAt(i);

            switch(move)
            {
                case 'N' :
                {
                    Y++;
                    dist = Math.abs(X) + Math.abs(Y);
                    break;
                }
                case 'S' :
                {
                    Y--;
                    dist = Math.abs(X) + Math.abs(Y);
                    break;
                }
                case 'E' :
                {
                    X++;
                    dist = Math.abs(X) + Math.abs(Y);
                    break;
                }
                case 'W' :
                {
                    X--;
                    dist = Math.abs(X) + Math.abs(Y);
                    break;
                }
            }
        }

        System.out.println("Case #" + no + ": IMPOSSIBLE");
        return;

    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int input = s.nextInt();

        for(int i=1; i<=input; i++)
        {
            int X = s.nextInt();
            int Y = s.nextInt();
            String S = s.next();
            FindPepper(i,X,Y,S);
        }

    }
}
