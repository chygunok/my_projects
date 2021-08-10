/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package homework;

import java.util.Comparator;

/**
 *
 * @author Ivan
 */
public class TriangleComparator implements Comparator<Triangle>{
    @Override
    public int compare(Triangle triangle1,Triangle triangle2)
    {
        if (triangle1.square() == triangle2.square()) {
            return 0;
        }
        if (triangle1.square() > triangle2.square()) {
            return 1;
        }
        else {
            return -1;
        }
    }
}

