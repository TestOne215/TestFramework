package Day2;

public class Common_arithemetics{
     //1.local variable for eg num1 and num2 used in method
    //2.Instance variable
         int j=0;
    //3.class variable or static
         static int k=0;


   //increment values
   void increment(){
       j++;
       k++;
   }
   int add(int num1, int num2) {
       int  s= num1 + num2 ;
       return s;

    }


    int mult(int num1,int num2) {
       return num1*num2;
    }

    int subt(int num1,int num2) {
        return num1-num2;
    }

    static void addk(){ //static method not normal method
       ++k;
       //++j;
       System.out.println("value of k:" +k);
       //System.out.println("value of j:" +j);
    }



}
