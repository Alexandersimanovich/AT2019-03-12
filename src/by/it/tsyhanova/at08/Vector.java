package by.it.tsyhanova.at08;

import java.util.Arrays;

public class Vector extends Var {

    private double[] value;

    public Vector(double[] value) {
        this.value = Arrays.copyOf(value,value.length);
    }


    public Vector(String strVector) {
        String[] s = strVector.replace("{", "").replace("}", "").split(",\\s*");
        value=new double[s.length];
        for (int i = 0; i < s.length; i++) {
            value[i]=Double.parseDouble(s[i]);
        }
    }

    public Vector(Vector vector) {
        this.value=Arrays.copyOf(vector.value,vector.value.length);
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            double[] res=Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i]+((Scalar) other).value;
            }
            return new Vector(res);
        }
        else if (other instanceof Vector){
            double[] res=Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i]+((Vector) other).value[i];
            }
            return new Vector(res);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar){
            double[] res=Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i]-((Scalar) other).value;
            }
            return new Vector(res);
        }
        else if (other instanceof Vector){
            double[] res=Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i]-((Vector) other).value[i];
            }
            return new Vector(res);
        }
        return super.add(other);
    }

    @Override
    public Var mul(Var other) {
        double multy=0.0;
        if (other instanceof Scalar){
            double[] res=Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i]*((Scalar) other).value;
            }
            return new Vector(res);
        }
        else if (other instanceof Vector){
            double[] res=Arrays.copyOf(value,value.length);

            for (int i = 0; i < res.length; i++) {
                res[i]=res[i]*((Vector) other).value[i];
                multy=multy+res[i];
            }
            return new Scalar(multy);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar){
            double[] res=Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i]*1/((Scalar) other).value;
            }
            return new Vector(res);
        }
        else if (other instanceof Vector) {
            return super.div(other);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        return Arrays.toString(value).replace('[','{').replace(']','}');
    }
}
