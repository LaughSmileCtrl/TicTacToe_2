package componen;

public class Checker 
{
    final private int[][] targetPosition = {{1,2,3}, {1,4,7}, {1,5,9}, {2,5,8}, {3,5,7},{3,6,9}, {4,5,6}, {7,8,9}};
    private Player player1;
    private Player player2;
    private Player activePlayer;

    public Checker(Player player1, Player player2)
    {
        this.player1 = player1;
        this.player2 = player2;
    }

    public Checker setActivePlayer(Player player)
    {
        this.activePlayer = player;
        return this;
    }

    public boolean isExistPosition(int newPosition)
    {
        if(newPosition > 9 || newPosition < 1)
        {
            return false;
        }

        int [] getPosition1 = player1.getPosition();
        int [] getPosition2 = player2.getPosition();

        for(int i = 0; i < 5; i++)
        {
            if((newPosition == getPosition1[i]) || (newPosition == getPosition2[i]))
            {
                return false;
            }
        }

        activePlayer.addPosition(newPosition);
        return true;
    }

    public Player playerWinner()
    {
        for (int i = 0; i < targetPosition.length; i++) 
        {
            int[] position = targetPosition[i];
            int[] playerPosition = player1.getPosition();
            int status = 0;

            for(int j = 0; j < position.length; j++)
            {
                for (int k = 0; k < playerPosition.length; k++) 
                {
                    if(playerPosition[k] == position[j])
                    {
                        status++;
                    }

                    if(status >= 3)
                    {
                        return player1;
                    }
                }
            }

            playerPosition = player2.getPosition();
            status = 0;
            for(int j = 0; j < position.length; j++)
            {
                for (int k = 0; k < playerPosition.length; k++) 
                {
                    if(playerPosition[k] == position[j])
                    {
                        status++;
                    }
                    if(status >= 3)
                    {
                        return player2;
                    }
                }
            }
        }

        return null;
    }

}
