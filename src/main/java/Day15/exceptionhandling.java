package Day15;

import java.io.FileInputStream;

public class exceptionhandling {
    public static void main(String[] args)  {
        //checked Exception
     //   Thread.sleep(5000);
    //    new FileInputStream("C:\\wertyui.xls");

        //unchecked exception
        String[] str = new String[3];
      //  str[3]="Annie";
        AgeCalc ag = new AgeCalc();

        try{
            String y=null;
            System.out.println(y.length());
            int a;
            int b=4;
            a=b/0;
            //include the lines which u feels doubtful
            ag.AgeCalculation(2);
        }

        catch (ArithmeticException e){
            System.out.println("the Arithmetic exception is "+e.toString());
        }
        catch(NullPointerException e){
            System.out.println("the Null pointer exception is "+e.toString());
            e.printStackTrace();
        }
        catch (Exception e){
            System.out.println("the exception is "+e.toString());
        }
        finally {
            System.out.println("I am always going to get executed");
        }
        System.out.println("end of progress");
    }
}
