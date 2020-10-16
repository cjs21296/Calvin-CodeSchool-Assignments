import java.io.*;
import java.util.*;
public class PigLatinDriver {
    private static File file = new File("C:\\Users\\cjs21\\GIT\\Group Submission\\Week6\\PigLatinApp\\src\\main\\java");
    private static Scanner inFile;
//    public static void main(String[] args)
//    {
//        String original="Wikipedia";
//        System.out.println("****************");
//        System.out.println(original);
//        original=getPigLatin(original);
//        System.out.println(original);
//        System.out.println("****************");
//        //readInputTxtScanner();
//        readInputTxtBuffered();
//    }
    public String getPigLatin(String original)
    {
        String Coded;
        if(original.length()>2) {
            Coded = original.substring(1, 2).toUpperCase()
                    + original.substring(2, original.length())
                    + "ay";
        }else{
            Coded = "P"+original.toLowerCase()+"ay";
        }
        return Coded;
    }
    public void readInputTxtScanner()
    {
        String Message;
        File f = new File(file+"\\RandomInputGen.txt");
        try {
            inFile = new Scanner(file);
            while(inFile.hasNext())
            {
                Message=inFile.next();
                System.out.println("****************");
                System.out.println(Message);
                Message=getPigLatin(Message);
                System.out.println(Message);
                System.out.println("****************");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void readInputTxtBuffered()
    {
        String Message;
        try{
            File f = new File(file+"\\RandomInputGen.txt");
            FileReader fileReader = new FileReader(f);
            BufferedReader BR = new BufferedReader(fileReader);
            f = new File(file+"\\PigLatinOutput.txt");
            FileWriter fileWriter = new FileWriter(f);
            BufferedWriter BW = new BufferedWriter(fileWriter);


            while((Message = BR.readLine())!=null)
            {

                BW.write(Message+" = ");
                System.out.println("****************");
                System.out.println(Message);
                Message=getPigLatin(Message);
                System.out.println(Message);
                System.out.println("****************");
                BW.write(Message+"\n");

            }
            BR.close();
            BW.close();
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
