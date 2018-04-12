<%--
  Created by IntelliJ IDEA.
  User: suppressf0rce
  Date: 4/11/18
  Time: 4:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PhoneBook</title>
</head>
<body>

<div align="center">
    <h1>PhoneBook</h1>

    <form action="main" id="list" method="GET"></form>
    <form id="logout" action="logout" method="GET"></form>
    <form action="main" method="GET">
        <table>
            <tr>
                <td>First Name: </td>
                <td><input type="text" name="firstName" required/></td>
            </tr>
            <tr>
                <td>Last Name: </td>
                <td><input type="text" name="lastName" required /><br></td>
            </tr>
            <tr>
                <td>Phone Number: </td>
                <td><input type="text" name="phoneNumber" required /><br></td>
            </tr>
            <tr>
                <td><input type="submit" name="add" value="Add Contact" /></td>
                <td><input type="submit" name="list" form="list" value="List Contacts" /></td>
                <td><input type="submit" form="logout" value="Logout" /></td>
            </tr>
        </table>
    </form>

    ${contacts}
</div>

</body>
</html>
