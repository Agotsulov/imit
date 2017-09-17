package byzilio;

public class Vector3DProcessor {

    public Vector3D sum(Vector3D a,Vector3D b){
        return new Vector3D(a.getCenter().x + b.getCenter().x, a.getCenter().y + b.getCenter().y, a.getCenter().z + b.getCenter().z);
    }


    public Vector3D diff(Vector3D a,Vector3D b){
        return new Vector3D(a.getCenter().x - b.getCenter().x, a.getCenter().y - b.getCenter().y, a.getCenter().z - b.getCenter().z);
    }

    public double scalar(Vector3D a,Vector3D b){
        return (a.getCenter().x * b.getCenter().x + a.getCenter().y * b.getCenter().y + a.getCenter().z * b.getCenter().z);
    }

    public Vector3D vector(Vector3D a,Vector3D b){
        return new Vector3D(a.getCenter().y * b.getCenter().z - a.getCenter().z * b.getCenter().x,
                a.getCenter().z * b.getCenter().x - a.getCenter().x * b.getCenter().z,
                a.getCenter().x * b.getCenter().y - a.getCenter().y * b.getCenter().x);
    }

    public boolean colline(Vector3D a,Vector3D b){
        if(vector(a, b).length() == 0){
            return true;
        }
        return false;
    }

}
