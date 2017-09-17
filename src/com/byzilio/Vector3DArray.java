package byzilio;

public class Vector3DArray {

    int length;
    Vector3D array[];

    public Vector3DArray(int length){
        this.length = length;
        array = new Vector3D[this.length];
    }

    public Vector3D get(int i) {
        return array[i];
    }


    public void set(int i,Vector3D v) {
        array[i] = v;
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

    public Point3D[] move(Point3D p){
        Point3D pm[] = new Point3D[length];
        for(int i = 0;i < length;i++){
            pm[i] = new Point3D(p.x + array[i].getCenter().x,p.y + array[i].getCenter().y,p.z + array[i].getCenter().z);
        }
        return pm;
    }

    public Vector3D sumAll(){
        Vector3D sum = new Vector3D(0,0,0);
        Vector3DProcessor vp = new Vector3DProcessor();
            for(int i = 0;i < length;i++){
            sum = vp.sum(sum,array[i]);
        }
        return sum;
    }

}

