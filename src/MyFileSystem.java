import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lolik on 2017-03-28.
 */
public class MyFileSystem {
    private List<Partition> pList = new ArrayList<>();
    public MyFileSystem() {
//        Partition C = new Partition("C", 10000);
//        Partition D = new Partition("D", 10000);
//        pList.add(C);
//        pList.add(D);
    }
    public void addPartition(Partition p){
        pList.add(p);
    }
    public void removePartition(Partition p){
        pList.remove(p);
    }
    public List<Partition>  getAllPartitions(){
        return pList;
    }

}
