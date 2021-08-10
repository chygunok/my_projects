package Ivan;

public abstract class Shape
{
   public void draw(int x, int y)
   {
      System.out.println("x+y = " + x+y);
   }

   abstract public void hello();
}
