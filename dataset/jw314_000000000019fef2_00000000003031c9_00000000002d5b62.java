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
        String zer = "0";
        if(binX.length() > binY.length()){
            binY = zer.concat(binY);
        }
        if(binY.length() > binX.length()){
            binX = zer.concat(binX);
        }
        binY = zer.concat(binY);
        binX = zer.concat(binX);
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
                if(recent1 == 2){
                    possible = false;
                    break;
                }
                recent1 = 1;
            }else if(binX.charAt(i) == '0' && binY.charAt(i) == '1'){
                //moves = moves.concat("E");
                if(recent1 == 2){
                    possible = false;
                    break;
                }
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
                }
                else if(recent1 == 1){
                    String temp = binY;
                    String on = "1";
                    int rp = i;
                    binY = temp.substring(0, rp)+on+temp.substring(rp+1);
                    invY[i+1] = 1;
                }
                else{
                    //recent1 == 2
                    String temp = binX;
                    String on = "1";
                    int rp = i;
                    binX = temp.substring(0, rp)+on+temp.substring(rp+1);
                    int pos0 = i+1;
                    boolean good = true;
                    boolean run = true;
                    while(run && pos0 <= binX.length()-1){
                        if(binX.charAt(pos0) == '0'){
                            good = false;
                            run = false;
                        }else if(binX.charAt(pos0) == '1' && binY.charAt(pos0) == '1'){
                            pos0++;
                        }else{
                            run = false;
                        }
                    }
                    if(!good || pos0 == binX.length()){
                        //UNDO PREV
                        temp = binX;
                        on = "0";
                        rp = i;
                        binX = temp.substring(0, rp)+on+temp.substring(rp+1);
                        //START
                        temp = binY;
                        on = "1";
                        rp = i;
                        binY = temp.substring(0, rp)+on+temp.substring(rp+1);
                        pos0 = i+1;
                        good = true;
                        run = true;
                        while(run && pos0 <= binY.length()-1){
                            if(binY.charAt(pos0) == '0'){
                                good = false;
                                run = false;
                            }else if(binY.charAt(pos0) == '1' && binX.charAt(pos0) == '1'){
                                pos0++;
                            }else{
                                run = false;
                            }
                        }
                        if(!good || pos0 == binY.length()){
                            possible = false;
                            break;
                        }else{
                            invY[pos0] = 1;
                            for (int j = i+1; j < pos0; j++) {
                                String tempp = binY;
                                String z = "0";
                                int rp0 = j;
                                binY = tempp.substring(0, rp0)+z+tempp.substring(rp0+1);
                            }
                        }
                    }
                    else{
                        invX[pos0] = 1;
                        for (int j = i+1; j < pos0; j++) {
                            String tempp = binX;
                            String z = "0";
                            int rp0 = j;
                            binX = temp.substring(0, rp0)+z+temp.substring(rp0+1);
                        }
                    }
                }
            }else if(binX.charAt(i) == '1' && binY.charAt(i) == '1'){
                recent1 = 2;
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
                    if(binX.charAt(i) == '0' && binY.charAt(i) == '0'){
                        break;
                    }else{
                        possible = false;
                        break;
                    }

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

