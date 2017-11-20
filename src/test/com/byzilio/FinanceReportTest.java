package com.byzilio;

import com.byzilio.arrays.FinanceReport;
import com.byzilio.arrays.Payment;
import org.testng.annotations.Test;

import java.io.*;

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


    @Test
    public void testFoundLess() throws IOException {
        Payment p[] = new Payment[6];
        p[0] = new Payment("АФфа",3,3,3,11325);
        p[1] = new Payment("Аgasdgisadhghsadbgkjasdkg",5,3,16,15);
        p[2] = new Payment("Ффа",1,1,3,141215);
        p[3] = new Payment("фыафыФфа",12,2,18,512505);
        p[4] = new Payment("Фтывптатапфа",14,3,5,5);
        p[5] = new Payment("Ффчсичсча",16,12,31,611251205);

        Payment expexted[] = {p[0], p[1], p[4]};
        FinanceReport f = new FinanceReport(p);
        f.foundLess(20000);
    }


    @Test
    public void testSumAll() throws IOException {
        Payment p[] = new Payment[6];
        p[0] = new Payment("АФфа",3,3,3,155);
        p[1] = new Payment("Аgasdgisadhghsadbgkjasdkg",3,3,3,223);
        p[2] = new Payment("Ффа",15,1,7,6105);
        p[3] = new Payment("фыафыФфа",12,2,18,512505);
        p[4] = new Payment("Фтывптатапфа",14,3,5,5);
        p[5] = new Payment("Ффчсичсча",16,12,31,611251205);

        FinanceReport f  = new FinanceReport(p);


        assertEquals(f.sumDate("3.3.3"),378);
    }

    @Test
    public void testGetMonthsWithOutP() throws IOException {
        Payment p[] = new Payment[6];
        p[0] = new Payment("АФфа",5,4,3,155);
        p[1] = new Payment("Аgasdgisadhghsadbgkjasdkg",3,3,3,223);
        p[2] = new Payment("Ффа",15,1,7,6105);
        p[3] = new Payment("фыафыФфа",5,3,18,512505);
        p[4] = new Payment("Фтывптатапфа",14,3,5,5);
        p[5] = new Payment("Ффчсичсча",5,12,31,611251205);

        FinanceReport f  = new FinanceReport(p);

        String s[] = f.getMonthsWithOutP(5);
        String r[] = {"Март","Апрель","Декабрь"};

        assertEquals(s, new String[]{"Март","Апрель","Декабрь"});
        assertEquals(f.getMonthsWithOutP(5)[2],"Декабрь");
    }


    @Test
    public void testInput() throws IOException {
        FinanceReport f  = new FinanceReport();

        FileInputStream fis = new FileInputStream(new File("input.txt"));
        f.read(fis);

        f.write(System.out);
    //  fis.close();
    }

    @Test
    public void testOutput() throws IOException {
        Payment p[] = new Payment[6];
        p[0] = new Payment("АФфа",5,4,3,155);
        p[1] = new Payment("Аgasdgisadhghsadbgkjasdkg",3,3,3,223);
        p[2] = new Payment("Ффа",15,1,7,6105);
        p[3] = new Payment("фыафыФфа",5,3,18,512505);
        p[4] = new Payment("Фтывптатапфа",14,3,5,5);
        p[5] = new Payment("Ффчсичсча",5,12,31,611251205);

        FinanceReport f  = new FinanceReport(p);

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        f.write(System.out);
    }


}
