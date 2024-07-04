import java.util.Scanner;
public class ListActivity
{
    public static void main(String args[])
    {
        int t, n, temp;
        Scanner sc = new Scanner(System.in);   
        t = sc.nextInt(); 
       
        for(int i=0;i<t;i++) {
             String result="";
            boolean im = false;
            n = sc.nextInt();
            int[][] timeArr = new int[n][2];
            int[] st = new int[n];
            int[] et = new int[n];
            String ans[] = new String[n];
            for(int j=0;j<n;j++) {
                for(int k=0;k<2;k++) {
                    timeArr[j][k] = sc.nextInt();
                }
            }
            
            for(int p=0;p<n;p++) {
                st[p] = timeArr[p][0];
                et[p] = timeArr[p][1];
            }
            
           
            int count=0;
            ans[0] = "C";
            
            for(int p=1;p<n;p++) {
                int q=p;
                if(st[p] >= et[q-1]) {
                   ans[p] = ans[p-1];
                   count=0;
                }
                else if(st[p] > st[q-1] && st[p]>et[q-1]) {
                   ans[p] = ans[p-1]; 
                   count=0;
                }
                else {
                    if(ans[p-1]=="C")
                        ans[p]="J";
                    else
                        ans[p]="C";
                        count++;
                }
            }
            
            if(count>=2) {
                im=true;
            }
            
        for(int p=0;p<n;p++) {
                result += ans[p];
            }
            
        if (im) {
            System.out.println("Case #"+(i+1)+": IMPOSSIBLE");    
        }  
        else 
            System.out.println("Case #"+(i+1)+": "+result);
        }
    }
}