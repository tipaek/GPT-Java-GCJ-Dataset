
import java.util.*;

public class Solution {

    static class Point{
        public int x;
        public int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int t=1; t<=tc; t++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            String path = sc.next();
            
            int result = getDirectionSequence(x, y, path);
            
            if(result == -1){
                System.out.println("Case #" + t + ": " + "IMPOSSIBLE");
            }else{
                System.out.println("Case #" + t + ": " + result);
            }

        }
    }

    public static int timeRequiredToReach(Point p){
      return Math.abs(p.x) + Math.abs(p.y);
    }

    private static int getDirectionSequence(int x, int y,String path){

        Map<Integer, Point> locationMapping = new HashMap<>();
        locationMapping.put(0,new Point(x,y));
        for(int i=0;i<path.length();i++){
            char ch = path.charAt(i);
            if(ch == 'S'){
                y--;
            }else if(ch == 'N'){
                y++;
            }else if(ch == 'E'){
                x++;
            }else{
                x--;
            }
            locationMapping.put(i+1,new Point(x,y));
        }

        for(int time: locationMapping.keySet()){
            if(timeRequiredToReach(timePointMapping.get(time)) <= time){
                return time;
            }
        }

        return -1;
    }
}