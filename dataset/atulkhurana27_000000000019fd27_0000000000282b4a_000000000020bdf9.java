


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCases = sc.nextInt();
        String result = "";


        for (int i = 1; i <= testCases; i++) {
            result = "";
            int n = sc.nextInt();
            Pair[] p = new Pair[n];
            Pair[] p1 = new Pair[n];
            Integer cL = null;
            Integer cR = null;
            Integer jL = null;
            Integer jR = null;
            boolean notPosssible = false;

            for (int j = 0; j < n; j++) {

                int x = Integer.parseInt(sc.next());
                int y = Integer.parseInt(sc.next());
                p[j] = new Pair(x, y);
                p1[j] = new Pair(x, y);


            }
            Comparator<Pair> localeComparator = new Comparator<Pair>() {
                public int compare(Pair p1, Pair p2) {
                    return Integer.valueOf(p1.getX()).compareTo(Integer.valueOf(p2.getX()));
                }
            };
            Arrays.sort(p, localeComparator);

            char res[] = new char[n];

            for (int j = 0; j < n; j++) {

                int x = p[j].getX();
                int y = p[j].getY();


                if (cL == null || cR <= x) {
                    cL = x;
                    cR = y;
                    res[j] = 'C';
                } else if (jL == null || jR <= x) {
                    jL = x;
                    jR = y;
                    res[j] = 'J';
                } else {

                    notPosssible = true;
                    break;

                }

            }
            if (notPosssible)
                result = "IMPOSSIBLE";
            else {
                for(int k=0;k<n;k++) {
                    int x = getIndexOF(p,p1[k].getX());
                    result+=res[x];
                }
            }
            System.out.println("Case #" + i + ": " + result);
        }

    }

    private static int getIndexOF(Pair[] p , int x) {
        int y=-1;

        for(int k=0;k<p.length;k++) {
            if(p[k].getX()==x)
                return k;
        }
        return  y;

    }

    static class Pair {
        private int x;
        private int y;


        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }


    }

}


