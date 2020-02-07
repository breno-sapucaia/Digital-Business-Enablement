package br.com.fiap.loja;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/search")
public class LojaServlet extends HttpServlet{
	
	public static class Camiseta {
		private String cor;
		
		public Camiseta(String cor) {
			this.cor = cor;
		}
		
		public String getCor() {
			return cor;
		}

		public void setCor(String cor) {
			this.cor = cor;
		}
		
	}
	private static final long serialVersionUID = 1L;
	private static HashMap armazem = new HashMap<Integer,Camiseta>();
	static {
		armazem.put(401, new Camiseta("branca"));
		armazem.put(402, new Camiseta("azul"));
		armazem.put(403, new Camiseta("rosa"));
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		req.setAttribute("camiseta", armazem.getOrDefault(id, null));
		
		req.getRequestDispatcher("index.jsp").forward(req,resp);
		super.doGet(req, resp);
	}
	
}
