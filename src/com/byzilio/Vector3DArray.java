package com.byzilio;

class DiffLengthException extends Exception{
    public DiffLengthException() {
        //initCause(e);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
}

public class Vector3DArray {

    private int length;
    private Vector3D array[];

    public Vector3DArray(int length){
        this.length = length;
        array = new Vector3D[this.length];
        for( int i=0; i< array.length; i++){
            array[i]=new Vector3D();
        }
    }

    public Vector3D get(int i) {
        return array[i];
    }


    public void set(int i,Vector3D v) {

        array[i] = new Vector3D(v.getCenter().x,v.getCenter().y,v.getCenter().z);
    }

    public int length(){
        return length;
    }

    public Vector3D maxLength(){
        double maxL = 0;
        Vector3D maxV = new Vector3D(0,0,0);
        for(int i = 0;i < length;i++){
            if(array[i].length() >= maxL){
                maxL = array[i].length();
                maxV = array[i];
            }
        }
        return maxV;
    }

    public int found(Vector3D v){
        for(int i = 0;i < length;i++){
            if(array[i].equals(v)){
                return i;
            }
        }
        return -1;
    }

    public Vector3D[] factor(double[] c) throws DiffLengthException {
        Vector3D result[] = new Vector3D[length];

        for(int i = 0;i < c.length;i++){
            result[i] = new Vector3D(array[i].getCenter().x * c[i],array[i].getCenter().y * c[i],array[i].getCenter().z * c[i]);
        }
        if( 0 != (length - c.length) ){
            throw new DiffLengthException();
        }
        for(int i = 0;i < (length - c.length);i++){
            result[i] = new Vector3D(0,0,0);
        }

        return result;
    }

    public Point3D[] move(Point3D p){
        Point3D pm[] = new Point3D[length];
        for(int i = 0;i < length;i++){
            pm[i] = new Point3D(p.x + array[i].getCenter().x,p.y + array[i].getCenter().y,p.z + array[i].getCenter().z);
        }
        return pm;
    }

    public Vector3D sumAll(){
        Vector3D sum = new Vector3D(0,0,0);
       // Vector3DProcessor vp = new Vector3DProcessor();
            for(int i = 0;i < length;i++){
            sum = Vector3DProcessor.sum(sum,array[i]);
        }
        return sum;
    }

}

