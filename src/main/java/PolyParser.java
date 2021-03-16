//import java.util.ArrayList;
import java.math.BigInteger;
import java.util.HashMap;
//import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PolyParser {

    private Poly poly = new Poly();
    //private List<Poly> polyList = new ArrayList<>();

    //static final String operator = "[+-]";
    //static final String coeff = "\\d*";
    //static final String x = "\\*x";
    //static final String index = "(?"+ "\\*{2}(\\d*)" +")?" +"?";
    //static final String polyRegex = operator +
    // "(" + coeff + ")" + "(?" + "\\*{2}" +
    static final String polyRegex =
            "([+-])((\\d+)\\*)?x(\\*{2}([+-]?\\d+))?";

    public String parseStr(String inputStr) {
        String string = this.processStr(inputStr);
        Pattern pattern = Pattern.compile(polyRegex);
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            String operatorStr = matcher.group(1);
            String coefStr = matcher.group(3);
            String indexStr = matcher.group(5);

            //    if (null != coefStr) {
            //        if ("+" == operatorStr) {
            //            //Integer coef =
            //            Integer.getInteger(coefStr)             //
            //            poly.addTerm(Integer.getInteger(coefStr),
            //            Integer.getInteger(indexStr));
            //        }
            //        else {
            //            poly.addTerm(-Integer.getInteger(coefStr),
            //            Integer.getInteger(indexStr));
            //        }
            //    }
            //    else {
            //
            //    }

            BigInteger coef;
            BigInteger index;
            if (operatorStr.equals("+")) {
                //coef = Integer.getInteger(coefStr);
                if (null == coefStr) {
                    coef = new BigInteger("1");
                }
                else {
                    //coef = Integer.getInteger(coefStr);
                    //coef = Integer.valueOf(coefStr);
                    coef = new BigInteger(coefStr);
                }
            }
            else {
                if (null == coefStr) {
                    //coef = -1;
                    coef = new BigInteger("-1");
                }
                else {
                    //coef = - Integer.getInteger(coefStr);
                    //coef = - Integer.valueOf(coefStr);
                    coef = new BigInteger(coefStr).negate();
                }
            }

            if (null == indexStr) {
                //index = 1;
                index = new BigInteger("1");
            }
            else {
                //index = Integer.getInteger(indexStr);
                //index = Integer.valueOf(indexStr);
                index = new BigInteger(indexStr);
            }

            //poly.addTerm(coef, index);
            HashMap<BigInteger, BigInteger> map = poly.getTerms();
            if (map.containsKey(index)) {
                BigInteger originalCoef = map.get(index);
                //map.put(index, coef + originalCoef);
                map.put(index, coef.add(originalCoef));
            }
            else {
                map.put(index, coef);
            }
        }

        //if (string.startsWith("+")) {
        //    string = string.substring(0, 1);
        //}

        return string;
    }

    public String deleteBlank(String inputStr) {
        String processedStr = inputStr.replaceAll("[ \t]", "");
        return processedStr;
    }

    public String translateOperator(String inputStr) {
        String string = inputStr.replace("++", "+");
        string = string.replace("+-", "-");
        string = string.replace("-+", "-");
        string = string.replace("--", "+");

        return string;
    }

    public String initializeStr(String inputStr) {
        StringBuffer stringBuffer = new StringBuffer(inputStr);

        String checkFirst = "[+-]";
        Pattern regex = Pattern.compile(checkFirst);
        Matcher matcher = regex.matcher(inputStr.substring(0, 1));

        if (!matcher.matches()) {
            stringBuffer.insert(0, "+");
        }

        return new String(stringBuffer);
    }

    public String processStr(String inputStr) {
        String string = this.deleteBlank(inputStr);
        string = this.translateOperator(string);
        string = this.initializeStr(string);

        return string;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        PolyParser polyParser = new PolyParser();

        //String deleteBlkStr = this.deleteBlank(inputStr);
        polyParser.parseStr(input);
        System.out.println(polyParser.poly.getDeriv().getPolyStr());
    }
}
