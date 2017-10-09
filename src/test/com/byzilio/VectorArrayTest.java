package com.byzilio;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.AssertJUnit.assertTrue;

public class VectorArrayTest {


    @Test
    public void testNotNull(){
        assertNotNull(new Vector3DArray(10));
    }

    @Test
    public void testLength(){
        Vector3DArray v = new Vector3DArray(20);
        assertEquals(v.length(),20);
    }


    @Test
    public void testI(){
        Vector3DArray v = new Vector3DArray(20);
        Vector3D i = new Vector3D(3,3,3);
        v.set(4,i);
        assertEquals(v.get(4),i);
    }


    @Test
    public void testMaxVectorLength(){
        Vector3DArray v = new Vector3DArray(20);
        Vector3D mV = new Vector3D(10,10,10);
        v.set(14,mV);
        v.set(4,new Vector3D(3,1,2));
        v.set(7,new Vector3D(5,2,1));
        v.set(19,new Vector3D(2,9,0));
        assertEquals(v.maxLength(),mV);
    }

    @Test
    public void testFound(){
        Vector3DArray v = new Vector3DArray(10);
        Vector3D f = new Vector3D(10,10,10);
        v.set(8,f);
        v.set(4,new Vector3D(3,1,2));
        v.set(1,new Vector3D(1,1,1));
        v.set(7,new Vector3D(5,2,1));
        v.set(9,new Vector3D(2,9,0));
        assertEquals(v.found(f),8);
    }


    @Test
    public void testSum(){
        Vector3DArray v = new Vector3DArray(10);
        Vector3D sum = new Vector3D(1,1,1);
        Vector3DProcessor p = new Vector3DProcessor();

        sum = p.sum(sum,new Vector3D(3,1,2));
        sum = p.sum(sum,new Vector3D(5,2,1));
        sum = p.sum(sum,new Vector3D(2,9,0));

        v.set(1,new Vector3D(1,1,1));
        v.set(4,new Vector3D(3,1,2));
        v.set(7,new Vector3D(5,2,1));
        v.set(9,new Vector3D(2,9,0));

        assertEquals(v.sumAll(),sum);
        //А он сравнивает ссылки или переопределеную функцию использует?

    }


    @Test
    public void testFactor(){
        Vector3DArray v = new Vector3DArray(2);

        Vector3D v1 = new Vector3D(1,1,1);
        Vector3D v2 = new Vector3D(2,2,0);

        v.set(0,v1);
        v.set(1,v2);

        Vector3D c[] = new Vector3D[2];

        c[0] = new Vector3D(10,3,2);
        c[1] = new Vector3D(1,1,1);

        Vector3D r[] = new Vector3D[2];

        try {
            r = v.factor(c);
        } catch (DiffLengthException e) {
            e.printStackTrace();
        }


        assertTrue(r[0].equals(new Vector3D(10,3,2)));
        assertTrue(r[1].equals(new Vector3D(2,2,0)));

    }


    @Test
    public void testMove(){
        Vector3DArray v = new Vector3DArray(2);

        Vector3D v1 = new Vector3D(1,1,1);
        Vector3D v2 = new Vector3D(2,-3,0);

        v.set(0,v1);
        v.set(1,v2);

        Point3D p = new Point3D(0,8,-1);

        Point3D r[];

        r = v.move(p);


        assertTrue(r[0].equals(new Point3D(1,9,0)));
        assertTrue(r[1].equals(new Point3D(2,5,-1)));

    }



    }
