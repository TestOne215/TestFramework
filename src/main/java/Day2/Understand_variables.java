package Day2;

public class Understand_variables {
    public static void main(String[] args) {
        Common_arithemetics ca = new Common_arithemetics();
        ca.increment();
        System.out.println("value of j:"+ca.j);           //j incremented
        System.out.println("value of k:"+Common_arithemetics.k);  //k incremnted

        System.out.println("##############################");
        Common_arithemetics cal = new Common_arithemetics();
        cal.increment();
        System.out.println("value of j:"+cal.j);  //copy of j is created(not incremented)
        System.out.println("value of k:"+Common_arithemetics.k);//last value of k is considered and incremented
        System.out.println("##############################");
        Common_arithemetics.addk();
   //trial
        System.out.println("##############################");
        Common_arithemetics.addk();
        System.out.println("##############################");
        Common_arithemetics can = new Common_arithemetics();
        can.increment();
        System.out.println("value of j:"+can.j);           //j incremented
        System.out.println("value of k:"+Common_arithemetics.k);  //k incremnted
    }

}
