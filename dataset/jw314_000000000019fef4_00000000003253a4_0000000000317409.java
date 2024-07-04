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
        List<Integer> tour = readList(0, scan);
        List<Integer> manhattanDist = new ArrayList<Integer>();
        int mDist = Math.abs(x)+Math.abs(y);
        manhattanDist.add(mDist);
        for (int i = 0; i < tour.size(); i++) {
            int dir = tour.get(i);
            if(dir == 0){
                y++;
            }
            if(dir == 2){
                y--;
            }
            if(dir == 1){
                x--;
            }
            if(dir == 3){
                x++;
            }
            mDist = Math.abs(x)+Math.abs(y);
            manhattanDist.add(mDist);
        }
        int found = -1;
        for (int i = 0; i < manhattanDist.size(); i++) {
            if(i >= manhattanDist.get(i)){
                found = i;
                break;
            }
        }
        if(found == -1){
            System.out.println("Case #"+(testNum+1)+": IMPOSSIBLE");
        }else{
            System.out.println("Case #"+(testNum+1)+": "+found);
        }
        System.out.flush();
    }
    //READ LIST
    public List<Integer> readList(int n, Scanner scan){
        List<Integer> res = new ArrayList<Integer>();
        String m = scan.next();
        for(int i = 0; i < m.length(); i++){
            if(m.charAt(i) == 'N'){
                res.add(0);
            }
            if(m.charAt(i) == 'W'){
                res.add(1);
            }
            if(m.charAt(i) == 'S'){
                res.add(2);
            }
            if(m.charAt(i) == 'E'){
                res.add(3);
            }
        }
        return res;
    }

}



