package comexamplecollections.controller;

import java.util.*;

public class HomeTask {
    private static List<Integer> nums = new ArrayList<>(List.of(10, 1, 8, 3, 4, 5, 5, 8, 6, 70));
    private static List<String> words = new ArrayList<>(List.of("будем", "Требуется", "будем", "Мы", "Делать", "Дела", "Требуется", "Дела", "Дела"));
    private static List<String> words3 = new ArrayList<>();

    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
    }


    private static void task1() {
        List<Integer> nums1 = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) % 2 == 1)
                nums1.add(nums.get(i));
        }
        System.out.println(nums1);
    }

    private static void task2() {
        List<Integer> nums1 = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) % 2 == 0) {
                nums1.add(nums.get(i));
            }
        }
        Set<Integer> number = new HashSet<>(nums1);
        nums1.clear();
        nums1.addAll(number);
        Collections.sort(nums1);
        System.out.println(nums1);
    }

    private static void task3() {
        String a = "";
        Collections.sort(words);
        for (int i = 0; i < words.size(); i++) {
            for (int i1 = i + 1; i1 < words.size(); i1++) {
                if (words.get(i).equals(words.get(i1)) && !words.get(i).equals(a)) {
                    a = words.get(i);
                    words3.add(a);
                }
            }
        }
        System.out.println(words3);
    }

    private static void task4() {
        int counter = 0;
        List<Integer> list = new ArrayList<>();
        Collections.sort(words);
        for (int i = 0; i < words3.size(); i++) {
            for (int i1 = 0; i1 < words.size(); i1++) {
                if (words3.get(i).equals(words.get(i1))) {
                    counter++;
                }
            }
            list.add(counter);
            counter = 0;
            System.out.print( list.get(i) + "-" + words3.get(i));
            System.out.print(" ");
        }

    }
}