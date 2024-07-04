import java.util.Scanner;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        line=line.trim();
        String[] arr=line.split(" ");
        int testcase = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);
        char[] ch = new char[b];
        for(int test=1;test<=testcase;test++){
            int j=0;
            if(b==10){
                for(j=1;j<=10;j++){
                    System.out.println(j);
                    ch[j-1] = sc.nextLine().charAt(0); 
                }
            }
            if(b==20){
                for(j=1;j<=20;j++){
                    System.out.println(j);
                    ch[j-1] = sc.nextLine().charAt(0);
                    if(j==10)
                        j+=10;
                }
                char d = new char[b];
                for(int j=11;j<=20;j++){
                    System.out.println(j);
                    d[j-1] = sc.nextLine().charAt(0);
                }
                
                int x = ch[19]-'48' ^ d[19]-'48';
                
                for(int j=1;j<10;j++){
                    if(x==0)
                        d[j-1]=ch[j-1];
                    else
                        d[j-1]='97'-ch[j-1];
                }  
                
                char e = new char[b];
                for(int j=10;j<=11;j++){
                    System.out.println(j);
                    e[j-1] = sc.nextLine().charAt(0);
                }
                
                x = e[10]-'48' ^ d[10]-'48';
                if(x==0)
                    d[9]=e[9];
                else{
                    d[9]='97'-e[9];
                    for(int j=0;j<19;j++){
                        ch[j]='97'-d[9];
                    }
                }
            }
            if(b==100){
                for(j=1;j<=100;j+=10){
                    System.out.println(j);
                    ch[j-1] = sc.nextLine().charAt(0);
                    if(j==41)
                        j+=9;
                }
            }
        }
        String s="";
        for(int i=0;i<b;i++){
            s+=ch[i];
        }
        System.out.println(s);
        char c = sc.nextLine().charAt(0);
        if(c=='N')
            break;
    }
}