package com.codecool.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.codecool.items.ItemStore;
import com.codecool.items.Item;

@WebServlet(name = "webshopservlet", urlPatterns = {"/webshop"}, loadOnStartup = 1)
public class WebShopServlet extends HttpServlet {
    public static List<Item> listItems = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        listItems.add(new Item("Harry Potter", 150.0));
        listItems.add(new Item("And again", 200));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter out = response.getWriter();
        String title = "Welcome to our Webshop";
        StringBuffer webshopTable = new StringBuffer();
        webshopTable.append("<table>\n<thead>\n<th>Name</th><th>Price</th></thead><tbody>");
        for (Item item : listItems) {
            webshopTable.append("<tr>");
            webshopTable.append("<td>" + item.getName() + "</td>");
            webshopTable.append("<td>" + item.getPrice() + "</td>");
            webshopTable.append("<form action=\"webshop\">");
            webshopTable.append("<td><button class=\"add\" id=\"" + item.getId() + "\">Add</button></td>");
            webshopTable.append("</form><form action=\"webshop\">");
            webshopTable.append("<td><button class=\"remove\" id=\"" + item.getId() + "\">Remove</button></td>");
            webshopTable.append("</form>");
            webshopTable.append("</tr>");
        }

        String addIndex = request.getParameter("add");

        out.println(
                "<html>\n" +
                        "<head><title>" + title + "</title>" +
                        "<script type=\"text/javascript\" src=\"static/javascript/buttonHandler.js\" defer></script>\n" +
                        "<script src=\"https://code.jquery.com/jquery-3.3.1.js\"" +
                        "integrity=\"sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60=\"" +
                        "crossorigin=\"anonymous\"></script>" +
                        "<body>\n" +
                        "<h1 align = \"center\">" + title + "</h1>\n" +
                        "<div>" + webshopTable.toString() + "</div>" +
                        "<a href=\"/cart\">Go to cart page</a>" +
                        "</body></html>");

    }

}
