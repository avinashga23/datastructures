package com.byteobject.prototype.datastructures.numberline;

public class NumberLineJump {

    static String kangaroo(int x1, int v1, int x2, int v2) {
        if (x1 == x2) {
            if (v1 == v2)
                return "YES";
            else
                return "NO";
        } else {
            if (x1 > x2) {
                if (v1 < v2) {
                    int firstPos = x1;
                    int secondPos = x2;
                    while (firstPos >= secondPos) {
                        if (firstPos == secondPos)
                            return "YES";
                        firstPos += v1;
                        secondPos += v2;
                    }
                }
            } else {
                if (v2 < v1) {
                    int firstPos = x1;
                    int secondPos = x2;
                    while (secondPos >= firstPos) {
                        if (secondPos == firstPos)
                            return "YES";
                        firstPos += v1;
                        secondPos += v2;
                    }
                }
            }
            return "NO";
        }
    }

    public static void main(String[] args) {
        System.out.println(kangaroo(0,2,5,3));
    }

}
