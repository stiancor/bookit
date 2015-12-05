<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Create new user</title>
</head>
<body>
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
        <g:submitButton name="Create"/>
    </g:form>
</body>
</html>