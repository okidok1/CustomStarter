package com.example.customspringbootstarter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class MyHttpServletResponseWrapper extends HttpServletResponseWrapper {

    private StringWriter sw = new StringWriter(1024);

    public MyHttpServletResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    public PrintWriter getWriter() throws IOException {
        return new PrintWriter(sw);
    }

    public String toString() {
        return sw.toString();
    }
}