import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution{

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int c = in.nextInt();
        int a;
        int[][] as;
        String S = "";
        for (int i = 0; i < c; i++) {
            S = "";
            a = in.nextInt();
            as = new int[a][4];//-1 for impossible, 0 for c and 1 for j
            for (int n = 0; n < a; n++) {
                    as[n][0] = in.nextInt(); 
                    as[n][1] = in.nextInt();
                    as[n][2] = -1; //not assigned;
                    as[n][3] = n; //this stores the innitial indexes for resotring later
            }
            sortbyColumn(as, 1); //sort by ending times of the activities
            as[0][2] = 0; //first a assigned to 0
            int pr = 0;
            for (int n = 1; n < a; n++) {
                   if(as[n][0] >= as[pr][1]){as[n][2] = 0; pr = n;}
            }
            int countJ = 0;
            for (int n = 1; n < a; n++) {
                   if(as[n][2] == -1)
                   {
                       as[n][2] = 1;
                       countJ = n;
                       pr = n;
                       break;
                   }
            }
            for (int n = countJ+1; n < a; n++) {
                   if(as[n][2] == -1)
                   {
                       if(as[n][0] >= as[pr][1]){as[n][2] = 1; pr = n;}
                       
                   }
            }
            sortbyColumn(as, 3);
            for (int n = 0; n < a; n++) {
                   if(as[n][2] == 0)
                   {
                       S = S + "C";
                   }
                   if(as[n][2] == 1)
                   {
                       S = S + "J";
                   }
            }
                        for (int n = 0; n < a; n++) {
                   if(as[n][2] == -1)
                   {
                       S = "IMPOSSIBLE";
                       break;
                   }
            }
            System.out.println("Case #"+ (i+1) +": " + S);
            
            
            
            

        }

    }

    public static void sortbyColumn(int arr[][], int col) {
        Arrays.sort(arr, (int[] entry1, int[] entry2) -> {
            return(entry1[col] > entry2[col]) ? 1: -1;
        });
    }
    public static boolean between(int i, int minValueInclusive, int maxValueInclusive) {
    return (i >= minValueInclusive && i <= maxValueInclusive);
}
}
