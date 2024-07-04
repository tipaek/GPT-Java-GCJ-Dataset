

import java.util.*;

public class Solution {
    public static void sortbyColumn(int arr[][], int col){
        Arrays.sort(arr, new Comparator<int[]>() {

            @Override
            public int compare(final int[] entry1,
                               final int[] entry2) {
                if (entry1[col] > entry2[col])
                    return 1;
                else
                    return -1;
            }
        });
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t=s.nextInt();
        for(int b=1; b<=t; b++){
            int n=s.nextInt();
            int[][] a=new int[n][3];
            for(int i=0; i<n; i++){
                for(int j=0; j<2; j++){
                    a[i][j]=s.nextInt();
                }
                a[i][2]=i;
            }
            boolean flag=true;
            int[] time= new int[]{0, 0};
            char[] l=new char[n];
            sortbyColumn(a, 0);
            for (int i=0; i<n; i++){
                if(a[i][0]>=time[0]) {
                    time[0] = a[i][1];
                    l[a[i][2]]='C';
                }
                else if(a[i][0]>=time[1]) {
                    time[1] = a[i][1];
                    l[a[i][2]]='J';
                }
                else{
                    flag=false;
                    break;
                }
            }
            String out=String.valueOf(l);
            if(!flag)
                System.out.println("Case #"+b+": IMPOSSIBLE");
            else
                System.out.println("Case #"+b+": "+out);
        }
    }
}
