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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AsciiArt {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int l = in.nextInt(); in.nextLine();
        int h = in.nextInt(); in.nextLine();

        Map<Character, List<String>> alphabet = new HashMap<Character, List<String>>();

        String text = in.nextLine();

        for (int row = 0; row < h; row++) {
            String line = in.nextLine();
            char currentChar = 'A';
            for (int index = 0; index < 27*l; index += l) {
                if (!alphabet.containsKey(currentChar)) {
                    alphabet.put(currentChar, new ArrayList<String>());
                }
                alphabet.get(currentChar).add(line.substring(index, index +l));
                if (currentChar == 'Z') {
                    currentChar = '?';
                } else {
                    currentChar = (char) (currentChar + 1);
                }
            }

            for (char letter : text.toCharArray()) {
                System.out.print(
                        alphabet.containsKey(Character.toUpperCase(letter))
                                ? alphabet.get(Character.toUpperCase(letter)).get(row)
                                : alphabet.get('?').get(row)

                );
            }
            System.out.println();
        }
    }
}
