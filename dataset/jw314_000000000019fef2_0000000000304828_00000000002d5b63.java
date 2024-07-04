import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tests = scan.nextInt();
        boolean db = false;
        if(tests == 0){
            db = true;
            tests = 100;
        }
        for(int testNum = 0; testNum < tests; testNum++){
            Solution testcase = new Solution();
            boolean success = testcase.solve(testNum, scan, db);
            if(!success){
                break;
            }
        }
    }

    public Solution(){

    }

    public boolean solve(int testNum, Scanner scan, boolean db){
        boolean found = false;
        int bX = 0;
        int bY = 0;
        for (int i = -5; i < 6; i++) {
            for (int j = -5; j < 6; j++) {
                int resp = ask(i, j, scan);
                if(resp == 2){
                    found = true;
                    bX = i;
                    bY = j;
                    break;
                }
            }
            if(found){
                break;
            }
        }
        /**
        System.out.flush();
        String res = scan.next();
        if(res.equals("Y")){
            return true;
        }else{
            return false;
        }**/
        if(found){
            return true;
        }else{
            return false;
        }
    }
    public int ask(int posx, int posy, Scanner scan){
        System.out.println(posx+" "+posy);
        System.out.flush();
        String res = scan.next();
        if(res.equals("CENTER")){
            return 2;
        }else{
            return 1;
        }
    }
}
