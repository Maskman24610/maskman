<%@tag description='' pageEncoding='Utf-8'%>
<%@tag dynamic-attributes='data'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<%@attribute name='title' required='true' %>
<table border='1' width='100%'>
	<c:forEach var='row' items='${data}'>
		<tr>
			<th>${row.key}</th>
			<td>${row.value}</td>
		</tr>
	</c:forEach>
</table>