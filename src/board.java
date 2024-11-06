//game origin is bottom left

public class board {
    public  int[][] grid=new int[6][7];
    public  int turns_played_this_match=0;

    


    public  void place_disc(int playerID,int column){
        for (int i = 0; i < 6; i++) {
            if(grid[i][column]==0){
                grid[i][column]=playerID;
                turns_played_this_match++;
                break;
            }
        }
    }


    public  boolean column_is_full(int column){
        boolean isfull=false;
        int count =0;
        for (int i = 0; i < 6; i++) {
            if (grid[i][column]!=0){
                count++;
            }
        }

        if (count==6)
            isfull=true;
        return isfull;
    }

    public  void display_the_game(){
        for (int i = 5; i >-1; i--) {
            for (int j = 0; j < 7; j++) {
                System.out.print(grid[i][j]);
                System.out.print('\t');
            }
            System.out.println();
        }
    }


}
