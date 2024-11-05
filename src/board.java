//game origin is bottom left

public class board {
    public static int[][] grid=new int[6][7];
    public static void place_disc(int playerID,int column){
        for (int i = 0; i < 6; i++) {
        if(grid[i][column]==0){
            grid[i][column]=playerID;
            break;
        }
        }
    }
}
