/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package homework;
import java.util.Arrays;
import java.util.Comparator;
/**
 *
 * @author Ivan
 */
public class Triangle {
    private double x1;
    private double x2;
    private double y1;
    private double y2;
    private double z1;
    private double z2;
    //конструктор по умолчанию
    public Triangle()
    {
        x1=0;
        x2=0;
        y1=0;
        y2=0;
        z1=0;
        z2=0;
    }
    
    public Triangle (double x1,double x2, double y1, double y2, double z1, double z2)
    {
        this.x1=x1;
        this.x2=x2;
        this.y1=y1;
        this.y2=y2;
        this.z1=z1;
        this.z2=z2;
        if (Math.abs((y1-x1)*(z2-x2)-(z1-x1)*(y2-x2))/2==0)
        {
            throw new IllegalArgumentException("точки лежат на 1 прямой");
        }
    }
    
    public double getX1()
    {
        return x1;
    }
    
    public void setX1(double x1)
    {
        this.x1=x1;
    }
    
   public double getX2()
    {
        return x2;
    }
    
    public void setX2(double x2)
    {
        this.x2=x2;
    }
    
    public double getY1()
    {
        return y1;
    }
    
    public void setY1(double y1)
    {
        this.y1=y1;
    }
    
    public double getY2()
    {
        return y2;
    }
    
    public void setY2(double y2)
    {
        this.y2=y2;
    }
    
    public double getZ1()
    {
        return z1;
    }
    
    public void setZ1(double z1)
    {
        this.z1=z1;
    }
    
    public double getZ2()
    {
        return z2;
    }
    
    public void setZ2(double z2)
    {
        this.z2=z2;
    }
    
    public Triangle (Triangle triangle)
    {
        this.x1 = triangle.x1;
        this.x2 = triangle.x2;
        this.y1 = triangle.y1;
        this.y2 = triangle.y2;
        this.z1 = triangle.z1;
        this.z2 = triangle.z2;
    }
    
    //Высчитывание периметра треугольника
    public double perimeter()
    {
        double perim =(Math.sqrt((y1-x1)*(y1-x1)+(y2-x2)*(y2-x2))+ Math.sqrt((z1-y1)*(z1-y1)+(z2-y2)*(z2-y2))+Math.sqrt((z1-x1)*(z1-x1)+(z2-x2)*(z2-x2)));
        return perim;
    }
       
    public double square()
    {
        double sqr = Math.abs((y1-x1)*(z2-x2)-(z1-x1)*(y2-x2))/2;
        return sqr;
    }
    
     @Override
    public String toString()
    {
        return "X1="+x1+" Y1="+x2+" X2="+y1+" Y2="+y2+" X3="+z1+" Y3="+z2 + " Периметр:"+ perimeter()+ " Площадь: "+ square();
    }
     
}
