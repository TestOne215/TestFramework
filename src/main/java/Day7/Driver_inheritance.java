package Day7;

public class Driver_inheritance {
    public static void main(String[] args) {
        EMI_inheritance s1 = new EMI_inheritance();
        s1.launchApp("https://www.unionbankofindia.co.in/english/emicalculator.aspx");
        String emi = s1.extractEmi("20000", "10", "120");
        System.out.println("EMI is:"+emi);
        s1.tearDown();


        Bing_inheritance b1 = new Bing_inheritance();
        b1.launchApp("https://www.bing.com/");
        b1.search("DataProviders");
        b1.tearDown();


    }
}
