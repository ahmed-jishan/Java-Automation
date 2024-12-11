package jishan;

public class Hello {
//int numb = 100;//method er bahire and class er moddhe jei variable thake seta instance ba non static variable
    //static int numb = 100; variable er sathe static ache tai eta global variable
    String text = "Hello";
    public static void main(String[] args) {
        //System.out.println("Hello world");
        //primitive data type
        //syntax: variable_type variable name = variable value
        int num = 100; //main method er modde jei variable thake seta local variable.
        float num2 = 10.55f;
        double num3 = 123456789;
        char alph = 'a';
        boolean bool = true;

        /*System.out.println("Integer Number: " +num);
        System.out.println("Float Number: " +num2);
        System.out.println("Double Number: " +num3);
        System.out.println("Charecter Value: " +alph);
        System.out.println("Boolean Value: " +bool);*/

        //System.out.println("Integer Number: "+num+"\n Float Number: "+num2+"\n Double Number: "+num3+"\n  Charecter Value: "+alph+"\n Boolean Value: "+bool);

        //non premitive datatype
        String name = "Jishan Ahmed";
        int[] numbers = {1,2,3,4,5};
        System.out.println("Name: "+name);
        System.out.println("Numbers: "+numbers[2]);


        //object syntax: classname objectname = new classname()
        Hello obj = new Hello();//instance variable access korar jonno object dorker.
        System.out.println(obj.text);
    }
}
