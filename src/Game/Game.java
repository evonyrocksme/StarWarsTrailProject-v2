package Game;


import GameEntities.Pilot;
import GameEntities.Ship;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author charlesurban
 */
public class Game extends GameSetup{
    
    private Ship ship; //make the Game Objects
    private Pilot pilot;
    private int difficulty; //choose how hard the game is depending on this number, not sure how to implement yet
    Random random = new Random();
    
    /*
    Things I changed in this class
    
    -   removed 'static' keyword from all the Game methods
    -   added a handful of comments
    -   used get and set methods for the pilot instance variable instead of initializing
            a whole other slew of variables in Game and making a method that updated them
    -   added pilot and ship game objects, and removed the other instance variables in
            place of the previously mentioned get/set methods
    -   got rid of various little errors that occured
    -   cleaned up the switch case error you had (use Case 1: Case 2: instead of Case 1, 2:)
    */
    
    
    public Game(int difficulty, Ship ship, Pilot pilot) {
        
    }
    
    public void start() {
        GameSetup.setupGame();
        //run the actual game code in here, kinda sucks to do it this way but yeah, you can use methods to clean it up
    }
    
    //I think it's supposed to be if the ship's damage is greater than a certain value, but I'm really not sure how you want your game to play tbh. Feel free to change as needed
    public boolean checkShipCanTravel() {
        boolean bool = !(ship.getBatteries() < 0 || ship.getDamage() > 100 || ship.getFuel() < 0);
        return bool;
    }
    
    public boolean checkPilotIsDead() {
        boolean bool = !(pilot.getEnergy() <= 0 || pilot.getHunger() < 0 || pilot.getThirst() < 0);
        return bool;
    }
    
    private String getNewLocation() {
        String location;
        int locationPicker = random.nextInt(15);
        if (locationPicker == 0 || locationPicker == 1) {
            location = "Hutt Space";
        }
        
        if (locationPicker == 2 || locationPicker == 3) {
            location = "Western Reaches";
        }
        
        if (locationPicker == 4 || locationPicker == 5) {
            location = "Outer Rim";
        }
        
        if (locationPicker == 6 || locationPicker == 7 || locationPicker == 8 || locationPicker == 9 || locationPicker == 10 || locationPicker == 11) {
            location = "The Core";
        }
        
        else {
            location = "Mid Rim";
        }
        return location;
    }
    
    private String getNewWeather() {
        String weather;
        int weatherPicker = random.nextInt(8);
        switch (weatherPicker) {
            case 0:
                weather = "Solar Winds";
                break;
            case 1:
                weather = "Astroids!";
                break;
            case 2: case 3: case 4: case 5:
                weather = "Clear Space All Around You";
                break;
            default:
                weather = "A huge cluster of ships are around you";
                break;
        }
        return weather;
    }
    
    private String getNewTimeOfDay() {
        return null;
    }
    
    private String getPursuerDistanceDescription() {
        return null;
    }
    
    private void processTurn() {
        System.out.println("What would you like to do next?");
        System.out.println("1. Rest");
        System.out.println("2. Stop and Search for Food");
        System.out.println("3. Stop and Search for Water");
        System.out.println("4. Fly Carefully");
        System.out.println("5. Fly Regulary");
        System.out.println("6. Jump to LightSpeed");
        System.out.println("7. Check how far away the Galactic Empire is");
        Scanner turn = new Scanner(System.in);
        int processTurn = turn.nextInt();
        if (processTurn == 1) {
            processRest();
        }
        if (processTurn == 2) {
            processFoodSearch();
        }
        if (processTurn == 3) {
            processWaterSearch();
        }
        if (processTurn == 4) {
            processTravelCarefully();
        }
        if (processTurn == 5) {
            processTravelRegularly();
        }
        if (processTurn == 6) {
            processJumpToLightSpeed();
        }
        if (processTurn == 7) {
            processPursuers();
        }
        else {
            System.out.println("Please select a listed option.");
        }
    }
    
    private void processRest() {
        
    }
    
    private void processFoodSearch() {
        System.out.println("You landed on the closest planet, hopefully there is some food here.");
        Random food = new Random();
        int randFood = food.nextInt(30);
        System.out.println("You found " + randFood + " lbs of food.");
        pilot.adjustHunger(randFood + pilot.getHunger());
        System.out.println("Your hunger level is now at " + pilot.getHunger() + ".");
    }
    
    private void processWaterSearch() {
        System.out.println("You landed on the closest planet, hopefully there is some food here.");
        Random food = new Random();
        int randWater = food.nextInt(30);
        System.out.println("You found " + randWater + " cups of water.");
        pilot.adjustThirst(pilot.getThirst() + randWater);
        System.out.println("Your thirst level is now at " + pilot.getThirst() + ".");
    }
    
    private void processTravelCarefully() {
        
    }
    
    private void processTravelRegularly() {
        
    }
    
    private void processJumpToLightSpeed() {
        
    }
    
    private void processPursuers() {
        
    }
    
}
