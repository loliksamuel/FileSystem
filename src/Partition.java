/**
 * Created by lolik on 2017-03-28.
 */
public class Partition extends Dir{


    public static double MIN_SIZE = 10000;

    public Partition(String name, double aSize) {

        super(name, aSize, Constants.ATTRIBUTES_READ_WRITE);
        this.size = Math.max(aSize, MIN_SIZE);
        this.type = Constants.TYPE_PARTITION;

    }



}
