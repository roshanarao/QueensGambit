import java.util.ArrayList;

public class Hacksy {
    static int [] solutions;
    static int row;
   static int col;
    static boolean solutionFound = false;
    static ArrayList<Integer> moves = new ArrayList<Integer>();
   static final int[] directions = {0, 1, 2, 3};
   static final boolean[][] alreadyBeenHere;
    

    public Hacksy(Labyrinth l){
        
    }

    public static void solve(Labyrinth l){
        findSafeMove(0, 0, l);
    }

    public static boolean findSafeMove(int row, int col, Labyrinth l){
        
        if (row == l.rows - 1 && col == l.cols - 1){
            System.out.println("Ez maze solve");
            return true;
         }
        for(int i = 0; i < directions.length; i++){
            int x = 0;
            int y = 0;
         switch(directions[i]){
           
            case 0: x = 1; y = 0;
            if(l.isValid(row - 1, col) && isSafeMove(row - 1, col, l)){
           moves.add(1);
           findSafeMove(row - 1, col, l);
           moves.remove(1);
            }
           break;

            case 1: x = 0; y = 1;
            if (l.isValid(row, col + 1) && isSafeMove(row, col + 1, l)){
            moves.add(2);
            findSafeMove(row, col + 1, l);
            moves.remove(2); 
            }          
            break;

            case 2: x = -1; y = 0;
            if(l.isValid(row + 1, col) && isSafeMove(row + 1, col, l)){
            moves.add(0);
            findSafeMove(row + 1, col, l);
            moves.remove(0);
            }
            break;

            case 3: x = 0; y = 1;
            if (l.isValid(row, col - 1) && isSafeMove(row, col - 1, l)){
            moves.add(3);
            findSafeMove(row, col - 1, l);
            moves.remove(3);
            }
            break;

            default:
            }

        }
        return false;
    }
     

    
    public void reMove(String move){
        moves.remove(moves.size() - 1);
    }

    public void addPosition(int row, int col, Labyrinth l){
        if(isSafeMove(row, col, l)){
            for (int i = 0; i <= row; i++){
                for (int j = 0; j <= col; j++){
                    alreadyBeenHere[i][j] = true;

                }
            }
        }
    }

    public static boolean alreadyMoved(int row, int col){
        return alreadyBeenHere[row][col];
    }

    public static boolean isSafeMove(int row, int col, Labyrinth l){
        for (int i = 0; i <= l.rows; i++){
            for (int j = 0; j <= l.cols; j++){
                if(l.isStone(i, j) && alreadyMoved(i, j)){
                    
                }
            }
        }
        return true;

    }

    


    public static void main(String[] args){
        if (args.length != 2) {
            System.out.println("Usage is java Labyrinth [rows] [columns]");
            return;
        }
        
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        
        Labyrinth l = new Labyrinth(a,b);
        l.printGrid();

        solve(l);
    }
        
}
