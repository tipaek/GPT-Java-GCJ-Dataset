import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int iteration=1; iteration<=T; iteration++){
            int n = sc.nextInt();
            int[][] input = new int [n][2];
            String output = "";
            for(int i=0; i<n; i++){
                input[i][0] = sc.nextInt();
                input[i][1] = sc.nextInt();
            }

            int[] order = new int[n];
            order[0] = 1;
            boolean isPossible= true;
            for(int i=1; i<n; i++){
                boolean addtoJ = true;
                boolean addToC = true;
                for(int j=0; j<i; j++){
                    if(order[j]==1 && addtoJ && isInterfering(input[i][0], input[i][1], input[j][0], input[j][1])){
                        addtoJ = false;
                    }

                    if(order[j]==2 && addToC && isInterfering(input[i][0], input[i][1], input[j][0], input[j][1])){
                        addToC = false;
                    }
                }
                if(addtoJ){
                    order[i] = 1;
                }
                else if(addToC){
                    order[i] =2;
                }
                else{
                    isPossible = false;
                    break;
                }
            }
            if(!isPossible){
                System.out.println("Case #" + iteration + ": IMPOSSIBLE");
                continue;
            }
            for(int i=0; i<n; i++){
                if(order[i]==1)
                    output = output + "J";
                if(order[i]==2)
                    output = output + "C";    
            }
            System.out.println("Case #" + iteration + ": " + output);
    }
        sc.close();
    }

    public static boolean isInterfering(int x1, int y1, int x2, int y2){
        if((x1>x2 && x1<y2) || (y1>x2 && y1<y2) || (x2>x1 && x2<y1) || (y2>x1 && y2<y1) || (x1==x2 && y1==y2))
            return true;
        return false;
    }
}