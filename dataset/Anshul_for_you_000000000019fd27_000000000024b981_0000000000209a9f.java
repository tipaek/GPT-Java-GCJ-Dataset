import java.util.Scanner;

class Solution{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            String s = in.next();
            String ans="";
            stackp st  = new stackp();
            int[] c = new int[s.length()];
            for(int j=0;j<s.length();j++){
                c[j]=Integer.parseInt(String.valueOf(s.charAt(j)));
//                if(Integer.parseInt(String.valueOf(s.charAt(j)))==1);
            }

//            else if(c[0]==1&&s.length()==1){
//                st.push("(");
//                st.push("1");
//                st.push(")");
//            }
//            else {
//                st.push("(");
//                st.push("1");
//            }
            int oc = 0;
            int cc = 0;
//            st.push("(");
//            oc++;
//            if(c[0]==0)st.push("0");
            for(int j=0;j<s.length();j++){
                if(c[j]==0)st.push("0");
                else {
                    while (oc - cc != c[j]) {
                        st.push("(");
                        oc++;
                    }
                    st.push(String.valueOf(c[j]));
                    while (oc - cc != 1) {
                        st.push(")");
                        cc++;
                    }
                }
            }
            st.push(")");
            System.out.print("Case"+" "+ "#"+(i+1)+":" + " ");
            st.print();
        }
    }
}
class stackp{
    int top;
    int max = 1000;
    String[] a = new String[max];
    stackp(){
        top =-1;
    }
    void push(String x){
        if(top>max-1)System.out.println("StackOverflow");
        else{
            a[++top]= x;
        }
    }
    void pop(){
        if(top<0)System.out.println("Stackunderflow");
        else{
            String p = a[top--];
            System.out.println(p);
        }
    }
    void print(){
        for(int i=0;i<=top;i++) System.out.print(a[i]);
        System.out.println();
    }
    void peek(){
        System.out.println(a[top]);
    }
}