<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <title>Library</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>

    <body>
         <c:import url="${contextPath}/WEB-INF/html/navibar.jsp"/>

            <form action="/findBook">
              <label for="bookName">Book name:</label><br>
              <input type="text" id="bookName" name="bookName"><br>
              <input type="submit" value="Submit">
            </form>

                  <table>
                      <thead>
                      <tr>
                          <td style="text-align: center">Book name</td>
                          <td style="text-align: center">Count pages</td>
                          <td style="text-align: center">Author name</td>
                      </tr>
                      </thead>
                      <tbody>
                              <tr>
                                  <td>
                                      <c:out value="${book.name}"/>
                                  </td>
                                  <td>
                                      <c:out value="${book.countPages}"/>
                                  </td>
                                  <td>
                                      <c:forEach items="${book.authors}" var="author">
                                      <a href="/findAuthor?authorId=${author.id}"> <c:out value="${author.firstName}"/> <c:out value="${author.lastName}"/> </a>
                                      </c:forEach>
                                  </td>
                              </tr>
                      </tbody>
                  </table>
    </body>
</html>
