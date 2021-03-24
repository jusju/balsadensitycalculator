package engine;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BalsalevyDAO;

import java.sql.*;
import java.text.DecimalFormat;
import java.time.LocalTime;
import java.util.ArrayList;


@WebServlet("/JukkaController")
public class JukkaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public JukkaController() {
		super();
	}

	
	protected void teeAutentikaatio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
	protected void laskeBalsaGrainilla(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("JUKKA" + request.getParameter("deleteid"));
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		if (request.getParameter("action") != null && request.getParameter("action").equals("Laske")
				&& request.getParameter("salasana") != null && request.getParameter("salasana").equals("42")) {
			System.out.println("VAIN AUTENTIKAATIO ONNISTUI!!!!");
			String stringThickness = request.getParameter("thickness");
			String stringLength = request.getParameter("length");
			String stringWidth = request.getParameter("width");
			String stringWeight = request.getParameter("weight");

			request.setAttribute("thickness", stringThickness);
			request.setAttribute("length", stringLength);
			request.setAttribute("width", stringWidth);
			request.setAttribute("weight", stringWeight);

			// forward the request to the index.jsp page
			request.getRequestDispatcher("jukkaindex.jsp").forward(request, response);

		} else if (request.getParameter("action") != null && request.getParameter("action").equals("Laske")) {
			System.out.println("TEHDÄÄN LASKUA!!!!");

			String stringThickness = request.getParameter("thickness");
			String stringLength = request.getParameter("length");
			String stringWidth = request.getParameter("width");
			String stringWeight = request.getParameter("weight");
			String stringGrain = request.getParameter("grain");

			request.setAttribute("thickness", stringThickness);
			request.setAttribute("length", stringLength);
			request.setAttribute("width", stringWidth);
			request.setAttribute("weight", stringWeight);

			if (stringThickness.contains(",")) {
				System.out.println("NO SIELLA OLI PILKKU!!!");
				String[] solut = stringThickness.split(",");
				stringThickness = solut[0] + "." + solut[1];
			}
			if (stringLength.contains(",")) {
				System.out.println("NO SIELLA OLI PILKKU!!!");
				String[] solut = stringLength.split(",");
				stringLength = solut[0] + "." + solut[1];
			}
			if (stringWidth.contains(",")) {
				System.out.println("NO SIELLA OLI PILKKU!!!");
				String[] solut = stringWidth.split(",");
				stringWidth = solut[0] + "." + solut[1];
			}
			if (stringWeight.contains(",")) {
				System.out.println("NO SIELLA OLI PILKKU!!!");
				String[] solut = stringWeight.split(",");
				stringWeight = solut[0] + "." + solut[1];
			}

			double thickness = Double.parseDouble(stringThickness);
			double length = Double.parseDouble(stringLength);
			double width = Double.parseDouble(stringWidth);
			double weight = Double.parseDouble(stringWeight);

			double volume = thickness * length * width;
			double density = (weight / 1000.0) / (volume / 1000000000.0);
			DecimalFormat decimal = new DecimalFormat("0.00");
			System.out.println("DENSITY: " + density);



			Connection conn = null;
			try {

				String URL = "jdbc:sqlite:/var/lib/tomcat8/webapps/balsalaskin/balsa.db";

				Class.forName("org.sqlite.JDBC");
				Connection connection = DriverManager.getConnection(URL);
				Statement statement = connection.createStatement();
				String sql = "INSERT INTO Balsalevy(tiheys,korkeus,leveys,paino,pituus,grain) VALUES('\"\r\n" + 
						"						+ density + \"','\" + thickness + \"','\" + width + \"','\" + weight + \"','\" + length + \"','\"\r\n" + 
						"						+ stringGrain + \"');";
				System.out.println(sql);
				statement.executeUpdate("INSERT INTO Balsalevy(tiheys,korkeus,leveys,paino,pituus,grain) VALUES('"
						+ density + "','" + thickness + "','" + width + "','" + weight + "','" + length + "','"
						+ stringGrain + "');");

				statement.close();
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

			request.setAttribute("density", "" + decimal.format(density));
			
			ArrayList<Balsalevy> balsat = new ArrayList<Balsalevy>();
			BalsalevyDAO dao = new BalsalevyDAO();
			balsat = dao.haeBalsat();
			request.setAttribute("balsat", balsat);

			// forward the request to the index.jsp page
			request.getRequestDispatcher("jukkaindex.jsp").forward(request, response);

		} else if (request.getParameter("deleteid") != null) {
			String id = request.getParameter("deleteid");
			System.out.println("DELETE CASE " + id);

			request.setAttribute("thickness", "");
			request.setAttribute("length", "");
			request.setAttribute("width", "");
			request.setAttribute("weight", "");
			
			Connection conn = null;
			try {

				String URL = "jdbc:sqlite:/var/lib/tomcat8/webapps/balsalaskin/balsa.db";

				Class.forName("org.sqlite.JDBC");
				Connection connection = DriverManager.getConnection(URL);
				Statement statement = connection.createStatement();
				statement.executeUpdate("DELETE FROM Balsalevy WHERE ID=" + id);

				statement.close();
	

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
			response.sendRedirect("jukkaindex.jsp");
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
