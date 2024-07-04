import java.util.*;

class Solution{
    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        int tc = in.nextInt();
        for(int t = 0;t< tc;t++){
            String str = in.nextLine();
            solve(str);
        }
    }
    private static void solve(String str){
        int bb = 0;
        int ba = 0;
        StringBuilder stb = new StringBuilder();
        for(int i = 0;i<str.length();i++){
            bb = ba;
            ba = Character.getNumericValue(str.charAt(i));
            int k = bb-ba;
            for(int j = 0;j<Math.abs(k);j++){
                stb.append(k<0?'(':')');
            }
            stb.append(str.charAt(i));
        }
        bb=ba;
        ba = 0;
        int k = bb-ba;
        for(int j = 0;j<Math.abs(k);j++){
            stb.append(k<0?'(':')');
        }
        System.out.println(stb.toString());
    }
    
    
    
    
        //2   1  5    2  0  7  6  2  1
//bb      0   2  1    5  2  0  7  6  2
///ba      2   1  5    2  0  7  6  2  1
    
}

        //((2)1((((5)))2)))0(((((((7)6))))2)1)
