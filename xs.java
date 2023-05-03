@WebServlet("/submitComment")
public class CommentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String comment = request.getParameter("comment");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Comment Result</title></head><body>");
        out.println("Your comment was: " + comment);
        out.println("</body></html>");
    }

}
