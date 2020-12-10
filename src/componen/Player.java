package componen;

public class Player 
{
    private int[] position = new int[5];
    private char icon;

    public Player(char icon)
    {
        this.icon = icon;
    }

    public char getIcon()
    {
        return icon;
    }

    public int[] getPosition()
    {
        return position;
    }

    public void addPosition(int newPosition)
    {
        int lastIndex = getLastIndex();
        position[lastIndex] = newPosition;
        sortPosition();
    }

    private int getLastIndex()
    {
        for(int i = 0; i < 5; i++)
        {
            if(position[i] == 0)
            {
                return i;
            }
        }

        return 9;
    }

    private void sortPosition()
    {
        for (int i = 0; i < position.length; i++) 
        {
            int iMin = i;
            for (int j = i; j < position.length; j++)
            {
                if(position[j]  < position[iMin])
                {
                    iMin = j;
                }
            }

            if(iMin != i && position[iMin] != 0)
            {
                int tmp = position[iMin];
                position[iMin] = position[i];
                position[i] = tmp;
            }
        }
    }

}
