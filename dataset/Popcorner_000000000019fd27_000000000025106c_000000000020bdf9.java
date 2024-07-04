import java.util.*;
import java.io.*;

public class Solution{

    public static void sortMat(int[][] mat, int col){
        Arrays.sort(mat, new Comparator<int[]>(){
            @Override
            public int compare(final int[] entry1, final int[] entry2){
                if(entry1[col] > entry2[col])
                    return 1;
                return -1;
            }
        });
    }

    public static String setSchedule(int[][] mat, int size){
        sortMat(mat, 0);

        int end1 = 0, end2 = 0;
        char[] ans = new char[size];

        for(int i = 0; i < size; i++){
            if(end1 <= mat[i][0]){
                ans[mat[i][2]] = 'C';
                end1 = mat[i][1];
                continue;
            }

            if(end2 <= mat[i][0]){
                ans[mat[i][2]] = 'J';
                end2 = mat[i][1];
                continue;
            }

            return "IMPOSSIBLE";
        }

        return new String(ans);
    }
    
    public static void main(String[] args){
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int tc = 0;

        if(input.hasNextLine())
            tc = Integer.parseInt(input.nextLine());

        for(int i = 0; i < tc; i++){
            int size = Integer.parseInt(input.nextLine());
            int[][] mat = new int[size][3];

            for(int j = 0; j < size; j++){
                String[] line = input.nextLine().split(" ");
                mat[j][0] = Integer.parseInt(line[0]);
                mat[j][1] = Integer.parseInt(line[1]);
                mat[j][2] = j;
            }
            System.out.println("Case #" + (i + 1) + ": " + setSchedule(mat, size));
        }
        input.close();
    }
}