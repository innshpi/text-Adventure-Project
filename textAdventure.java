/**
 * Write a description of class textAdventure here.
 *
 * @author (Piper Inns Hall)
 * @version (8/04/22)
 */
import java.util.Scanner;  
import java.io.File;
import java.io.IOException;                  
public class textAdventure
{
    Scanner kb = new Scanner(System.in); 
    
    boolean stillPlaying = false;
    
    int currentRoom = 0;
    int nextRoom=-1;
    
    final int INVALIDDIRECTION = -1;
    int[] goNorth = {/*room 0*/INVALIDDIRECTION,/*room 1*/INVALIDDIRECTION,/*room 2*/INVALIDDIRECTION,/*room 3*/4,/*room 4*/INVALIDDIRECTION,/*room 5*/1,/*room 6*/INVALIDDIRECTION,/*room 7*/INVALIDDIRECTION,/*room 8*/INVALIDDIRECTION,/*room 9*/INVALIDDIRECTION};
    int[] goSouth = {/*room 0*/INVALIDDIRECTION,/*room 1*/5,/*room 2*/INVALIDDIRECTION,/*room 3*/INVALIDDIRECTION,/*room 4*/3,/*room 5*/INVALIDDIRECTION,/*room 6*/INVALIDDIRECTION,/*room 7*/INVALIDDIRECTION,/*room 8*/INVALIDDIRECTION,/*room 9*/INVALIDDIRECTION};
    int[] goEast = {/*room 0*/INVALIDDIRECTION,/*room 1*/3,/*room 2*/INVALIDDIRECTION,/*room 3*/INVALIDDIRECTION,/*room 4*/INVALIDDIRECTION,/*room 5*/4,/*room 6*/INVALIDDIRECTION,/*room 7*/INVALIDDIRECTION,/*room 8*/INVALIDDIRECTION,/*room 9*/INVALIDDIRECTION};
    int[] goWest = {/*room 0*/INVALIDDIRECTION,/*room 1*/INVALIDDIRECTION,/*room 2*/INVALIDDIRECTION,/*room 3*/1,/*room 4*/5,/*room 5*/7,/*room 6*/7,/*room 7*/INVALIDDIRECTION,/*room 8*/INVALIDDIRECTION,/*room 9*/INVALIDDIRECTION};
    int[] goUp = {/*room 0*/INVALIDDIRECTION,/*room 1*/INVALIDDIRECTION,/*room 2*/1,/*room 3*/INVALIDDIRECTION,/*room 4*/INVALIDDIRECTION,/*room 5*/INVALIDDIRECTION,/*room 6*/4,/*room 7*/INVALIDDIRECTION,/*room 8*/0,/*room 9*/INVALIDDIRECTION};
    int[] goDown = {/*room 0*/INVALIDDIRECTION,/*room 1*/INVALIDDIRECTION,/*room 2*/INVALIDDIRECTION,/*room 3*/INVALIDDIRECTION,/*room 4*/6,/*room 5*/INVALIDDIRECTION,/*room 6*/INVALIDDIRECTION,/*room 7*/INVALIDDIRECTION,/*room 8*/INVALIDDIRECTION,/*room 9*/INVALIDDIRECTION};
    
    final int NUMROOMS = 12;
    File roomDFile=new File("roomD.txt");
    String[] roomD = new String[NUMROOMS];
    
    final int NUMSEARCH = 7;
    File searchFile=new File("search.txt");
    String[] search = new String[NUMSEARCH];
    
    private String[] nextRoomDescript = {
    /*room 0*/"to Grassy hill  (explored previously)",
    /*room 1*/"to Sand dunes (explored previously)",
    /*room 2*/"to Dark cave (explored previously)",
    /*room 3*/"to Bright cave (explored previously)",
    /*room 4*/"to Tide pool (explored previously)",
    /*room 5*/"to Beach (explored previously)",
    /*room 6*/"to Under water cave (explored previously)",
    /*room 7*/"to Ocean (explored previously)",
    /*room 8*/"to Stream (explored previously)"};
    
    //Rooms you have been to
    boolean[] beenRoom = {false,false,false,false,false,false,false,false,false,false};
    
    //inventory
    final int YSRCH = 1;
    final int NSRCH = 0;
    int[] canSearch = {NSRCH,YSRCH,YSRCH,YSRCH,YSRCH,YSRCH,YSRCH,YSRCH,YSRCH,NSRCH};
    boolean canBackpack = true;
    boolean haveRope = true;
    boolean haveSword = false;
    boolean haveLifeJacket = false;
    boolean haveFangKey = false;
    /**
     * Constructor for objects of class textAdventure
     */
    public textAdventure()
    {
        fileRead();
        System.out.println(roomD[11]);
        String cmdn1 = kb.nextLine();
        if(cmdn1.equals ("start")) stillPlaying = true;
        if(stillPlaying){
            System.out.print('\u000C');
            System.out.println(roomD[10]);
            doableActions();
        }
        while (stillPlaying){
            String cmd0 = kb.nextLine();
            //cmd0.toLowerCase();
            if(cmd0.equals("north"))nextRoom=goNorth[currentRoom];
            if(cmd0.equals("south"))nextRoom=goSouth[currentRoom];
            if(cmd0.equals("east"))nextRoom=goEast[currentRoom];
            if(cmd0.equals("west"))nextRoom=goWest[currentRoom];
            if(cmd0.equals("up"))nextRoom=goUp[currentRoom];
            if(cmd0.equals("down"))nextRoom=goDown[currentRoom];
            if (cmd0.equals("backpack")){
                backpack();
            }
            else if (cmd0.equals("search") && canSearch[currentRoom] == YSRCH){
                search();
            }
            else if(nextRoom>=0){
                System.out.print('\u000C');
                beenRoom[currentRoom] = true;
                currentRoom = nextRoom;
                System.out.println(roomD[currentRoom]);
                doableActions();
                nextRoom=-1;
            }
            else{ 
                System.out.println("\nYou cannot do this right now, or this is an invalid command");
                doableActions();
            }
        }
    }
    public void fileRead(){
        try {
            Scanner readFile = new Scanner(roomDFile);
            for(int i=0;i<NUMROOMS;i++)roomD[i] = "";
            for(int i=0;i<NUMROOMS;i++){
                String lineRead = readFile.nextLine();
                while(!lineRead.equals(";")){
                    roomD[i]+=lineRead+"\n";
                    lineRead = readFile.nextLine();
                }
            }
        }catch (IOException e){}
        try {
            Scanner readFile = new Scanner(searchFile);
            for(int i=0;i<NUMSEARCH;i++)search[i] = "";
            for(int i=0;i<NUMSEARCH;i++){
                String lineRead = readFile.nextLine();
                while(!lineRead.equals(";")){
                    search[i]+=lineRead+"\n";
                    lineRead = readFile.nextLine();
                }
            }
        }catch (IOException e){}
    }
    public void backpack(){
        System.out.println ("\nyou take your trusty backpack off of your back and look at the contents.\n\ninside is:");
        if(haveRope){ 
            System.out.println("A rope");
            useItem();
        }
        if(haveSword)System.out.println ("A sword");
        if(haveLifeJacket)System.out.println ("A lifejacket");
        if(haveFangKey){
            System.out.println ("A large fang");
            useItem();
        }
        doableActions();
    }
    public void useItem(){
        if(currentRoom == 0&&haveRope){ 
            System.out.println("\nyou think that the rope might be useful to you so you take it out of the bag.");
            System.out.println("Try using the rope to help you. (type 'use rope')");
            String cmd1 = kb.nextLine();
            if(cmd1.equals("use rope")){
                System.out.println("\nyou tie the rope to a sturdy looking branch in hopes of making it down to the sand flats below");
                haveRope = false;
                goDown[0]=1;
            }
            else System.out.println("\nYou cannot do this right now, or this is an invalid command");
        }
        if(currentRoom == 0&&haveFangKey){ 
            System.out.println("\nyou notice the fang fits perfectly in the hole on the door so you take it out of the bag.");
            System.out.println("Try placing the fang in the door. (type 'use fang')");
            String cmd1 = kb.nextLine();
            if(cmd1.equals("use fang")){
                System.out.println("\nyou place the fang in the door, and it opens. Everything around you is suddenly engulfed in a bright white light eminating from inside the door");
                goNorth[0]=9;
                canBackpack = false;
            }
            else System.out.println("\nYou cannot do this right now, or this is an invalid command");
        }
    }
    public void search(){
        if(currentRoom == 1){
            System.out.println(search[0]);
            goDown[1]=2;
            canSearch[currentRoom] = NSRCH;
            doableActions();
        }    
        else if(currentRoom == 2){
            System.out.println(search[1]);
            canSearch[currentRoom] = NSRCH;
            spiderAttack();
        }
        else if(currentRoom == 3){
            System.out.println(search[2]);
            haveLifeJacket = true;
            canSearch[currentRoom] = NSRCH;
            doableActions();
        }
        else if(currentRoom == 4){
            System.out.println(search[3]);
            haveSword = true;
            canSearch[currentRoom] = NSRCH;
            doableActions();
        }
        else if(currentRoom == 5){
            System.out.println(search[4]);
            canSearch[currentRoom] = NSRCH;
            doableActions();
        }
        else if(currentRoom == 7){
            System.out.println(search[5]);
            canSearch[currentRoom] = NSRCH;
            ripCaught();
        }
        else {
            System.out.println(search[6]);
            canSearch[currentRoom] = NSRCH;
            doableActions();
        }
    }
    public void doableActions(){
        System.out.println("\nActions you can perform right now:");
        if(goNorth[currentRoom]>=0)System.out.print("\nNorth ");
        if(goNorth[currentRoom]>=0 && beenRoom[goNorth[currentRoom]])System.out.print(nextRoomDescript[goNorth[currentRoom]]);
        if(goSouth[currentRoom]>=0)System.out.print("\nSouth ");
        if(goSouth[currentRoom]>=0 && beenRoom[goSouth[currentRoom]])System.out.print(nextRoomDescript[goSouth[currentRoom]]);
        if(goEast[currentRoom]>=0)System.out.print("\nEast ");
        if(goEast[currentRoom]>=0 && beenRoom[goEast[currentRoom]])System.out.print(nextRoomDescript[goEast[currentRoom]]);
        if(goWest[currentRoom]>=0)System.out.print("\nWest ");
        if(goWest[currentRoom]>=0 && beenRoom[goWest[currentRoom]])System.out.print(nextRoomDescript[goWest[currentRoom]]);
        if(goUp[currentRoom]>=0)System.out.print("\nUp ");
        if(goUp[currentRoom]>=0 && beenRoom[goUp[currentRoom]])System.out.print(nextRoomDescript[goUp[currentRoom]]);
        if(goDown[currentRoom]>=0)System.out.print("\nDown ");
        if(goDown[currentRoom]>=0 && beenRoom[goDown[currentRoom]])System.out.print(nextRoomDescript[goDown[currentRoom]]);
        if(canSearch[currentRoom] == YSRCH)System.out.print("\nSearch");
        if(canBackpack)System.out.print("\nBackpack\n");
        if(currentRoom == 9)System.out.println("Nothing because you won!");
    }
    public void spiderAttack(){
        if(haveSword){
            System.out.println("\nYou equip your sword, and strike down the spider in one blow. It dies\ninstantly and desintegrates, leaving behind a large fang.\nYou pick up the fang and put it in your backpack, because it looks cool");
            haveFangKey= true;
            doableActions();
        }
        else{
            System.out.println("\nBare fists dont seem to do much against the spider, and after a few useless\npunches, the spider suffocates you in web fluid, leaving you to die.");
            death();
        }
    }
    public void ripCaught(){
        if(haveLifeJacket){
            System.out.println("\nYou quickly reach into your backpack and pull out your lifejacket.\nFortunately the gas cylinder still works, and you ride the rip safely to land.");
            goSouth[7] = 8;
            doableActions();
        }
        else{
            System.out.println("\nYou try to swim, but you are already too far out. The cold is unbearable, and exhaustion catches up to you.");
            death();
        }
    }
    public void death(){ 
        System.out.println ("\nUnfortunately, you died. Type respawn to try again");
        String cmd2 = kb.nextLine();
        if(cmd2.equals("respawn")){
            //Clear screen
            System.out.print('\u000C');
            
            //Reseting starting room
            currentRoom = 0;
            nextRoom=-1;
            
            //Closing opened pathways
            goDown[1]=INVALIDDIRECTION;
            goSouth[7]=INVALIDDIRECTION;
            goNorth[0]=INVALIDDIRECTION;
            
            //Reseting rooms you have been to
            int[] beenRoom = {-1,-1,-1,-1,-1,-1,-1,-1};
            
            //Reseting inventory
            int[] canSearch = {NSRCH,YSRCH,YSRCH,YSRCH,YSRCH,YSRCH,YSRCH,YSRCH,YSRCH,YSRCH};
            canBackpack = true;
            haveRope = true;
            haveSword = false;
            haveLifeJacket = false;
            haveFangKey = false;
            
            System.out.println(roomD[currentRoom]);
            doableActions();
        }
    }
}