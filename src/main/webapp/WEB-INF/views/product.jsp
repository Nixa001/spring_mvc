<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<a href="${pageContext.request.contextPath}/product/new">Ajouter un produit</a>


<table>
  <c:forEach var="product" items="${products}">
    <tr> <td>${product.id}</td>
      <td>${product.libelle}</td>
      <td>${product.prix}</td>
      <td>
        <a href="${pageContext.request.contextPath}/product/edit/${product.id}">Modifier</a>
        <a href="${pageContext.request.contextPath}/product/delete/${product.id}">Supprimer</a>
      </td> </tr>
  </c:forEach>
</table>
