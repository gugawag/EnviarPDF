package com.gugawag.exemplos.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EnviarPDFServlet
 */
@WebServlet("/enviarpdf.do")
public class EnviarPDFServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnviarPDFServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String caminho = request.getParameter("caminho");
		PrintWriter saida = response.getWriter();
		
		response.setContentType("application/pdf");
		FileInputStream fis = new FileInputStream(caminho);
		
		 
				
		try{
			int c;
			while((c=fis.read()) != -1){
				saida.write(c);
			}
		}finally{
			if (fis != null){
				fis.close();
			}
		}
		saida.close();
		
	}

}
