/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import GameEntities.Pilot;
import GameEntities.Ship;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author charlesurban
 */
public class GameSetup{
    
    private static Ship shipConstructor;
    private static Pilot pilotConstructor;
    
    /*
    Things I changed in this class
    
    -   Made objects, removed initialization from methods so they could be accessed across the class
    -   Changed scanner.ToString() to scanner.next()     -consider only using one scanner and skipping past lines, it saves on memory
    -   Cleaned up variable intialization in the methods to save on memory (RAM)
    -   Added while loops to allow the program to continue to run and not error out if a user enters numbers not accepted by scan.nextInt()
    */
    
    /*
    Recommended things
    
    -   Consider checking input's to be type-resistant (if I enter a for a scanner accepting .nextInt(), what happens?
    */
    
    //Ship Setup
    public static Ship setupShip(int option) {
        switch (option) {
            case 1: //Default Ship
                shipConstructor = new Ship("Millenium Falcon");
                break;
            case 2: //Random Ship
                Random name = new Random();
                int nameGen = name.nextInt(3);
                Random fuel = new Random();
                Random batteries = new Random();
                Random damage = new Random();
                //Random Ship Name
                String randomName;
                switch (nameGen) {
                    case 0:
                         randomName = "Millenium Falcon";
                         break;
                    case 1:
                        randomName = "X-Wing";
                        break;
                     default:
                        randomName = "Tie Fighter";
                        break;
            }
                //Random Fuel Level
                int randomFuel = fuel.nextInt(100);
                //Random Battery Level
                int randomBatteries = batteries.nextInt(100);
                //Random Damage Level
                int randomDamage = damage.nextInt(96);
                //Random Ship Constructed
                shipConstructor = new Ship(randomName, randomFuel, randomBatteries, randomDamage);
                break;


           case 3: //Custom Ship
                System.out.println("Please enter a name for your ship.");
                Scanner sName = new Scanner(System.in);
                String customName = sName.next();
                System.out.println("Please enter a fuel value for your ship. 100 being a full tank of fuel.");
                Scanner sFuel = new Scanner(System.in);
                int customFuel = sFuel.nextInt();
                System.out.println("Please enter a battery charge for your ship. 100 being fully charged batteries.");
                Scanner sBatteries = new Scanner(System.in);
                int customBatteries = sBatteries.nextInt();
                System.out.println("Please enter a damage value for your ship. 0 being no damage to the ship.");
                Scanner sDamage = new Scanner(System.in);
                int customDamage = sDamage.nextInt();
                shipConstructor = new Ship(customName, customFuel, customBatteries, customDamage);
                break;
        }
        
        return shipConstructor;
    }
    
    //Pilot Setup
    public static Pilot setupPilot(int option) {
        Pilot pilotConstructor;
        switch (option) {
            case 1: //Default Pilot
                Pilot defaultPilot = new Pilot("Han Solo");
                pilotConstructor = defaultPilot;
                break;
            case 2: //Random Ship
                Random name = new Random();
                int nameGen = name.nextInt(3);
                Random hunger = new Random();
                Random thirst = new Random();
                Random energy = new Random();
                //Random Ship Name
                String randomName;
                switch (nameGen) {
                    case 0:
                         randomName = "Millenium Falcon";
                         break;
                    case 1:
                        randomName = "X-Wing";
                        break;
                     default:
                        randomName = "Tie Fighter";
                        break;
            }
                //Random Fuel Level
                int randomHunger = hunger.nextInt(100);
                //Random Battery Level
                int randomThirst = thirst.nextInt(100);
                //Random Damage Level
                int randomEnergy = energy.nextInt(100);
                //Random Ship Constructed
                Pilot randomPilot = new Pilot(randomName, randomHunger, randomThirst, randomEnergy);
                pilotConstructor = randomPilot;
                break;

           case 3: //Custom Ship
                System.out.println("Please enter a name for your ship.");
                Scanner sName = new Scanner(System.in);
                String customName = sName.next();
                System.out.println("Please enter a fuel value for your ship. 100 being a full tank of fuel.");
                Scanner sHunger = new Scanner(System.in);
                int customHunger = sHunger.nextInt();
                System.out.println("Please enter a battery charge for your ship. 100 being fully charged batteries.");
                Scanner sThirst = new Scanner(System.in);
                int customThirst = sThirst.nextInt();
                System.out.println("Please enter a damage value for your ship. 0 being no damage to the ship.");
                Scanner sEnergy = new Scanner(System.in);
                int customEnergy = sEnergy.nextInt();
                Pilot customPilot = new Pilot(customName, customHunger, customThirst, customEnergy);
                pilotConstructor = customPilot;
                break;
           default: //bad case, set this up later
               pilotConstructor = new Pilot("Han Solo");
        }
       return pilotConstructor; 
    }

    public static Game setupGame() {
    //Initialize Game
        System.out.println("Quick! The galaxy needs your help. Luke Skywalker is missing and you must find him! If he is not found soon, the galatic empire will take over the entire galaxy.");        
        System.out.println("Please Select A Difficulty.");
        System.out.println("1. Easy");
        System.out.println("2. Normal");
        System.out.println("3. Hard");
        Scanner d = new Scanner(System.in);
        int difficulty = d.nextInt();
        
    //Ship Selection
        System.out.println("Please Select A Type Of Ship.");
        System.out.println("1. Default Ship");
        System.out.println("2. Random Ship");
        System.out.println("3. Fully Custom Ship");
        Scanner s = new Scanner(System.in);
        while (true) {
            if (s.nextInt() == 1 || s.nextInt() == 2 || s.nextInt() == 3) {
                GameSetup.setupShip(s.nextInt());
                break;
            }
            else {
                System.out.println("Please select a valid ship type.");
            }
        }
        
    //Pilot Selection
        System.out.println("Please Select A Type Of Pilot.");
        System.out.println("1. Default Pilot");
        System.out.println("2. Random Pilot");
        System.out.println("3. Fully Custom Pilot");
        Scanner p = new Scanner(System.in);
        while (true) {
            if (p.nextInt() == 1 || p.nextInt() == 2 || p.nextInt() == 3) {
                GameSetup.setupPilot(s.nextInt());
                break;
            }
            else {
                System.out.println("Please select a valid pilot type.");
            }
        }
        
        Game newGame = new Game(difficulty, shipConstructor, pilotConstructor);
        
        return newGame;        
    }
    
}
