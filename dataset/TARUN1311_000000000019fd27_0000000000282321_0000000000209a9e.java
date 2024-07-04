import java.util.Scanner;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        line=line.trim();
        String[] arr=line.split(" ");
        int testcase = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);
        char[] ch = new char[b+1];
        for(int test=1;test<=testcase;test++){
            int j=0;
            if(b==10){
                for(j=1;j<=10;j++){
                    System.out.println(j);
                    ch[j] = sc.nextLine().charAt(0); 
                }
            }
            if(b==20){
                for(j=1;j<=20;j++){
                    System.out.println(j);
                    ch[j] = sc.nextLine().charAt(0);
                    if(j==9)
                        j+=10;
                }
                char[] d = new char[b+1];
                for(j=11;j<=20;j++){
                    System.out.println(j);
                    d[j] = sc.nextLine().charAt(0);
                }
                
                int x = ch[20]-'0' ^ d[20]-'0';
                int y = ch[1]-'0' ^ d[20]-'0';
                int z = ch[1]-'0' ^ ch[20]-'0';
                
                for(j=1;j<=10;j++){
                    if(z==0 && x==0)
                        d[j]=ch[j];
                    else if(z==1){
                        if(x==0)
                            d[j]=ch[j];
                        else if(y==0)
                            d[j]=d[21-j];
                    }
                }  
                
                char[] e = new char[b+1];
                for(j=9;j<=12;j++){
                    System.out.println(j);
                    e[j] = sc.nextLine().charAt(0);
                }
                
                x = e[12]-'0' ^ d[12]-'0';
                y = e[12]-'0' ^ d[9]-'0';
                z = d[12]-'0' ^ d[9]-'0';
                
                if(z==0 && x==0){
                    d[10]=e[10];
                    for(j=1;j<=20;j++){
                        ch[j]=d[j];
                    }
                }
                else if(z==1){
                    if(x==0){
                        d[10]=e[10];
                        for(j=1;j<=20;j++){
                            ch[j]=d[j];
                        }
                    }else if(y==0){
                        d[10]=e[11];
                        for(j=1;j<=10;j++){
                            ch[j]=d[j];
                        }
                        for(j=11;j<=20;j++){
                            ch[j]=d[21-j];
                        }
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
            String s="";
            for(int i=1;i<=b;i++){
                s+=ch[i];
            }
            System.out.println(s);
            char c = sc.nextLine().charAt(0);
            if(c=='N')
                break;
        }
    }
}