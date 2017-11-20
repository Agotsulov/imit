package com.byzilio.string;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.byzilio.string.StringProcessor.repeat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.fail;

public class StringProcessorTest {


    @DataProvider
    public static Object[][] data() {
        return new Object[][]{
                {"a",5 ,"aaaaa"},
                {"ab-12 ",6,"ab-12 ab-12 ab-12 ab-12 ab-12 ab-12 "},
                {" ",10,"          "},
                {"",15,""},
                {"ab",0,""},
                {"",0,""}
        };
    }

    @Test
    public void testNotNull() {
        assertNotNull(new StringProcessor());
    }

    @Test(dataProvider = "data")
    public void testRepeat(String source, int count, String expected) throws NegativeException {
        assertEquals(repeat(source,count),expected);
    }

    @Test(expectedExceptions = {NegativeException.class})
    public void testNCopyEx() throws NegativeException {
        repeat("asd", -4);
        fail();
    }

    @Test
    public void testIndexOf(){
        StringProcessor v = new StringProcessor();

        assertEquals(v.indexOf("sacababab","a"),4);
        assertEquals(v.indexOf("xza1b,bjs124a1a1bba1b1kb51a1b51gjkabga1bjkansdg","a1b"),5);
        assertEquals(v.indexOf("ssssssssssssss","1"),0);


    }

    @Test
    public void testReplace(){
        StringProcessor v = new StringProcessor();

        assertEquals(v.replace("a1b3c2"),"aодинbтриcдва");
        assertEquals(v.replace("asd"),"asd");
        assertEquals(v.replace(""),"");
    }

    @Test
    public void testDeleteEven(){
        StringProcessor v = new StringProcessor();
        StringBuilder sb = new StringBuilder("a,b,c,d,f");
        v.deleteEven(sb);
        assertEquals(new String(sb),",,,,");

        sb = new StringBuilder(" a ");
        v.deleteEven(sb);
        assertEquals(new String(sb),"a");

        sb = new StringBuilder("a");
        v.deleteEven(sb);
        assertEquals(sb.toString(),"");
        v.deleteEven(sb);
        assertEquals(sb.toString(),"");
    }

    @Test
    public void testReplaceFirstLast(){
        StringProcessor v = new StringProcessor();
        StringBuilder sb = new StringBuilder("a b c d f");
        v.replaceFirstLast(sb);
        assertEquals(sb.toString(),"f b c d a");

        sb = new StringBuilder(" a b c d f ");
        v.replaceFirstLast(sb);
        assertEquals(sb.toString()," f b c d a ");


        sb = new StringBuilder(" aagda baga cagan dbvxb fbxbcbc ");
        v.replaceFirstLast(sb);
        assertEquals(sb.toString()," fbxbcbc baga cagan dbvxb aagda ");


        sb = new StringBuilder("a      b   c   d                    f");
        v.replaceFirstLast(sb);
        assertEquals(sb.toString(),"f      b   c   d                    a");

        sb = new StringBuilder("");
        v.replaceFirstLast(sb);
        assertEquals(sb.toString(),"");

        sb = new StringBuilder("   bnmbnmbmn   ");
        v.replaceFirstLast(sb);
        assertEquals(sb.toString(),"   bnmbnmbmn   ");


    }

    @Test
    public void testReplace16(){
        StringProcessor v = new StringProcessor();
        String s = new String("Васе 0x00000010 лет");

        assertEquals(v.replace16(s),"Васе 16 лет");

        s = new String("Васе 0x00000D56C лет");

        assertEquals(v.replace16(s),"Васе 54636 лет");


        s = new String("Васе 0x00000D56C 0x00000D56C 0x00000D56C лет");

        assertEquals(v.replace16(s),"Васе 54636 54636 54636 лет");


    }
}