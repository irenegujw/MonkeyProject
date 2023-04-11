package Sanctuary;

/**
 * an isolation is used to keep monkeys when they first arrive at the sanctuary
 *              and anytime they are receiving medical attention.
 * an isolation can only hold a single animal.
 */
public class Isolation implements Housing{

    private Monkey occupant;

    /**
     * constructor of an isolation
     * the isolation is set up empty
     */
    public Isolation() {
        this.occupant = null;
    }

    public Monkey getOccupant() {
        return occupant;
    }

    /**
     * @return true if the housing is full
     */
    public boolean isFull() {
        return occupant!=null;
    }

    /**
     * assign a monkey to this isolation
     * @param monkey
     * @throws IllegalArgumentException if the cage is full
     */
    @Override
    public void accommodate(Monkey monkey) throws IllegalArgumentException {
        if(isFull()){
            throw new IllegalArgumentException("This isolation cage is already occupied!");
        }
        this.occupant = monkey;

    }

    /**
     * remove a monkey from this isolation
     * @param monkey
     */
    @Override
    public void remove(Monkey monkey) {
        if (!isFull()){
            throw new IllegalArgumentException("This isolation cage is already empty!");
        }
        occupant =null;

    }


}
