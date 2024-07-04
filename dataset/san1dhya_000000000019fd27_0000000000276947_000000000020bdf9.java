import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        //insert code here
        Scanner sc=new Scanner(System.in);
    int  t=sc.nextInt();
    for(int x=1;x<=t;x++){

        int n=sc.nextInt();
        int a[][]=new int[n][3];
        char tsk[]=new char[n];
        for(int i=0;i<n;i++){
            a[i][0]=i;
            a[i][1]=sc.nextInt();
            a[i][2]=sc.nextInt();
        }
        sbc(a,1);
        for(int i=0;i<n;i++){
     //       System.out.println(a[i][0]+" "+a[i][1]+" "+a[i][2]);
        }
        int f=1;
        long jt=-1,ct=-1;
        for(int i=0;i<n;i++){
            if(a[i][1]>=jt)
            {
                tsk[a[i][0]]='C';
                jt=a[i][2];
            }
            else if(a[i][1]>=ct)
            {
                tsk[a[i][0]]='J';
                ct=a[i][2];
            }
            else
            {
                f=0;
                break;
            }
        }
        if(f==0)
            System.out.println("Case #"+x+": IMPOSSIBLE");
        else
        {   System.out.print("Case #"+x+": ");
            for(int i=0;i<n;i++){
                System.out.print(tsk[i]);
            }
            System.out.println();
        }

    }
    }
    public static void sbc(int arr[][], int col)
    {
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
}
