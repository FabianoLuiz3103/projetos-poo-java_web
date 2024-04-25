
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Visualiza��o de Usu�rios</title>
</head>
<body>

<%@ page import = "com.crudjspjava.dao.UsuarioDao, com.crudjspjava.bean.*, java.util.*"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Listagem de Usu�rios</h1>

<%

/*String pageId = request.getParameter("page");
if (pageId != null && !pageId.isEmpty()) {
    try {
        int id = Integer.parseInt(pageId);
        int total = 5;

        if (id != 1) {
            id = id - 1;
            id = id * total + 1;
        }

        List<Usuario> list = UsuarioDao.getRegistros(id, total);
        request.setAttribute("list", list);
    } catch (NumberFormatException e) {
        // Tratar erro de convers�o, se necess�rio
        e.printStackTrace();
   }
}*/

List<Usuario> list = UsuarioDao.listarUsuario();
request.setAttribute("list", list);
%>

<table border="1">
<tr>
<th>ID</th>
<th>NOME</th>
<th>PASSWORD</th>
<th>EMAIL</th>
<th>SEXO</th>
<th>PA�S</th>
<th>EDITAR</th>
<th>EXCLUIR</th>
</tr>

<c:forEach items = "${list}" var ="usuario">

<tr>
<td>${usuario.getId()}</td>
<td>${usuario.getNome()}</td>
<td>${usuario.getPassword()}</td>
<td>${usuario.getEmail()}</td>
<td>${usuario.getSexo()}</td>
<td>${usuario.getPais()}</td>
<td><a href="editform.jsp?id=${usuario.getId()}">Editar</a></td>
<td><a href="deleteusuario.jsp?id=${usuario.getId()}">Excluir</a></td>
</tr>
</c:forEach>
</table>
<br>

<br>
<a href="addusuarioform.jsp">ADICIONAR NOVO USU�RIO</a>

</body>
</html>