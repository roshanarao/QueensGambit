public class Hacksy {
    int [] solutions;
    int row = 1;
    int col = 2;


    public Hacksy(Labyrinth l){
        
    }

    public int[] isSafeMove(Labyrinth l){
       for(int i = 0; i < row; i++){
           for(int j = 0; j < col; j++){
               l.isStone(i, j);
               l.isValid(i, j);
           }
       }
       
       
       
        return solutions; 
    }
    

    public static void main(String[] args){
        Labyrinth test = new Labyrinth(10, 10);
        Hacksy simulation = new Hacksy(test);
        test.printGrid();
        //simulation.isSafeMove(test);
        
    }
        


    

    


    
}
