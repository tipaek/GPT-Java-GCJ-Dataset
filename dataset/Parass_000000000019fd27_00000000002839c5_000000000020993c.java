import java.io.*;
import java.util.*;

public class Q1 {

    public static void main(String[] args) {

        Scanner in =new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);

        int t =in.nextInt(),x=0;
        while(x++<t) {
            int N =in.nextInt();
            int arr[][]=new int[N][N];
            int r=0,c=0,m=0;
            for (int i = 0; i <N; i++) {
                for (int j = 0; j <N; j++) {
                    arr[i][j]=in.nextInt();
                    if(i==j)
                        m+=arr[i][j];
                }
            }

            HashSet<Integer> set=new HashSet<>();
            for (int i = 0; i <N; i++) {
                set=new HashSet<>();
                for (int j = 0; j <N; j++) {
                    if(set.contains(arr[i][j])) {
                        r++;
                        break;
                    }
                    set.add(arr[i][j]);
                }
            }

            for (int i = 0; i <N; i++) {
                set=new HashSet<>();
                for (int j = 0; j <N; j++) {
                    if(set.contains(arr[j][i])) {
                        c++;
                        break;
                    }
                    set.add(arr[j][i]);
                }
            }


            out.println("Case #"+x+": " +m+" "+r+" "+c);
        }

        out.close();

    }
}

