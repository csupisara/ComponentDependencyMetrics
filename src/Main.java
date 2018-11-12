import java.io.File;
import java.text.DecimalFormat;


public class Main {

    public static void main(String[] args) {
//        File jcdFile = new File("/Users/supisara/Documents/workspace/Facade/src");
        File jcdFile = new File("/Users/supisara/Desktop/eagle-master/eagle-jpm/eagle-jpm-spark-history/src/main/java/org/apache/eagle/jpm/spark/history/crawl");

        String[] jcdFiles = jcdFile.list();
        FileRead read = new FileRead();

        System.out.println("Files Found: " + jcdFiles.length);

        for (String myFile : jcdFiles)
            if (myFile.contains(".java")) read.readInFile(jcdFile.toString(), myFile);

        PackageInfo pack = new PackageInfo(read.getNa(), read.getNc(), read.getCa(), read.getCe());
        DecimalFormat df = new DecimalFormat("#.######");

        System.out.println("ca: " + read.getCa());
        System.out.println("ce: " + read.getCe());
        System.out.println("nc: " + read.getNc());
        System.out.println("na: " + read.getNa());
        System.out.println("Instability(I): " + df.format(pack.getInstability()));
        System.out.println("Abstractness(A): " + df.format(pack.getAbstractness()));
        System.out.println("Distance(D): " + df.format(pack.getDistance()));

    }

}
