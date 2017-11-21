<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Beer Recommendations JSP</title>
</head>
<body>
<%=1+1%>
<%
    List styles = (List) request.getAttribute("styles");
    //iterator返回按适当顺序在列表的元素上进行迭代的迭代器。
    Iterator it = styles.iterator();
    //hasNext如果仍有元素可以迭代，则返回 true
    while (it.hasNext()) {
        //next返回迭代的下一个元素
        out.print("<br/>try: "+it.next());
    }
%>
</body>
</html>
