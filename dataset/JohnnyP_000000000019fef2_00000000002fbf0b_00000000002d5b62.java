
import java.util.*;

public class Solution {



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        for(int test =0; test< t;test++)
        {
            int x = in.nextInt();
            int y = in.nextInt();

            ArrayList<ArrayList<Integer>> m = new ArrayList<>();
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(0);
            temp.add(0);
            temp.add(0);
            m.add(temp);

            int c =3;
            boolean ok = false;
            while(m.size() > 0)
            {
                //System.out.println(m);
                ArrayList<Integer> cur = m.remove(0);

                if(cur.get(0) == x && cur.get(1) == y)
                {
                    System.out.print("CASE #" + (test+1) + ": ");
                    for(int i=3;i<cur.size();i++)
                    {
                        System.out.print((char)(cur.get(i) + 'A'));
                    }
                    System.out.print("\n");
                    ok = true;
                    break;
                }
                else
                {
                    ArrayList<Integer> sal = new ArrayList<Integer>();
                    sal.add(cur.get(0));
                    sal.add(cur.get(1) + (int) Math.pow(2, cur.get(2) ));
                    sal.add(cur.get(2) +1);
                    for(int i=3;i<cur.size();i++)
                    {
                        sal.add(cur.get(i));
                    }
                    sal.add('N'-'A');

                    if(2*Math.abs(cur.get(0) - x) < Math.pow(2, sal.get(2)) && 2*Math.abs(cur.get(1) - y)  < Math.pow(2, sal.get(2)))
                    {

                    }else
                        m.add(sal);

                     sal = new ArrayList<Integer>();
                    sal.add(cur.get(0));
                    sal.add(cur.get(1) - (int) Math.pow(2, cur.get(2)));
                    sal.add(cur.get(2) +1);
                    for(int i=3;i<cur.size();i++)
                    {
                        sal.add(cur.get(i));
                    }
                    sal.add('S'-'A');
                    if(2*Math.abs(cur.get(0) - x) < Math.pow(2, sal.get(2)) && 2*Math.abs(cur.get(1) - y)  < Math.pow(2, sal.get(2)))
                    {

                    }else
                        m.add(sal);


                    sal = new ArrayList<Integer>();
                    sal.add(cur.get(0)- (int) Math.pow(2, cur.get(2)));
                    sal.add(cur.get(1) );
                    sal.add(cur.get(2) +1);
                    for(int i=3;i<cur.size();i++)
                    {
                        sal.add(cur.get(i));
                    }
                    sal.add('W'-'A');
                    if(2*Math.abs(cur.get(0) - x) < Math.pow(2, sal.get(2)) && 2*Math.abs(cur.get(1) - y)  < Math.pow(2, sal.get(2)))
                    {

                    }else
                        m.add(sal);

                    sal = new ArrayList<Integer>();
                    sal.add(cur.get(0)+(int) Math.pow(2, cur.get(2)));
                    sal.add(cur.get(1) );
                    sal.add(cur.get(2) +1);
                    for(int i=3;i<cur.size();i++)
                    {
                        sal.add(cur.get(i));
                    }
                    sal.add('E'-'A');
                    if(2*Math.abs(cur.get(0) - x) < Math.pow(2, sal.get(2)) && 2*Math.abs(cur.get(1) - y)  < Math.pow(2, sal.get(2)))
                    {

                    }else
                        m.add(sal);
                }

            }
            if(!ok)
                System.out.println("CASE #" + (test +1) +  ": IMPOSSIBLE");
        }
    }

}