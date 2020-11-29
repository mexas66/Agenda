<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
        <title>Agenda</title>
    </head>

    <body>
            <h3>Ajouter un evenement</h3>
            <form method="POST" action="${pageContext.request.contextPath}/addevent" class>
            	<div class="form-group">
	                <label>Debut</label>
	                <input type="datetime-local" class="form-control" name="event_begin_date" required>
	            </div>
	            <div class="form-group">
	                <label>Fin</label>
	                <input type="datetime-local" class="form-control" name="event_end_date" required>
	            </div>
	            <div class="form-group">
	                <label>Title</label>
	                <input type="text" class="form-control" name="event_title" required>
	            </div>
	           	<div class="form-group">
	                <label>Description</label>
	                <input type="text" class="form-control" name="event_description" required>
	            </div>
	           	<div>
	                <button class="btn btn-primary" type="submit" name="submit">Valider</button>
	            </div>
            </form>
    </body>
    
</html>