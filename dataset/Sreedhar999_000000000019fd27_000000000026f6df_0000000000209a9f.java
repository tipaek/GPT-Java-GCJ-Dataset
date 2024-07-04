import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for(int w=0;w<t;w++){
            String str1=br.readLine();
            Stack<Character> st=new Stack<Character>();
            char[] ar=str1.toCharArray();
            int n=ar.length;
            for(int q=0;q<n;q++){
                char y=ar[q];
                int x=Integer.parseInt(String.valueOf(y));
                if(x==0) st.push(y);
                else if(st.isEmpty()){
                    for(int i=0;i<x;i++){
                        st.push('(');
                    }
                    st.push(y);
                    for(int i=0;i<x;i++){
                        st.push(')');
                    }
                }
                else{
                    int j=0;
                    while(!st.isEmpty() && j<x){
                        if(st.peek()==')') st.pop();
                        else break;
                        j++;
                    }
                    if(j==x){
                        st.push(y);
                        for(int i=0;i<x;i++){
                        st.push(')');
                        }
                    }
                    else{
                        int p=x-j;
                        for(int i=0;i<p;i++){
                        st.push('(');
                        }
                        st.push(y);
                        for(int i=0;i<p;i++){
                            st.push(')');
                        }
                        for(int i=0;i<j;i++){
                        st.push(')');
                        }
                    }
                }
            }
            Stack<Character> st1=new Stack<Character>();
            while(!st.isEmpty()){
                st1.push(st.pop());
            }
            String str="";
            while(!st1.isEmpty()){
                str+=String.valueOf(st1.pop());
            }
           System.out.println("Case #"+(w+1)+": "+str); 
        }
    }
}