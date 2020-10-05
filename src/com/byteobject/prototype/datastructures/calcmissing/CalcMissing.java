package com.byteobject.prototype.datastructures.calcmissing;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CalcMissing {

    public static void calcMissing(List<String> readings) {
        List<String> values = readings.stream().map(s -> s.split("\\t")[1]).collect(Collectors.toList());
       for (int i = 0; i < readings.size(); i++) {
           if (values.get(i).startsWith("Miss")) {
               if (i == 0) {
                   int currentIndex = i;
                   double toPrint = 0;

                   double nextValue = Double.valueOf(getNextValidValueAfterIndex(currentIndex, values));
                   double valueAfterNext = Double.valueOf(getNextValidValueAfterIndex(currentIndex + 1, values));
                   toPrint = (nextValue + valueAfterNext)/2;
                   System.out.println(toPrint);
               } else if (i == values.size() - 1) {
                   int currentIndex = i;
                   double toPrint = 0;
                   double previousValue = Double.valueOf(getPreviousValidValueBeforeIndex(currentIndex, values));
                   double valueBeforePrevious = Double.valueOf(getPreviousValidValueBeforeIndex(currentIndex - 1, values));
                   toPrint = (previousValue + valueBeforePrevious)/2;
                   System.out.println(toPrint);
               } else {
                   int currentIndex = i;
                   double toPrint = 0;
                   double previousValue = Double.valueOf(getPreviousValidValueBeforeIndex(currentIndex, values));
                   double nextValue = Double.valueOf(getNextValidValueAfterIndex(currentIndex, values));
                   toPrint = (previousValue + nextValue)/2;
                   System.out.printf("%.2f", toPrint);
                   System.out.println();
               }

           }
       }
    }

    private static String getNextValidValueAfterIndex(int index, List<String> values) {
        String retVal = "0";
        for (int i = index + 1; i < values.size(); i++) {
            if (values.get(i).startsWith("Missing"))
                continue;
            else {
                retVal = values.get(i);
                break;
            }
        }

        return  retVal;
    }

    private static String getPreviousValidValueBeforeIndex(int index, List<String> values) {
        String retVal = "0";
        for (int i = index - 1; i >= 0; i--) {
            if (values.get(i).startsWith("Missing"))
                continue;
            else {
                retVal = values.get(i);
                break;
            }
        }

        return  retVal;
    }

    public static void main(String[] args) {
        List<String> missingArr = Arrays.asList(
                "1/3/201216:00:00	26.96",
                "1/4/201216:00:00	27.47",
                "1/5/201216:00:00	27.728",
                "1/6/201216:00:00	28.19",
                "1/9/201216:00:00	28.1",
                "1/10/201216:00:00	28.15",
                "1/11/201216:00:00	27.98",
                "1/12/201216:00:00	28.02",
                "1/13/201216:00:00	28.25",
                "1/17/201216:00:00	28.65",
                "1/18/201216:00:00	28.4",
                "1/19/201216:00:00	28.435",
                "1/20/201216:00:00	29.74",
                "1/23/201216:00:00	29.95",
                "1/24/201216:00:00	29.5703",
                "1/25/201216:00:00	29.65",
                "1/26/201216:00:00	29.7",
                "1/27/201216:00:00	29.53",
                "1/30/201216:00:00	29.62",
                "1/31/201216:00:00	29.7",
                "2/1/201216:00:00	30.05",
                "2/2/201216:00:00	30.17",
                "2/3/201216:00:00	30.4",
                "2/6/201216:00:00	30.22",
                "2/7/201216:00:00	30.485",
                "2/8/201216:00:00	30.67",
                "2/9/201216:00:00	30.8",
                "2/10/201216:00:00	30.8",
                "2/13/201216:00:00	30.77",
                "2/14/201216:00:00	30.46",
                "2/15/201216:00:00	30.39",
                "2/16/201216:00:00	31.55",
                "2/17/201216:00:00	31.32",
                "2/21/201216:00:00	31.61",
                "2/22/201216:00:00	31.68",
                "2/23/201216:00:00	31.59",
                "2/24/201216:00:00	31.5",
                "2/27/201216:00:00	31.5",
                "2/28/201216:00:00	31.93",
                "2/29/201216:00:00	32",
                "3/1/201216:00:00	32.39",
                "3/2/201216:00:00	32.44",
                "3/5/201216:00:00	32.05",
                "3/6/201216:00:00	31.98",
                "3/7/201216:00:00	31.92",
                "3/8/201216:00:00	32.21",
                "3/9/201216:00:00	32.16",
                "3/12/201216:00:00	32.2",
                "3/13/201216:00:00	Missing_1",
                "3/14/201216:00:00	32.88",
                "3/15/201216:00:00	32.94",
                "3/16/201216:00:00	32.95",
                "3/19/201216:00:00	32.61",
                "3/20/201216:00:00	32.15",
                "3/21/201216:00:00	Missing_2",
                "3/22/201216:00:00	32.09",
                "3/23/201216:00:00	32.11",
                "3/26/201216:00:00	Missing_3",
                "3/27/201216:00:00	32.7",
                "3/28/201216:00:00	32.7",
                "3/29/201216:00:00	32.19",
                "3/30/201216:00:00	32.41",
                "4/2/201216:00:00	32.46",
                "4/3/201216:00:00	32.19",
                "4/4/201216:00:00	31.69",
                "4/5/201216:00:00	31.63",
                "4/9/201216:00:00	31.4",
                "4/10/201216:00:00	31.19",
                "4/11/201216:00:00	30.53",
                "4/12/201216:00:00	31.04",
                "4/13/201216:00:00	31.16",
                "4/16/201216:00:00	31.19",
                "4/17/201216:00:00	31.61",
                "4/18/201216:00:00	31.31",
                "4/19/201216:00:00	31.68",
                "4/20/201216:00:00	32.89",
                "4/23/201216:00:00	32.5",
                "4/24/201216:00:00	32.52",
                "4/25/201216:00:00	32.32",
                "4/26/201216:00:00	32.23",
                "4/27/201216:00:00	32.22",
                "4/30/201216:00:00	32.11",
                "5/1/201216:00:00	32.335",
                "5/2/201216:00:00	31.925",
                "5/3/201216:00:00	31.9",
                "5/4/201216:00:00	31.57",
                "5/7/201216:00:00	30.86",
                "5/8/201216:00:00	30.78",
                "5/9/201216:00:00	30.83",
                "5/10/201216:00:00	31.02",
                "5/11/201216:00:00	31.54",
                "5/14/201216:00:00	31.04",
                "5/15/201216:00:00	30.795",
                "5/16/201216:00:00	30.32",
                "5/17/201216:00:00	30.2084",
                "5/18/201216:00:00	29.81",
                "5/21/201216:00:00	29.79",
                "5/22/201216:00:00	29.88",
                "5/23/201216:00:00	29.4",
                "5/24/201216:00:00	Missing_4",
                "5/25/201216:00:00	29.36",
                "5/29/201216:00:00	29.72",
                "5/30/201216:00:00	29.479",
                "5/31/201216:00:00	29.42",
                "6/1/201216:00:00	Missing_5",
                "6/4/201216:00:00	Missing_6",
                "6/5/201216:00:00	28.75",
                "6/6/201216:00:00	29.37",
                "6/7/201216:00:00	29.7",
                "6/8/201216:00:00	29.68",
                "6/11/201216:00:00	29.81",
                "6/12/201216:00:00	29.3",
                "6/13/201216:00:00	29.44",
                "6/14/201216:00:00	29.46",
                "6/15/201216:00:00	30.08",
                "6/18/201216:00:00	30.03",
                "6/19/201216:00:00	31.11",
                "6/20/201216:00:00	31.05",
                "6/21/201216:00:00	31.14",
                "6/22/201216:00:00	30.73",
                "6/25/201216:00:00	30.32",
                "6/26/201216:00:00	30.27",
                "6/27/201216:00:00	30.5",
                "6/28/201216:00:00	30.05",
                "6/29/201216:00:00	30.69",
                "7/2/201216:00:00	30.62",
                "7/3/201216:00:00	30.76",
                "7/5/201216:00:00	30.78",
                "7/6/201216:00:00	30.7",
                "7/9/201216:00:00	30.23",
                "7/10/201216:00:00	30.22",
                "7/11/201216:00:00	29.735",
                "7/12/201216:00:00	29.18",
                "7/13/201216:00:00	29.48",
                "7/16/201216:00:00	29.53",
                "7/17/201216:00:00	29.86",
                "7/18/201216:00:00	30.45",
                "7/19/201216:00:00	30.8",
                "7/20/201216:00:00	Missing_7",
                "7/23/201216:00:00	Missing_8",
                "7/24/201216:00:00	29.36",
                "7/25/201216:00:00	29.33",
                "7/26/201216:00:00	Missing_9",
                "7/27/201216:00:00	29.85",
                "7/30/201216:00:00	29.82",
                "7/31/201216:00:00	29.71",
                "8/1/201216:00:00	29.65",
                "8/2/201216:00:00	29.525",
                "8/3/201216:00:00	29.94",
                "8/6/201216:00:00	30.11",
                "8/7/201216:00:00	30.35",
                "8/8/201216:00:00	30.47",
                "8/9/201216:00:00	30.65",
                "8/10/201216:00:00	30.62",
                "8/13/201216:00:00	30.46",
                "8/14/201216:00:00	30.39",
                "8/15/201216:00:00	30.28",
                "8/16/201216:00:00	30.94",
                "8/17/201216:00:00	30.92",
                "8/20/201216:00:00	30.85",
                "8/21/201216:00:00	30.96",
                "8/22/201216:00:00	30.76",
                "8/23/201216:00:00	30.4",
                "8/24/201216:00:00	30.63",
                "8/27/201216:00:00	30.96",
                "8/28/201216:00:00	30.8",
                "8/29/201216:00:00	30.75",
                "8/30/201216:00:00	30.61",
                "8/31/201216:00:00	30.96",
                "9/4/201216:00:00	30.66",
                "9/5/201216:00:00	30.53",
                "9/6/201216:00:00	31.36",
                "9/7/201216:00:00	31.07",
                "9/10/201216:00:00	Missing_10",
                "9/11/201216:00:00	30.91",
                "9/12/201216:00:00	31.18",
                "9/13/201216:00:00	31.18",
                "9/14/201216:00:00	31.25",
                "9/17/201216:00:00	Missing_11",
                "9/18/201216:00:00	31.21",
                "9/19/201216:00:00	31.19",
                "9/20/201216:00:00	Missing_12",
                "9/21/201216:00:00	31.61",
                "9/24/201216:00:00	31.07",
                "9/25/201216:00:00	31",
                "9/26/201216:00:00	30.6",
                "9/27/201216:00:00	30.4",
                "9/28/201216:00:00	30.26",
                "10/1/201216:00:00	29.98",
                "10/2/201216:00:00	29.89",
                "10/3/201216:00:00	29.99",
                "10/4/201216:00:00	30.03",
                "10/5/201216:00:00	30.25",
                "10/8/201216:00:00	29.92",
                "10/9/201216:00:00	Missing_13",
                "10/10/201216:00:00	Missing_14",
                "10/11/201216:00:00	29.25",
                "10/12/201216:00:00	29.32",
                "10/15/201216:00:00	Missing_15",
                "10/16/201216:00:00	29.74",
                "10/17/201216:00:00	29.64",
                "10/18/201216:00:00	29.73",
                "10/19/201216:00:00	29.08",
                "10/22/201216:00:00	28.83",
                "10/23/201216:00:00	28.2",
                "10/24/201216:00:00	28.2",
                "10/25/201216:00:00	28.2",
                "10/26/201216:00:00	28.34",
                "10/31/201216:00:00	Missing_16",
                "11/1/201216:00:00	29.56",
                "11/2/201216:00:00	29.77",
                "11/5/201216:00:00	29.74",
                "11/6/201216:00:00	Missing_17",
                "11/7/201216:00:00	29.825",
                "11/8/201216:00:00	29.37",
                "11/9/201216:00:00	29.19",
                "11/12/201216:00:00	29.01",
                "11/13/201216:00:00	Missing_18",
                "11/14/201216:00:00	27.29",
                "11/15/201216:00:00	26.97",
                "11/16/201216:00:00	Missing_19",
                "11/19/201216:00:00	26.8",
                "11/20/201216:00:00	26.8",
                "11/21/201216:00:00	27.1666",
                "11/23/201213:00:00	27.77",
                "11/26/201216:00:00	27.58",
                "11/27/201216:00:00	27.38",
                "11/28/201216:00:00	27.39",
                "11/29/201216:00:00	27.36",
                "11/30/201216:00:00	27.13",
                "12/3/201216:00:00	26.82",
                "12/4/201216:00:00	26.63",
                "12/5/201216:00:00	26.93",
                "12/6/201216:00:00	26.98",
                "12/7/201216:00:00	26.82",
                "12/10/201216:00:00	26.97",
                "12/11/201216:00:00	27.49",
                "12/12/201216:00:00	27.62",
                "12/13/201216:00:00	Missing_20",
                "12/14/201216:00:00	27.13",
                "12/17/201216:00:00	27.21",
                "12/18/201216:00:00	27.63",
                "12/19/201216:00:00	27.73",
                "12/20/201216:00:00	27.68",
                "12/21/201216:00:00	27.49",
                "12/24/201213:00:00	27.25",
                "12/26/201216:00:00	27.2",
                "12/27/201216:00:00	27.09",
                "12/28/201216:00:00	26.9",
                "12/31/201216:00:00	26.77"
        );
        calcMissing(missingArr);
    }

}