import java.util.*;
class Solution{
    public static void main(String as[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int ts[][] = new int[n][2];
            int m[] = new int[2];
            char m1[] = new char[n];
            for (int j = 0; j < n; j++) {
                ts[j][0] = sc.nextInt();
                ts[j][1] = sc.nextInt();
            }
            String fs = "";
            m[0] = ts[0][1];
            fs = "C";
            m1[0] = 'C';
            for (int j = 1; j < n; j++) {
                if (j == 1) {
                    if (ts[j][0] < ts[j - 1][1]) {
                        m[1] = ts[j][1];
                        //m1[1]=ts[j][0];
                        fs += "J";
                        m1[j] = 'J';
                    } else {
                        fs += "C";
                        m1[j] = 'C';
                    }
                } else if (ts[j][0] >= m[1]) {
                    fs += "J";
                        m1[j]='J';
                        m[1]=ts[j][1];
                    }else if(ts[j][0]>=m[0]){
                        fs+="C";
                        m1[j]='C';
                        m[0]=ts[j][1];
                    }else{
                        int k=j-1;
                        int flag=0;
                        while(k>=0){
                            if(ts[j][0]>ts[k][0]){
                                if(m1[k]=='C'){
                                    fs+='J';
                                    m1[j]='J';
                                }else{
                                    fs+='C';
                                    m1[j]='C';
                                }
                                flag=1;
                            }
                            k--;
                        }
                        if(flag==0){
                            fs="IMPOSSIBLE";
                            break;
                        }
                    }
                }
            
            System.out.println("Case #"+(i+1)+": "+fs);
        }
    }
}