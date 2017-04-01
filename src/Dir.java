import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lolik on 2017-03-28.
 */
public class Dir extends Filee{
    protected List<Filee> fileList ;
    protected List<Dir> dirList ;

    public Dir(String name, int readWrite) {
        this(name, 0, readWrite);
    }
    public Dir(String name,  double size, int readWrite) {
        super(name, size, readWrite);
        this.dateCreated = new Date();
        fileList = new ArrayList<>();
        dirList = new ArrayList<>();
        this.type = Constants.TYPE_DIR;
    }


    public Dir addDir(String dirName){
        Dir newDir = new Dir(dirName, Constants.ATTRIBUTES_READ_WRITE);
        dirList.add(newDir);
        return newDir;
    }
    public void addFile(String fileName , double size){
        fileList.add(new Filee(fileName, size, Constants.ATTRIBUTES_READ_WRITE));
    }
    public List<Dir> getAllDirs(){
        return dirList;
    }

    public List<Filee> getAllFiles(){
        return fileList;
    }

    public void getAllFilesAndDirRecursive(){
        getAllFilesAndDirRecursive(this);
    }
    //rw---date-----------------------type---Name---size----
    private  void getAllFilesAndDirRecursive(Dir dir){
        if (dir == null)
            return ;
        System.out.println(dir.getAttribute()+"  "+dir.getDateCreated()+" "+dir.getType()+"   "+dir.getFilesAndDirsRecursiveSize(dir)+"   "+dir.getName());
        for(Filee filee:dir.getAllFiles())
            System.out.println(filee.getAttribute()+"  "+filee.getDateCreated()+" "+filee.getType()+"  "+filee.getSize()+"   "+filee.getName());

        List<Dir> currDirList = dir.getAllDirs();
        for(Dir currDir:currDirList)
            getAllFilesAndDirRecursive(currDir);

    }

    public  int getFilesAndDirsRecursiveCount(Dir dir){
        int  fileCounter   = 0;
        if (dir == null)
            return 0;
        fileCounter = dir.getAllFiles().size();

        List<Dir> currDirList = dir.getAllDirs();
        for(Dir childDir:currDirList)
            fileCounter = 1+fileCounter+getFilesAndDirsRecursiveCount(childDir);

        return fileCounter;
    }

    public  double getFilesAndDirsRecursiveSize(Dir dir){
        double  totalSize   = 0.0;
        if (dir == null)
            return 0;

        //System.out.println(dir.getReadWrite()+"  "+dir.getCreateDate()+" "+dir.getType()+"   "+dir.getSizeRecursive()+"   "+dir.getName());
        for(Filee filee:dir.getAllFiles())
            totalSize += filee.getSize();

        List<Dir> currDirList = dir.getAllDirs();
        for(Dir childDir:currDirList)
            totalSize =  totalSize+getFilesAndDirsRecursiveSize(childDir);

        return totalSize;
    }

    /*
    private  int count(Node node){

        if (node == null)
            return 0;
        return 1+count(node.L)+count(node.R);*/
}
