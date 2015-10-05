package com.github.rutledgepaulv.qbuilders.visitors;

import com.github.rutledgepaulv.base.QBuilderTestBase;

import static org.junit.Assert.assertEquals;

public class RSQLQBuilderTest extends QBuilderTestBase<RSQLVisitor, String> {

    public RSQLQBuilderTest() {

        String_EQ = "myString==abcdefg";
        String_NE = "myString!=abcdefg";
        String_LT = "myString=lt=abcdefg";
        String_GT = "myString=gt=abcdefg";
        String_EX = "myString=ex=true";
        String_DNE = "myString=ex=false";
        String_IN = "myString=in=(a,b,c)";
        String_NIN = "myString=nin=(d,e,f)";

        Boolean_TRUE = "myBoolean==true";
        Boolean_FALSE = "myBoolean==false";
        Boolean_EX = "myBoolean=ex=true";
        Boolean_DNE = "myBoolean=ex=false";

        Short_EQ = "myShort==100";
        Short_NE = "myShort!=100";
        Short_LT = "myShort=lt=100";
        Short_GT = "myShort=gt=100";
        Short_LTE = "myShort=le=100";
        Short_GTE = "myShort=ge=100";
        Short_EX = "myShort=ex=true";
        Short_DNE = "myShort=ex=false";
        Short_IN = "myShort=in=(98,99,100)";
        Short_NIN = "myShort=nin=(101,102,103)";

        Integer_EQ = "myInteger==100";
        Integer_NE = "myInteger!=100";
        Integer_LT = "myInteger=lt=100";
        Integer_GT = "myInteger=gt=100";
        Integer_LTE = "myInteger=le=100";
        Integer_GTE = "myInteger=ge=100";
        Integer_EX = "myInteger=ex=true";
        Integer_DNE = "myInteger=ex=false";
        Integer_IN = "myInteger=in=(98,99,100)";
        Integer_NIN = "myInteger=nin=(101,102,103)";

        Long_EQ = "myLong==100";
        Long_NE = "myLong!=100";
        Long_LT = "myLong=lt=100";
        Long_GT = "myLong=gt=100";
        Long_LTE = "myLong=le=100";
        Long_GTE = "myLong=ge=100";
        Long_EX = "myLong=ex=true";
        Long_DNE = "myLong=ex=false";
        Long_IN = "myLong=in=(98,99,100)";
        Long_NIN = "myLong=nin=(101,102,103)";

        Float_EQ = "myFloat==100.0";
        Float_NE = "myFloat!=100.0";
        Float_LT = "myFloat=lt=100.0";
        Float_GT = "myFloat=gt=100.0";
        Float_LTE = "myFloat=le=100.0";
        Float_GTE = "myFloat=ge=100.0";
        Float_EX = "myFloat=ex=true";
        Float_DNE = "myFloat=ex=false";
        Float_IN = "myFloat=in=(98.0,99.0,100.0)";
        Float_NIN = "myFloat=nin=(101.0,102.0,103.0)";

        Double_EQ = "myDouble==100.0";
        Double_NE = "myDouble!=100.0";
        Double_LT = "myDouble=lt=100.0";
        Double_GT = "myDouble=gt=100.0";
        Double_LTE = "myDouble=le=100.0";
        Double_GTE = "myDouble=ge=100.0";
        Double_EX = "myDouble=ex=true";
        Double_DNE = "myDouble=ex=false";
        Double_IN = "myDouble=in=(98.0,99.0,100.0)";
        Double_NIN = "myDouble=nin=(101.0,102.0,103.0)";


        INLINE_ANDING = "myString==Thing;myLong=ex=false";

        INLINE_ORING = "myString==Thing,myLong=ex=false";

        LIST_ANDING = "(myString==Thing;myLong=ex=false)";

        LIST_ORING = "(myString==Thing,myLong=ex=false)";

        LIST_ORING_OF_INLINE_ANDING = "((myString==Thing;myLong=ex=false),(myString!=Cats;myLong=gt=30))";

        LIST_ANDING_OF_INLINE_ORING = "((myString==Thing,myLong=ex=false);(myString!=Cats,myLong=gt=30))";

        LIST_ANDING_OR_LIST_ORING = "((myString==Thing,myLong=ex=false);(myString!=Cats,myLong=gt=30))," +
                "((myString==Thing;myLong=ex=false),(myString!=Cats;myLong=gt=30))";

        LIST_ORING_AND_LIST_ANDING = "((myString==Thing;myLong=ex=false),(myString!=Cats;myLong=gt=30));" +
                "((myString==Thing,myLong=ex=false);(myString!=Cats,myLong=gt=30))";
    }



    @Override
    protected RSQLVisitor getVisitor() {
        return new RSQLVisitor();
    }

    @Override
    protected void compare(String expected, String converted) {
        assertEquals(expected, converted);
    }

}