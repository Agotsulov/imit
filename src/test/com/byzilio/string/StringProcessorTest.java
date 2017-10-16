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

        assertEquals(v.repeat("a",5),"aaaaa");
    }


    @Test
    public void testIndexOf(){
        StringProcessor v = new StringProcessor();

        assertEquals(v.indexOf("sacababab","a"),4);
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

    }

    @Test
    public void testReplace16(){
        StringProcessor v = new StringProcessor();
        String s = new String("Васе 0x00000010 лет");

        assertEquals(v.replace16(s),"Васе 16 лет");


    }
}