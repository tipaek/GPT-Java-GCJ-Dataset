import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

    /*
    logic:
    left to right:
        open max number of brackets
        right to left:
            close max at each step (need to know minimum)
     */

    public static int findIndex(StringBuilder sb, int index)
    {
        int count = -1;
        for(int j = 0; j<sb.length();j++)
        {
            if(Character.isDigit(sb.charAt(j)))
            {
                count++;
            }
            if ( count == index)
                return j;
        }
        return -1;
    }



    public static void decrement(Pair[] a,int start, int end)
    {
        for(int i = start;i<=end;i++)
            a[i].sortedValue.decX();

    }

    public static int findMin(Pair[] a,int start, int end)
    {
        int min = Integer.MAX_VALUE;
        for(int i = start;i<=end;i++)
            min = Math.min(min,a[i].sortedValue.getX());
        return min;
    }


    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for (int testcase = 1; testcase<= T; testcase++)
        {
            StringBuilder S = new StringBuilder(sc.nextLine());
            int length = S.length();
            int[] arr = new int[length];
            for (int i = 0; i< length; i++)
            {
                arr[i]= Character.getNumericValue(S.charAt(i));
            }
            Pair[] pNeeded= new Pair[length];
            for (int i = 0; i< length;i ++)
            {
                pNeeded[i]= new Pair(arr[i],new myInteger(arr[i]));
            }

            int Sindex = 0;

            for (int i = 0; i< length; i++) // i is the index of the current digit being handled
            {
               Sindex = findIndex(S,i);
               for(int j = 0; j< pNeeded[i].sortedValue.getX();j++)
                   S.insert(Sindex,'(');
               int closeNeeded = pNeeded[i].sortedValue.getX();

               for(int j = length-1; j>=0; j-- )
               {
                   if (closeNeeded <= 0)
                       break;
                   while (findMin(pNeeded,i,j)>0 && closeNeeded>0) {
                       decrement(pNeeded, i, j);
                       S.insert(findIndex(S, j) + 1, ')');
                       closeNeeded--;
                   }
               }
            }
            System.out.printf("Case #%d: %s\n",testcase,S);
        }
    }

    static class Pair implements Comparable<Pair>{
        int value;
        myInteger sortedValue;

        public Pair(int value, myInteger sortedValue) {
            this.value = value;
            this.sortedValue = sortedValue;
        }

        @Override
        public int compareTo(Pair o) {
            return sortedValue.x - o.sortedValue.x;
        }
    }

    static class myInteger implements Comparable<myInteger>
    {
        int x;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void decX()
        {
            x--;
        }

        public myInteger(int x) {
            this.x = x;
        }

        public String toString()
        {
            return x+"";
        }

        @Override
        public int compareTo(myInteger o) {
            return x - o.x;
        }

        @Override
        public boolean equals(Object obj) {
            return this.x == ((myInteger)obj).x;
        }
    }
}



