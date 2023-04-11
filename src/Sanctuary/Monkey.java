package Sanctuary;

import java.util.StringJoiner;

/**
 * The monkey
 */
public class Monkey implements Comparable<Monkey> {
    private String name;
    private Species species;
    private Sex sex;
    private double size,weight;
    private int age;
    private Food favFood;

    /**
     * constructor of monkey, the method is called when sanctuary receives a new monkey
     * @param name
     * @param species
     * @param sex
     * @param size
     * @param weight
     * @param age
     * @param favFood
     */
    public Monkey(String name, Species species, Sex sex, double size, double weight, int age, Food favFood)
            throws IllegalArgumentException {
        if(size<=0||weight<=0||age<0){
            throw new IllegalArgumentException("invalid input");
        }
        this.name = name;
        this.species = species;
        this.sex = sex;
        this.size = size;
        this.weight = weight;
        this.age = age;
        this.favFood = favFood;
    }

    /**
     * getter of species
     * @return monkey species
     */
    public Species getSpecies() {
        return species;
    }

    /**
     * getter of name
     * @return monkey name
     */
    public String getName() {
        return name;
    }

    /**
     * getter of size
     * @return size
     */
    public double getSize() {
        return size;
    }

    /**
     * getter of weight
     * @return weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * getter of age
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * getter of sex
     * @return monkey sex
     */
    public Sex getSex() {
        return sex;
    }

    /**
     * getter of favorite food
     * @return monkey's favorite food
     */
    public Food getFavFood() {
        return favFood;
    }

    /**
     * compare monkeys by their names alphabetically
     * @param others the monkey object to be compared.
     * @return 1 if this monkey's name is alphabetically large
     *         null object is to be sorted as larger (later in the list)
     */
    @Override
    public int compareTo(Monkey others) {
        if (others == null){
            return -1;}
        if( this==null ){
            return 1;
        }
        return this.name.compareTo(others.name);
    }

    /**
     * generate the string version of this monkey's info
     * @return monkey's profile including name, sex, and favorite
     */
    @Override
    public String toString() {
        return new StringJoiner(", ", name + " [", "]")
                .add(sex.toString().toLowerCase())
                .add("favorite food: " + favFood.toString().toLowerCase())
                .toString();
    }






    public boolean isInIsolation(SanctuaryModel s){
        for (Monkey other :s.listOfMonkeyInIsolation()){
            if((this.name.equals(other.name))
                    && (this.species.equals( other.species))
                    && (this.sex.equals(other.sex)) && (this.size==other.size)
                    && (this.weight==other.weight) && (this.age==other.age)
                    && (this.favFood.equals(other.favFood))
            ){
                return true;
            }
        }
        return false;
    }

    //    /**
//     *
//     * @param o1 the first object to be compared.
//     * @param o2 the second object to be compared.
//     * @return a negative integer, zero, or a positive integer as the
//     * first argument is less than, equal to, or greater than the
//     * second.
//     * @throws NullPointerException if an argument is null and this
//     *                              comparator does not permit null arguments
//     * @throws ClassCastException   if the arguments' types prevent them from
//     *                              being compared by this comparator.
//     */
//    @Override
//    public int compare(Sanctuary.Monkey o1, Sanctuary.Monkey o2) {
//        if (o2 == null){
//            return -1;}
//        if( o1 == null){
//            return 1;}
//        return o1.name.compareTo(o2.name);
//    }
}
