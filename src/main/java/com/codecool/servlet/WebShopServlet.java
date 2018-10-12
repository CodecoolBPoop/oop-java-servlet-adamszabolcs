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
    private List<Item> listItems = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        listItems.add(new Item("Harry Potter", 150.0));
        listItems.add(new Item("And again", 200));
        ItemStore.add(listItems.get(0));
        ItemStore.add(listItems.get(0));
        ItemStore.add(listItems.get(0));
        ItemStore.add(listItems.get(1));
        ItemStore.add(listItems.get(1));
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
            webshopTable.append("<td><button type=\"submit\" name=\"add\" value=\"" + item.getId() + "\">Add</button></td>");
            webshopTable.append("</form><form action=\"webshop\">");
            webshopTable.append("<td><button type=\"submit\" name=\"remove\" value=\"" + item.getId() + "\">Remove</button></td>");
            webshopTable.append("</form>");
            webshopTable.append("</tr>");
        }

        String addIndex = request.getParameter("add");

        out.println(
                "<html>\n" +
                        "<head><title>" + title + "</title></head>\n" +
                        "<body>\n" +
                        "<h1 align = \"center\">" + title + "</h1>\n" +
                        "<div>" + webshopTable.toString() + "</div>" +
                        (addIndex != null ?
                                "<div>" + listItems.get(Integer.parseInt(addIndex)).getName() + " added to Your cart!</div>" :
                                "<div></div>") +
                        "<a href=\"/cart\">Go to cart page</a>" +
                        "</body></html>");

    }

}
