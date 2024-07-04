import java.util.*;
public class Solution {
    static int A,B;
    //static long hiddenx,hiddeny,hiddenr;
    public static void main(String[] args) {
        //hiddenr = 999999950;
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        A = in.nextInt();
        B = in.nextInt();
        for (int i = 0; i < T; i++) {
            //for (int j = -50; j <= 50; j++) {
              //  for (int k = -50; k <= 50 ; k++) {
                    //hiddenx = j;
                    //hiddeny = k;
                    solve(in);
             //   }
            //}
        }
    }
    public static void solve(Scanner in){

        //BinarySearch for an edge on y=0;
        int minx = 0;
        int maxx = 1000000001;
        while(maxx>minx+1) {
            int mid = (minx + maxx) / 2;
            String situation = query(in, mid, 0);
            if (situation.equals("CENTER")) {
                return;
            }
            if (situation.equals("MISS")) {
                maxx = mid;
            } else {
                minx = mid;
            }
        }
        int Ypos = minx;
        minx = -1000000000;
        maxx = 1;
        while(maxx>minx+1){
            int mid = (minx+maxx)/2;
            String situation = query(in,mid,0);
            if(situation.equals("CENTER")){
                return;
            }
            if(situation.equals("MISS")){
                minx = mid;
            }
            else{
                maxx = mid;
            }
        }
        int Yneg = maxx;



        //BinarySearch for an edge on x=0;
        int miny = 0;
        int maxy = 1000000001;
        while(maxy>miny+1) {
            int mid = (miny + maxy) / 2;
            String situation = query(in, 0, mid);
            if (situation.equals("CENTER")) {
                return;
            }
            if (situation.equals("MISS")) {
                maxy = mid;
            } else {
                miny = mid;
            }
        }
        int Xpos = miny;
        miny = -1000000000;
        maxy = 1;
        while(maxy>miny+1){
            int mid = (miny+maxy)/2;
            String situation = query(in,0,mid);
            if(situation.equals("CENTER")){
                return;
            }
            if(situation.equals("MISS")){
                miny = mid;
            }
            else{
                maxy = mid;
            }
        }
        int Xneg = maxy;

        //System.out.println(Ypos+" "+Yneg+" "+Xpos+" "+Xneg);

        int minimumx = (Ypos+Yneg-1)/2;
        int minimumy = (Xpos+Xneg-1)/2;
        //System.out.println(minimumx);
        //System.out.println(minimumy);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                String sit = query(in,i+minimumx,j+minimumy);
                if(sit.equals("CENTER")){
                    return;
                }
            }
        }





        /*//find a good Y
        int dist = 1;
        int direction = 0;
        while(true){
            String sit = query(in,minx,dist);
            if(sit.equals("CENTER")){
                return;
            }
            if(sit.equals("MISS")){
                direction = -1;
                break;
            }
            sit = query(in,minx+1,dist);
            if(sit.equals("CENTER")){
                return;
            }
            if(sit.equals("HIT")){
                direction = 1;
                break;
            }
            dist++;
        }

        while(maxx>minx+1){
            int mid = (minx+maxx)/2;
            String situation = query(in,mid,0);
            if(situation.equals("CENTER")){
                return;
            }
            if(situation.equals("MISS")){
                maxx = mid;
            }
            else{
                minx = mid;
            }
        }

        int checkx = minx;
        if(direction == 1){
            int miny = 0;
            int maxy = 1000000001;
            while(maxy>miny+1){
                int mid = (miny+maxy)/2;
                String sit = query(in,checkx,mid);
                if(sit.equals("CENTER")){
                    return;
                }
                if(sit.equals("MISS")){

                }
            }
        }
        else{
            int miny = -1000000000;
            int maxy = 1;
        }*/

    }
    public static String query(Scanner in, int x, int y){
        /*if(x==hiddenx&&y==hiddeny){
            return "CENTER";
        }
        if(((hiddenx-x)*(hiddenx-x)+((hiddeny-y)*(hiddeny-y)))<=hiddenr*hiddenr){
            return "HIT";
        }
        return "MISS";*/
        System.out.println(x+" "+y);
        return in.next();
    }
}
