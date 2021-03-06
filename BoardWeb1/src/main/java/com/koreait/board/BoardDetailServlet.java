package com.koreait.board;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/detail")
public class BoardDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String str = req.getParameter("iboard");
        int iboard = Integer.parseInt(str);
        BoardVO param = new BoardVO();
        param.setIboard(iboard);
        BoardVO vo = BoardDAO.selBoardDetail(param);
        req.setAttribute("dat", vo);

        String path = "/WEB-INF/detail.jsp";
        req.getRequestDispatcher(path).forward(req,res);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}
