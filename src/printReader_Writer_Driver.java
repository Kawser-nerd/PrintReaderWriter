public class printReader_Writer_Driver {
    public static void main(String[] args){
        printReader_Writer prw = new printReader_Writer();
        String inputFileName = "datain.txt";
        String outputFileName = "dataout.txt";

        prw.setFileName(inputFileName);
        prw.readFile();
        prw.countNumbers();

        prw.setFileName(outputFileName);
        prw.writeFile();
    }
}
