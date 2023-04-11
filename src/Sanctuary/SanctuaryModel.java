package Sanctuary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The Sanctuary class implements the whole facility with both housing and moneys
 */
public class SanctuaryModel {

    private ArrayList<Isolation> isolations; // 20
    private ArrayList<Enclosure> enclosures; // 8
    final int MAX_ISOLATION = 20;

    /**
     * constructor of an empty Sanctuary.
     * Sanctuary is set up with 20 isolation cages and 8 enclosures ( 1 for each species)
     * No monkeys in it
     */
    public SanctuaryModel() {
        this.isolations = new ArrayList<>();
        for(int i =0; i<MAX_ISOLATION; i++){
            isolations.add(new Isolation());
        }
        this.enclosures = new ArrayList<>();
        enclosures.add(new Enclosure(Species.DRILL));
        enclosures.add(new Enclosure(Species.GUEREZA));
        enclosures.add(new Enclosure(Species.HOWLER));
        enclosures.add(new Enclosure(Species.MANGABEY));
        enclosures.add(new Enclosure(Species.SAKI));
        enclosures.add(new Enclosure(Species.SPIDER));
        enclosures.add(new Enclosure(Species.SQUIRREL));
        enclosures.add(new Enclosure(Species.TAMARIN));

    }


    /**
     * receive a monkey and put it into an isolation cage
     * @param monkey the target monkey
     * @throws IllegalArgumentException if all the cages are full or the monkey is already received
     */
    public void receiveMonkey(Monkey monkey){
        if (monkeyInIsolation(monkey)||monkeyInEnclosure(monkey)){
            throw new IllegalArgumentException(String.format("%s is already received!",monkey.getName()));
        }
        if(isolationsAllFull()){
            throw new IllegalArgumentException("ALL isolations are full!");
        }
        for (Isolation i: isolations){
            if (!i.isFull()){
                i.accommodate(monkey);
                return;}
        }
    }

    /**
     * verify if all the isolation cages are occupied
     * @return true if all the isolation cages are full
     */
    private boolean isolationsAllFull(){
        for (Isolation i: isolations){
            if (!i.isFull()){
                return false;}
        }
        return true;
    }

    /**
     * verify if a monkey is in the enclosure
     * @param monkey
     * @return true if the monkey is currently in the enclosure
     */
    private boolean monkeyInEnclosure(Monkey monkey){
        for(Enclosure e: enclosures){
            if(e.getTroop().contains(monkey)){
                return true;
            }
        }
        return false;
    }

    /**
     * verify if a monkey is in Isolation
     * @param monkey
     * @return true if the monkey is currently in the isolation
     */
    private boolean monkeyInIsolation(Monkey monkey){
//        for (Isolation i: isolations){
//            Monkey o = i.getOccupant();
//            if(o!=null){
//                if((monkey.getName()==o.getName()) && (monkey.getSpecies()==o.getSpecies())
//                        && (monkey.getSex() ==o.getSex()) && (monkey.getSize()==o.getSize())
//                        && (monkey.getWeight()==o.getWeight()) && (monkey.getAge()==o.getAge())
//                        &&(monkey.getFavFood()==o.getFavFood())){
//                    return true;
//                }
//
//            }

//            if(monkey.equals(i.getOccupant())){
//                return true;
//            }
//        }
        return monkey.isInIsolation(this);
//        return false;
    }


    /**
     * move the monkey into isolation (when it receives medical attention)
     * @param monkey the monkey currently in one of the enclosures
     * @throws IllegalArgumentException if the monkey is not in the enclosure
     */
    public boolean moveMonkeyToIsolation(Monkey monkey){
        if (!monkeyInEnclosure(monkey)){
            throw new IllegalArgumentException(String.format("%s is not in enclosure ",monkey.getName()));
        }
        for (Enclosure enclosure : enclosures) {
            if (enclosure.getSpeciesOfRoom().equals(monkey.getSpecies())) {
                enclosure.remove(monkey);
            }
        }
        for (Isolation i: isolations){
            if (!i.isFull()){
                i.accommodate(monkey);}
            return true;
        }
        return false;
    }

    /**
     * move the monkey into enclosure (when it finishes isolation)
     * @param monkey
     * @throws IllegalArgumentException if the monkey is not in the enclosure
     */
    public boolean moveMonkeyToEnclosure(Monkey monkey){
        if (!monkeyInIsolation(monkey)){
            throw new IllegalArgumentException(String.format("%s is not in isolation ",monkey.getName()));
        }
        for (Isolation i: isolations){
            if (i.getOccupant()==monkey){
                i.remove(monkey);}
        }
        for (Enclosure enclosure : enclosures) {
            if (enclosure.getSpeciesOfRoom().equals(monkey.getSpecies())) {
                enclosure.accommodate(monkey);
                return true;
            }
        }
        return false;
    }



    /**
     * Produce a list in string form for every enclosure that shows each individual monkey currently housed there.
     * For each individual monkey, the list should include their name, sex, and favorite food.
     * @return list of monkeys in every enclosure
     */
    public String listMonkeysInEnclosures() {
        String s = "";
        for (Enclosure enclosure : enclosures) {
            s += enclosure.listAllOccupants() +"----------------------\n";

        }
        return s;
    }

    /**
     * Produce a list in string form for specified enclosure that shows each individual monkey currently housed there.
     * For each individual monkey, the list should include their name, sex, and favorite food.
     * @param species the enclosure for species
     * @return list of monkeys in the enclosure
     */
    public String listMonkeysInEnclosure(Species species) {
        for (Enclosure e:enclosures){
            if (e.getSpeciesOfRoom()==species){
                return e.listAllOccupants();
            }
        }
        return "INVALID SPECIES";
    }

    /**
     * Produce a name list (Alphabetic) in string form for every monkey in all housings in the sanctuary.
     * @return name list of all the monkeys in the sanctuary
     */
    public String nameListOfAllMonkeys() {
        List<Monkey> allMonkeys = new ArrayList<>();
        for (Isolation i : isolations) {
            if(i.getOccupant()!=null){
                allMonkeys.add(i.getOccupant());}
        }
        for (Enclosure enclosure : enclosures) {
            for (Monkey monkey : enclosure.getTroop()) {
                allMonkeys.add(monkey);
            }
        }
        Collections.sort(allMonkeys);
        String s ="Name list (Alphabetically):\n";
        for (Monkey m: allMonkeys) {
             s+=m.getName()+" ";
        }
        s += "\n";
        return s;
    }


    public ArrayList<Monkey> listOfMonkeyInIsolation(){
        ArrayList<Monkey> ret = new ArrayList<>();
        for(Isolation i:isolations){
            if(i.getOccupant()!=null){
                ret.add(i.getOccupant());
            }
        }
        return ret;
    }
}
