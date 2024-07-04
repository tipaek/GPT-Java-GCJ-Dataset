import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;

class Stacks {

    int n;
    char[] arr;

    Stacks(int c) {
        n = -1;
        arr = new char[c];
    }

    public void push(char c) {
        arr[++n] = c;
    }

    public boolean isEmpty() {
        if (n > -1)
            return false;
        else
            return true;
    }

    public char pop() {
        return arr[n--];
    }

    public char peek(){
        return arr[n];
    }

    public int size(){
        return (n+1);
    }
}

class Solution {


    public static void main(String[] args) {

        try{
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
            int n =Integer.parseInt(read.readLine());
            char[][] out = new char[n][];

            for (int i=0;i<n;i++){

                String s= read.readLine();

                Stacks res = new Stacks(90000);

                for(int j=0;j<s.length();j++){

                    int k = Integer.parseInt(String.valueOf(s.charAt(j))),cnt = 0;
                    if(res.isEmpty() || res.peek()=='0'){
                        while(cnt<k){
                            res.push('(');
                            cnt++;
                        }
                        res.push(s.charAt(j));
                        cnt =0;
                        while(cnt<k){
                            res.push(')');
                            cnt++;
                        }
                    }

                    else if(res.peek() == ')'){
                        while(cnt<k && res.peek()==')') {
                            res.pop();
                            cnt++;
                        }
                        if(cnt<k){
                            int a=0;
                            while(a<k-cnt){
                                res.push('(');
                                a++;
                            }
                        }
                        res.push(s.charAt(j));
                        cnt=0;
                        while(cnt<k){
                            res.push(')');
                            cnt++;
                        }
                    }

                }
                out[i] = Arrays.copyOf(res.arr , res.size());
            }

            for(int i=0;i<n;i++){
                System.out.print("Case #"+(i+1)+": ");
                System.out.println(out[i]);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}