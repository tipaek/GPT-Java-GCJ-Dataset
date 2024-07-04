import java.util.*;
import java.io.*;
public class Solution {
    public static HashMap<Coordinate, String> hashmap = new HashMap<Coordinate, String>();
    public static ArrayList<Coordinate> arrayList = new ArrayList<Coordinate>();
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        recur(0, 0, 0, "");
        for(int i=1; i<=T; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            boolean istrue = false;
            ArrayList<Coordinate> coors = new ArrayList<Coordinate>();
            int min = Integer.MAX_VALUE;
            for(Coordinate coor : arrayList) {
                if(coor.x==x&&coor.y==y) {
                    coors.add(coor);
                    if(hashmap.get(coor).length()<min) {
                        min = hashmap.get(coor).length();
                    }
                    istrue = true;
                }
            }
            for(Coordinate coor : arrayList) {
                if(hashmap.get(coor).length()==min&&coor.x==x&&coor.y==y) {
                    System.out.println("Case #" + i + ": " + hashmap.get(coor));
                    break;
                }
            }
            if(istrue == false) {
                System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
            }
        }
    }
    public static void recur(int x, int y, int count, String str) {
        if(Math.abs(x)>100||Math.abs(y)>100) {
            return;
        }
        Coordinate coordinate = new Coordinate(x, y);
        hashmap.put(coordinate, str);
        arrayList.add(coordinate);
        recur(x+(int)Math.pow(2, count), y, count+1, str+'E');
        recur(x-(int)Math.pow(2, count), y, count+1, str+'W');
        recur(x, y+(int)Math.pow(2, count), count+1, str+'N');
        recur(x, y-(int)Math.pow(2, count), count+1, str+'S');
    }
    static class Coordinate {
        public int x;
        public int y;
        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
