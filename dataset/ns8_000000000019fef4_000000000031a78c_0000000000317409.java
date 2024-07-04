import java.util.*;

public class CodeJam {

    static class point{
        public int x;
        public int y;
        point(int x, int y){
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

            String sequence = sc.next();
            int result = getDirectionSequence(x,y,sequence);
            String impossible = "IMPOSSIBLE";
            if(result == -1){
                System.out.println("Case #" + t + ": " + impossible);
            }else{
                System.out.println("Case #" + t + ": " + result);
            }

        }
    }


    private static int getDirectionSequence(int x, int y,String sequence){

        Map<Integer, point> timePointMapping = new HashMap<>();
        timePointMapping.put(0,new point(x,y));
        for(int i=0;i<sequence.length();i++){
            char ch = sequence.charAt(i);
            if(ch == 'S'){

                y = y-1;
            }else if(ch == 'N'){
                y = y+1;
            }else if(ch == 'E'){
                x = x+1;
            }else{
                x = x-1;
            }
            timePointMapping.put(i+1,new point(x,y));
        }

        for(int time: timePointMapping.keySet()){
            if(timeTakeToReach(timePointMapping.get(time)) <= time){
                return time;
            }
        }

        return -1;
    }

    public static int timeTakeToReach(point p){
      return Math.abs(p.x) + Math.abs(p.y);
    }
}