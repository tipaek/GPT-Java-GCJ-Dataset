import java.util.Scanner;

public class Solution {

    public static void giveSequence(int[][] mat, int n, int cnt){
        int persons = 0;
        int[] endTasks = new int[2];
        boolean[] areBusy = new boolean[2];
        char[] sequence = new char[n];
        for(int i=0;i<n;i++){
            int st = mat[i][0];
            int et = mat[i][1];


            if(areBusy[0]==true && endTasks[0]<=st){
                areBusy[0] = false;
                persons--;
            }
            if(areBusy[1]==true && endTasks[1] <= st){
                areBusy[1] = false;
                persons--;
            }

            if(areBusy[0]==false){
                endTasks[0] = et;
                areBusy[0] = true;
                sequence[i] = 'C';
            }
            else if(areBusy[1]==false){
                endTasks[1] = et;
                areBusy[1] = true;
                sequence[i] = 'J';
            }
            persons++;
            if(persons > 2){
                System.out.println("Case #"+cnt+": IMPOSSIBLE");
                return;
            }
        }

        String res = new String(sequence);
        System.out.println("Case #"+cnt+": " + res);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int cnt = 1;
        while(cnt <= t){
            int n = sc.nextInt();
            int[][] mat = new int[n][2];
            for(int i=0;i<n;i++){
                mat[i][0] = sc.nextInt();
                mat[i][1] = sc.nextInt();
            }

            int i=1;
            while(i<n){
                int key0 = mat[i][0];
                int key1 = mat[i][1];
                int j = i-1;
                while(j>=0 && mat[j][0]>key0){
                    mat[j+1][0] = mat[j][0];
                    mat[j+1][1] = mat[j][1];
                    j--;
                }
                mat[j+1][0] = key0;
                mat[j+1][1] = key1;
                i++;
            }
            giveSequence(mat, n, cnt);
            cnt++;
        }
    }
}