/**
 * Created by lolik on 2017-03-28.
 */
public class _MainApp {
    public static void main(String[] args)
    {
        MyFileSystem fs = new MyFileSystem();
        fs.addPartition(new Partition("C:", 10000));
        fs.addPartition(new Partition("D:", 10000));
        //Dir CC = new Filee("d",2.0,2);//forbidden so it's ok
        Partition C = fs.getAllPartitions().get(0);
      //Dir C = new Dir("C", 1);
        Dir dir1 = C.addDir("dir1_InC");
        Dir dir2 = C.addDir("dir2_InC");//empty dir
       // Dir dir3 = C.addDir("dir3");
        C.addFile("file1_InC.txt", 1);
        C.addFile("file2_InC.txt", 2);
        C.addFile("file3_InC.txt", 3);
        dir1.addFile("file4_InC.txt", 9.9);


        System.out.println("C----------------");
        System.out.println("Files in C:"+C.getAllFiles());
        System.out.println("Dirs in C:"+C.getAllDirs());
        System.out.println("Filess in C:/dir1:"+dir1.getAllFiles());
        System.out.println("Dirs in C:/dir1:"+dir1.getAllDirs());
        System.out.println("rw--date-------------------------type--size--name---------------  recursively in C:");
        C.getAllFilesAndDirRecursive();
        System.out.println("total element count in C "+C.getFilesAndDirsRecursiveCount(C));
        System.out.println("total element size in C "+C.getFilesAndDirsRecursiveSize(C));

        System.out.println("");
        System.out.println("D--------------");
        Partition D = fs.getAllPartitions().get(1);
      //Dir D = new Dir("D", 2);
        D.addDir("dir");
        D.addFile("file.txt", -2);
        System.out.println("Files in D:"+D.getAllFiles());
        System.out.println("Dirs in D:"+D.getAllDirs());
        System.out.println("rw--date-------------------------type--size--name---------------  recursively in D:");
        D.getAllFilesAndDirRecursive();
        System.out.println("total element count in D "+D.getFilesAndDirsRecursiveCount(D));
        System.out.println("total element size in D "+D.getFilesAndDirsRecursiveSize(D));
    }
}
