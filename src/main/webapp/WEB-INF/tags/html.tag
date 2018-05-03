<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Movie world</title>
    <ui:link href="css/bootstrap.css"/>
    <ui:link href="css/font-awesome.min.css"/>
    <ui:link href="css/main.css"/>
</head>
<body>
<ui:header/>

<jsp:doBody/>

<ui:footer/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
