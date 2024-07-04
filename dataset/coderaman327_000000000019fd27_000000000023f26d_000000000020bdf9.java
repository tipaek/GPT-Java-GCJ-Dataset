import java.util.*;

public class Solution {
    private static class Node implements Comparable
    {
        int time;
        int task;
        Node(int ti,int ta)
        {
            time=ti;
            task=ta;
        }

        @Override
        public int compareTo(Object o) {
            Node o2=(Node)o;
            if(time<o2.time)
                return -1;
            if(time>o2.time)
                return 1;
            return 0;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int k=1;k<=t;k++)
        {
            int n=sc.nextInt();
            ArrayList<Node> start=new ArrayList<>();
            ArrayList<Node> end = new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                start.add(new Node(sc.nextInt(),i));
                end.add(new Node(sc.nextInt(),i));
            }
            Collections.sort(start);
            Collections.sort(end);
            int counter=0;
            int i=0,j=0;
            char[] ans=new char[n+1];
            LinkedList<Character> queue=new LinkedList<>();
            queue.add('C');
            queue.add('J');
            boolean check=true;
            while(true)
            {
                int next_start;
                if(i<n)
                    next_start=start.get(i).time;
                else
                    next_start=Integer.MAX_VALUE;
                int next_end=end.get(j).time;
                if(next_end<=next_start)
                {
                    counter--;
                    char assigned=ans[end.get(j).task];
                    queue.add(assigned);
                    j++;
                    if(j==n)
                        break;
                }
                else
                {
                    counter++;
                    if(counter==3) {
                        check=false;
                        break;
                    }
                    char available=queue.poll();
                    ans[start.get(i).task]=available;
                    i++;
                }
            }
            if(check==false)
                System.out.println("Case #"+k+": IMPOSSIBLE");
            else
            {
                System.out.print("Case #"+k+": ");
                for(i=0;i<n;++i)
                    System.out.print(ans[i]);
                System.out.println();
            }
        }
    }
}
