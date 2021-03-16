//import java.util.ArrayList;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//import java.util.List;

public class Poly {
    //private Integer degree;
    //private Integer coef;
    //
    //public Poly(Integer degree, Integer coef) {
    //    this.degree = degree;
    //    this.coef = coef;
    //}
    //
    //public Integer getDegree() {
    //    return degree;
    //}
    //
    //public Poly setDegree(Integer degree) {
    //    this.degree = degree;
    //    return this;
    //}
    //
    //public Integer getCoef() {
    //    return coef;
    //}
    //
    //public Poly setCoef(Integer coef) {
    //    this.coef = coef;
    //    return this;
    //}
    //
    //public Poly add(Poly poly) {
    //
    //}
    //
    //public Poly sub(Poly poly) {
    //
    //}

    //private List<Integer> terms = new ArrayList<>();
    private HashMap<BigInteger, BigInteger> terms = new HashMap<>();

    //private int degree = 0;

    //public Poly(int degree) {
    //    this.degree = degree;
    //    for (int i = 0; i < degree; i++) {
    //        terms.add(new Integer(0));
    //    }
    //}

    //public Poly(int coeff, int index) {
    //    terms.add(index, coeff);
    //}

    public Poly() {}

    //public Poly add(Poly another) {
    //    Poly poly = new Poly();
    //    //if (this.degree > another.degree) {
    //    //    poly.degree = this.degree;
    //    //    for (int i = another.degree; i < this.degree; i++) {
    //    //        another.terms.add(new Integer(0));
    //    //    }
    //    //}
    //    //else {
    //    //    poly.degree = another.degree;
    //    //    for (int i = this.degree; i < another.degree; i++) {
    //    //        this.terms.add(new Integer(0));
    //    //    }
    //    //}
    //    poly.degree = justifiedAndGetDegree(another);
    //    for (int i = 0; i < poly.degree; i++) {
    //        poly.terms.set(i,
    //                this.terms.get(i) + another.terms.get(i));
    //    }
    //    return poly;
    //}

    public HashMap<BigInteger, BigInteger> getTerms() {
        return terms;
    }

    //public Poly addTerm(Integer coef, Integer index) {
    //    terms.put(index, coef);
    //    return this;
    //}

    //public Poly sub(Poly another) {
    //    Poly poly = new Poly();
    //    poly.degree = justifiedAndGetDegree(another);
    //    for (int i = 0; i < poly.degree; i++) {
    //        poly.terms.set(i,
    //                this.terms.get(i) - another.terms.get(i));
    //    }
    //    return poly;
    //}

    //public int justifiedAndGetDegree(Poly another) {
    //    int degree;
    //    if (this.degree > another.degree) {
    //        degree = this.degree;
    //        for (int i = another.degree; i < this.degree; i++) {
    //            another.terms.add(new Integer(0));
    //        }
    //    }
    //    else {
    //        degree = another.degree;
    //        for (int i = this.degree; i < another.degree; i++) {
    //            this.terms.add(new Integer(0));
    //        }
    //    }
    //    return degree;
    //}

    public Poly getDeriv() {
        Poly poly = new Poly();

        //
        //if (poly.terms.isEmpty()) {
        //    poly.terms.add(0);
        //}

        Iterator<HashMap.Entry<BigInteger, BigInteger>> iterator =
                terms.entrySet().iterator();
        while (iterator.hasNext()) {
            HashMap.Entry<BigInteger, BigInteger> entry = iterator.next();
            BigInteger coef = entry.getValue();
            BigInteger index = entry.getKey();
            //poly.addTerm(coef, index);
            poly.getTerms().put(index.add(
                    new BigInteger(String.valueOf(-1))), coef.multiply(index));
        }

        return poly;
    }

    public String getPolyStr() {
        String string = "";
        //String plus = "+";
        //String x = "x";


        //else {
        //    for (Integer coeff :
        //            this.terms) {
        //        if (coeff > 0) {
        //            string += coeff.toString() + ;
        //        }
        //    }
        //}
        //else {
        //    //string += terms.get(0).toString();
        //    //if (null != terms.get(1)) {
        //    //    if (0 != terms.get(1)) {
        //    //        string += terms.get(1).toString() + "*x";
        //    //    }
        //    //}
        //    //else {
        //    //    return string;
        //    //}
        //    for (Integer i = 0; i < terms.size(); i++) {
        //        Integer coef = terms.get(i);
        //        if(0 == coef) {
        //            continue;
        //        }
        //        if (0 < coef) {
        //            string += "+" + coef.toString() + "*x**" +
        //            i.toString();
        //        }
        //        else {
        //            string += coef.toString() + "*x**" + i.toString();
        //        }
        //    }
        //}

        Iterator<HashMap.Entry<BigInteger, BigInteger>> iterator =
                terms.entrySet().iterator();
        while (iterator.hasNext()) {
            HashMap.Entry<BigInteger, BigInteger> entry = iterator.next();
            BigInteger coef = entry.getValue();
            BigInteger index = entry.getKey();
            String ret = "";
            //if(0 == coef) {
            //    continue;
            //}
            //if (1 == coef) {
            //    string += "+" + "x**"
            //}
            //if (0 < coef) {
            //    string += "+" + coef.toString() + "*x**" +
            //    index.toString();
            //}
            //else {
            //    string += coef.toString() + "*x**" + index.toString();
            //}
            //if (coef.equals(0)) {
            //    ret = "+";
            //}
            //else {
            //    ret = "+" + String.valueOf(coef);
            //}
            //if ()
            if (coef.compareTo(new BigInteger("0")) > 0) {
                if (coef.equals(1)) {
                    ret = "+";
                }
                else {
                    ret = "+" + String.valueOf(coef);
                }
            }
            else if (coef.compareTo(new BigInteger("0")) < 0) {
                if (coef.equals(-1)) {
                    ret = "-";
                }
                else {
                    ret = String.valueOf(coef);
                }
            }
            else {
                continue;
            }

            if (index.equals(0)) {
                //string += ret;
                if (coef.equals(1)) {
                    string += "+1";
                }
                else if (coef.equals(-1)) {
                    string += "-1";
                }
                else {
                    string += ret;
                }
            }
            else if (index.equals(1)) {
                string += ret + "*x";
            }
            else {
                string += ret + "*x**" + String.valueOf(index);
            }
        }
        if (string.startsWith("+")) {
            string = string.substring(1);
        }

        if (string.equals("")) {
            string = "0";
        }
        return string;
    }

    //static final String outputRegex1 = "[+-]";
    //static final String outoutRegex2 = "(1)\\*x(\\*){2}\\d+";
    //static final String outputRegex3 = "\\*x(\\*){2}(0)";
    //public String processOutputStr(String inputStr) {
    //    StringBuffer stringBuffer = new StringBuffer(inputStr);
    //
    //    Pattern pattern1 = Pattern.compile(outputRegex1);
    //    Matcher matcher1 = pattern1.matcher(stringBuffer);
    //    if (matcher1.lookingAt()) {
    //        if (matcher1.group(0).equals("+")) {
    //            stringBuffer.delete(0, 1);
    //        }
    //    }
    //
    //    pattern1 = Pattern.compile(outoutRegex2);
    //    matcher1 = pattern1.matcher(stringBuffer);
    //    while (matcher1.find()) {
    //        String temp = matcher1.group(0);
    //        Integer revisePossition = temp.indexOf(new String(stringBuffer));
    //        //stringBuffer.delete(revisePossition,
    //        //        revisePossition - matcher1.start() + matcher1.end());
    //        stringBuffer.replace(revisePossition,
    //                revisePossition + 1,
    //                "");
    //    }
    //
    //    pattern1 = Pattern.compile(outputRegex3);
    //    matcher1 = pattern1.matcher(stringBuffer);
    //    if (matcher1.lookingAt()) {
    //
    //    }
    //
    //   // pattern1 = Pattern.compile(outoutRegex2);
    //   // matcher1 = pattern1.matcher(stringBuffer);
    //   //
    //   //if (matcher1.find()) {
    //   //     String coefStr = matcher1.group(1);
    //   //     if (coefStr.equals("1")) {
    //   //         pattern2 = Pattern.compile("1");
    //   //         matcher2 = pattern2.matcher(matcher1.group(1));
    //   //         stringBuffer.delete(matcher2.start(), matcher2.end());
    //   //     }
    //   //     //
    //   //     //String indexStr = matcher1.group(4);
    //   //     //if (indexStr.equals("0")) {
    //   //     //    pattern2 = Pattern.compile("\\*x(\\*){2}0");
    //   //     //    matcher2 = pattern2.matcher(matcher1.group(2));
    //   //     //    stringBuffer.delete(matcher2.start(), matcher2.end());
    //   //     //}
    //   //     //else if (indexStr.equals("1")) {
    //   //     //    pattern2 = Pattern.compile("(\\*){2}1");
    //   //     //    matcher2 = pattern2.matcher(matcher1.group(3));
    //   //     //    stringBuffer.delete()
    //   //     //}
    //   // }
    //
    //    return new String(stringBuffer);
    //}
}
