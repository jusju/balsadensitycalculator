package engine;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.time.LocalTime;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		if (request.getParameter("action") != null && request.getParameter("action").equals("calculate")) {

			String timeString = LocalTime.now().toString();

			// lähetä merkkijono JSP sivulle attribuuttina
			request.setAttribute("timeNow", timeString);

			Connection conn = null;
			try {
				// db parameters
				String url = "jdbc:sqlite:balsa.db";
				// create a connection to the database
				conn = DriverManager.getConnection(url);

				System.out.println("Yhteys SQL kantaan saatu.");

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException ex) {
					System.out.println(ex.getMessage());
				}
			}

			// forward the request to the index.jsp page
			request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
