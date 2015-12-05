<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Show user</title>
</head>
<body>
<h1>Are there any users here?</h1>
Name: ${result.get(':user/fullName')}
<br/>
Email: ${result.get(':user/email')}
<br/>
Phone: ${result.get(':user/phone')}
</body>
</html>