import java.util.*;
/**
 * This is a part of the Gamemain. It creates the board from the array
 * It creates arraylist of monsters
 * This is the layout for which the game will be played, the 
 * equals sign are the hedges and the stars are the possible 
 * positions where the monsters will appear.
 * 
 *
 * @author (Rojan Giri)
 * @version (V1)
 */
public class Board  
{
    //Size for the rows and columns in the array 
    private final int SIZE = 5;
    //Sets up the 2D array board
    public char board [][];
    //Sets a new array for holding a posiiton in the array
    private Random rand;
    //Holds the measurements for the size of the array
    int first =1;
    int last=4;
    ArrayList< Monster> arrayMonsters ;
    Scanner input= new Scanner(System.in);

    /**
     * Constructor fills the board initially with *
     * and sets up the surrounding edges / hedge "="
     * @param
     */
    public Board() 
    {
        board = new char [SIZE][SIZE]; 
        rand = new Random();
        arrayMonsters = new ArrayList<Monster>();

        for (int i = first; i <= last; i++)
        {
            for (int j = first; j <= last; j++)
                board[i][j] = '*';

        }

        for (int i = 0; i < SIZE ; i++)
        {
            board[0][i] = '=';
            board[i][0] = '=';
            board[i][SIZE - 1] = '=';
            board[SIZE - 1][i] = '=';
        }
        viewBoard();
    }

    /**
     * set ups the board
     * @param
     */
    public void viewBoard()
    {
                for(int i = 0; i<board.length; i++)
        {
            for(int j = 0; j<board[i].length; j++)
            {
                System.out.print((board[i][j]) + " ");
            }
            System.out.println();
        }
    }


      /**
     * ask for the input for the monster name 
     * adds the monsters as a new monster
     * adds the monster in the arraylist
     * assigns the monster 
     * @param input the monstername and added to the board.
     */

    public void inputMonsters()
    {
        System.out.println("Enter the Mosters Name");
        String monstername = input.nextLine().toUpperCase();
        System.out.println(monstername+" monster added to the board");
        Monster m = new Monster(monstername);
        arrayMonsters.add(m);
        findPlaceMonster(m);

    }

    /**
     * find the random place within the board and checkes weather or not the array is occupied 
     * gets the first letter of the monster name and the postion 
     * 
     * @param randomly assign monster with its first charecter
     */

    public void findPlaceMonster(Monster monster ){
        int r = rand.nextInt(SIZE-2) + 1;
        int c = rand.nextInt(SIZE-2) + 1; 
        while(board[r][c]!='*'){
            r = rand.nextInt(SIZE-2) + 1;
            c = rand.nextInt(SIZE-2) + 1; 
        }
        monster.getMonsterPosition()[0]=r;
        monster.getMonsterPosition()[1]=c;
        board[r][c]= monster.getFirst();
        monster.Postion();
        System.out.println("");
        System.out.println(""); 
        viewBoard();
    }

    /**
     * gets the list of all the monster in the board by looping though the arraylist of monsters
     * @param get name stored in the arraylist 
     */
    public void getList(){
        viewBoard();
        System.out.println("");
        System.out.println("List of Players");
        for (Monster m : arrayMonsters) {
            System.out.println(m.getName());
        }
        System.out.println("");
    }

    /**
     * looped though the arraylist of monsters , if it contains the input return m
     * @return null if the imput name does conatin with in the arryalist
     */
    public Monster returnName(String name){
        for(Monster m: arrayMonsters){
            if(m.monstername.contains(name)){
                return m;
            }

        }
        System.out.println("Monster Not Found");
        System.out.println("");
        return null;
    }

    /**
     * ASk for the name of the monster to launch the attack 
     * look is the input contains with in the arraylist and if not null it launched the attack monster method
     * @param get the input and search for the input within the array and if found attacks the other monsters 
     */
    public void attackMonster() {
        System.out.println("Enter a monster name to lanuch an attack with");
        String search = input.nextLine().toUpperCase();
        Monster attackingMonster = returnName(search);
        if(attackingMonster != null) {
            System.out.println(search+ " Monster found");
            System.out.println("");
            launchAttack(attackingMonster);
            viewBoard();
        }
    }

    /**
     * 
     * gets the postion of the monster and checks around for another monster , 
     * and if its there ,it removes the monster from the board and arraylist,
     * and give the attacking monster a 10 point score.
     * 
     */
    public void launchAttack(Monster monster ) { 
        int monsterX=monster.getMonsterPosition()[0];
        int monsterY=monster.getMonsterPosition()[1];
        char north = board[monsterX-1][monsterY];
        char south = board[monsterX+1][monsterY];
        char west = board[monsterX][monsterY-1];
        char east = board[monsterX][monsterY+1];

        if(north != '*'&& north !='='){
            remove(north);
            removeBoardMonster(monsterX-1, monsterY);
            monster.setScore();
        }  

        else if( south != '*'&& south !='='){
            remove(south);
            removeBoardMonster(monsterX+1, monsterY);
            monster.setScore();
        }

        else if( west != '*'&& west !='='){
            remove(west);
            removeBoardMonster(monsterX, monsterY-1);
            monster.setScore();
        }

        else if( east != '*'&& east !='='){
            remove(east);
            removeBoardMonster(monsterX, monsterY+1);
            monster.setScore();
        }

    }

      /**
     * remove the charrecter from the board and arraylist by looping though the arraylist of monstername 
     * @param remove the initial character of teh monster name
     */
    public void remove( char removeM)  {

        String S= Character.toString(removeM);
        Iterator<Monster>i= arrayMonsters.iterator();
        while(i.hasNext()){
            Monster monster = i.next();
            if(monster.getName().startsWith(S)){
                i.remove();

            }
        }
    }

    /**
     * It replaces the a particular postion of the board with * 
     * @param assigns '*' 
     */

    public void removeBoardMonster(int rw , int cl) {
        board[rw][cl]='*';
    }

    /**
     * Loopes though the arraylist and print out the stored name and score of the monsters. 
     * @param prints the score and name of the monster 
     */
    public void getScore(){
        System.out.println("Scores of Monsters");
        for(Monster monster: arrayMonsters){
            System.out.println(""+monster.getName()+":"+monster.getScore());

        }
        System.out.println("");
    }
}
