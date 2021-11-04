package Day15;

public class AgeCalc {
    public void AgeCalculation(int age) throws Exception {
      if(age<4){
           throw new Exception("OH HE IS A KID");
      }else if(age>4 && age<=18){
           System.out.println("He is a minor");
      }else{
          System.out.println("He is a major");
      }
    }
}
