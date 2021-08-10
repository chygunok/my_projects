package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.lang.Math;

public class MyСircle {

    private SimpleStringProperty line;
    private String line1;
    public MyСircle(String line) {
        this.line1 = line;
        this.line = new SimpleStringProperty(line);
    }

  public String getLine(){
      return line.get();
  }
  public void setLine(String line)
  {
      this.line.set(line);
  }
    public String Max()
    {
        String[] strings = this.line1.split(",");
        int len = strings.length;
        int [] seq = new int[len];
        for (int i=0;i<len;i++)
        {
            seq[i]=Integer.parseInt(strings[i]);
        }
        int max=seq[0];
        for(int i=1;i<len;i++)
        {
            if (max < seq[i])
            {
                max=seq[i];
            }
        }
        return Integer.toString(max);
    }
    public String Min()
    {
        String[] strings = this.line1.split(",");
        int len = strings.length;
        int [] seq = new int[len];
        for (int i=0;i<len;i++)
        {
            seq[i]=Integer.parseInt(strings[i]);
        }
        int min=seq[0];
        for(int i=1;i<len;i++)
        {
            if (min > seq[i])
            {
                min=seq[i];
            }
        }
        return Integer.toString(min);
    }
    public String SrAr()
    {
        String[] strings = this.line1.split(",");
        int len = strings.length;
        int [] seq = new int[len];
        for (int i=0;i<len;i++)
        {
            seq[i]=Integer.parseInt(strings[i]);
        }
        int srar=0;
        for(int i=0;i<len;i++)
        {
            srar+=seq[i];
        }
        srar=srar/len;
        return Integer.toString(srar);
    }
    public int[] Mass()
    {
        String[] strings = this.line1.split(",");
        int len = strings.length;
        int [] mass = new int[len];
        for (int i=0;i<len;i++)
        {
            mass[i]=Integer.parseInt(strings[i]);
        }
        return mass;
    }
}
