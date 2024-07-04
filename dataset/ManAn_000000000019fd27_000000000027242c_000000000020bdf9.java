import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Solution {
    public static void sortbyColumn(int arr[][], int col) {
        Arrays.sort(arr, new Comparator<int[]>() {

            @Override
            public int compare(final int[] entry1, final int[] entry2) {
                if (entry1[col] > entry2[col])
                    return 1;
                else
                    return -1;
            }
        });
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.next());
        int count = 0;
        while (t-- > 0) {
            count++;
            int n = Integer.parseInt(in.next());
            int[][] w= new int[n][3];
            char []a = new char[n];

            for (int i = 0; i < w.length; i++) {
                w[i][0] = Integer.parseInt(in.next());
                w[i][1] = Integer.parseInt(in.next());
                w[i][2] = i;
            }

            sortbyColumn(w, 0);
            boolean flag = true;
            int jas = 0;
            int com = 0;
            for (int i = 0; i < w.length; i++) {
                    if(w[i][0]>=jas){
                        a[w[i][2]] = 'J';
                        jas = w[i][1];
                    }
                    else if(w[i][0] >= com){
                        a[w[i][2]] = 'C';
                        com = w[i][1];
                    }
                    else{
                        flag = false;
                        break;
                    }
                    //               if(w[i][0]>=com){
                    //     a[w[i][2]] = 'C';
                    //     com = w[i][1];
                    // }
                    // else if(w[i][0] >= jas){
                    //     a[w[i][2]] = 'J';
                    //     jas = w[i][1];
                    // }
                    // else{
                    //     flag = false;
                    //     break;
                    // }
            }

            System.out.print("Case #"+count+": ");
            if(flag){
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i]);
            }
            System.out.println();}
            else{
                System.out.println("IMPOSSIBLE");
            }

        }
    }

}