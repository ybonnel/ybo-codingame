package lvl1;/*
 * Copyright 2013- Yan Bonnel
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.util.Scanner;

public class ChuckNorris {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        String binaire = "";
        for (char car : text.toCharArray()) {
            String letterInBinary = Integer.toBinaryString(car);
            while (letterInBinary.length() < 7) {
                letterInBinary = "0" + letterInBinary;
            }
            binaire += letterInBinary;
        }

        char lastChar = '2';

        for (char car : binaire.toCharArray()) {
            if (car == lastChar) {
                System.out.print("0");
            } else {
                if (lastChar != '2') {
                    System.out.print(" ");
                }
                lastChar = car;
                if (lastChar == '0') {
                    System.out.print("0");
                }
                System.out.print("0 0");
            }
        }
    }
}
