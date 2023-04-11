package Sanctuary;

import java.util.ArrayList;

/**
 * Each enclosure is configured to house a particular species of monkeys.
 * Fields: list of troop containing monkeys
 *         Species of the monkeys in the room - which is assigned at construction
 */
public class Enclosure implements Housing {

    private ArrayList<Monkey> troop;
    private Species speciesOfRoom;

    /**
     * constructor of this housing
     * @param species
     */
    public Enclosure(Species species) {
        this.troop = new ArrayList<>();
        this.speciesOfRoom = species;
    }


    /**
     * assign a monkey to this enclosure
     * @param newMonk the monkey to be assigned
     * @throws IllegalArgumentException if the new monkey is not of the same species as the current occupants
     */
    @Override
    public void accommodate(Monkey newMonk) throws IllegalArgumentException{
        if (speciesOfRoom!=null && speciesOfRoom!=newMonk.getSpecies()){
            throw new IllegalArgumentException("The species does not match!");
        }
        if(troop.size()==0){
            speciesOfRoom = newMonk.getSpecies();
        }
        troop.add(newMonk);

    }

    /**
     * remove a monkey from this enclosure
     * @param monkey the monkey to be removed
     */
    @Override
    public void remove(Monkey monkey) {
        if (troop.size()==0){
            throw new IllegalArgumentException("This enclosure is already empty!");
        }
        troop.remove(monkey);
    }

    /**
     * getter of species of the room
     * @return the species of the room
     */
    public Species getSpeciesOfRoom() {
        return speciesOfRoom;
    }

    /**
     * getter of the occupants
     * @return the troop (list object of the occupants)
     */
    public ArrayList<Monkey> getTroop() {
        return troop;
    }

    /**
     * list the moneys in this room
     * @return a string containing the info of monkey (name, sex, favorite food)
     */
    public String listAllOccupants(){
        String s = "Monkeys in the enclosure for "+getSpeciesOfRoom().toString().toLowerCase()+":\n";
        for(Monkey monkey: troop){
            s+=monkey.toString()+"\n";
        }
        return s;
    }
}
