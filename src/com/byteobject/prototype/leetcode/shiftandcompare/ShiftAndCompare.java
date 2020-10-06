package com.byteobject.prototype.leetcode.shiftandcompare;

public class ShiftAndCompare {

    public static void main(String[] args) {
        System.out.println(rotateString("abcde", "abced"));
    }

    public static boolean rotateString(String A, String B) {
        if (A.equals(B))
            return true;
        boolean retVal = false;
        String toRotate = A;
        for (int i = 0; i < A.length() - 1; i++) {
            toRotate = shiftAndGet(toRotate);
            if (toRotate.equals(B)) {
                retVal = true;
                break;
            }
        }

        return retVal;
    }

    private static String shiftAndGet(String s) {
        char[] chars = s.toCharArray();
        char[] secondPart = new char[chars.length - 1];
        for (int i = 1; i < chars.length; i++) {
            secondPart[i - 1] = chars[i];
        }
        return new String(secondPart) + new String(new char[]{chars[0]});
    }

}
