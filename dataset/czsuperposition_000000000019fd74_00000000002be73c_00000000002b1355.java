import java.util.*;

public class Solution {
    public static class Node{
        private int skill;
        private Node left;
        private Node right;
        private Node up;
        private Node down;
        public Node(int skillLevel)
        {
            skill = skillLevel;
            left = null;
            right = null;
            up = null;
            down = null;
        }

        public double getAverage()
        {
            int sum = 0;
            int count = 0;
            if(left != null)
            {
                sum += left.skill;
                count++;
            }
            if(right != null)
            {
                sum += right.skill;
                count++;
            }
            if(up != null)
            {
                sum += up.skill;
                count++;
            }
            if(down != null)
            {
                sum += down.skill;
                count++;
            }
            if(count > 0)
                return sum*1.0/count;
            return 0;
        }
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int i=0;i<T;i++)
        {
            int R = scanner.nextInt();
            int C = scanner.nextInt();
            Node[][] alive = new Node[R][C];
            for(int j=0;j<R;j++)
            {
                for(int k=0;k<C;k++)
                {
                    int s = scanner.nextInt();
                    alive[j][k] = new Node(s);
                }
            }
            for(int j=0;j<R;j++)
            {
                for(int k=0;k<C;k++)
                {
                    if(j!=0)
                        alive[j][k].up = alive[j-1][k];
                    if(j!=R-1)
                        alive[j][k].down = alive[j+1][k];
                    if(k!=0)
                        alive[j][k].left = alive[j][k-1];
                    if(k!=C-1)
                        alive[j][k].right = alive[j][k+1];
                }
            }

            int interest = 0;
            while(true)
            {
                int sum = 0;
                int sumofElim = 0;
                int[][] eliminated = new int[R][C];
                for(int j=0;j<R;j++)
                {
                    for(int k=0;k<C;k++)
                    {
                        Node people = alive[j][k];
                        if(people != null)
                        {
                            sum += people.skill;
                            double average = people.getAverage();
                            if(people.skill < average)
                            {
                                eliminated[j][k] = 1;
                                sumofElim++;
                            }
                        }
                    }
                }
                interest += sum;
                if(sumofElim == 0)
                    break;
                for(int j=0;j<R;j++)
                {
                    for(int k=0;k<C;k++)
                    {
                        if(eliminated[j][k] == 1)
                        {
                            Node people = alive[j][k];
                            if(people.left!=null)
                                people.left.right = people.right;
                            if(people.right!=null)
                                people.right.left = people.left;
                            if(people.up!=null)
                                people.up.down = people.down;
                            if(people.down!=null)
                                people.down.up = people.up;
                            alive[j][k] = null;
                        }
                    }
                }
            }
            System.out.println("Case #" + (i+1) + ": " + interest);
        }

    }
}
