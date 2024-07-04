import java.util.Scanner;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String path;
        char step;
        int min;
        StringBuilder ans = new StringBuilder();
        for(int i = 1; i<=T; i++){
            ans.append("Case #"+i+": ");
            path = "";
            min = 0;
            int x = 0, y=0, difX, difY;
            int xStart = sc.nextInt();
            int yStart = sc.nextInt();
            difX = xStart;
            difY = yStart;
            path = sc.next();
            for(int j = 0; j<path.length(); j++){
                step = path.charAt(j);
                if(step=='N'){
                    yStart++;
                    difY++;
                } else if(step=='E'){
                    xStart++;
                    difX++;
                } else if (step == 'W') {
                    xStart--;
                    difX--;
                }else if (step == 'S') {
                    yStart--;
                    difY--;
                }
                min++;
                if(!(difX==0&&difY==0)){

                    if (difX > 0) {
                        x++;
                    } else if (difX < 0) {
                        x--;
                    } else if (difY > 0) {
                        y++;
                    } else if (difX < 0) {
                        y--;
                    }
                    difX = xStart - x;
                    difY = yStart - y;
                } else{
                    break;
                }
            }
            if(difX == 0 && difY == 0){
                ans.append(min+"\n");
            }else{
                ans.append("IMPOSSIBLE\n");
            }
        }
        System.out.print(ans.toString());
    }
}