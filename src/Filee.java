import java.util.Date;

/**
 * Created by lolik on 2017-03-28.
 */
public class Filee {


    protected String name;
    protected Date dateCreated;
    protected Date dateModified;
    protected Date dateAccessed;
    protected double size;
    protected int attribute;


    protected int type;

    public Filee(String name, double size, int attribute) {
        this.name = name;
        this.size = Math.max(size,0.0);
        this.dateCreated = new Date();
        this.attribute = attribute;
        this.type = Constants.TYPE_FILE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateModified(Date aDate) {
        this.dateModified = aDate;
    }
    public void setDateAccessed(Date aDate) {
        this.dateAccessed = aDate;
    }
    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }



    public String getType() {
        if (type == Constants.TYPE_PARTITION)
            return "PRTSN";
        else if (type == Constants.TYPE_DIR)
            return "DIR";
        return "FILE";
    }



    public void setAttribute(int attribute) {
        this.attribute = attribute;
    }
    public String getAttribute() {
        if (attribute == 0)
            return "r-";
        else if (attribute == 1)
            return "-w";
        return "rw";

    }

}
