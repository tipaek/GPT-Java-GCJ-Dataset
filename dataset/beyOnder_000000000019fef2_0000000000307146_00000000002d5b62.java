

import java.util.*;

public class Solution{
    static char arr[] = {'E','W','N','S'};//E+1      ,    W-1     ,N+1     ,S-1
    static int power(int n){
        return 1<<n;
    }
    static int[] findWithSign(int x,int y){
        int min = Math.min(Math.abs(x),Math.abs(y));
        int max;
        if(min == x){
            max = y;
            return new int[]{min, 1,max};
        }
        if(min == y){
            max = x;
            return new int[]{min, -1,max};
        }
        if(min == -x){
            max = y;
            return new int[]{-min, 1,max};
        }
        max = x;
        return new int[]{-min, -1,max};
    }
    static ArrayList<Character> list = new ArrayList<>();
    static boolean find(int x ,int y,int twoPow){
        int temp = power(twoPow);
        if(x==0 && y==0){
//            System.out.println("task0");
            return true;
        }
        if(x==0){
            if(temp>Math.abs(y)){
                return false;
            }
            else if(temp==Math.abs(y)){
                list.add((y<0)?'S':'N');
//                System.out.println("task1");
                return true;
            }
            else if(temp<Math.abs(y)){
                if(find(0,(y<0)?(y+temp):(y-temp),twoPow+1)){
                    list.add((y<0)?'S':'N');
//                    System.out.println("task2");
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        if(y==0){
            if(temp>Math.abs(x)){
                return false;
            }
            else if(temp==Math.abs(x)){
//                System.out.println("task3");
                list.add((x<0)?'W':'E');
                return true;
            }
            else if(temp<Math.abs(x)){
                if(find((x<0)?(x+temp):(x-temp),y,twoPow+1)){
                    list.add((x<0)?'W':'E');
//                    System.out.println("task4");
                    return true;
                }
                else{
                    return false;
                }
            }
        }
//        System.out.println("x = "+x+"  ,y = "+y+"  ,temp = "+temp+"  ,power = "+twoPow);
        if(temp>Math.min(Math.abs(x),Math.abs(y))){
            return false;
        }

        if(find(x+temp,y,twoPow+1)){
            list.add('W');
//            System.out.println("task6");
            return true;
        }
        if(find(x-temp,y,twoPow+1)){
            list.add('E');
//            System.out.println("task7");
            return true;
        }

        if(find(x,y-temp,twoPow+1)){
//            System.out.println("task8");
            list.add('N');
            return true;
        }
        if(find(x,y+temp,twoPow+1)){
//            System.out.println("task9");
            list.add('S');
            return true;
        }
        return false;


    }

    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        for(int h=1;h<=t;h++){
            int x = in.nextInt();
            int y = in.nextInt();
            System.out.print("Case #"+h+": ");
            boolean z = find(x,y,0);
            if(!z){
                System.out.println("Impossible");
            }
            else{
//                System.out.println(list);
                for(int q=list.size()-1;q>=0;q--){
                    System.out.print(list.get(q));
                }
                System.out.println();
            }
//            System.out.println();
            list.clear();
        }
//        System.out.println(Arrays.toString(findWithSign(3,-2)));
//        System.out.println(Arrays.toString(findWithSign(-9,-8)));
//        System.out.println(Arrays.toString(findWithSign(9,18)));
    }
}