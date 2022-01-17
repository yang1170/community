//package com.newcoder.community;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class testLeetcodedemo {
//    public static void main(String[] args) {
//        List<List<String>> stulist = new ArrayList<List<String>>();
//        List<String> list1 = new ArrayList<String>();
//        List<String> list2 = new ArrayList<String>();
//        List<String> list3 = new ArrayList<String>();
//        List<String> list4 = new ArrayList<String>();
//        list1.add("大连");
//        list1.add("青岛");
//        list3.add("广州");
//        list3.add("大连");
//        list2.add("青岛");
//        list2.add("澳门");
//
//        stulist.add(list1);
//        stulist.add(list2);
//        String s = new testLeetcodedemo().destCity(stulist);
//        System.out.println(s);
//    }
//    public String destCity(List<List<String>> paths) {
//        Map<String,String> map = new HashMap<String,String>();
//        for(int i=0;i<paths.size();i++){
//            map.put(paths.get(i).get(0),null);
//        }
//        for(int i=0;i<paths.size();i++){
//            if(!map.containsKey(paths.get(i).get(1))){
//                return paths.get(i).get(1);
//            }
//        }
//        return "";
//
//
//    }
//}
