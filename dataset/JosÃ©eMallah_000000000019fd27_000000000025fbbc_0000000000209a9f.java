import java.util.Scanner;

public class Solution
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int x = 1;
        int depth = 0;
        String s = "";
        int l;
        char c;
        StringBuilder y = new StringBuilder();
        while (x <= t)
        {
            s = in.next();
            l = s.length();
            y = new StringBuilder();
            depth = 0;
            for (int i = 0; i < l; i++)
            {
                c = s.charAt(i);
                if (c == '0')
                {
                    if (depth > 0)
                    {
                        while(depth > 0)
                        {
                            y.append(")");
                            depth--;
                        }
                    }
                    y.append("0");
                }
                else if (c == '1')
                {
                    if (depth > 1)
                    {
                        while(depth > 1)
                        {
                            y.append(")");
                            depth--;
                        }
                    }
                    if (depth == 0)
                    {
                        y.append("(1");
                        depth++;
                    }
                    else
                        y.append("1");
                }
                else if (c == '2')
                {
                    if (depth > 2)
                    {
                        while(depth > 2)
                        {
                            y.append(")");
                            depth--;
                        }
                    }
                    if (depth == 0)
                    {
                        y.append("((2");
                        depth = depth + 2;
                    }
                    else if (depth == 1)
                    {
                        y.append("(2");
                        depth++;
                    }
                    else
                    {
                        y.append("2");
                    }
                }
                else if (c == '3')
                {
                    if (depth > 3)
                    {
                        while(depth > 3)
                        {
                            y.append(")");
                            depth--;
                        }
                    }
                    if (depth == 0)
                    {
                        y.append("(((3");
                        depth = depth + 3;
                    }
                    else if (depth == 1)
                    {
                        y.append("((3");
                        depth = depth + 2;
                    }
                    else if (depth == 2)
                    {
                        y.append("(3");
                        depth++;
                    }
                    else
                    {
                        y.append("3");
                    }
                }
                else if (c == '4')
                {
                    if (depth > 4)
                    {
                        while(depth > 0)
                        {
                            y.append(")");
                            depth--;
                        }
                    }
                    if (depth == 0)
                    {
                        y.append("((((4");
                        depth = depth + 4;
                    }
                    else if (depth == 1)
                    {
                        y.append("(((4");
                        depth = depth + 3;
                    }
                    else if (depth == 2)
                    {
                        y.append("((4");
                        depth = depth + 2;
                    }
                    else if (depth == 3)
                    {
                        y.append("(4");
                        depth++;
                    }
                    else
                    {
                        y.append("4");
                    }
                }
                else if (c == '5')
                {
                    if (depth > 5)
                    {
                        while(depth > 5)
                        {
                            y.append(")");
                            depth--;
                        }
                    }
                    if (depth == 0)
                    {
                        y.append("(((((5");
                        depth = depth + 5;
                    }
                    else if (depth == 1)
                    {
                        y.append("((((5");
                        depth = depth + 4;
                    }
                    else if (depth == 2)
                    {
                        y.append("(((5");
                        depth = depth + 3;
                    }
                    else if (depth == 3)
                    {
                        y.append("((5");
                        depth = depth + 2;
                    }
                    else if (depth == 4)
                    {
                        y.append("(5");
                        depth++;
                    }
                    else
                    {
                        y.append("5");
                    }
                }
                else if (c == '6')
                {
                    if (depth > 6)
                    {
                        while(depth > 6)
                        {
                            y.append(")");
                            depth--;
                        }
                    }
                    if (depth == 0)
                    {
                        y.append("((((((6");
                        depth = depth + 6;
                    }
                    else if (depth == 1)
                    {
                        y.append("(((((6");
                        depth = depth + 5;
                    }
                    else if (depth == 2)
                    {
                        y.append("((((6");
                        depth = depth + 4;
                    }
                    else if (depth == 3)
                    {
                        y.append("(((6");
                        depth = depth + 3;
                    }
                    else if (depth == 4)
                    {
                        y.append("((6");
                        depth = depth + 2;
                    }
                    else if (depth == 5)
                    {
                        y.append("(6");
                        depth++;
                    }
                    else
                    {
                        y.append("6");
                    }
                }
                else if (c == '7')
                {
                    if (depth > 7)
                    {
                        while(depth > 7)
                        {
                            y.append(")");
                            depth--;
                        }
                    }
                    if (depth == 0)
                    {
                        y.append("(((((((7");
                        depth = depth + 7;
                    }
                    else if (depth == 1)
                    {
                        y.append("((((((7");
                        depth = depth + 6;
                    }
                    else if (depth == 2)
                    {
                        y.append("(((((7");
                        depth = depth + 5;
                    }
                    else if (depth == 3)
                    {
                        y.append("((((7");
                        depth = depth + 4;
                    }
                    else if (depth == 4)
                    {
                        y.append("(((7");
                        depth = depth + 3;
                    }
                    else if (depth == 5)
                    {
                        y.append("((7");
                        depth = depth + 2;
                    }
                    else if (depth == 6)
                    {
                        y.append("(7");
                        depth++;
                    }
                    else
                    {
                        y.append("7");
                    }
                }
                else if (c == '8')
                {
                    if (depth > 8)
                    {
                        while(depth > 8)
                        {
                            y.append(")");
                            depth--;
                        }
                    }
                    if (depth == 0)
                    {
                        y.append("((((((((8");
                        depth = depth + 8;
                    }
                    else if (depth == 1)
                    {
                        y.append("(((((((8");
                        depth = depth + 7;
                    }
                    else if (depth == 2)
                    {
                        y.append("((((((8");
                        depth = depth + 6;
                    }
                    else if (depth == 3)
                    {
                        y.append("(((((8");
                        depth = depth + 5;
                    }
                    else if (depth == 4)
                    {
                        y.append("((((8");
                        depth = depth + 4;
                    }
                    else if (depth == 5)
                    {
                        y.append("(((8");
                        depth = depth + 3;
                    }
                    else if (depth == 6)
                    {
                        y.append("((8");
                        depth = depth + 2;
                    }
                    else if (depth == 7)
                    {
                        y.append("(8");
                        depth++;
                    }
                    else
                    {
                        y.append("8");
                    }
                }
                else
                {
                    if (depth > 9)
                    {
                        while(depth > 9)
                        {
                            y.append(")");
                            depth--;
                        }
                    }
                    if (depth == 0)
                    {
                        y.append("(((((((((9");
                        depth = depth + 9;
                    }
                    else if (depth == 1)
                    {
                        y.append("((((((((9");
                        depth = depth + 8;
                    }
                    else if (depth == 2)
                    {
                        y.append("(((((((9");
                        depth = depth + 7;
                    }
                    else if (depth == 3)
                    {
                        y.append("((((((9");
                        depth = depth + 6;
                    }
                    else if (depth == 4)
                    {
                        y.append("(((((9");
                        depth = depth + 5;
                    }
                    else if (depth == 5)
                    {
                        y.append("((((9");
                        depth = depth + 4;
                    }
                    else if (depth == 6)
                    {
                        y.append("(((9");
                        depth = depth + 3;
                    }
                    else if (depth == 7)
                    {
                        y.append("((9");
                        depth = depth + 2;
                    }
                    else if (depth == 8)
                    {
                        y.append("(9");
                        depth++;
                    }
                    else
                    {
                        y.append("9");
                    }
                }
            }
            while(depth > 0)
            {
                y.append(")");
                depth--;
            }
            System.out.println("Case #" + x + ": " + y.toString());
            x++;
        }
    }
}