import java.io.*; 
import java.util.*; 
public class Solution {
    static ArrayList<Integer> arr[];
    public static void main(String args[]) {
        Scanner input=new Scanner(System.in);
        int test=input.nextInt();
        for(int t=1;t<=test;t++) {
            int u=input.nextInt();
            arr=new ArrayList[26];
            for(int i=0;i<26;i++) {
                arr[i]=new ArrayList<>();
                for(int j=0;j<10;j++) {
                    arr[i].add(j);
                }
            }
            boolean has[]=new boolean[26];
            for(int i=0;i<10000;i++) {
                long n=input.nextLong();
                
                String str=input.next();
                if(n==-1) {
                    n=(int)Math.pow(10, str.length()+1);
                    n--;
                }
                for(int j=0;j<str.length();j++) {
                    has[str.charAt(j)-65]=true;
                }
                solve(n,str);
            }
            char chr[]=new char[10];
            StringBuilder ans=new StringBuilder("");
            while(true) {
                boolean exis=false;
                for(int i=0;i<26;i++) {
                    if(!has[i]) {
                        continue;
                    }
                    if(arr[i].size()==1) {
                        chr[arr[i].get(0)]=(char)(65+i);
                        del(arr[i].get(0));
                        exis=true;
                    }
                }
                if(!exis) {
                    break;
                }
            }
            for(int i=0;i<chr.length;i++) {
                ans.append(chr[i]);
            }
            System.out.println("Case #"+t+": "+ans);
        }
    }
    public static void solve(long n,String str) {
        if((""+n).length()>str.length()) {
            return;
        }
        String tmp=""+n;
        int strt=tmp.charAt(0)-48;
        for(int i=strt+1;i<10;i++) {
            if(arr[str.charAt(0)-65].contains(i)) {
                arr[str.charAt(0)-65].remove(new Integer(i));
            }
        }
        if((""+n).length()>1 && arr[str.charAt(0)-65].contains(0)) {
            arr[str.charAt(0)-65].remove(new Integer(0));
        }
        if(str.length()==2 && n/10==1) {
            strt=(int)(n%10);
            for(int i=strt+1;i<10;i++) {
                if(arr[str.charAt(1)-65].contains(i)) {
                    arr[str.charAt(1)-65].remove(new Integer(i));
                }
            }
        }
    }
    public static void del(int n) {
        for(int i=0;i<26;i++) {
            if(arr[i].contains(n)) {
                arr[i].remove(new Integer(n));
            }
        }
    }
    public static void print() {
        for(int i=0;i<26;i++) {
            System.out.print(i+".)"+(char)(i+65)+" ");
            for(int j=0;j<arr[i].size();j++) {
                System.out.print(arr[i].get(j)+" ");
            }
            System.out.println();
        }
    }
}
