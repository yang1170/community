//package com.newcoder.community;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class TestLeetcode {
//
//
//        public static void main(String[] args) {
//
//            List<List<String>> stulist = new ArrayList<List<String>>();
//
//            List<String> list1 = new ArrayList<String>();
//            List<String> list2 = new ArrayList<String>();
//            List<String> list3 = new ArrayList<String>();
//            List<String> list4 = new ArrayList<String>();
//
//            list1.add("1");
//            list1.add("张三");
//            list1.add("D");
//
//            list2.add("2");
//            list2.add("李四");
//            list2.add("B");
//
//            list3.add("3");
//            list3.add("王五");
//            list3.add("A");
//
//            list4.add("4");
//            list4.add("赵六");
//            list4.add("C");
//
//            stulist.add(list3);
//            stulist.add(list4);
//            stulist.add(list1);
//            stulist.add(list2);
//
//            System.out.println(stulist);
//
//            // Java 8 对List<List<String>>排序代码
//            stulist = stulist.stream().sorted((o1, o2) -> {
//                for (int i = 0; i < Math.min(o1.size(), o2.size()); i++) {
//                    int c = o1.get(2).compareTo(o2.get(2));
//                    if (c != 0) {
//                        return c;
//                    }
//                }
//                return Integer.compare(o1.size(), o2.size());
//            }).collect(Collectors.toList());
//            System.out.println(stulist);
//
//            stulist = stulist.stream().sorted((o1, o2) -> {
//                for (int i = 0; i < Math.min(o1.size(), o2.size()); i++) {
//                    int c = Integer.valueOf(o1.get(0)).compareTo(Integer.valueOf(o2.get(0)));
//                    if (c != 0) {
//                        return c;
//                    }
//                }
//                return Integer.compare(o1.size(), o2.size());
//            }).collect(Collectors.toList());
//            System.out.println(stulist);
//        }
//
//    }
//
