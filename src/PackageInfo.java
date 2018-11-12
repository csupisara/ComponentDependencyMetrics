
public class PackageInfo {

    String packageName;
    double ca;
    double ce;
    double na;
    double nc;

    public PackageInfo(double na, double nc, double ca, double ce) {
        this.ce = ce;
        this.ca = ca;
        this.na = na;
        this.nc = nc;
    }

    public double getInstability() {
        if(ce == 0 || (ca + ce) == 0) return 0;
        return ce / (ca + ce);
    }

    public double getAbstractness() {
        if(na == 0 || nc == 0) return 0;
        return na / nc;
    }

    public double getDistance() {
        return Math.abs(getAbstractness() + getInstability() - 1);
    }






//    String packageName;
//    int ca; //The number of classes outside this component that depend on classes within this component
//    int ce; //The number of classes inside this component that depend on classes outside this component
//
//    public double getInstability(){
//        return ce/(ca+ce);
//    }
//
//    int na; //the number of abstract classes in the component.
//    int nc; //the number of classes in the component.
//
//    public double getAbstractness(){
//        if(na == 0 || nc == 0) return 0;
//        else return na/nc;
//    }
//
//    public static void main(String[] args){
//        File jcdFile = new File("/Users/supisara/Documents/workspace/Facade/src");
//        String[] jcdFiles = jcdFile.list();
//        System.out.println("Files Found: "+jcdFiles.length);
//        String jdkReleaseFile = null;
//
//        //Enhance loop through all files in the directory or folder
//        for(String myFile : jcdFiles) {
//            System.out.println("Found: " + myFile);
//            jdkReleaseFile = jcdFile + "/" + myFile;
//        }
//
//        //Reference a file to read
////        String jdkReleaseFile = "/Users/supisara/Documents/IntelliJWorkSpace/Conway/src/Cell.java";
////        String jdkReleaseFile = "/Users/supisara/Documents/workspace/Facade/src/Warehouse.java";
//
//
//        PackageInfo p = new PackageInfo();
//        //Call our read file method
//        if(readTextFile(jdkReleaseFile) == 2) {
//            p.nc++;
//            p.na++;
//        }
//        if(readTextFile(jdkReleaseFile) == 1) p.nc++;
//        System.out.println("na: " + p.na + "    nc: " + p.nc);
//
//        System.out.println("Abstractness: " + p.getAbstractness());
//    }
//
//    //Method to read a text file: normal class return 1, abstract class return 2
//    public static int readTextFile(String fileToRead) {
//        String eachLine = "";
//        int classCount = 0;
//
//        try {
//            //Create a BufferedReader object and feed it FileReader object
//            BufferedReader buffReader = new BufferedReader(new FileReader(fileToRead));
//
//            while ((eachLine = buffReader.readLine()) != null){
//                if(eachLine.contains("abstract")) classCount++;
//                if(eachLine.contains("class")) classCount++;
//            }
//            buffReader.close();
//        }
//        catch(Exception ex) {
//            System.out.println("Exception: "+ex.toString());
//        }
//        return classCount;
//    }

}
