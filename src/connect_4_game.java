public class connect_4_game {
    private final board game_board;
    private final player[] players;
    private final player current_player;

    public connect_4_game(){
        game_board = new board();
        players = new player[2];

        players[0] = new player("Player 1", 1);
        players[1] = new player("Player 2", 2);

        current_player= new player(players[0].getName(),players[0].getID());
    }

    public boolean check_win(){
        boolean win=false;

        for (int i = 0; i <6 ; i++) {
            for (int j = 0; j < 7; j++) {
                //vertical
                if (i>2){
                    if (game_board.grid[i][j] != 0 &&
                            game_board.grid[i][j] == game_board.grid[i - 1][j] &&
                            game_board.grid[i][j] == game_board.grid[i - 2][j] &&
                            game_board.grid[i][j] == game_board.grid[i - 3][j]) {
                        win = true;
                    }
                }


                //horizontal
                if(!win && j>2){
                    if (game_board.grid[i][j] != 0 &&
                            game_board.grid[i][j]==game_board.grid[i][j-1] &&
                            game_board.grid[i][j]==game_board.grid[i][j-2] &&
                            game_board.grid[i][j]==game_board.grid[i][j-3]){
                        win=true;
                    }
                }

                //positive diagonal
                if(!win && i>2 && j>2){
                    if (game_board.grid[i][j] != 0 &&
                            game_board.grid[i][j]==game_board.grid[i-1][j-1] &&
                            game_board.grid[i][j]==game_board.grid[i-2][j-2] &&
                            game_board.grid[i][j]==game_board.grid[i-3][j-3]){
                        win=true;
                    }
                }

                //negative diagonal
                if(!win && i>2 && j<4){
                    if (game_board.grid[i][j] != 0 &&
                            game_board.grid[i][j] == game_board.grid[i - 1][j + 1] &&
                            game_board.grid[i][j] == game_board.grid[i - 3][j + 2] &&
                            game_board.grid[i][j] == game_board.grid[i - 3][j + 3]) {
                        win = true;
                    }
                }
                if (win){
                    break;
                }
            }
        }
        return win;
    }

    public boolean check_draw(){
        int count=0;
        for (int i = 0; i < 7; i++) {
            if (game_board.column_is_full(i)){
                count++;
            }
        }
        return count == 7;
    }

    public void switch_current_player(){
        if (current_player.getID()==players[0].getID()){
            current_player.setID(players[1].getID());
            current_player.setName(players[1].getName());
        } else if (current_player.getID()==players[1].getID()) {
            current_player.setID(players[0].getID());
            current_player.setName(players[0].getName());
        }
    }

    public void start_game(){
        boolean game_won=false, game_drawn=false;

        while (!game_won && !game_drawn){
            game_board.display_the_game();
            current_player.make_a_move(game_board);
            game_won=check_win();
            game_drawn=check_draw();
            if (game_won){
                System.out.println("player"+current_player.getName()+"won!");
            } else if (game_drawn) {
                System.out.println("it's a draw!");
            }else {
                switch_current_player();
            }
        }

        System.out.println("thank you for playing Ramy's X O game!");
    }

    public static void main(String[] args) {
    connect_4_game match=new connect_4_game();
    match.start_game();
    }
}