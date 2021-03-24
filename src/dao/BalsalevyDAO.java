package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import engine.Balsalevy;

public class BalsalevyDAO {

	public ArrayList<Balsalevy> haeBalsat() {

		
		ArrayList<Balsalevy> levyt = new ArrayList<Balsalevy>();
		try {

			String URL = "jdbc:sqlite:/var/lib/tomcat8/webapps/balsalaskin/balsa.db";

			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection(URL);
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM Balsalevy");
			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				Balsalevy balsalevy = new Balsalevy();
				int id = (int) resultset.getDouble("id");
				System.out.println("ID " + id);
				balsalevy.setId(id);
				double tiheys = (double) resultset.getDouble("tiheys");
				System.out.println("TIHEYS " + tiheys);
				balsalevy.setTiheys(tiheys);
				double korkeus = (double) resultset.getDouble("korkeus");
				System.out.println("korkeus " + korkeus);
				balsalevy.setPaksuus(korkeus);
				double leveys = (double) resultset.getDouble("leveys");
				System.out.println("leveys " + leveys);
				balsalevy.setLeveys(leveys);
				double paino = (double) resultset.getDouble("paino");
				System.out.println("paino " + paino);
				balsalevy.setPaino(paino);
				double pituus = (double) resultset.getDouble("pituus");
				System.out.println("pituus " + pituus);
				balsalevy.setPituus(pituus);
				String grain = resultset.getString("grain") + "";
				System.out.println("grain " + grain);
				balsalevy.setGrain(grain);
				levyt.add(balsalevy);
			}

			resultset.close();
			statement.close();
			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return(levyt);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
