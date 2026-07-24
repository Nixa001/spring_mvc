<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>


<form action="${pageContext.request.contextPath}/product" method="post">
    <input type="text" hidden="" name="id" value="${product.id}">
    <label for="Libelle">Libelle</label>
    <input type="text" name="libelle" value ="${product.libelle}" />
    <label for="">Prix</label>
    <input type="number" name="prix" value ="${product.prix}" />
    <button type="submit">Enregistrer</button>
</form>