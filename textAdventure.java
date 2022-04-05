/**
 * Write a description of class textAdventure here.
 *
 * @author (Piper Inns Hall)
 * @version (24/03/21)
 */
import java.util.Scanner;                    
public class textAdventure
{
    Scanner kb = new Scanner(System.in); 
    
    boolean stillPlaying = true;
    
    int currentRoom = 0;
    int nextRoom=-1;
    
    final int INVALIDDIRECTION = -1;
    int[] goNorth = {/*room 0*/INVALIDDIRECTION,/*room 1*/INVALIDDIRECTION,/*room 2*/INVALIDDIRECTION,/*room 3*/4,/*room 4*/INVALIDDIRECTION,/*room 5*/1,/*room 6*/INVALIDDIRECTION,/*room 7*/INVALIDDIRECTION,/*room 8*/INVALIDDIRECTION,/*room 9*/INVALIDDIRECTION};
    int[] goSouth = {/*room 0*/INVALIDDIRECTION,/*room 1*/5,/*room 2*/INVALIDDIRECTION,/*room 3*/INVALIDDIRECTION,/*room 4*/3,/*room 5*/INVALIDDIRECTION,/*room 6*/INVALIDDIRECTION,/*room 7*/INVALIDDIRECTION,/*room 8*/INVALIDDIRECTION,/*room 9*/INVALIDDIRECTION};
    int[] goEast = {/*room 0*/INVALIDDIRECTION,/*room 1*/3,/*room 2*/INVALIDDIRECTION,/*room 3*/INVALIDDIRECTION,/*room 4*/INVALIDDIRECTION,/*room 5*/4,/*room 6*/INVALIDDIRECTION,/*room 7*/INVALIDDIRECTION,/*room 8*/INVALIDDIRECTION,/*room 9*/INVALIDDIRECTION};
    int[] goWest = {/*room 0*/INVALIDDIRECTION,/*room 1*/INVALIDDIRECTION,/*room 2*/INVALIDDIRECTION,/*room 3*/1,/*room 4*/5,/*room 5*/7,/*room 6*/7,/*room 7*/INVALIDDIRECTION,/*room 8*/INVALIDDIRECTION,/*room 9*/INVALIDDIRECTION};
    int[] goUp = {/*room 0*/INVALIDDIRECTION,/*room 1*/INVALIDDIRECTION,/*room 2*/1,/*room 3*/INVALIDDIRECTION,/*room 4*/INVALIDDIRECTION,/*room 5*/INVALIDDIRECTION,/*room 6*/4,/*room 7*/INVALIDDIRECTION,/*room 8*/0,/*room 9*/INVALIDDIRECTION};
    int[] goDown = {/*room 0*/INVALIDDIRECTION,/*room 1*/INVALIDDIRECTION,/*room 2*/INVALIDDIRECTION,/*room 3*/INVALIDDIRECTION,/*room 4*/6,/*room 5*/INVALIDDIRECTION,/*room 6*/INVALIDDIRECTION,/*room 7*/INVALIDDIRECTION,/*room 8*/INVALIDDIRECTION,/*room 9*/INVALIDDIRECTION};
    
    private String[] roomDescript = {
    /*room 0*/"almost there",
    /*room 1*/"You are walking across a barren sand flat, with nothing much in sight but\nsand dunes, and the occasional crab. You look east and across the dunes, and you see a small opening in the side of a tall rocky cliff. Interested, you walk towards the cave opening. South towards the right of the cave opening, is a winding dirt path lined with dense trees and shrubs.",
    /*room 2*/"You descend down into the dark pit below, the only thing keeping you from\nplummeting to the bottom are the rusty steel rungs your hands are clasped to.\nWhen your feet finally meet the hard stone floor, you can see nothing but black.\nAs your eyes slowly adjust to the dark, you realise you’re in a vast, empty cavern.\nYou take in the scene and your eyes follow the impossibly high walls up to the\nceiling, which nests thousands of glowworms. Across the rocky floor there are\npatches of thriving moss and in the distance you hear the faint echoing of dripping\nwater.",
    /*room 3*/"Bright cave",
    /*room 4*/"Tide pool",
    /*room 5*/"Beach",
    /*room 6*/"Under water cave",
    /*room 7*/"Ocean",
    /*room 8*/"Stream",
    /*room 9*/"You wade up the stream, and when you step out you realise you are back at the small feild on the hill. You look down the sheer cliff and see the sand flats, as well as the rope you placed to get down. Somethings different though. In the center of the field is an old door, sitting alone with no building to support it. It has no defining charachteristics except for a fang shaped hole in the center, about as big as your head.",
    /*room 0(starting descrpition)*/"grass patch, down steep hill is sand flats.\nall you have is the clothes on your back and a brown backpack."};
    
    private String[] nextRoomDescript = {
    /*room 0*/"toward the unknown",
    /*room 1*/"to Sand dunes (explored previously)",
    /*room 2*/"to Dark cave (explored previously)",
    /*room 3*/"to Bright cave (explored previously)",
    /*room 4*/"to Tide pool (explored previously)",
    /*room 5*/"to Beach (explored previously)",
    /*room 6*/"to Under water cave (explored previously)",
    /*room 7*/"to Ocean (explored previously)",
    /*room 8*/"to Stream (explored previously)",};
    
    //Rooms you have been to
    boolean[] beenRoom = {false,false,false,false,false,false,false,false};
    
    //inventory
    final int YSRCH = 1;
    final int NSRCH = 0;
    int[] canSearch = {NSRCH,YSRCH,YSRCH,YSRCH,YSRCH,YSRCH,YSRCH,YSRCH,YSRCH,YSRCH};
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
        System.out.println(roomDescript[10]);
        doableActions();
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
                System.out.println(roomDescript[currentRoom]);
                doableActions();
                nextRoom=-1;
            }
            else{ 
                System.out.println("\nYou cannot do this right now, or this is an invalid command");
                doableActions();
            }
        }
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
                doableActions();
            }
            else System.out.println("\nYou cannot do this right now, or this is an invalid command");
        }
    }
    public void search(){
        if(currentRoom == 1){
            System.out.println("\nyou rustle around the undergrowth and push away some shrubs,\ndiscovering an ominous trapdoor heading downwards.");
            goDown[1]=2;
            canSearch[currentRoom] = NSRCH;
            doableActions();
        }    
        else if(currentRoom == 2){
            System.out.println("\nyou walk towards the sound of running water, when suddenly you can't move.\nbefore you realise what has happened, a giant spider with fangs that look big enough to tear a deer in half jumps out at you from\nthe darkness.");
            canSearch[currentRoom] = NSRCH;
            spiderAttack();
        }
        else if(currentRoom == 3){
            System.out.println("\nPerched on a particularly sharp stalagmite in the corner of\nthe cave is a lifejacket. It may come in handy so you pick it up.");
            haveLifeJacket = true;
            canSearch[currentRoom] = NSRCH;
            doableActions();
        }
        else if(currentRoom == 4){
            System.out.println("\nYou wade through the glistening pools and in the depths of a large one is a sword buried underneath some sand.");
            haveSword = true;
            canSearch[currentRoom] = NSRCH;
            doableActions();
        }
        else if(currentRoom == 5){
            System.out.println("\nYou climb to the top of the largest rock you can find and stare into the horizon.\nYou truly feel like an adventurer.");
            canSearch[currentRoom] = NSRCH;
            doableActions();
        }
        else if(currentRoom == 7){
            System.out.println("\nYou swim out to sea from the shallows, but you get caught in a rip.");
            canSearch[currentRoom] = NSRCH;
            ripCaught();
        }
        else {
            System.out.println("\nYou found nothing. You feel slightly demoralized for no particular reason");
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
        if(canSearch[currentRoom] == YSRCH)System.out.println("\nSearch");
        if(canBackpack)System.out.println("\nBackpack");
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
            
            System.out.println(roomDescript[currentRoom]);
            doableActions();
        }
    }
}