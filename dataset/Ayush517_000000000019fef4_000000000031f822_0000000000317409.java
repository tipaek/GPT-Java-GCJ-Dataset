import java.math.*;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);

        int testcases = ob.nextInt();
        for (int test = 1; test<=testcases; test++) {
            int y=ob.nextInt();
            int x=ob.nextInt();
            String s = ob.next();
            char[] arr = s.toCharArray();

            HashSet<Pair> visited = new HashSet<Pair>();
            Queue<Pair> queue = new LinkedList();

            queue.add(new Pair(0, 0));
            visited.add(new Pair(0, 0));

            int i=0;
            int ans=0;
            boolean flag=false;
            while(i!=s.length() && !flag) {
                int size = queue.size();
                ans++;
                if(arr[i]=='S')
                    x--;
                else if(arr[i]=='N')
                    x++;
                else if(arr[i]=='E')
                    y++;
                else if(arr[i]=='W')
                    y--;
                Pair curr = new Pair(x, y);
                //System.out.println("xy "+ x+" "+y);
                for(int j=0;j<size;j++) {
                    Pair p = queue.poll();
                    //System.out.println(p.a+" "+p.b);

                    int x1=p.a, y1=p.b+1;
                    int x2=p.a, y2=p.b-1;
                    int x3=p.a+1, y3=p.b;
                    int x4=p.a-1, y4=p.b;

                    Pair p1 = new Pair(x1, y1);
                    Pair p2 = new Pair(x2, y2);
                    Pair p3 = new Pair(x3, y3);
                    Pair p4 = new Pair(x4, y4);

                    if(curr.equals(p)) {
                        flag=true;
                        break;
                    } else if (!visited.contains(p1) && curr.equals(p1)) {
                        flag=true;
                        break;
                    } else if (!visited.contains(p2) && curr.equals(p2)) {
                        flag=true;
                        break;
                    } else if (!visited.contains(p3) && curr.equals(p3)) {
                        flag=true;
                        break;
                    } else if (!visited.contains(p4) &&  curr.equals(p4)) {
                        flag=true;
                        break;
                    } else {
                        queue.add(p);
                        if(!visited.contains(p1)) {
                            queue.add(p1);
                            visited.add(p1);
                        }
                        if(!visited.contains(p2)) {
                            queue.add(p2);
                            visited.add(p2);
                        }
                        if(!visited.contains(p3)) {
                            queue.add(p3);
                            visited.add(p3);
                        }
                        if(!visited.contains(p4)) {
                            queue.add(p4);
                            visited.add(p4);
                        }
                    }
                }
                //System.out.println();
                i++;
            }
            if(flag)
                System.out.println("Case #"+test+": "+ans);
            else
                System.out.println("Case #"+test+": IMPOSSIBLE");
        }
    }
}

class Pair {
    int a;
    int b;
    Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public boolean equals(Object o) {
        if (o instanceof Pair) {
            Pair p = (Pair)o;
            return p.a == a && p.b == b;
        }
        return false;
    }

    public int hashCode() {
        return new Integer(a).hashCode() * 31 + new Integer(b).hashCode();
    }
}