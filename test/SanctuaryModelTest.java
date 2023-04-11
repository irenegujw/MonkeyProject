import Sanctuary.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class SanctuaryModelTest {

    private SanctuaryModel s1 = new SanctuaryModel();
    private Monkey m1 = new Monkey("m1", Species.GUEREZA, Sex.MALE,50,100,7, Food.EGGS);
    private Monkey m2 = new Monkey("m2",Species.GUEREZA,Sex.FEMALE,40,90,3, Food.FRUITS);
    private Monkey m3 = new Monkey("m3",Species.TAMARIN, Sex.MALE,90,100,8, Food.INSECTS);

    @Test
    public void testInvalidMonkeyConstructor(){
        assertThrows(IllegalArgumentException.class, () -> m3 = new Monkey("m3",Species.TAMARIN, Sex.MALE,-1,100,8, Food.INSECTS));
        assertThrows(IllegalArgumentException.class, () -> m3 = new Monkey("m3",Species.TAMARIN, Sex.MALE,13,0,8, Food.INSECTS));
        assertThrows(IllegalArgumentException.class, () -> m3 = new Monkey("m3",Species.TAMARIN, Sex.MALE,13,5,-1, Food.INSECTS));
    }

    @Test
    public void testReceiveMonkey() {
        s1.receiveMonkey(m1);
        System.out.println(s1.nameListOfAllMonkeys());
        assertEquals("Name list (Alphabetically):\nm1 \n",s1.nameListOfAllMonkeys());
    }

    @Test
    public void testReceiveOver20Monkey() {
        for(int i =0;i<20;i++){
            Monkey mm = new Monkey(String.format("%d",i+1),m1.getSpecies(),m1.getSex(),10.1,10,10,Food.NUTS);
            s1.receiveMonkey(mm);
        }
        assertThrows(IllegalArgumentException.class, () -> s1.receiveMonkey(m1));
    }

    @Test
    public void testReceive2Times() {
        s1.receiveMonkey(m1);
        assertThrows(IllegalArgumentException.class, () -> s1.receiveMonkey(m1));
        s1.moveMonkeyToEnclosure(m1);
        assertThrows(IllegalArgumentException.class, () -> s1.receiveMonkey(m1));
    }

    @Test
    public void testMoveMonkeyToEnclosure() {
        s1.receiveMonkey(m1);
        s1.moveMonkeyToEnclosure(m1);
    }

    @Test
    public void testMoveUnreceivedMonkeyToEnclosure() {
        assertThrows(IllegalArgumentException.class, () -> s1.moveMonkeyToEnclosure(m1));
        // a monkey cannot be added to an enclosure if has not been labelled as healthy (not received before)
    }

    @Test
    public void testMoveMonkeyToEnclosureAgain() {
        s1.receiveMonkey(m1);
        s1.moveMonkeyToEnclosure(m1);
        assertThrows(IllegalArgumentException.class, () -> s1.moveMonkeyToEnclosure(m1));
    }

    @Test
    public void testMoveMonkeyToIsolation() {
        s1.receiveMonkey(m1);
        assertThrows(IllegalArgumentException.class, () -> s1.moveMonkeyToIsolation(m1));
    }

    @Test
    public void testMoveUnreceivedMonkeyToIsolation() {
        assertThrows(IllegalArgumentException.class, () -> s1.moveMonkeyToIsolation(m1));
    }

    @Test
    public void testMoveMonkeyToIsolationAgain() {
        s1.receiveMonkey(m1);
        assertThrows(IllegalArgumentException.class, () -> s1.moveMonkeyToIsolation(m1));
    }


    @Test
    public void testListMonkeysInAllEnclosures() {
        s1.receiveMonkey(m1);
        s1.receiveMonkey(m2);
        // empty
        assertEquals("Monkeys in the enclosure for drill:\n" +
                "----------------------\n" +
                "Monkeys in the enclosure for guereza:\n" +
                "----------------------\n" +
                "Monkeys in the enclosure for howler:\n" +
                "----------------------\n" +
                "Monkeys in the enclosure for mangabey:\n" +
                "----------------------\n" +
                "Monkeys in the enclosure for saki:\n" +
                "----------------------\n" +
                "Monkeys in the enclosure for spider:\n" +
                "----------------------\n" +
                "Monkeys in the enclosure for squirrel:\n" +
                "----------------------\n" +
                "Monkeys in the enclosure for tamarin:\n" +
                "----------------------\n", s1.listMonkeysInEnclosures());

        s1.moveMonkeyToEnclosure(m1);
        assertEquals("Monkeys in the enclosure for drill:\n" +
                "----------------------\n" +
                "Monkeys in the enclosure for guereza:\n" +
                "m1 [male, favorite food: eggs]\n" +
                "----------------------\n" +
                "Monkeys in the enclosure for howler:\n" +
                "----------------------\n" +
                "Monkeys in the enclosure for mangabey:\n" +
                "----------------------\n" +
                "Monkeys in the enclosure for saki:\n" +
                "----------------------\n" +
                "Monkeys in the enclosure for spider:\n" +
                "----------------------\n" +
                "Monkeys in the enclosure for squirrel:\n" +
                "----------------------\n" +
                "Monkeys in the enclosure for tamarin:\n" +
                "----------------------\n", s1.listMonkeysInEnclosures());

        s1.moveMonkeyToEnclosure(m2);
        s1.moveMonkeyToIsolation(m1);
        assertEquals("Monkeys in the enclosure for drill:\n" +
                "----------------------\n" +
                "Monkeys in the enclosure for guereza:\n" +
                "m2 [female, favorite food: fruits]\n" +
                "----------------------\n" +
                "Monkeys in the enclosure for howler:\n" +
                "----------------------\n" +
                "Monkeys in the enclosure for mangabey:\n" +
                "----------------------\n" +
                "Monkeys in the enclosure for saki:\n" +
                "----------------------\n" +
                "Monkeys in the enclosure for spider:\n" +
                "----------------------\n" +
                "Monkeys in the enclosure for squirrel:\n" +
                "----------------------\n" +
                "Monkeys in the enclosure for tamarin:\n" +
                "----------------------\n", s1.listMonkeysInEnclosures());

    }

    @Test
    public void testListMonkeysIn1Enclosure() {
        s1.receiveMonkey(m1);
        s1.receiveMonkey(m3);
        s1.moveMonkeyToEnclosure(m1);
        assertEquals(s1.listMonkeysInEnclosure(Species.GUEREZA),"Monkeys in the enclosure for guereza:\n" +
                "m1 [male, favorite food: eggs]\n");
        assertEquals(s1.listMonkeysInEnclosure(Species.TAMARIN),"Monkeys in the enclosure for tamarin:\n");


    }

    @Test
    public void testNameListOfAllMonkeys() {
        s1.receiveMonkey(m1);
        s1.receiveMonkey(m2);
        s1.moveMonkeyToEnclosure(m1);
        assertEquals("Name list (Alphabetically):\nm1 m2 \n", s1.nameListOfAllMonkeys());
    }

    @Test
    public void testEmptyNameList() {
        assertEquals("Name list (Alphabetically):\n\n", s1.nameListOfAllMonkeys());
    }





}