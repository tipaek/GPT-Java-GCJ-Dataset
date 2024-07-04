import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String[]agrs){
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < T; i++) {
            String s = sc.nextLine();
            String rest = putNesting(s);
            System.out.println("Case #"+(i+1)+": "+rest);
        }
    }

    public static String vaciarPila(Stack<Integer> pila){
        String result="";
        while(!pila.empty()){
            Integer ul = pila.pop();
            result += quoteClose(ul);
        }
        return result;
    }

    public static String quoteClose(int n){
        return getString(n, ")");
    }

    public static String quoteOpen(int n){
        return getString(n, "(");
    }

    private static String getString(int n, String s) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += s;
        }
        return result;
    }


    public static String putNesting(String s) {
        Stack<Integer> pilaCa = new Stack<>();
        String resul = "";
        int countOpen=0;
        int countClose=0;
        for(Character c : s.toCharArray()){
            int n = Integer.parseInt(c.toString());
            if(c == '0'){
                resul += quoteClose(countClose);
                countClose = 0;
                resul += "0";
                pilaCa = new Stack<>();
            }else {
                if(pilaCa.isEmpty()){
                    resul += quoteOpen(n);
                    resul += n;
                    countClose = n;
                    pilaCa.push(n);
                }else{

                    if(pilaCa.peek() == n){
                        resul += n;
                    }else if(pilaCa.peek() > n){
                        int f = pilaCa.peek() - n;
                        resul += quoteClose(f);
                        resul += n;
                        countClose -= f;
                        pilaCa.push(n);
                    }else if(pilaCa.peek() < n){
                        int f = n - pilaCa.peek() ;
                        resul += quoteOpen(f);
                        resul += n;
                        pilaCa.push(n);
                        countClose += f;
                    }
                }
            }
        }
        resul += quoteClose(countClose);
        return resul;
    }

}
