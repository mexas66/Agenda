<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
        <title>Agenda</title>
    </head>

    <body>
        <a href="addevent">Ajouter un evenement</a>

        <h3>Liste des évènement</h3>


        <table>
            <thead>
                <th>Date</th>
                <th>Titre</th>
                <th>Description</th>
                <th>Annuler</th>
            </thead>
            <tbody>
                
                <c:forEach items="${requestScope.events}" var="event">
                    <tr>
                        <td><c:out value="${event.beginDate.day}"/>/<c:out value="${event.beginDate.month}"/>/<c:out value="${event.beginDate.year}"/>  
                            <c:out value="${event.beginDate.hour}"/>:<c:out value="${event.beginDate.minute}"/><br/>
                            <c:out value="${event.endDate.day}"/>/<c:out value="${event.endDate.month}"/>/<c:out value="${event.endDate.year}"/>  
                            <c:out value="${event.endDate.hour}"/>:<c:out value="${event.endDate.minute}"/></td>
                        <td><c:out value="${event.title}"/></td>
                        <td><c:out value="${event.description}"/></td>
                        <td><a href="${pageContext.request.contextPath}/remove?eventToRemove=<c:out value="${event.id}" />" type="button" class="btn btn-primary">Annuler</a></td>
                    </tr>
                </c:forEach> 
            </tbody>
        </table>

    </body>