<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Create new user</title>
</head>
<body>
<div class="container">
    <div class="row">
        <g:form action="insert" class="form">
            <div class="form-group">
                <label for="email">Epost</label>
                <g:field type="email" name="email" class="form-control" id="email" placeholder="Email"/>
            </div>
            <div class="form-group">
                <label for="email">Fullt navn</label>
                <g:field type="text" name="fullName" class="form-control" id="fullName"/>
            </div>
            <div class="form-group">
                <label for="email">Telefon</label>
                <g:textField name="phone" class="form-control" id="phone" placeholder="Telefonnummer"/>
            </div>
            <div class="form-group">
                <label for="password">Passord</label>
                <g:field type="password" name="password" class="form-control" id="password" placeholder="Passord"/>
            </div>
            <g:submitButton name="Create" class="btn btn-primary"/>
        </g:form>
    </div>
</div>
</body>
</html>