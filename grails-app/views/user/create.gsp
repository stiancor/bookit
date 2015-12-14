<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Create new user</title>
</head>
<body>
<div class="container">
    <div class="row">
        <g:form action="insert">
            Brukernavn
            <g:textField name="email"/>
            <br/>
            Fullt navn
            <g:textField name="fullName"/>
            <br/>
            Telefonnummer
            <g:textField name="phone"/>
            <br/>
            Passord
            <g:passwordField name="password"/>
            <br/>
            <g:submitButton name="Create" class="btn btn-default"/>
        </g:form>
    </div>
</div>
</body>
</html>