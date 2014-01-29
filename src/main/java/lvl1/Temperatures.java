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

public class Temperatures {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); in.nextLine();
        if (n == 0) {
            System.out.println(n);
            return;
        }
        int betterTemp = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = in.nextInt();
            if (Math.abs(betterTemp) > Math.abs(temp)
                    || Math.abs(betterTemp) == Math.abs(temp) && temp > betterTemp) {
                betterTemp = temp;
            }
        }
        System.out.println(betterTemp);
    }
}
