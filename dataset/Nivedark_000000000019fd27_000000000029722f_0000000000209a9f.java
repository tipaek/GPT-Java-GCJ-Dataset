import java.util.Scanner;

public class NestingDepth {
    private static boolean areThereExtraBrackets(String str){
        for(int i=0;i<str.length()-1;i++)
            if(str.charAt(i)==')' && str.charAt(i+1)=='(')
                return true;
        return false;
    }

    private static String removeBrackets(String str){
        while(areThereExtraBrackets(str))
            for(int i=0;i<str.length()-1;i++)
                if(str.charAt(i)==')' && str.charAt(i+1)=='(')
                    str = str.substring(0,i)+str.substring(i+2);

        return str;
    }

    private static String addBrackets(String str){
        StringBuilder temp = new StringBuilder();
        for(int i=0;i<str.length();i++){
            for(char j='0';j<str.charAt(i);j++)
                temp.append('(');
            temp.append(str.charAt(i));
            for(char j='0';j<str.charAt(i);j++)
                temp.append(')');
        }
        return temp.toString();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i=0;i<N;i++) {
            String str = sc.next();
            str = addBrackets(str);
            str = removeBrackets(str);
            System.out.println("Case #1: "+str);
        }
    }
}
