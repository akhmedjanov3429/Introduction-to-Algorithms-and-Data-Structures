/******************************************************************************
 *  Compilation:  javac Value.java
 *  Execution:    java Value  (interactive test of basic functionality)
 *  Dependencies: none
 *
 *  Author: Jiang Long 
 *
 *  Untyped value ADT.
 * 
 ******************************************************************************/
import java.util.Arrays;
public class Value{
    
    //--------------------------------------------------------------------
    // Enum types and static variables
    //--------------------------------------------------------------------
    public enum ValueType {
        LONG,
        DOUBLE, 
        STRING
    } ;
    public static final ValueType STRING = ValueType.STRING;
    public static final ValueType LONG = ValueType.LONG;
    public static final ValueType DOUBLE = ValueType.DOUBLE;


    //--------------------------------------------------------------------
    // member variable: valType, longVal, strVal, doubleVal
    //--------------------------------------------------------------------
    // Complete the code here, see README on course website for problem description and instructions.
    private ValueType valType;
    private long longVal;
    private String strVal;
    private double doubleVal;
    // Constructors
    //--------------------------------------------------------------------
    // Complete the code here, see README on course website for problem description and instructions.

    public Value(long val){
        this.longVal = val;
        this.valType = LONG;
    }

    public Value(double val){
        this.doubleVal = val;
        this.valType = DOUBLE;
    }

    public Value(String val){
        this.strVal = val;
        this.valType = STRING;
    }
    //--------------------------------------------------------------------
    // static method : __add__(a,b)
    //--------------------------------------------------------------------
    // Complete the code here, see README on course website for problem description and instructions.

    public static Value __add__(Value a, Value b){
    if(a.valType == LONG && b.valType == LONG){
        return new Value(a.longVal + b.longVal);
    }else if(a.valType == LONG && b.valType == DOUBLE){
        return new Value(a.longVal + b.doubleVal);
    }else if(a.valType == DOUBLE && b.valType == LONG){
        return new Value(a.doubleVal + b.longVal);
    }else if(a.valType == DOUBLE && b.valType == DOUBLE){
        return new Value(a.doubleVal + b.doubleVal);
    }else if(a.valType == LONG && b.valType == STRING){
        return new Value(a.longVal + b.strVal);
    }else if(a.valType == DOUBLE && b.valType == STRING){
        return new Value(a.doubleVal + b.strVal);
    }else if(a.valType == STRING && b.valType == LONG){
        return new Value(a.strVal + b.longVal);
    }else if(a.valType == STRING && b.valType == DOUBLE){
        return new Value(a.strVal + b.doubleVal);
    }else if(a.valType == STRING && b.valType == STRING){
        return new Value(a.strVal + b.strVal);
    }
    return null;
}



    //--------------------------------------------------------------------
    // instance method : a.__add__(b)
    //--------------------------------------------------------------------
    // Complete the code here, see README on course website for problem description and instructions.
    public Value __add__(Value b){
        return Value.__add__(this, b);
    }




    //--------------------------------------------------------------------
    // __str__
    //--------------------------------------------------------------------
    public String toString(){
        if (valType == LONG) return ""+longVal;
        else if (valType == STRING) return strVal;
        else if (valType == DOUBLE) return ""+doubleVal;
        assert (false);
        return null;
    }

    //--------------------------------------------------------------------
    // Generic print method
    //--------------------------------------------------------------------
    public static <E> void  TPrint(String tag, E e){
        System.out.println(tag + " " + e);
    }

    public static <E> void  TPrint(String tag, E[] e){
        System.out.println(tag + " " + Arrays.toString(e));
    }

    //--------------------------------------------------------------------
    // test client: don't touch below this line
    //--------------------------------------------------------------------
    public static void main(String [] args){

        Value a = new Value(Long.parseLong(args[0])); // long 
        Value b = new Value(Double.parseDouble(args[1])); // double
        Value c = new Value(args[2]);
        
        Value [] vx = { a,b,c};
        TPrint("a =", a);
        TPrint("b =", b);
        TPrint("c =", c);

        TPrint("a+a =", a.__add__(a));
        TPrint("b+b =", b.__add__(b));
        TPrint("c+c =", c.__add__(c));

        TPrint("a+b =", a.__add__(b));
        TPrint("a+c =", a.__add__(c));
        TPrint("b+c =", b.__add__(c));
        TPrint("c+b =", c.__add__(b));

        TPrint("b+c =", __add__(b,c));
        TPrint("c+b =", __add__(c,b));

        TPrint("a+a+a =", a.__add__(a).__add__(a));
        TPrint("b+b+b =", b.__add__(b).__add__(b));
        TPrint("c+c+c =", c.__add__(c).__add__(c));

        TPrint("vx =", vx);
     }

};
 