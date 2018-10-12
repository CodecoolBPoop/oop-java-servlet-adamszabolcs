package com.codecool.servlet;

import com.codecool.items.Item;
import com.codecool.items.ItemStore;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "cart", urlPatterns = {"/cart"}, loadOnStartup = 2)
public class ShoppingCartServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Item> cartList = ItemStore.getItemList();
        PrintWriter out = response.getWriter();
        String title = "Cart page";
        int sumPrice = 0;
        for (Item item : cartList) {
            sumPrice += item.getPrice();
        }
        String totalCart = "The total price of the cart is: ";

        StringBuffer cartPage = new StringBuffer();
        cartPage.append("<table>");
        cartPage.append("<thead>");
        cartPage.append("<tr>");
        cartPage.append("<th>Name</th>");
        cartPage.append("<th>Price</th>");
        cartPage.append("</tr>");
        for (Item item : cartList) {
            cartPage.append("<tr><td>" + item.getName() + "</td>");
            cartPage.append("<td>" + item.getPrice() + "</td></tr>");
        }

        out.println(
                "<html>" +
                "<head><title>" + title + "</title></head>" +
                "<body>" +
                "<h1 align=\"center\">" + title + "</h1>" +
                "<div>" + cartPage.toString() + "</div>" +
                "<div>" + totalCart + sumPrice + "</div>" +
                "</body>" +
                "</html>");
    }

}
