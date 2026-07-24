<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>


<form action="${pageContext.request.contextPath}/type" method="post">
    <input type="text" hidden="" name="id" value="${type.id}">
    <label for="Libelle">Libelle</label>
    <input type="text" name="libelle" value ="${type.libelle}" />
    <button type="submit">Enregistrer</button>
</form>
