<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edi��o do usu�rio</title>
</head>
<body>

	<%@ page
		import="com.crudjspjava.bean.Usuario, com.crudjspjava.dao.UsuarioDao"%>


	<%
	String id = request.getParameter("id");
	Usuario usuario = UsuarioDao.pegarById(Integer.parseInt(id));
	%>

	<h1>Edi��o do usu�rio</h1>

	<form action="editusuario.jsp" method="post">
		<input type="hidden" name="id" value="<%=usuario.getId()%>" />
		<table>
			<tr>
				<td>NOME:</td>
				<td><input type="text" name="nome"
					value="<%=usuario.getNome()%>" /></td>
			</tr>
			<tr>
				<td>PASSWORD:</td>
				<td><input type="password" name="password"
					value="<%=usuario.getPassword()%>" /></td>
			</tr>
			<tr>
				<td>EMAIL:</td>
				<td><input type="email" name="email"
					value="<%=usuario.getEmail()%>" /></td>
			</tr>
			<tr>
				<td>SEXO:</td>
				<td><input type="radio" name="sexo" value="masculino" />MASCULINO
					<input type="radio" name="sexo" value="feminino" />FEMININO</td>
			</tr>
			<tr>
				<td>PA�S:</td>
				<td><select name="pais">
				<option>Brasil</option>
				<option>EUA</option>
				<option>Portugal</option>
				<option>Argentina</option>
				<option>Fran�a</option>
				<option>Outro</option>
				</select>
				</td>
			</tr>
			
			<tr>
			<td colspan="2"><input type="submit" value="Editar usu�rio"></td>
			</tr>
		</table>
	</form>


</body>
</html>