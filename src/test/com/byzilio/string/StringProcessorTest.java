package com.byzilio.string;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.AssertJUnit.assertTrue;

public class StringProcessorTest {


    @Test
    public void testNotNull() {
        assertNotNull(new StringProcessor());
    }

    @Test
    public void testRepeat(){
        StringProcessor v = new StringProcessor();


        try {
            assertEquals(v.repeat("a",5),"aaaaa");
            assertEquals(v.repeat("ab-12 ",6),"ab-12 ab-12 ab-12 ab-12 ab-12 ab-12 ");
            assertEquals(v.repeat(" ",10),"          ");
            assertEquals(v.repeat("",15),"");
            assertEquals(v.repeat("ab",0),"");
            assertEquals(v.repeat("ab",-5),"");
        } catch (NegativeException e) {
            e.printStackTrace();
        }

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

        sb = new StringBuilder("aa");
        v.deleteEven(sb);
        assertEquals(new String(sb),"a");
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


        sb = new StringBuilder(" aagdafa baga cagan dbvxb fbxbcbc ");
        v.replaceFirstLast(sb);
        assertEquals(sb.toString()," fbxbcbc baga cagan dbvxb aagdafa ");


        sb = new StringBuilder("a      b   c   d                    f");
        v.replaceFirstLast(sb);
        assertEquals(sb.toString(),"f      b   c   d                    a");

        sb = new StringBuilder("       a    b    c    d   f   ");
        v.replaceFirstLast(sb);
        assertEquals(sb.toString(),"       f    b    c    d   a   ");


    }

    @Test
    public void testReplace16(){
        StringProcessor v = new StringProcessor();
        String s = new String("Васе 0x00000010 лет");

        assertEquals(v.replace16(s),"Васе 16 лет");

        s = new String("Васе 0x00000D56C лет");

        assertEquals(v.replace16(s),"Васе 54636 лет");


    }
}