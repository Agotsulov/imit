package com.byzilio;

import com.byzilio.arrays.FinanceReport;
import com.byzilio.arrays.Payment;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class FinanceReportTest {


    @Test
    public void testNotNull(){
            assertNotNull(new FinanceReport());
        }

    @Test
    public void testFound() throws IOException {
        Payment p[] = new Payment[3];
        p[0] = new Payment("АФфа",3,3,3,15);
        p[1] = new Payment("Аgasdgisadhghsadbgkjasdkg",5,3,16,15);
        p[2] = new Payment("Ффа",1,1,3,15);

        FinanceReport f = new FinanceReport(p);
        f.found('А');
    }

    @Test
    public void testClone() throws IOException {
        Payment p[] = new Payment[3];
        p[0] = new Payment("АФфа",3,3,3,15);
        p[1] = new Payment("Аgasdgisadhghsadbgkjasdkg",5,3,16,15);
        p[2] = new Payment("Ффа",1,1,3,15);

        FinanceReport f1 = new FinanceReport(p);
        FinanceReport f2 = new FinanceReport(f1);
        f2.set(0,new Payment());
        assertEquals("АФфа",f1.get(0).getName());
        assertEquals("",f2.get(0).getName());

    }


}
