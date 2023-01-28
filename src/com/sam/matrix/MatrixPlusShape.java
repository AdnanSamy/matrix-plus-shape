package com.sam.matrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatrixPlusShape {
    private static List<List<Map<String, String>>> matrixHeight = new ArrayList<>();
    private static List<String> answers = new ArrayList<>();

    public void showAnswer() {
        for (List<Map<String, String>> list : matrixHeight) {

            for (Map<String, String> map : list) {
                System.out.print(map.get("num"));
            }

            System.out.print("\n");
        }

        System.out.println("Result:");
        for (String answer : answers) {
            System.out.println(answer);
        }
    }

    public void process() {
        for (int i = 0; i < 15; i++) {
            List<Map<String, String>> matrixWidth = new ArrayList<>();

            for (int j = 0; j < 25; j++) {
                Map<String, String> num = new HashMap<>();
                String randomNum = Integer.toString(GenerateRandom.generateInt(0, 1));

                if (randomNum.equals("1")) {
                    if (i >= 2 &&
                            j >= 2 &&
                            (j + 1) < 25) {

                        List<Map<String, String>> middleMatrix = matrixHeight.get(i - 1);
                        List<Map<String, String>> topMatrix = matrixHeight.get(i - 2);
                        Map<String, String> middleNum = middleMatrix.get(j);
                        Map<String, String> leftNum = middleMatrix.get(j - 1);
                        Map<String, String> rightNum = middleMatrix.get(j + 1);
                        Map<String, String> topNum = topMatrix.get(j);

                        if ((middleNum.get("used").equals("0") && middleNum.get("num").equals("1")) &&
                                (leftNum.get("used").equals("0") && leftNum.get("num").equals("1")) &&
                                (rightNum.get("used").equals("0") && rightNum.get("num").equals("1")) &&
                                (topNum.get("used").equals("0") && topNum.get("num").equals("1"))) {

                            answers.add("(" + j + ", " + (i - 1) + ")");

                            middleNum.put("num", "*");
                            leftNum.put("num", "*");
                            rightNum.put("num", "*");
                            topNum.put("num", "*");
                            randomNum = "*";
                        }
                    }
                }

                num.put("num", randomNum);
                num.put("used", "0");

                matrixWidth.add(num);
            }

            matrixHeight.add(matrixWidth);
        }
    }
}
