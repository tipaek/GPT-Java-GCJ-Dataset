import java.util.*;

class Solution{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int c = 1;
        while(t-- > 0){
            String s = sc.next();
            StringBuilder s1 = new StringBuilder("");
            int currNested = 0;
            for(int i = 0; i < s.length(); i++){
                int k = Character.getNumericValue(s.charAt(i));
                if(k > currNested){
                    int y = k - currNested;
                    for(int j =0 ;j < y;j++){
                        s1.append("(");
                        currNested++;
                    }
                }else if(k < currNested){
                    int y = currNested - k;
                    for(int j =0 ;j < y ;j++){
                        s1.append(")");
                        currNested--;
                    }
                }
                s1.append(k);
            }
            while(currNested > 0){
                s1.append(")");
                currNested--;
            }
            System.out.println("Case #"+ c + ":" + " " + s1.toString());
            c++;
        }
    }
}