package engine;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HitsServlet
 */
@WebServlet("/HitsServlet")
public class HitsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HitsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Scanner lukija = new Scanner(new File("C:/TEMP/hits.txt"));
		
		String stringLuku = "";
		while(lukija.hasNext()) {
			stringLuku = lukija.nextLine();				
			System.out.println(stringLuku);

		}
		lukija.close();
		int luku = Integer.parseInt(stringLuku);
		PrintWriter out = response.getWriter();
		out.println("{");
		out.print("\"hits\": ");
		out.println(luku);
		out.println("}");
		luku = luku + 1;

		try {
			PrintWriter ulosKirjoitus = new PrintWriter("C:/TEMP/hits.txt");
			ulosKirjoitus.println(luku);
			ulosKirjoitus.close();
		} catch(IOException ex) {
			System.out.println("Tiedostoon kirjoitus ei onnistunut");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}