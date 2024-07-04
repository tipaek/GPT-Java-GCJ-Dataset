
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

class Solution {
    public static void main1(String[] args) {
        LinkedList<Integer[]> list = new LinkedList<>();
        list.add(new Integer[]{0,0});
        System.out.println(list.stream().anyMatch(i -> i[0]==0&&i[1]==0));
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i11 = 0; i11 < t; i11++) {
            int n = in.nextInt();
            LinkedList<Integer[]> list = new LinkedList<>();
            list.add(new Integer[]{0,0,1});
            getPaths(n-1, 0, 0, list);
            System.out.println("Case #"+(i11+1)+":");
            for(Integer[] ar: list) {
                //System.out.println((ar[0]+1)+" "+(ar[1]+1)+"\t"+ar[2]);
                System.out.println((ar[0]+1)+" "+(ar[1]+1));
            }
        }
        in.close();
    }

    private static Object getPaths(int n, int x1, int x2, LinkedList<Integer[]> list) {
        if (n==0)return new Object();
        if (list.size()>20)return null;
        //r+1,c+1
        int x=x1+1,y=x2+1;
        if (list.size()%2==0) y--;
        int a1 = comb(x,y);
        if (n>=a1) {
            //System.out.println(x+"\t"+y+"\t"+a1);
            list.add(new Integer[]{x, y,a1});
            Object res = getPaths(n-a1, x, y, list);
            if (res != null)
                return new Object();
            else list.removeLast();
        }
        //r+1,c
        x=x1+1;y=x2;
        if (list.size()%2==0) y++;
        a1 = comb(x,y);
        if (n>=a1) {
            //System.out.println(x+"\t"+y+"\t"+a1);
            list.add(new Integer[]{x, y,a1});
            Object res = getPaths(n-a1, x, y, list);
            if (res != null)
                return new Object();
            else list.removeLast();
        }

        //r,c-1
        x=x1;y=x2-1;
        if (y!=0) {
            a1 = comb(x,y);
            if (n>=a1) {
                //System.out.println(x+"\t"+y+"\t"+a1);
                list.add(new Integer[]{x, y,a1});
                Object res = getPaths(n-a1, x, y, list);
                if (res != null)
                    return new Object();
                else list.removeLast();
            }
        }

        //r,c+1
        x=x1;y=x2+1;
        if (!contains(list, x,y)) {
            a1 = comb(x,y);
            if (n>=a1) {
                //System.out.println(x+"\t"+y+"\t"+a1);
                list.add(new Integer[]{x, y,a1});
                Object res = getPaths(n-a1, x, y, list);
                if (res != null)
                    return new Object();
                else list.removeLast();
            }
        }
        //r-1,c-1
        x=x1-1;y=x2-1;
        if (!contains(list, x,y)) {
            a1 = comb(x,y);
            if (n>=a1) {
                //System.out.println(x+"\t"+y+"\t"+a1);
                list.add(new Integer[]{x, y,a1});
                Object res = getPaths(n-a1, x, y, list);
                if (res != null)
                    return new Object();
                else list.removeLast();
            }
        }
        //r-1,c
        x=x1-1;y=x2;
        if (!contains(list, x,y)) {
            a1 = comb(x,y);
            if (n>=a1) {
                //System.out.println(x+"\t"+y+"\t"+a1);
                list.add(new Integer[]{x, y,a1});
                Object res = getPaths(n-a1, x, y, list);
                if (res != null)
                    return new Object();
                else list.removeLast();
            }
        }
        return null;
    }

    private static boolean contains(LinkedList<Integer[]> list, int x, int y) {
        return list.stream().anyMatch(i->i[0]==x&&i[1]==y);
    }

    static int comb(int n, int r){
        int rfact=1, nfact=1, nrfact=1,temp1 = n-r ,temp2 = r;
        if(r>n-r)
        {
            temp1 =r;
            temp2 =n-r;
        }
        for(int i=1;i<=n;i++)
        {
            if(i<=temp2)
            {
                rfact *= i;
                nrfact *= i;
            }
            else if(i<=temp1)
            {
                nrfact *= i;
            }
            nfact *= i;
        }
        return (int) (nfact/(double)(rfact*nrfact));
    }
}
