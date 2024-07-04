import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);


        HashMap<String,String> ans = new HashMap<>();
        ans.put("0 0","");

        LinkedList<String> queue = new LinkedList<>();
        queue.addLast("0 0");
        int count = 1;
        int jump = 1;
        for(int i=0;i<11;i++){
            for(int j=0;j<count;j++){
                String[] coord = queue.removeFirst().split(" ");
                int x = Integer.parseInt(coord[0]);
                int y = Integer.parseInt(coord[1]);
                if(!ans.containsKey((x+jump)+" "+y)){
                    ans.put((x+jump)+" "+y, ans.get(x+" "+y)+"E");
                    queue.addLast((x+jump)+" "+y);
                }
                if(!ans.containsKey((x-jump)+" "+y)){
                    ans.put((x-jump)+" "+y, ans.get(x+" "+y)+"W");
                    queue.addLast((x-jump)+" "+y);
                }
                if(!ans.containsKey((x)+" "+(y+jump))) {
                    ans.put((x) + " " + (y + jump), ans.get(x + " " + y) + "N");
                    queue.addLast((x)+" "+(y+jump));
                }
                if(!ans.containsKey((x)+" "+(y-jump))) {
                    ans.put((x) + " " + (y - jump), ans.get(x + " " + y) + "S");
                    queue.addLast((x)+" "+(y-jump));
                }
            }
            count*=4;
            jump*=2;
        }
        int t = sc.nextInt();
        int tt = t;

        while(t-->0){

            int X = sc.nextInt();
            int Y = sc.nextInt();

            if(ans.containsKey(X+" "+Y)){
                System.out.println("Case #"+(tt-t)+": "+ans.get(X+" "+Y));
            }
            else{
                System.out.println("Case #"+(tt-t)+": IMPOSSIBLE");
            }





        }
    }
}
