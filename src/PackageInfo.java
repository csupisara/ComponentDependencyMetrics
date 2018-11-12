import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class PackageInfo {

    String packageName;
    int ca; //The number of classes outside this component that depend on classes within this component
    int ce; //The number of classes inside this component that depend on classes outside this component

    public double getInstability(){
        return ce/(ca+ce);
    }

    int na; //the number of abstract classes in the component.
    int nc; //the number of classes in the component.

    public double getAbstractness(){
        return na/nc;
    }

    public static void main(String[] args){
        File jcdFile = new File("/Users/supisara/Documents/workspace/Facade/src");
        String[] jcdFiles = jcdFile.list();
        System.out.println("Files Found: "+jcdFiles.length);
        String jdkReleaseFile = null;

        //Enhance loop through all files in the directory or folder
        for(String myFile : jcdFiles) {
            System.out.println(myFile);
            jdkReleaseFile = jcdFile + "/" + myFile;
            System.out.println(jdkReleaseFile);
        }





        //Reference a file to read
//        String jdkReleaseFile = "/Users/supisara/Documents/IntelliJWorkSpace/Conway/src/Cell.java";
//        String jdkReleaseFile = "/Users/supisara/Documents/workspace/Facade/src/Warehouse.java";


        PackageInfo p = new PackageInfo();
        //Call our read file method
        if(readTextFile(jdkReleaseFile) == 2) {
            p.nc++;
            p.na++;
        }
        if(readTextFile(jdkReleaseFile) == 1) p.na++;
        System.out.print(p.na + "    " + p.nc);
    }

    //MEthod to read a text file
    public static int readTextFile(String fileToRead) {
        String eachLine = "";
        int classCount = 0;

        try {
            //Create a BufferedReader object and feed it FileReader object
            BufferedReader buffReader = new BufferedReader(new FileReader(fileToRead));

            while ((eachLine = buffReader.readLine()) != null){
                if(eachLine.contains("class")) classCount++;
                else if(eachLine.contains("abstract")) classCount++;
            }
            buffReader.close();
        }
        catch(Exception ex) {
            System.out.println("Exception: "+ex.toString());
        }
        return classCount;
    }

}
