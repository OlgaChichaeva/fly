<%-- 
    Document   : showPlane
    Created on : 23.04.2014, 10:34:03
    Author     : Ольга
--%>

<%@page import="com.netcracker.unc.lab3.Plane"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% String ROOT = request.getContextPath();
         
            List<Plane> planes = (List<Plane>) request.getAttribute("PlaneList");
            if (planes == null) {
                out.print("asd");
                return;
            }
            %>
            <table border="1">
                <tr>
                <th  >id</th>
                 <th  >parentId</th>
                  <th  >name</th>
                   <th  >charecteristics</th>
                   </tr>
                <%
             for (Plane plane : planes) {
                    %>
                    <tr>
                       <td>
                            <%= plane.getId()%>
                        </td>
                        <td>
                            <%= plane.getParent_id()%>
                        </td>
                        <td>
                            <%= plane.getName()%>
                        </td>
                        <td >
                            <%= plane.getCharacter()%>
                           
                        </td>
                        </tr>
       <% }%>
    </table>
    </body>
</html>
