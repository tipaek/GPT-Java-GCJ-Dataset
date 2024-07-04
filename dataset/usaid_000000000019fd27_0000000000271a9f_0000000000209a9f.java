
import java.io.*;
import java.util.*;


public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCase = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < testCase; i++) {
            String num = sc.nextLine();
            System.out.println(calculate(num,i+1));
        }

    }
    static void add(LinkedList<String> stack, int n,int flag){
        String p = "(";
        if(flag==1){
            p=")";
        }
        for (int i = 0; i < n; i++) {
            stack.add(p);
        }
    }
    static String calculate(String n, int index){
        LinkedList<String> stack = new LinkedList<>();
        String[] num = n.split("");
        int save=-1,count=0,temp,diff=0;
        for (int i = 0; i < n.length(); i++) {
            temp = Integer.parseInt(num[i]);

            if(save==-1){
                add(stack,temp,0);
                count+=temp;
                stack.add(num[i]);
                save = temp;
                continue;
            }
            diff = temp -save;
            if(diff>0){
                add(stack,diff,0);
                count+=diff;
                stack.add(num[i]);
                save=temp;
            }
            else if(diff<0){
                diff = save-temp;
                add(stack,diff,1);
                count-=diff;
                stack.add(num[i]);
                save=temp;
            }
            else{
                stack.add(num[i]);
            }

        }
        if(count!=0){
            add(stack,count,1);
        }
        String result= "Case #"+index+": ";
        for(String j:stack){
            result+=j;
        }
        return result;
    }
}