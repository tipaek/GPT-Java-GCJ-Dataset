import java.util.LinkedList;
import java.util.Scanner;

import static java.lang.Integer.max;

public class Solution{
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int x = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= x; i++) {
            String str = sc.nextLine();
            String [] arr = str.split(" ");
            int init = Integer.parseInt(arr[0]);
            int fin = Integer.parseInt(arr[1]);
            String path = arr [2];
            LinkedList<int []> list = findPepPso(init, fin, path);
            int min = 999999999;
            for(int j = 1; j<list.size(); j++){
                int need = canI( list.get(j),j);
                if(need != -1 && max(need, j) <min){
                    min = max(need,j);
                }
            }
            if(min == 999999999){
                System.out.println("Case #"+i+": "+"IMPOSSIBLE");
            }else {
                System.out.println("Case #"+i+": "+min);
            }
        }
    }

    public static LinkedList<int []> findPepPso(int x, int y, String str){
        LinkedList<int []> list = new LinkedList<>();
        int [] arr = new int[]{x,y};
        list.add(arr);
        int len = str.length();
        for (int i = 0; i<len; i++){
            char c= str.charAt(i);
            switch (c) {
                case 'N':
                    list.add(new int[] {list.getLast()[0], list.getLast()[1]+1});
                    break;
                case 'S':
                    list.add(new int[] {list.getLast()[0], list.getLast()[1]-1});
                    break;
                case 'E':
                    list.add(new int[] {list.getLast()[0]+1, list.getLast()[1]});
                    break;
                case 'W':
                    list.add(new int[] {list.getLast()[0]-1, list.getLast()[1]});
                    break;
            }
        }
        return list;
    }

    public static int canI ( int[] peppPos, int limit){
        int xDiff = Math.abs(peppPos[0] );
        int yDiff = Math.abs(peppPos[1] );
        int tot = xDiff + yDiff;
        if(tot<=limit){
            return tot;
        }else {
            return -1;
        }
    }
}