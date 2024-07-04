import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        for(int n=0; n<t;n++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String m = scanner.nextLine();
            int[][] path = new int[m.length()][2];
            int [] length = new int[m.length()];
            int shortestI = -1;
            int shortestV = 1;
            for(int i=0; i<m.length();i++){
                path[i][0]=x;
                path[i][1]=y;

                switch (m.charAt(i)){
                    case 'N': y++; break;
                    case 'S': y--; break;
                    case 'E': x++; break;
                    case 'W': x--; break;
                }
                length[i] = calcLenght(x,y)-i;
                //System.out.println(length[i]);
                if(shortestI==-1 && length[i]<=0){
                   shortestI = i;
                   shortestV = length[i];
                }else if(length[i]<=0 && length[i]>shortestV){
                    shortestI = i;
                    shortestV = length[i];
                }
            }

            String out = "";
            if(shortestI==-1){
                out="IMPOSSIBLE";
            }else{
                out+=shortestI;
            }

            System.out.println("Case #"+(n+1)+": "+out);
        }
    }

    private static int calcLenght(int x, int y) {
        return Math.abs(x)+Math.abs(y);
    }
}
