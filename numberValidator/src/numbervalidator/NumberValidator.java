/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numbervalidator;

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
        //Initializing fields
        String number;
        Pattern p = Pattern.compile("([(]?)([0-9]{3})([)]?)([ -.]?)([0-9]{3})([ -.]+)([0-9]{4})");
        
        //Calls getnumber and stores returned value in String variable
        number = getNumber(p);
        //Prints number 
        System.out.println(number);
    }
    
    static String getNumber(Pattern p)
    {
        //Test number -- Initializing fields
        String str = "419) 123 4567";
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
                System.out.println("Invalid number entry: ");
                break;
            }//endif
            //Returns final, reformated, number
        }while(!match.matches());
            return str;
    }
}
