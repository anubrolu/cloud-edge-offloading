package converter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * conversion from one unit to the other
 */
public class Unitconverter extends HttpServlet {

    /**
     * Handles request for unit converter servlet
     * @param req request from the client
     * @param resp respons to the server
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Double input = Double.parseDouble(req.getParameter("input"));
        String type =  req.getParameter("typeofconversion");
        String result = convert(input, type);
        PrintWriter out = resp.getWriter();
        out.println(result);
    }

    /**
     * converts given value to a given type
     * @param t value to be converted
     * @param type type of conversion
     * @return converted value
     */
    public String convert(Double t, String type){
        double convertedOutput=0.0;
        String c="0";

            if (type.equals("f2c")){
                convertedOutput=(t-32)*0.55556;
            }

            else if(type.equals("c2f")){
                convertedOutput=(t*1.8)+32;
            }

            else if(type.equals("l2g")){
                convertedOutput=(t*0.264);
            }

            else if(type.equals("g2l")){
                convertedOutput=(t*3.7854);
            }
            else if(type.equals("k2m")){
                convertedOutput=(t*0.62137);
            }
            else if(type.equals("m2k")) {
                convertedOutput = (t * 1.60934);
            }

            else if(type.equals("w2h")){
                convertedOutput=( t * 168);

            }
            double roundOff = Math.round(convertedOutput*100)/100D;

            c = Double.toString(roundOff);

        return c;
    }
}
