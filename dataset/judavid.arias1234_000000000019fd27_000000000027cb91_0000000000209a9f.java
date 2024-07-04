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
        Stack<Integer> pila = new Stack<>();
        String resul = "";
        for(Character c : s.toCharArray()){

            if(c == '0'){
                resul += vaciarPila(pila);
                resul += "0";
            }else {
                if(pila.isEmpty()){
                    int n = Integer.parseInt(c.toString());
                    resul += quoteOpen(n);
                    resul += n;
                    pila.push(n);
                }else{
                    int n = Integer.parseInt(c.toString());
                    if(pila.peek() == n){
                        resul += n;
                    }else if(pila.peek() > n){
                        int f = pila.pop() - n;
                        resul += quoteClose(f);
                        resul += n;
                        pila.push(f);
                    }else if(pila.peek() < n){
                        int f = n - pila.pop() ;
                        resul += quoteOpen(f);
                        resul += n;
                        pila.push(f);
                    }
                }
            }
        }
        resul += vaciarPila(pila);
        return resul;
    }

}
