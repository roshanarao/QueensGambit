import java.util.ArrayList;

public class Hacksy {
    static int [] solutions;
    static int row;
   static int col;
    static boolean solutionFound = false;
    static ArrayList<Integer> moves = new ArrayList<Integer>();
   static final int[] directions = {0, 1, 2, 3};
    

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
         switch(directions[i]){
           
            case 0: l.isValid(row - 1, col);
           moves.add(1);
           findSafeMove(row - 1, col, l);
           moves.remove(1);
           break;

            case 1: l.isValid(row, col + 1);
            moves.add(2);
            findSafeMove(row, col + 1, l);
            moves.remove(2);           
            break;

            case 2: l.isValid(row + 1, col);
            moves.add(0);
            findSafeMove(row + 1, col, l);
            moves.remove(0);
            break;

            case 3: l.isValid(row, col - 1);
            moves.add(3);
            findSafeMove(row, col - 1, l);
            moves.remove(3);
            break;

            default: i = 0;
            }

        }
        return false;
    }
     

    
    public void reMove(String move){
        moves.remove(moves.size() - 1);
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
