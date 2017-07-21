package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class MyServlet
 */
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public MyServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String flag = request.getParameter("flag");
		System.out.println(flag);
		if ("login".equals(flag)) {
			PrintWriter out = response.getWriter();
			out.write("true");
		} else if ("userList".equals(flag)) {
			List<User> userList = new ArrayList<User>();
			// objectTypes = dao.load();
			userList.add(new User(1, "aa", "bb", 0));
			userList.add(new User(2, "a2", "b2", 0));
			userList.add(new User(3, "a3", "b3", 0));

			JSONObject jsonObject = new JSONObject();
			jsonObject.put("userList", userList);

			JSONArray jsonArray = new JSONArray();
			jsonArray.add(jsonObject);
			System.out.println(jsonArray);
			PrintWriter out = response.getWriter();
			out.write(jsonArray.toString());
			// out.println(jsonArray.toString());
		}

	}

}
