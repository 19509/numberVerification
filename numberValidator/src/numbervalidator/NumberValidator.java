/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numbervalidator;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author jhicks
 */
public class NumberValidator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Initializing test values
        String test1 = "(419)123-4567";
        String test2 = "(419) 123-4567";
        String test3 = "419-123-4567";
        String test4 = "419.123.4567";
        String test5 = "419_123_4567";
        String test6 = "(419)123-456";
        String test7 = "4191234567";
        String test8 = "419123456";

        //Establishing pattern for number refactoring
        Pattern p = Pattern.compile("([(]?)([0-9]{3})([)]?)([ -.]?)([0-9]{3})([ -.]+)([0-9]{4})");
        
        //Assigning variables to hold test getNumber method results
        String number1 = getNumber(p, test1);
        String number2 = getNumber(p, test2);
        String number3 = getNumber(p, test3);
        String number4 = getNumber(p, test4);
        String number5 = getNumber(p, test5);
        String number6 = getNumber(p, test6);
        String number7 = getNumber(p, test7);
        String number8 = getNumber(p, test8);
        
        //Printing test variables
        System.out.println(number1);
        System.out.println(number2);
        System.out.println(number3);
        System.out.println(number4);
        System.out.println(number5);
        System.out.println(number6);
        System.out.println(number7);
        System.out.println(number8);
    }
    
    static String getNumber(Pattern p, String number)
    {
        //Test number -- Initializing fields
        String str = number;
        Matcher match;
        
        //Uses inputed pattern to validate number and break it into groups
        do {
            match = p.matcher(str);
            if(match.matches()){
                String group1 = match.group(2);
                String group2 = match.group(5);
                String group3 = match.group(7);
                str = "(" + group1 + ") " + group2 + "-"+ group3; //Reformats number
            }
            //Catches invalid number entry and breaks loop
            else
            {
                str = "Invalid number entry: " + number;
                break;
            }//endif
            //Returns final, reformated, number
        }while(!match.matches());
            return str;
    }
}
