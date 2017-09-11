package byzilio;

public class Point3D {

    double x,y,z;

    public Point3D(){
        x = 0;
        y = 0;
        z = 0;
    }

    public Point3D(double x,double y,double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void print(){
        System.out.println("(" + x + "," + y + "," + z + ")");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point3D)) return false;

        Point3D point3D = (Point3D) o;

        if (Double.compare(point3D.getX(), getX()) != 0) return false;
        if (Double.compare(point3D.getY(), getY()) != 0) return false;
        return Double.compare(point3D.getZ(), getZ()) == 0;
    }


    public void setX(double x) {

        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getX() {

        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }
}
