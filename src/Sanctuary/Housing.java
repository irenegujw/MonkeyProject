package Sanctuary;

/**
 * this interface Housing has the common methods of Enclosure and Isolation
 */
public interface Housing {

    /**
     * assign a monkey to this housing
     * @param monkey
     */
    public void accommodate(Monkey monkey);

    /**
     * remove a monkey from this housing
     * @param monkey
     */
    public void remove(Monkey monkey);




}
