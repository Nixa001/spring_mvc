<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<a href="${pageContext.request.contextPath}/type/new">Ajouter un type</a>


<table>
  <c:forEach var="type" items="${types}">
    <tr> <td>${type.id}</td>
      <td>${type.libelle}</td>
      <td>
        <a href="${pageContext.request.contextPath}/type/edit/${type.id}">Modifier</a>
        <a href="${pageContext.request.contextPath}/type/delete/${type.id}">Supprimer</a>
      </td> </tr>
  </c:forEach>
</table>
