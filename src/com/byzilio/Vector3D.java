package byzilio;


public class Vector3D {

    Point3D start;
    Point3D end;


    public Vector3D() {
        this.start = new Point3D(0,0,0);
        this.end = new Point3D(0,0,0);
    }

    public Vector3D(double x1,double y1,double z1,double x2,double y2,double z2) {
        this.start = new Point3D(x1,y1,z1);
        this.end = new Point3D(x2,y2,z2);
    }

    public Vector3D(Point3D start, Point3D end) {
        this.start = start;
        this.end = end;
    }


    public double length(){
        return Math.sqrt( (end.x - start.x)*(end.x - start.x) + (end.y - start.y)*(end.y - start.y) + (end.z - start.z)*(end.z - start.z) );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vector3D)) return false;

        Vector3D vector3D = (Vector3D) o;

        if (start != null ? !start.equals(vector3D.start) : vector3D.start != null) return false;
        return end != null ? end.equals(vector3D.end) : vector3D.end == null;
    }

}
