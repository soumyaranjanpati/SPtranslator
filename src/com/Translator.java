package com;


import java.util.*;
public class Translator {

 public static void main(String[] args) throws Exception 
 {
	 ArrayList<String> al=new ArrayList<String>(); 
	 al.add("fr");
	 al.add("da");
  DevClass varDev = new DevClass();
  for(String languageVal:al){
  String word = varDev.callUrlAndParseResult("en", languageVal, "These Go code samples show you how to detect the language of text input and translate text using the Cloud Translation API.");
  
  System.out.println(word);
  }
 }
 

}
