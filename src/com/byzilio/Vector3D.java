package com.byzilio;


public class Vector3D {

    private Point3D start;
    private Point3D end;
    private Point3D center;

    public Vector3D() {
        this.start = new Point3D(0,0,0);
        this.end = new Point3D(0,0,0);
        this.center = new Point3D(end.x - start.x,end.y - start.y,end.z - start.z);
    }

    public Vector3D(double x,double y,double z){
        this.center = new Point3D(x,y,z);
        this.start = new Point3D(0,0,0);
        this.end = new Point3D(0,0,0);
    }

    public Vector3D(double x1,double y1,double z1,double x2,double y2,double z2) {
        this.start = new Point3D(x1,y1,z1);
        this.end = new Point3D(x2,y2,z2);
        this.center = new Point3D(end.x - start.x,end.y - start.y,end.z - start.z);
    }

    public Vector3D(Point3D start, Point3D end) {
        this.start = start;
        this.end = end;
        this.center = new Point3D(end.x - start.x,end.y - start.y,end.z - start.z);
    }


    public double length(){
        return Math.sqrt( (center.x)*(center.x) + (center.y)*(center.y) + (center.z)*(center.z) );
    }

    public void setStart(Point3D start) {
        this.start = start;
        center.x = end.x - start.x;
        center.y = end.y - start.y;
        center.z = end.z - start.z;
    }

    public void setEnd(Point3D end) {
        this.end = end;
        center.x = end.x - start.x;
        center.y = end.y - start.y;
        center.z = end.z - start.z;
    }

    public Point3D getCenter() {
        return center;
    }

    public Point3D getStart() {
        return start;
    }

    public Point3D getEnd() {
        return end;
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
