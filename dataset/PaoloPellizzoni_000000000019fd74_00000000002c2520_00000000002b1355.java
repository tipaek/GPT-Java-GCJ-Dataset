import java.util.*;
import java.io.*;
import java.math.*;

public class Solution
{
    static IO io = new IO();
    public static void main(String[] args)
    {
		int T = io.getInt();
		for(int cas=1; cas<=T; cas++){
			int r = io.getInt();
			int c = io.getInt();
			int[][] a = new int[r][c];
			for(int i=0; i<r; i++)
				for(int j=0; j<c; j++)
					a[i][j] = io.getInt();
			
			
			long score = 0;
			while(true){
				int[][] b = new int[r][c];
				int elim = 0;
				for(int i=0; i<r; i++){
					for(int j=0; j<c; j++){
						if(a[i][j] == 0) continue;
						int sumComp = 0;
						int numComp = 0;
						score+= a[i][j];
						int ii = i, jj = j;
						//N
						ii = i-1;
						while(ii >=0 && a[ii][j] == 0)
							ii--;
						if(ii>=0)
						{
							sumComp+= a[ii][j];
							numComp++;
						}
						//S
						ii = i+1;
						while(ii < r && a[ii][j] == 0)
							ii++;
						if(ii<r)
						{
							sumComp+= a[ii][j];
							numComp++;
						}
						//W
						jj = j-1;
						while(jj>=0 && a[i][jj] == 0)
							jj--;
						if(jj >= 0)
						{
							sumComp+= a[i][jj];
							numComp++;
						}	
						//E
						jj = j+1;
						while(jj<c && a[i][jj] == 0)
							jj++;
						if(jj <c)
						{
							sumComp+= a[i][jj];
							numComp++;
						}	
						
						
						
						if(a[i][j]*numComp < sumComp){
							b[i][j] = 0;
							elim++;
						}
						else{
							b[i][j] = a[i][j];
							//score += a[i][j];
						}
					}
				}
				/*
				for(int i=0; i<r; i++){
					for(int j=0; j<c; j++){
						io.print(b[i][j]+" ");
					}
					io.println();
				}
				io.println();
				*/
				a = b;
				if(elim == 0)
					break;
				
			}
			io.println("Case #"+cas+": "+score);
		}
		
		
        io.close();
    }
}


/*
						//N
						if(i-jump[i][j][0] >= 0){
							sumComp += a[i-jump[i][j][0]][j];
							numComp++;
						}
						//S
						if(i+jump[i][j][1] < r){
							sumComp += a[i+jump[i][j][1]][j];
							numComp++;
						}
						//W
						if(j-jump[i][j][2] >= 0){
							sumComp += a[i][j-jump[i][j][2]];
							numComp++;
						}
						//E
						if(j+jump[i][j][3] < c){
							sumComp += a[i][j+jump[i][j][3]];
							numComp++;
						}
						*/


class IO extends PrintWriter {
	public IO() {
        super(new BufferedOutputStream(System.out));
        r = new BufferedReader(new InputStreamReader(System.in));
    }

    public IO(String fileName) {
        super(new BufferedOutputStream(System.out));
        try{
            r = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            this.println("File Not Found");
        }
    }

    public boolean hasMoreTokens() {
        return peekToken() != null;
    }

    public int getInt() {
        return Integer.parseInt(nextToken());
    }

    public double getDouble() {
        return Double.parseDouble(nextToken());
    }

    public long getLong() {
        return Long.parseLong(nextToken());
    }

    public String getWord() {
        return nextToken();
    }

	public String getLine(){
        try{
            st = null;
            return r.readLine();
        }
        catch(IOException ex){}
        return null;
    }
	

    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;

    private String peekToken() {
        if (token == null)
            try {
                while (st == null || !st.hasMoreTokens()) {
                    line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException e) { }
        return token;
    }

    private String nextToken() {
        String ans = peekToken();
        token = null;
        return ans;
    }
}
