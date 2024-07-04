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
        int count = 0;
        boolean done = false;
        while(!done && count < tour.size()){
            int dir = tour.get(count);
            if(dir == 0 && y > 0){
                if(y > 1){
                    y -= 2;
                }else{
                    y = 0;
                }
            }
            if(dir == 2 && y < 0){
                if(y < -1){
                    y += 2;
                }else{
                    y = 0;
                }
            }
            if(dir == 3 && x > 0){
                if(x > 1){
                    x -= 2;
                }else{
                    x = 0;
                }
            }
            if(dir == 1 && x < 0){
                if(x < -1){
                    x += 2;
                }else{
                    x = 0;
                }
            }
            count++;
            if(x == 0 && y == 0){
                done = true;
            }
        }
        if(done){
            System.out.println("Case #"+(testNum+1)+": "+count);
        }else{
            System.out.println("Case #"+(testNum+1)+": IMPOSSIBLE");
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



