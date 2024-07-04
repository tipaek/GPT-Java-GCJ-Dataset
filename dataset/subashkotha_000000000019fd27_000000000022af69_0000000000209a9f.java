import java.util.Scanner;

class Nesting{
    private String s;
    private String sb;
    
    Nesting(String s){
        this.s = s;
        sb = new String();
    }

    public String construct(int t){
        String temp = "";
        int i = 0;
        while(i<t){
            temp = temp+"(";
            i++;
        }
        temp = temp + String.valueOf(t);
        i = 0;
        while(i<t){
            temp = temp+")";
            i++;
        }
        return temp;
    }
    public String solve(){
        for(int i=0; i<s.length(); ++i){
            sb = sb + construct(Integer.valueOf(s.charAt(i))-48);
        }
        while(sb.indexOf(")(")!=-1){
            sb = sb.replace(")(", "");
        }
        return sb;
    }
}

class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int k=1;
        while(k<=t){
            Nesting n = new Nesting(sc.next());
            String ans = n.solve();
            System.out.println("Case #"+k+": "+ans);
            k++;
        }
        sc.close();
    }
}