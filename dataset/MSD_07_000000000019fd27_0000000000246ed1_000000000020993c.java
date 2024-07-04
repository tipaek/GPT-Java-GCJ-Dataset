import java.util.*;
import java.io.*;
class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            int n=Integer.parseInt(br.readLine());
            int sum=0,id=0,kk=0;
            int a[][]=new int[n][n];
            int na=n;
            while(n-->0){
                String s[]=br.readLine().split(" ");
                for(int i=0;i<na;i++)
                a[kk][i]=Integer.parseInt(s[i]);
                kk++;
            }
            for(int i=0;i<na;i++){
                for(int j=0;j<na;j++)
                {
                    if(i==j)
                    sum+=a[i][j];
                }
            }
            int max=0;
            outer :for(int i=0;i<na;i++){
                HashMap<Integer,Integer> map=new HashMap<>();
                for(int j=0;j<na;j++){
                    if(map.containsKey(a[i][j]))
                    map.put(a[i][j],map.get(a[i][j])+1);
                    else
                    map.put(a[i][j],1);
                }
                for(int j=0;j<na;j++){
                    int num=a[i][j];
                    int cnt=1;
                    int numcnt=map.get(num);
                    for(int k=i+1;k<na;k++){
                        int c=0;
                        for(int z=0;z<na;z++){
                            if(num==a[k][z])
                            c++;
                        }
                        if(numcnt==1){
                            if(c>=2){ cnt++;
                            max=Math.max(max,cnt);}
                        }
                        else if(numcnt>1){
                            if(c>=1){
                            cnt++;
                            max=Math.max(max,cnt);}
                        }
                        if(max==na) break outer;
                    }
                }
            }
            int maxx=0;
            outer :for(int i=0;i<na;i++){
                HashMap<Integer,Integer> map=new HashMap<>();
                for(int j=0;j<na;j++){
                    if(map.containsKey(a[j][i]))
                    map.put(a[j][i],map.get(a[j][i])+1);
                    else
                    map.put(a[j][i],1);
                }
                for(int j=0;j<na;j++){
                    int num=a[j][i];
                    int cnt=1;
                    int numcnt=map.get(a[j][i]);
                    for(int k=i+1;k<na;k++){
                        int c=0;
                        for(int z=0;z<na;z++){
                            if(num==a[z][k])
                            c++;
                        }
                        if(numcnt==1){
                            if(c>=2){
                                cnt++;
                                maxx=Math.max(maxx,cnt);
                            }
                        }
                         else if(numcnt>1){
                            if(c>=1){
                            cnt++;
                            maxx=Math.max(maxx,cnt);}
                        }
                        if(maxx==na) break outer;
                    }
                }
            }
            
            System.out.println(sum+" "+max+" "+maxx);
            
        }
    }
}