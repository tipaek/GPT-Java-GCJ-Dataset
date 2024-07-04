import java.io.*;

class Vestigium {
    public static void main(String []args) throws IOException {
        BufferedReader rm=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(rm.readLine());
        StringBuilder fin=new StringBuilder();
        int n,i,j,z,k,r,c;
        int[][] arr =new int[100][100];
        String line;
        String []sarr;
        for(i=1;i<=t;i++){
            k=0;c=0;r=0;
            n=Integer.parseInt(rm.readLine());
            for(j=0;j<n;j++){
                line=rm.readLine();
                sarr = line.trim().split("\\s+");
                for (z = 0;z < n; z++)
                    arr[j][z] = Integer.parseInt(sarr[z]);
            }
            for(j=0;j<n;j++){
                k=k+arr[j][j];
            }
            for(j=0;j<n;j++){
                mark:
                for(z=0;z<n;z++)
                    for(int x=z+1;x<n;x++)
                        if(arr[j][z]==arr[j][x]) {
                            r++;
                            break mark;
                        }
            }
            for(j=0;j<n;j++){
                mark:
                for(z=0;z<n;z++)
                    for(int x=z+1;x<n;x++)
                        if(arr[z][j]==arr[x][j]) {
                            c++;
                            break mark;
                        }
            }
            fin.append("Case #").append(i).append(": ").append(k).append(" ").append(r).append(" ").append(c).append("\n");
        }
        System.out.println(fin);
    }
}