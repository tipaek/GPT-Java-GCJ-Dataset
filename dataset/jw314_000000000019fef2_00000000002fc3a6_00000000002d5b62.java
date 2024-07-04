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
            testcase.solve(testNum, scan, db);
        }
    }

    public Solution(){

    }
    public void solve(int testNum, Scanner scan, boolean db){
        int x = scan.nextInt();
        int y = scan.nextInt();
        boolean flipX = false;
        boolean flipY = false;
        if(x < 0){
            x = -1*x;
            flipX = true;
        }
        if(y < 0){
            y = -1*y;
            flipY = true;
        }
        String binX = Integer.toBinaryString(x);
        String binY = Integer.toBinaryString(y);
        if(binX.length() > binY.length()){
            String zer = "0";
            binY = zer.concat(binY);
        }
        if(binY.length() > binX.length()){
            String zer = "0";
            binX = zer.concat(binX);
        }
        int recent1 = -1;
        boolean possible = true;
        int[] invX = new int[binX.length()];
        int[] invY = new int[binX.length()];
        for (int i = 0; i < binX.length(); i++) {
            invX[i] = 0;
            invY[i] = 0;
        }
        for (int i = binX.length()-1; i >= 0; i--) {
            if(binX.charAt(i) == '0' && binY.charAt(i) == '1'){
                //moves = moves.concat("N");
                recent1 = 1;
            }else if(binX.charAt(i) == '0' && binY.charAt(i) == '1'){
                //moves = moves.concat("E");
                recent1 = 0;
            }else if(binX.charAt(i) == '0' && binY.charAt(i) == '0'){
                if(recent1 == -1){
                    possible = false;
                    break;
                }
                if(recent1 == 0){
                    String temp = binX;
                    String on = "1";
                    int rp = i;
                    binX = temp.substring(0, rp)+on+temp.substring(rp+1);
                    invX[i+1] = 1;
                }else{
                    String temp = binY;
                    String on = "1";
                    int rp = i;
                    binY = temp.substring(0, rp)+on+temp.substring(rp+1);
                    invY[i+1] = 1;
                }
            }else if(binX.charAt(i) == '1' && binY.charAt(i) == '1'){
                possible = false;
                break;
            }
        }
        String moves = "";
        if(possible){
            for (int i = binX.length()-1; i >= 0; i--) {
                if(binX.charAt(i) == '0' && binY.charAt(i) == '1'){
                    if(invY[i] == 1){
                        if(flipY){
                            moves = moves.concat("N");
                        }else{
                            moves = moves.concat("S");
                        }
                    }else{
                        if(flipY){
                            moves = moves.concat("S");
                        }else{
                            moves = moves.concat("N");
                        }
                    }
                }else if(binX.charAt(i) == '1' && binY.charAt(i) == '0'){
                    if(invX[i] == 1){
                        if(flipX){
                            moves = moves.concat("E");
                        }else{
                            moves = moves.concat("W");
                        }
                    }else{
                        if(flipX){
                            moves = moves.concat("W");
                        }else{
                            moves = moves.concat("E");
                        }
                    }
                }else {
                    possible = false;
                    break;
                }
            }
        }
        if(possible) {
            System.out.println("Case #"+(testNum+1)+": "+moves);
        }else{
            System.out.println("Case #"+(testNum+1)+": IMPOSSIBLE");
        }
    }
}

