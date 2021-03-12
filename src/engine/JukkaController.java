package engine;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.text.DecimalFormat;
import java.time.LocalTime;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/JukkaController")
public class JukkaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JukkaController() {
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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		if (request.getParameter("action") != null && 
				request.getParameter("action").equals("Laske") &&
				request.getParameter("salasana").equals("42")) {

			String stringThickness = request.getParameter("thickness");
			String stringLength = request.getParameter("length");
			String stringWidth = request.getParameter("width");
			String stringWeight = request.getParameter("weight");

			request.setAttribute("thickness", stringThickness);
			request.setAttribute("length", stringLength);
			request.setAttribute("width", stringWidth);
			request.setAttribute("weight", stringWeight);
			
			if(stringThickness.contains(",")) {
				System.out.println("NO SIELLA OLI PILKKU!!!");
				String[] solut = stringThickness.split(",");
				stringThickness = solut[0] + "." + solut[1];
			}
			if(stringLength.contains(",")) {
				System.out.println("NO SIELLA OLI PILKKU!!!");
				String[] solut = stringLength.split(",");
				stringLength = solut[0] + "." + solut[1];
			}
			if(stringWidth.contains(",")) {
				System.out.println("NO SIELLA OLI PILKKU!!!");
				String[] solut = stringWidth.split(",");
				stringWidth = solut[0] + "." + solut[1];
			}
			if(stringWeight.contains(",")) {
				System.out.println("NO SIELLA OLI PILKKU!!!");
				String[] solut = stringWeight.split(",");
				stringWeight = solut[0] + "." + solut[1];
			}
			
			double thickness = Double.parseDouble(stringThickness);
			double length = Double.parseDouble(stringLength);
			double width = Double.parseDouble(stringWidth);
			double weight = Double.parseDouble(stringWeight);

			double volume = thickness * length * width;
			double density =  (weight/1000.0) / (volume/1000000000.0);
			DecimalFormat decimal = new DecimalFormat("0.00");
			System.out.println("DENSITY: " + density);
			request.setAttribute("density", "" + decimal.format(density));
			Connection conn = null;
			try {
				Class.forName("org.sqlite.JDBC");
				// create a connection to the database
				conn = DriverManager.getConnection("jdbc:sqlite:./balsa.db");

				System.out.println("Yhteys SQL kantaan saatu.");

				Statement statement = conn.createStatement();
				statement.executeQuery("SELECT * FROM Balsalevy");
				ResultSet resultset = statement.executeQuery("SELECT * FROM Balsalevy");
				while(resultset.next()) {
					int id = (int)resultset.getDouble("id");
					double tiheys = (double)resultset.getDouble("tiheys");
				}
				
				conn.close();
				
			} catch (Exception e) {
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
			request.getRequestDispatcher("jukkaindex.jsp").forward(request, response);


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
