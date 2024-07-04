import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int t = T;
        while(T-->0){
            System.out.print("Case #"+(t-T)+": ");
            String str = sc.next();
            int counter = 0;
            for(int i = 0;i<str.length();i++){
                int val = Integer.parseInt(str.charAt(i)+"");
                // if(counter == val){
                //     System.out.print(val);
                // }
                if(counter<val){
                    while(counter != val){
                        counter++;
                        System.out.print("(");
                    }
                    //System.out.print(val);
                }
                else if(counter > val){
                    while(counter != val){
                        counter--;
                        System.out.print(")");
                    }
                }
                System.out.print(val);
            }
            while(counter>0){
                System.out.print(")");
                counter--;
            }
            System.out.println();
        }
    }
}