public class Competition {
	int countc=0;
    int countr=0;
    int T=0;
    int nums;
    int n;
    char [][] board;
public boolean isRep(int nums,int n,char [][] board){
    for(int i=0;i<nums;i++){
    if(board==null||board.length==0)return false;    
    for(int row=0;row<9;row++){
    	boolean[] taken=new boolean[9];
    for(int idx=0;idx<9;idx++){
        char c=board[row][idx];
        int num=c-'0';
        if(taken[num]==true)countc++;
        else taken[num]=true;
    }
    }
    for(int col=0;col<9;col++){
       boolean[] taken=new boolean[9];
       for(int idx=0;idx<9;idx++){
           char c=board[idx][col];
               int num=c-'0';
               if(taken[num]==true) countr++;
               else taken[num]=true;
           
       }
    }
    for(int row=0;row<9;row++){
    for(int idx=0;idx<9;idx++){
        char c=board[row][idx];
        int num=c-'0';
        if(idx==row) T+=num;
    }
    }
    }
    return false;
}
    
	public Competition(int nums, int n, char[][] board) {
	super();
	this.nums = nums;
	this.n = n;
	this.board = board;
}

	public static void main(String[] args) {
		Competition c=new Competition(3, n, board);
        
	}

}