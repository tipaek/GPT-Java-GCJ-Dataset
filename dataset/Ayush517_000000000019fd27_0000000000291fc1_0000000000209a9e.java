import java.util.*;
class Main {
    static char[] ans;
    static int i, j, r, c, t, b;
    static char l;
    static int flag=0;
    static Scanner ob = new Scanner(System.in);
    public static void main(String[] args) {
        t = ob.nextInt();
        b=ob.nextInt();
        for(int tim=0;tim<t;tim++) {
            ans = new char[b];
            Arrays.fill(ans,'1');
            for(i=1,j=0,r=-1,c=-1;j<(b+1)/2;i+=2) {
                if(i>10 && i%10==1){
                    func2();
                }
                else{
                    func1();
                }
            }
            System.out.println(String.valueOf(ans));
            System.out.flush();
            char fine;
            fine=ob.next().charAt(0);
            if(fine=='N') {
                flag=1;
                break;
            }
        }
        if(flag==1)
            return;
    }

    static void complement(char[] ans) {
        for(int i=0;i<b;i++) {
            if(ans[i]=='0')
                ans[i]='1';
            else 
                ans[i]='0';
        }
    }

    static void reverse(char[] ans) {
        for(int i=0;i<b/2;i++) {
            char c = ans[i];
            ans[i]=ans[b-i-1];
            ans[b-i-1]=c;
        }
    }

    static void func1() {
        System.out.println(j+1);
        System.out.flush();
        ans[j]=ob.next().charAt(0);
        System.out.println(b-j);
        System.out.flush();
        ans[b-1-j]=ob.next().charAt(0);
        if(ans[j]==ans[b-1-j])
            c=j;
        else r=j;
        j++;
    }

    static void func2() {
        if(c!=-1) {
            System.out.println(c+1);
            l=ob.next().charAt(0);
            if(ans[c]!=l)
                complement(ans);
        }
        else {
            System.out.println(1);
            l=ob.next().charAt(0);
        }
        if(r!=-1) {
            System.out.println(r+1);
            l=ob.next().charAt(0);
            if(ans[r]!=l)
                reverse(ans);
        }
        else {
            System.out.println(1);
            l=ob.next().charAt(0);
        }
        System.out.flush();
    }
}