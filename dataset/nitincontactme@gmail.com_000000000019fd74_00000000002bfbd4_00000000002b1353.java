
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i11 = 0; i11 < t; i11++) {
            int n = in.nextInt();
            LinkedList<Integer[]> list = new LinkedList<>();
            list.add(new Integer[]{0,0});
            getPaths(n-1, 0, 0, list);
            System.out.println("Case #"+(i11+1)+":");
            for(Integer[] ar: list) {
                System.out.println((ar[0]+1)+" "+(ar[1]+1));
            }
        }
        in.close();
    }

    private static void getPaths(int n, int x1, int x2, LinkedList<Integer[]> list) {
        if (n==0)return ;
        //r+1,c+1
        int x=x1+1,y=x2+1;
        if (list.size()%2==0) y--;
        int a1 = comb(x,y);
        if (n>=a1) {
            //System.out.println(x+"\t"+y+"\t"+a1);
            list.add(new Integer[]{x, y});
            getPaths(n-a1, x, y, list);
            return;
        }
        //r+1,c
        x=x1+1;y=x2;
        if (list.size()%2==0) y++;
        a1 = comb(x,y);
        if (n>=a1) {
            //System.out.println(x+"\t"+y+"\t"+a1);
            list.add(new Integer[]{x, y});
            getPaths(n-a1, x, y, list);
            return;
        }

        //r,c-1
        x=x1;y=x2-1;
        if (y!=0) {
            a1 = comb(x,y);
            if (n>=a1) {
                //System.out.println(x+"\t"+y+"\t"+a1);
                list.add(new Integer[]{x, y});
                getPaths(n-a1, x, y, list);
                return;
            }
        }

        //check if list comtains x1,0
        boolean first = false;
        for(Integer[] ar: list) {
            if (ar[0]==x1 && ar[1]==0) {
                first=true;
                break;
            }
        }

        if (!first) {
            list.add(new Integer[]{x1,0});
            getPaths(n-1, x1,0, list);
            return;
        } else {
            list.add(new Integer[]{x1+1,0});
            getPaths(n-1, x1+1,0, list);
        }
    }
    static int comb(int n , int r) {
        if( r== 0 || n == r)
            return 1;
        else
            return comb(n-1,r)+comb(n-1,r-1);
    }
}
