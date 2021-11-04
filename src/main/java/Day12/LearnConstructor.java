package Day12;

public class LearnConstructor {
    public int a;
    public int b;
 public LearnConstructor(){
     this.a=10;
     this.b=30;
 }
    public LearnConstructor(int a,int b){
        this.a=a;
        this.b=b;
    }
    public void setVal(int a,int b){
        this.a=a;
        this.b=b;
    }

    public int sum(){
        return a+b;
    }
}
