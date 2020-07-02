package com.cpulover.testdatabase;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDabaseServlet
 */
@WebServlet("/TestDabaseServlet")
public class TestDabaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public TestDabaseServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// setup connection paramethers
		String user = "cpulover";
		String password = "cpulover";
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
		String driver = "com.mysql.cj.jdbc.Driver";

		try {
			PrintWriter out = response.getWriter();
			out.println("Connecting to database: " + jdbcUrl);
			Class.forName(driver);
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, password);
			out.println("Successfully!");
			myConn.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
