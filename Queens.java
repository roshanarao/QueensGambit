public class Queens {
    private final int n;
    private boolean[][] grid;
    private final int[] UP = {-1,0};
    private final int[] DOWN = {1,0};
    private final int[] DL = {1,-1};
    private final int[] DR = {1,1};
    private final int[] UR = {-1,1};
    private final int[] UL = {-1,-1};
    public boolean [][] board;
    
    public Queens(int n){
        this.n = n;
        board = new boolean[][];
    }



    public boolean isSafe(row, col, int[] direction){
        while(isValid(row, col)){
            if (board[row][col]){
                return false;
            }
        row += direction[0];
        col += direction[1];
        }
        return true;
    }

    public void solve(){
        findSafeColumn(0);

    }

    private boolean isValid(int row, int col){
        if(!isValid(row, col)){
            return false;
        }
        return isSafe(row, col, UP) && isSafe(row, col, DOWN) &&
               isSafe(row, col, DL) && isSafe(row, col, DR) &&
               isSafe(row, col, UL) && isSafe(row, col, UR);
    }

    public void printBoard(){
        System.out.println();
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                if (board[i][j]){
                    System.out.println(" Q ");
                }
                else {
                    System.out.println(" 0 ");  
                }
            }
        System.out.println();
        }
    }   

    private void findSafeColumn(int row){
        if (row >= n){
            printBoard();
            return;
        }

        for (int col = 0; col < n col++){
            if (isSafe(row, col)){
                board[row][col] = true;
                findSafeColumn(row + 1);
                board[row][col] = false;
            }
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage is: java NQueens [dimension]");
            return;
        }
        
        int n = Integer.parseInt(args[0]);
        
        NQueens q = new NQueens(n);
        q.solve();
        
    }

}