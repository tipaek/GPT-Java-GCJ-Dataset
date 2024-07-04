import java.util.Scanner;
class Solutions{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        sc.nextLine();
        for(int k=1;k<=t;k++){
            String str[]=sc.nextLine().split("");
            String ans="";
            int depth=0;
            for(int i=0;i<str.length;i++){
                int temp=Integer.parseInt(str[i]);
                if(depth==0){
                    depth=temp;
                    for(int j=0;j<depth;j++){
                        ans+='(';
                    }
                    ans+=temp;
                    continue;
                }
                if((depth-temp)>0){
                    for(int j=0;j<(depth-temp);j++){
                        ans+=')';
                    }
                    depth-=(depth-temp);
                }
                else if((depth-temp)<0){
                    for(int j=0;j<(temp-depth);j++){
                        ans+='(';
                    }
                    depth+=(temp-depth);
                }
                ans+=temp;
            }
            for(int i=0;i<depth;i++){
                ans+=')';
            }
            System.out.println("Case #"+k+": "+ans);
        }
    }
}