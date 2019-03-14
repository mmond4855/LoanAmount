
package LoanAmount;

//These packages are very importnt 
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/LoanAmount"})
public class LoanAmount extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8"); //Sets the content.
        try (PrintWriter out = response.getWriter()) //Tries the print writer
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            
            out.println("<head>");
            out.println("<title>Servlet Loan Amount</title>");            
            out.println("</head>");
            
            out.println("<body>");
            
            out.println("<h1>Loan Amount " + "</h1>");
            
            double P = Double.parseDouble(request.getParameter("P")); 
            //P is referenced to the principal value. 
            double R = Double.parseDouble(request.getParameter("R"));
            //R is referenced to the rate.
            double T = Double.parseDouble(request.getParameter("T"));
            //T is reference to the time.
            double N = Double.parseDouble(request.getParameter("N"));
            //N is refenced to the compound.
            double A = P * R / (N * (1 - Math.pow(1 + R / N, -1 * N * T)));
            //Area
            
            //Outputs the data in HTML.
            out.println("<p> P = " + P  + "</p>");
            out.println("<p> R = " + R  + "</p>");
            out.println("<p> T = " + T  + "</p>");
            out.println("<p> N = " + N  + "</p>");
            out.println("<p> A = " + A  + "</p>");
            
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() 
    {
        return "Short description";
    }

}
