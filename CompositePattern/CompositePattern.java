package CompositePattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式
 * @author 秋玄
 * @version 1.0
 * @email qiu_2022@aliyun.com
 * @project DesignModel
 * @package CompositePattern
 * @date 2022-10-24-16:14
 * @since 1.0
 */
public class CompositePattern {
    public static void main(String[] args) {
        AbstractFile root = new Folder("root");

        AbstractFile folderA = new Folder("folderA");
        AbstractFile fileB = new File("fileB");

        AbstractFile fileC = new File("fileC");
        AbstractFile fileD = new File("fileD");
        AbstractFile fileE = new File("fileE");

        root.add(folderA);
        root.add(fileB);
        root.add(fileC);

        folderA.add(fileD);
        folderA.add(fileE);

        print(root);
    }

    static void print(AbstractFile file){
        file.printName();

        List<AbstractFile> childList = file.getChild();

        if (childList == null) return;

        for (AbstractFile child : childList) {
            print(child);
        }
    }
}

abstract class AbstractFile{
    protected String name;

    public void printName(){
        System.out.println(name);
    }

    public abstract boolean add(AbstractFile abstractFile);
    public abstract boolean delete(AbstractFile abstractFile);
    public abstract List<AbstractFile> getChild();
}

class Folder extends AbstractFile{
    private List<AbstractFile> fileList = new ArrayList<>();

    public Folder(String name){
        this.name = name;
    }

    @Override
    public boolean add(AbstractFile abstractFile) {
        return fileList.add(abstractFile);
    }

    @Override
    public boolean delete(AbstractFile abstractFile) {
        return fileList.remove(abstractFile);
    }

    @Override
    public List<AbstractFile> getChild() {
        return fileList;
    }
}

class File extends AbstractFile{
    public File(String name){
        this.name = name;
    }

    @Override
    public boolean add(AbstractFile abstractFile) {
        return false;
    }

    @Override
    public boolean delete(AbstractFile abstractFile) {
        return false;
    }

    @Override
    public List<AbstractFile> getChild() {
        return null;
    }
}
