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
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        int b=0;
        while(b!=t)
            {int n=in.nextInt();
            int[][] a=new int[n][3];
            for(int i=0; i<n; i++){
                for(int j=0; j<2; j++){
                    a[i][j]=in.nextInt();
                }
                a[i][2]=i;
            }
            boolean tf=true;
            int[] arr= new int[]{0, 0};
            char[] l=new char[n];
            sortbyColumn(a, 0);
            for (int i=0; i<n; i++){
                if(a[i][0]>=arr[0]) {
                    arr[0] = a[i][1];
                    l[a[i][2]]='C';
                }
                else if(a[i][0]>=arr[1]) {
                    arr[1] = a[i][1];
                    l[a[i][2]]='J';
                }
                else{
                    tf=false;
                    break;
                }
            }
            String ans=String.valueOf(l);
            if(!tf)
                System.out.println("Case #"+(++b)+": IMPOSSIBLE");
            else
                System.out.println("Case #"+(++b)+": "+ans);
        }
    }
}