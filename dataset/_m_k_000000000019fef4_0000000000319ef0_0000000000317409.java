import java.util.Scanner;

public class Solution {
    public static void main (String[] args) {
        //code
        Scanner s=new Scanner(System.in);
        int a=s.nextInt();
        for(int i=0;i<a;i++){
            int x=s.nextInt();
            int y=s.nextInt();
            String dir=s.next();
            int ans=-1;
            for(int j=0;j<dir.length();j++){
                if(dir.charAt(j)=='S')
                    y--;
               else if(dir.charAt(j)=='N')
                    y++;
                else if(dir.charAt(j)=='E')
                    x++;
                else
                    x--;
//                System.out.println(x+" "+y);
                if(Math.abs(x)+Math.abs(y)<=j+1) {
                    ans = j+1;
//                    System.out.println(x+" "+y);
                    break;
                }
            }
            String answer;
            if(ans==-1)
                answer="IMPOSSIBLE";
            else
            answer=ans+"";
                System.out.println("Case #"+(i+1)+": "+answer);
            }
            }
        }
