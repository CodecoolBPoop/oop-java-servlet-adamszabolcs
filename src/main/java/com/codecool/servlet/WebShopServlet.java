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
import java.util.stream.Stream;

import com.codecool.items.ItemStore;
import com.codecool.items.Item;

@WebServlet(name = "webshopservlet", urlPatterns = {"/"}, loadOnStartup = 1)
public class WebShopServlet extends HttpServlet {
    private List<Item> listItems = new ArrayList<>();

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
        webshopTable.append("<table>\n<thead>\n<th>Name</th><th>Price</th><th></th><th></th></thead><tbody>");
        for (Item item : listItems) {
            webshopTable.append("<tr>");
            webshopTable.append("<td>" + item.getName() + "</td>");
            webshopTable.append("<td>" + item.getPrice() + "</td>");
            webshopTable.append("<td><button>Add</button></td>");
            webshopTable.append("<td><button>Remove</button></td>");
            webshopTable.append("</tr>");
        }

        out.println(
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body>\n" +
                "<h1 align = \"center\">" + title + "</h1>\n" +
                "<div>" + webshopTable.toString() + "</div>" +
                "</body></html>");

    }

}
