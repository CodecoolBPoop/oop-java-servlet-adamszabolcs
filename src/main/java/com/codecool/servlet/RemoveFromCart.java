package com.codecool.servlet;

import com.codecool.items.ItemStore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "removefromcart", urlPatterns = {"/remove"})
public class RemoveFromCart extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        response.setContentType("plain/text");
        response.setCharacterEncoding("UTF-8");
        if (ItemStore.getItemList().isEmpty()) {
            response.getWriter().write("No items in cart!");
        } else {
            ItemStore.remove(WebShopServlet.listItems.get(id));
            response.getWriter().write("Item removed from cart!");
        }
    }
}
