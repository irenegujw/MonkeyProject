import Sanctuary.*;

/**
 *     This class shows how to use the codes in the sanctuary package
 */
public class Main {


    public static void main(String[] args) {

        // set up a new empty sanctuary
        SanctuaryModel sanctuary = new SanctuaryModel();

        // create several monkey objects
        Monkey m1 = new Monkey("m1", Species.GUEREZA,Sex.MALE,50,100,7, Food.EGGS);
        Monkey m2 = new Monkey("m2",Species.GUEREZA,Sex.FEMALE,40,90,3, Food.FRUITS);
        Monkey m3 = new Monkey("m3",Species.TAMARIN, Sex.MALE,90,100,8, Food.INSECTS);
        Monkey m4 = new Monkey("m1", Species.GUEREZA,Sex.MALE,50,100,7, Food.EGGS);

        // receive them (put them into isolations first)
        sanctuary.receiveMonkey(m1);
        sanctuary.receiveMonkey(m2);
        sanctuary.receiveMonkey(m3);

        // after isolation, move them into enclosure
        sanctuary.moveMonkeyToEnclosure(m2);
        sanctuary.moveMonkeyToEnclosure(m1);
        sanctuary.moveMonkeyToEnclosure(m3);
        System.out.println(sanctuary.listMonkeysInEnclosure(Species.GUEREZA));
        System.out.println(sanctuary.listMonkeysInEnclosure(Species.TAMARIN));
        System.out.println(sanctuary.nameListOfAllMonkeys());

        // if m1 is sick, move it to cage
        sanctuary.moveMonkeyToIsolation(m1);
        System.out.println(sanctuary.listMonkeysInEnclosure(Species.GUEREZA));
        System.out.println(sanctuary.listMonkeysInEnclosure(Species.TAMARIN));
        System.out.println(sanctuary.nameListOfAllMonkeys());

        // after medical treatment, move it back
//        sanctuary.moveMonkeyToEnclosure(m1);
        System.out.println(sanctuary.listMonkeysInEnclosures());
        System.out.println(m4.isInIsolation(sanctuary));
        sanctuary.receiveMonkey(new Monkey("m1", Species.GUEREZA,Sex.MALE,50,100,7, Food.EGGS));
//        System.out.println(sanctuary.monkeyInIsolation(m1));

    }
}